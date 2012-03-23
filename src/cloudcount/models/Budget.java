package cloudcount.models;

import cc.test.bridge.*;
import cc.test.bridge.BridgeConstants.Side;
import cc.test.bridge.BridgeConstants.State;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.workplicity.entry.Entry;
import org.workplicity.task.NetTask;
import org.workplicity.util.Helper;
import org.workplicity.util.MongoHelper;
import org.workplicity.worklet.WorkletContext;

/**
 *
 * @author joeycarmello
 */
public class Budget extends Entry implements BudgetInterface {

    private final String repositoryName = "budgets";
    private String name;
    private String description;
    private ArrayList<NoteInterface> notes;
    private ArrayList<LineInterface> lines;

	/**
	 *
         * Default Constructor
	 */
	public Budget() {
    }

	/**
	 *
	 * @return description
	 */
	@Override
    public String getDescription() {
        return description;
    }

	/**
	 *
	 * @param description
	 */
	@Override
    public void setDescription(String description) {
        this.description = description;
    }

	/**
	 *
	 * @param side
	 * @return
	 */
	@Override
    public ArrayList<LineInterface> fetchLines(Side side) {
        return lines;
    }

	/**
	 *
	 * @return a list of embedded notes
	 */
	@Override
    public ArrayList<NoteInterface> fetchNotes() {
        return notes;
    }

	/**
	 *
	 * @return a new Line instance
	 */
	@Override
    public LineInterface createLine() {
        return new Line();
    }

	/**
	 *
	 * @return a new Note instance
	 */
	@Override
    public NoteInterface createNote() {
        return new Note();
    }

	/**
	 *
         * Sets the note to dirty for creation
	 * @param note
	 */
	@Override
    public void add(NoteInterface note) {
        BridgeHelper.getHamper().put(note, State.CREATE);
        BridgeHelper.getHamper().put(this, State.UPDATE);
    }

	/**
	 *
         * Sets the note up to be deleted
	 * @param note
	 */
	@Override
    public void delete(NoteInterface note) {
        BridgeHelper.getHamper().put(note, State.DELETE);
        BridgeHelper.getHamper().put(this, State.UPDATE);
    }

	/**
	 *
         * Sets the note up to be updated
	 * @param note
	 */
	@Override
    public void update(NoteInterface note) {
        BridgeHelper.getHamper().put(note, State.UPDATE);
        BridgeHelper.getHamper().put(this, State.UPDATE);
    }

	/**
	 *
         * Sets the line up to be created
	 * @param line
	 */
	@Override
    public void add(LineInterface line) {
        BridgeHelper.getHamper().put(line, State.CREATE);
        BridgeHelper.getHamper().put(this, State.UPDATE);
    }

	/**
	 *
         * Sets the line up to be deleted
	 * @param line
	 */
	@Override
    public void delete(LineInterface line) {
        BridgeHelper.getHamper().put(line, State.DELETE);
        BridgeHelper.getHamper().put(this, State.UPDATE);
    }

	/**
	 *
         * sets the line up to be updated
	 * @param line
	 */
	@Override
    public void update(LineInterface line) {
        BridgeHelper.getHamper().put(line, State.UPDATE);
        BridgeHelper.getHamper().put(this, State.UPDATE);
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
	 * @return name of budget
	 */
	@Override
    public String getName() {
        return name;
    }

	/**
	 *
         * Depth-first insert of embedded and linked collections
	 * @return boolean for status of commit
	 */
	@Override
    public Boolean commit() {

        Boolean isSuccess = false;

        // Go through each embedded collection to commit them first
        for (BridgeInterface bridge : BridgeHelper.getHamper().keySet()) {

            // hold off on the current budget until last
            if (bridge != this) {
                State state = BridgeHelper.getHamper().get(bridge);

                if (state == State.CREATE) {
                    isSuccess = this.handleCreates(bridge);

                } else if (state == State.UPDATE) {
                    isSuccess = this.handleUpdates(bridge);

                } else if (state == State.DELETE) {
                    isSuccess = this.handleDeletes(bridge);
                }

                // don't continue if we hit any errors
                if (!isSuccess) {
                    break;
                }
            }

        }

        if (isSuccess) {
            // Now, see if the budget itself is dirty
            boolean isDirty = BridgeHelper.getHamper().containsKey(this);

            if (isDirty) {

                try {
                    // write the current budget through
                    int id = MongoHelper.insert(this, NetTask.getStoreName(), this.getRepositoryName());
                    isSuccess = id != -1;

                    if (isSuccess) {
                        // no longer dirty
                        BridgeHelper.getHamper().clear();
                    }

                } catch (Exception ex) {
                    Logger.getLogger(Budget.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return isSuccess;
    }

    /* handles State == CREATE
     *
     */
    private boolean handleCreates(BridgeInterface bridge) {
       boolean isSuccess = bridge.commit();

       if (isSuccess) {

           if (bridge instanceof LineInterface) {
               Line line = (Line) bridge;
               this.lines.add(line);

           } else if (bridge instanceof NoteInterface) {
               this.notes.add((Note) bridge);
           }

           BridgeHelper.getHamper().put(this, State.CREATE);
       }

       return isSuccess;

    }

    /*
     * handles State == UPDATE
     */
    private boolean handleUpdates(BridgeInterface bridge) {
        BridgeHelper.getHamper().put(this, State.UPDATE);
        return bridge.commit();
    }

    /*
     * handles State == DELETE
     */
    private boolean handleDeletes(BridgeInterface bridge) {

        if (bridge instanceof LineInterface) {

            this.lines.remove((Line) bridge);

        } else if (bridge instanceof NoteInterface) {

            this.notes.remove((Note) bridge);
        }

        BridgeHelper.getHamper().put(this, State.DELETE);

        bridge.commit();

        return true;
    }


	/**
	 *
	 * @return the repositoryName
	 */
	@Override
    public String getRepositoryName() {
        return repositoryName;
    }

    /*
     * Required for bean pattern / serialization
     *
     */
	/**
	 *
	 * @param name
	 */
	public void setRepositoryName(String name) {
    }
}
