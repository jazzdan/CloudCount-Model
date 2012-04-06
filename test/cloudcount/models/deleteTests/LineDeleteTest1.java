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
public class LineDeleteTest1 {

    public LineDeleteTest1() {
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
     * Tests that delete makes it impossible to query for the same Line again
     * the object
     *
     * @param args
     * @throws Exception
     */
    @Test
    public void main() throws Exception {
        WorkletContext context = WorkletContext.getInstance();

        Line l = new Line();
        l.setNumber(1);

        Integer insertId = MongoHelper.insert(l, "ccmodel", l.getRepositoryName());

        BasicDBObject criteria = new BasicDBObject();
        criteria.put("entry.id", insertId);
        ArrayList items = MongoHelper.query(criteria, "ccmodel", l.getRepositoryName());

        MongoHelper.delete(l, "ccmodel", l.getRepositoryName());

        ArrayList items2 = MongoHelper.query(criteria, "ccmodel", l.getRepositoryName());

        assertNotSame(items.size(), items2.size());
    }
}
