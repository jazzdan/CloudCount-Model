
package cloudcount.models;

import java.util.Date;
import org.workplicity.entry.Entry;

/**
 *
 * @author joeycarmello
 */
public class Transaction extends Entry {
    
    private Date date;
    
    private double amount;
   
    public Transaction() {
        
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
}
