
package cloudcount.models;

import cc.test.bridge.BridgeConstants;
import cc.test.bridge.BridgeConstants.Side;
import cc.test.bridge.BridgeConstants.State;
import cc.test.bridge.BudgetInterface;
import cc.test.bridge.LineInterface;
import cc.test.bridge.NoteInterface;
import java.util.ArrayList;
import org.workplicity.entry.Entry;
import org.workplicity.util.Helper;
import org.workplicity.worklet.WorkletContext;

/**
 *
 * @author joeycarmello
 */
public class Budget extends Entry implements BudgetInterface {
    
    private String name;
    
    private String description;
    
    private ArrayList<NoteInterface> notes;
    
    private ArrayList<LineInterface> lines;
            
    
    public Budget() {
        
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public ArrayList<LineInterface> fetchLines(Side side) {
        return lines;
    }

    @Override
    public ArrayList<NoteInterface> fetchNotes() {
        return notes;
    }

    @Override
    public LineInterface createLine() {
        return new Line();
    }

    @Override
    public NoteInterface createNote() {
        return new Note();
    }

    @Override
    public void add(NoteInterface note) {
        BridgeHelper.getHamper().put(note, State.CREATE);
        BridgeHelper.getHamper().put(this, State.UPDATE);
    }

    @Override
    public void delete(NoteInterface note) {
        BridgeHelper.getHamper().put(note, State.DELETE);
        BridgeHelper.getHamper().put(this, State.UPDATE);
    }
    
    @Override
    public void update(NoteInterface note) {
        BridgeHelper.getHamper().put(note, State.UPDATE);
        BridgeHelper.getHamper().put(this, State.UPDATE);
    }

    @Override
    public void add(LineInterface line) {
        BridgeHelper.getHamper().put(line, State.CREATE);
        BridgeHelper.getHamper().put(this, State.UPDATE);
    }

    @Override
    public void delete(LineInterface line) {
        BridgeHelper.getHamper().put(line, State.DELETE);
        BridgeHelper.getHamper().put(this, State.UPDATE);
    }

    @Override
    public void update(LineInterface line) {
        BridgeHelper.getHamper().put(line, State.UPDATE);
        BridgeHelper.getHamper().put(this, State.UPDATE);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Boolean commit() {
        
        Boolean isSuccess = false;
                
        isSuccess = Helper.insert(this, this.getRepositoryName(), WorkletContext.getInstance());
        
        if (isSuccess) {
            // no longer dirty
            BridgeHelper.getHamper().clear();
        }
        
        return isSuccess;
    }

    @Override
    public String getRepositoryName() {
        return "budgets";
    }
   
    
}
