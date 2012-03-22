
package cloudcount.models;

import java.util.Date;
import org.workplicity.entry.Entry;

/**
 *
 * @author joeycarmello
 */
public class Budget extends Entry {
    
    private String title;
    
    private String description;
    
    private Date starts;
    
    private Date ends;
    
    private int roll;
    
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
    
    
}
