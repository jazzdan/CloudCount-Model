package cloudcount.models;

import cc.test.bridge.BridgeConstants.State;
import cc.test.bridge.LineInterface;
import cc.test.bridge.SublineInterface;
import com.mongodb.BasicDBObject;
import java.util.ArrayList;
import java.util.Iterator;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.workplicity.entry.Entry;
import org.workplicity.task.NetTask;
import org.workplicity.util.Helper;
import org.workplicity.util.MongoHelper;
import org.workplicity.worklet.WorkletContext;

/**
 *
 * @author joeycarmello
 */
public class Line extends Entry implements LineInterface {

    private Integer budgetId = -1;
    private Integer number = -1;
    private String name = "n/a";
    private ArrayList<SublineInterface> sublines = new ArrayList<SublineInterface>();

    /**
     * Default constructor
     */
    public Line() {
    }

    /**
     *
     * @return the budgetId
     */
    public Integer getBudget() {
        return budgetId;
    }

    /**
     *
     * @param budgetId
     */
    public void setBudget(Integer budgetId) {
        this.budgetId = budgetId;
    }

    /**
     *
     * @return number
     */
    @Override
    public Integer getNumber() {
        return number;
    }

    /**
     *
     * @param number
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     *
     * @return the name of the line
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return the sublines from the database
     */
    @Override
    public ArrayList<SublineInterface> fetchSublines() {
        BasicDBObject query = new BasicDBObject();
        query.put("entry.parent", this);
        try {
            return MongoHelper.query(query, NetTask.getStoreName(), new SubLine().getRepositoryName());
        } catch (Exception e) {
            System.out.println("Couldnt fetch sublines of Line #" + number
                    + " because of error:" + e);
        }
        return null;
    }

    /**
     *
     * @return a new subline instance
     */
    @Override
    public SublineInterface createSubline() {
        return new SubLine();
    }

    /**
     * Commits this line without chance for abort. In other words, this is not a
     * two-phase commit. This could leave the line in incoherent state.
     *
     * @return True if commit successful, false otherwise
     */
    @Override
    public Boolean commit() {
        // If any of my sublines are in the hamper, commit them
        Boolean commitMe = false;

        for (SublineInterface subline : sublines) {
            State state = BridgeHelper.getHamper().get(subline);

            if (state != null) {
                subline.commit();

                if (state == State.DELETE) {
                    sublines.remove(subline);
                } else if (state == State.CREATE) {
                    sublines.add(subline);
                }

                commitMe = true;
            }
        }

        // If I'm not in the hamper AND all my sublines
        // are clean, there's nothing more to do 
        State myState = BridgeHelper.getHamper().get(this);

        if (myState == null && commitMe == false) {
            return true;
        }

        // Otherwise, update me
        WorkletContext context = WorkletContext.getInstance();

        Boolean successful = false;

        if (myState == State.CREATE || myState == State.UPDATE) {
            successful = Helper.insert(this, this.getRepositoryName(), context);
        } else if (myState == State.DELETE) {
            successful = Helper.delete(this, this.getRepositoryName(), context);
        }

        return successful;
    }

    /**
     * Deletes a subline without committing it.
     *
     * @param subline Subline
     */
    @Override
    public void delete(SublineInterface subline) {
        // Put the subline in the hamper for delete
        BridgeHelper.getHamper().put(subline, State.DELETE);

        // Put me in the hamper for update
        BridgeHelper.getHamper().put(this, State.UPDATE);
    }

    /**
     * Adds a subline without committing it.
     *
     * @param subline Subline
     */
    @Override
    public void add(SublineInterface subline) {
        // Put the subline in the hamper for create
        BridgeHelper.getHamper().put(subline, State.CREATE);

        // Put me in the hamper for update
        BridgeHelper.getHamper().put(this, State.UPDATE);
    }

    /**
     * Gets all the sublines.
     * @return 
     */
    public ArrayList<SublineInterface> getSublines() {
        return sublines;
    }

    /**
     * Sets the sublines and makes the line dirty.
     * @param sublines Sublines
     */
    public void setSublines(ArrayList<SublineInterface> sublines) {
        this.sublines = sublines;
        
        // Put me in the hamper for update
        BridgeHelper.getHamper().put(this, State.UPDATE);         
    }

    /**
     *
     * @return repositoryName
     */
    @JsonIgnore
    public String getRepositoryName() {
        return "lines";
    }
}
