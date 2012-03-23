package cloudcount.models;

import cc.test.bridge.LineInterface;
import cc.test.bridge.SublineInterface;
import com.mongodb.BasicDBObject;
import java.util.ArrayList;
import java.util.Iterator;
import org.workplicity.entry.Entry;
import org.workplicity.task.NetTask;
import org.workplicity.util.MongoHelper;

/**
 *
 * @author joeycarmello
 */
public class Line extends Entry implements LineInterface {

    public static final String REPOSITORY = "lines";
    private Integer budgetId = -1;
    private Integer number = -1;
    private String name = "n/a";

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
     *
     * @param si
     */
    @Override
    public void add(SublineInterface si) {
        SubLine subline = (SubLine) si;
        subline.setParent(this);
    }

    /**
     *
     * @param si
     */
    @Override
    public void delete(SublineInterface si) {
        SubLine subline = (SubLine) si;
        try {
            subline = null;
        } catch (Exception e) {
            System.out.println("Failed to delete subline");
        }
    }

    /**
     *
     * @return boolean for status of commit
     */
    @Override
    public Boolean commit() {
        try {
            ArrayList q = this.fetchSublines();
            Iterator iterator = q.iterator();
            while (iterator.hasNext()) {
                SubLine l = (SubLine) iterator.next();
                l.commit();
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    /**
     *
     * @return repositoryName
     */
    @Override
    public String getRepositoryName() {
        return Line.REPOSITORY;
    }
}
