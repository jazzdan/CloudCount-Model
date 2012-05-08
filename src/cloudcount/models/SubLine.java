package cloudcount.models;

import cc.test.bridge.BridgeConstants.State;
import cc.test.bridge.SublineInterface;
import cc.test.bridge.TransactionInterface;
import com.mongodb.BasicDBObject;
import java.io.Serializable;
import java.util.ArrayList;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.workplicity.entry.Entry;
import org.workplicity.task.NetTask;
import org.workplicity.util.Helper;
import org.workplicity.util.MongoHelper;
import org.workplicity.util.WorkDate;
import org.workplicity.worklet.WorkletContext;

/**
 *
 * @author joeycarmello
 */
public class SubLine extends Entry implements Serializable, SublineInterface {

    private Integer subNumber = -1;
    private String name = "N/A";
    private Line parent;
    private ArrayList<TransactionInterface> transactions = new ArrayList<TransactionInterface>();

    /**
     *
     */
    public SubLine() {
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
     * @param name
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return the parent line
     */
    public Line getParent() {
        return parent;
    }

    /**
     *
     * @param parent
     */
    public void setParent(Line parent) {
        this.parent = parent;
    }

    /**
     *
     * @return repositoryName
     */
    @JsonIgnore
    public String getRepositoryName() {
        return "sub_lines";
    }

    /**
     *
     * @return list of transitions
     */
    @Override
    public ArrayList<TransactionInterface> fetchTransactions() {
        return transactions;
    }

    /**
     *
     * @return new transaction instance
     */
    @Override
    public TransactionInterface createTransaction() {
        Transaction t = new Transaction();
        return t;
    }

    /**
     *
     * @return subNumber
     */
    @Override
    public Integer getSubNumber() {
        return this.subNumber;
    }

    /**
     *
     * @param subNumber
     */
    public void setSubNumber(Integer subNumber) {
        this.subNumber = subNumber;
    }

    /**
     *
     * @param ti
     */
    @Override
    public void add(TransactionInterface ti) {
        Transaction t = (Transaction) ti;
        transactions.add(t);
    }

    /**
     *
     * @param ti
     */
    @Override
    public void delete(TransactionInterface ti) {
        Transaction t = (Transaction) ti;
        transactions.remove(t);
        BridgeHelper.getHamper().put(t,State.DELETE);
    }

    /**
     *
     * @return boolean status of commit
     */
    @Override
    public Boolean commit() {
        State myState = BridgeHelper.getHamper().get(this);

        if (myState == null)
            return true;

        for (TransactionInterface trans : transactions) {
            State state = BridgeHelper.getHamper().get(trans);

            if (state != null) {
                trans.commit();

                if(state == State.DELETE)
                    transactions.remove(trans);

                else if(state == State.CREATE)
                    transactions.add(trans);
            }
        }

        return true;
    }

    /**
     *
     * @return subNumber
     */
/*    @Override
    public Integer getId() {
        return subNumber;
    }*/
}
