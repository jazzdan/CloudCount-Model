
package cloudcount.models;

import cc.test.bridge.BridgeConstants.Side;
import cc.test.bridge.BudgetInterface;
import cc.test.bridge.LineInterface;
import cc.test.bridge.NoteInterface;
import java.util.ArrayList;
import java.util.Date;
import org.workplicity.entry.Entry;

/**
 *
 * @author joeycarmello
 */
public class Budget extends Entry implements BudgetInterface {
    
    private String title;
    
    private String description;
    
    private Date starts;
    
    private Date ends;
    
    private int roll;
    
    private ArrayList<Note> notes;
    
    private ArrayList<Line> lines;
            
    
    public Budget() {
        
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEnds() {
        return ends;
    }

    public void setEnds(Date ends) {
        this.ends = ends;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public Date getStarts() {
        return starts;
    }

    public void setStarts(Date starts) {
        this.starts = starts;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public ArrayList<LineInterface> fetchLines(Side side) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<NoteInterface> fetchNotes() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public LineInterface createLine() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public NoteInterface createNote() {
        throw new UnsupportedOperationException("Not supported yet.");
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
    public void setName(String string) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Boolean commit() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getRepositoryName() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}
