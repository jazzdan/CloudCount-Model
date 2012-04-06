/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudcount.models.readTests;

import cloudcount.models.Budget;
import cloudcount.models.BudgetFactory;
import cloudcount.models.Line;
import com.mongodb.BasicDBObject;
import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;
import org.workplicity.task.NetTask;
import org.workplicity.util.MongoHelper;
import org.workplicity.worklet.WorkletContext;

/**
 *
 * @author joeycarmello
 */
public class LineReadTest0 {
    
    public LineReadTest0() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        String url = "http://localhost:8080/netprevayle/task";
        String name = "ccmodel";
        NetTask.setUrlBase(url);
        NetTask.setStoreName(name);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
   
    @Test
    public static void main(String[] args) throws Exception {
        WorkletContext context = WorkletContext.getInstance();

     	BudgetFactory bf = new BudgetFactory();
		Budget b = (Budget) bf.create();
		b.setName("derp");
        b.add(new Line());

	Integer insertId = MongoHelper.insert(b, "ccmodel", b.getRepositoryName());

        BasicDBObject criteria = new BasicDBObject();

        criteria.put("entry.id", insertId);

        ArrayList items = MongoHelper.query(criteria, "ccmodel", "budgets");

        assertEquals(items.size(), 1);

        assertEquals(((Budget)items.get(0)).getName(), "derp");

        MongoHelper.delete(b, "ccmodel", b.getRepositoryName());
    }
}
