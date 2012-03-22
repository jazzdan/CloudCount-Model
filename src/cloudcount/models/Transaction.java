
package cloudcount.models;

import cc.test.bridge.TransactionInterface;
import java.util.Date;
import org.workplicity.entry.Entry;

/**
 *
 * @author joeycarmello
 */
public class Transaction extends Entry implements TransactionInterface {
    
    public static final String REPOSITORY = "transactions";
    
    private String name;
    
    private Date date;
    
    private Double amount;
   
    public Transaction() {
        
    }

    @Override
    public Double getAmount() {
        return amount;
    }

    @Override
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Boolean commit() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getRepositoryName() {
        return Transaction.REPOSITORY;
    }
    
    
}
