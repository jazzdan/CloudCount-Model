/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudcount.models.deleteTests;

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
public class LineDeleteTest2 {

    public LineDeleteTest2() {
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

    /**
     * Tests that delete changes the count of Lines by 1
     * @param args
     * @throws Exception 
     */
    @Test
    public static void main(String[] args) throws Exception {
        WorkletContext context = WorkletContext.getInstance();

        Line l = new Line();
        l.setNumber(1);

        Integer insertId = MongoHelper.insert(l, "ccmodel", l.getRepositoryName());

        BasicDBObject criteria = new BasicDBObject();
        criteria.put("entry.id", insertId);
        ArrayList items = MongoHelper.query(criteria, "ccmodel", l.getRepositoryName(), true);
        Double count1 = (Double)items.get(0);

        MongoHelper.delete(l, "ccmodel", l.getRepositoryName());

        ArrayList items2 = MongoHelper.query(criteria, "ccmodel", l.getRepositoryName(), true);
        Double count2 = (Double)items2.get(0);

        count1 -= 1;
        assertEquals(count1, count2);
    }
}
