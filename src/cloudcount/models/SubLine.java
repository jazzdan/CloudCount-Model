
package cloudcount.models;

import cc.test.bridge.SublineInterface;
import cc.test.bridge.TransactionInterface;
import java.util.ArrayList;
import org.workplicity.entry.Entry;

/**
 *
 * @author joeycarmello
 */
public class SubLine extends Entry implements SublineInterface {
    
    public static final String REPOSITORY = "sub_lines";
    
    private Integer subNumber;
    
    private String name;
    
    private Line parent;
    
    private ArrayList<TransactionInterface> transactions;
    
    
    public SubLine() {
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Line getParent() {
        return parent;
    }

    public void setParent(Line parent) {
        this.parent = parent;
    }

    @Override
    public String getRepositoryName() {
        return SubLine.REPOSITORY;
    }

    @Override
    public ArrayList<TransactionInterface> fetchTransactions() {
        return this.transactions;
    }

    @Override
    public TransactionInterface createTransaction() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Integer getSubNumber() {
        return this.subNumber;
    }
   
    public void setSubNumber(Integer subNumber) {
        this.subNumber = subNumber;
    }

    @Override
    public void add(TransactionInterface ti) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(TransactionInterface ti) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public Boolean commit() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
