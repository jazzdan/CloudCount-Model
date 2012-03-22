
package cloudcount.models;

import cc.test.bridge.BridgeConstants.Side;
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
    
    public static final String REPOSITORY = "budgets";
    
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
    public void add(NoteInterface ni) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(NoteInterface ni) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void add(LineInterface li) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(LineInterface li) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(LineInterface li) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(NoteInterface ni) {
        throw new UnsupportedOperationException("Not supported yet.");
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
        return Budget.REPOSITORY;
    }
    
    
}
