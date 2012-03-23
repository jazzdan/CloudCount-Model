
package cloudcount.models;

import cc.test.bridge.TransactionInterface;
import java.util.Date;
import org.workplicity.entry.Entry;

/**
 *
 * @author joeycarmello
 */
public class Transaction extends Entry implements TransactionInterface {

		/**
		 *
		 */
		public static final String REPOSITORY = "transactions";

    private String name;

    private Date date;

    private Double amount;

	/**
	 *
	 */
	public Transaction() {

    }

	/**
	 *
	 * @return
	 */
	@Override
    public Double getAmount() {
        return amount;
    }

	/**
	 *
	 * @param amount
	 */
	@Override
    public void setAmount(Double amount) {
        this.amount = amount;
    }

	/**
	 *
	 * @return
	 */
	@Override
    public Date getDate() {
        return date;
    }

	/**
	 *
	 * @param date
	 */
	@Override
    public void setDate(Date date) {
        this.date = date;
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
	 * @return
	 */
	@Override
    public String getName() {
        return this.name;
    }

	/**
	 *
	 * @return
	 */
	@Override
    public Boolean commit() {
        return true;
    }

	/**
	 *
	 * @return
	 */
	@Override
    public String getRepositoryName() {
        return Transaction.REPOSITORY;
    }


}
