
package cloudcount.models;

import org.workplicity.entry.Entry;

/**
 *
 * @author joeycarmello
 */
public class Note extends Entry {
    
    
    // description text for the note
    private String label;
    
    // Contents of the note
    private String note;
    
    // 
    private int created_by;
    
    // 
    private Budget budget;
    
    public Note() {
        
    }

    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    public int getCreated_by() {
        return created_by;
    }

    public void setCreated_by(int created_by) {
        this.created_by = created_by;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
}
