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

    /**
     *
     */
    public static final String REPOSITORY = "notes";
    private String name = "n/a";
    // description text for the note
    private String text = "";
    //
    private String author = "";
    private Date date;

    /**
     *
     * Default constructor
     */
    public Note() {
    }

    /**
     *
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     *
     * @return date
     */
    @Override
    public Date getDate() {
        return date;
    }

    /**
     *
     * @return text
     */
    @Override
    public String getText() {
        return text;
    }

    /**
     *
     * @param text
     */
    @Override
    public void setText(String text) {
        this.text = text;
    }

    /**
     *
     * @return author
     */
    @Override
    public String getAuthor() {
        return author;
    }

    /**
     *
     * @param author
     */
    @Override
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     *
     * @param name
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     *
     * @return true for commit 
     */
    @Override
    public Boolean commit() {
        return true;
    }

    /**
     *
     * @return respositoryName
     */
    @Override
    public String getRepositoryName() {
        return Note.REPOSITORY;
    }

    /**
     *
     * @return
     */
    @Override
    public Integer getId() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     *
     * @return
     */
    @Override
    public WorkDate getUpdateDate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
