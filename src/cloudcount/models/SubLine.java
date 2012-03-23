package cloudcount.models;

import cc.test.bridge.SublineInterface;
import cc.test.bridge.TransactionInterface;
import com.mongodb.BasicDBObject;
import java.io.Serializable;
import java.util.ArrayList;
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
				return transactions;
		}

		@Override
		public TransactionInterface createTransaction() {
				Transaction t = new Transaction();
				return t;
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
				Transaction t = (Transaction) ti;
				t.setName("test");
				transactions.add(t);
		}

		@Override
		public void delete(TransactionInterface ti) {
				Transaction t = (Transaction) ti;
				transactions.remove(t);
		}

		@Override
		public Boolean commit() {
				int lineResult;
				int tResult;
				try {
						//TODO: Implement
						lineResult = MongoHelper.insert(this, NetTask.getStoreName(), this.getRepositoryName());
				} catch (Exception e) {
						System.out.println(this.getClass().getName() + " with id:" + id + " has not been commited because of error" + e);
						return false;
				}
				 return (lineResult > -1) ? true : false;

		}

		@Override
		public Integer getId() {
				return subNumber;
		}

//		@Override
//		public WorkDate getUpdateDate() {
//
//		}
}
