
package cloudcount.models;

import org.workplicity.entry.Entry;

/**
 *
 * @author joeycarmello
 */
public class Line extends Entry {
    
    private Budget budget;
    
    private int user_id;
    
    private int line_number;
    
    private String name;
    
    private double subtotal;
    
    private Line parent;
    
    private int order;
    
    
    public Line() {
        
    }

    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    public int getLine_number() {
        return line_number;
    }

    public void setLine_number(int line_number) {
        this.line_number = line_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public Line getParent() {
        return parent;
    }

    public void setParent(Line parent) {
        this.parent = parent;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
    
}
