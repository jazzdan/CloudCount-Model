
package cloudcount.models;

import cc.test.bridge.LineInterface;
import cc.test.bridge.SublineInterface;
import java.util.ArrayList;
import org.workplicity.entry.Entry;

/**
 *
 * @author joeycarmello
 */
public class Line extends Entry implements LineInterface {
    
    public static final String REPOSITORY = "lines";
    
    private Integer budgetId = -1;
    
    private Integer number = -1;
    
    private String name = "n/a";
    
    public Line() {
        
    }

    public Integer getBudget() {
        return budgetId;
    }

    public void setBudget(Integer budgetId) {
        this.budgetId = budgetId;
    }

    @Override
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public ArrayList<SublineInterface> fetchSublines() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public SublineInterface createSubline() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void add(SublineInterface si) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(SublineInterface si) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Boolean commit() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getRepositoryName() {
        return Line.REPOSITORY;
    }
    
    
}
