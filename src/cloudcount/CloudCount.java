


/**
 *
 * @author dan
 * THIS ONLY NEEDS TO BE RUN ONCE ON EACH NEW "INSTALLATION"
 */

package cloudcount;

//import org.apache.log4j.Logger;
import org.workplicity.task.NetTask;
import org.workplicity.util.Helper;
import org.workplicity.worklet.WorkletContext;

import cloudcount.models.BudgetFactory;
import cloudcount.models.Budget;
import cloudcount.models.Line;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;

import java.util.*;
import org.workplicity.util.MongoHelper;

/**
 *
 * @author dan
 */
public class CloudCount {

		/**
		 *
		 * @param args
		 * @throws Exception
		 */
		public static void main(String[] args) throws Exception {
	// accounts thing...
	Accounts acc = new Accounts();

	// properties
	Properties props = new Properties();

	// set properties
	props.setProperty("system.name", "ccmodel");
	props.setProperty("system.user.0", "admin gazelle User");

	// init accounts

	acc.init(props);

	String url = "http://localhost:8080/netprevayle/task";
	String name = "ccmodel";
	NetTask.setUrlBase(url);
	NetTask.setStoreName(name);
	WorkletContext context = WorkletContext.getInstance();
	boolean successful = Helper.login("admin","gazelle",context);

	BudgetFactory bf = new BudgetFactory();
	Budget b = (Budget) bf.create();
	b.setName("derp");
        b.add(new Line());

	Integer insert = MongoHelper.insert(b, "ccmodel", b.getRepositoryName());
	System.out.println(insert);

        BasicDBObject prod = new BasicDBObject();

        prod.put("entry.id", insert);

 //       Helper.fetch(b.getRepositoryName(), 2, WorkletContext.getInstance());
        ArrayList items = MongoHelper.query(prod, "ccmodel", "budgets");

        for (Object budget : items) {
             System.out.println(budget);
              System.out.println(((Budget) budget).getName());
	}
    }
}
