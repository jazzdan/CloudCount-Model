
package cloudcount.models;

import cc.test.bridge.NoteInterface;
import java.io.Serializable;
import java.util.Date;
import org.workplicity.entry.Entry;
import org.workplicity.task.NetTask;
import org.workplicity.util.MongoHelper;
import org.workplicity.util.WorkDate;

/**
 *
 * @author joeycarmello
 */
public class Note implements Serializable, NoteInterface {

    public static final String REPOSITORY = "notes";
    
    private String name = "n/a";
    
    // description text for the note
    private String text = "";
    
    // 
    private String author = "";
    
    private Date date;
    
    
    public Note() {
        
    }
    
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public void setAuthor(String author) {
        this.author = author;
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
        return true;
    }

    @Override
    public String getRepositoryName() {
        return Note.REPOSITORY;
    }

    @Override
    public Integer getId() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public WorkDate getUpdateDate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
