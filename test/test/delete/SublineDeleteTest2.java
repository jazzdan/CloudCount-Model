/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.delete;

import cloudcount.models.Budget;
import cloudcount.models.BudgetFactory;
import cloudcount.models.Line;
import cloudcount.models.SubLine;
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
public class SublineDeleteTest2 {

    public SublineDeleteTest2() {
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
     * Tests that delete changes the count of SubLines by 1
     * @param args
     * @throws Exception
     */
    @Test
    public void main() throws Exception {
        WorkletContext context = WorkletContext.getInstance();

        SubLine sl = new SubLine();
        sl.setSubNumber(1);

        Integer insertId = MongoHelper.insert(sl, "ccmodel", sl.getRepositoryName());

        BasicDBObject criteria = new BasicDBObject();
        criteria.put("entry.id", insertId);
        ArrayList items = MongoHelper.query(criteria, "ccmodel", sl.getRepositoryName(), true);
        int count1 = (Integer) items.get(0);

        MongoHelper.delete(sl, "ccmodel", sl.getRepositoryName());

        ArrayList items2 = MongoHelper.query(criteria, "ccmodel", sl.getRepositoryName(), true);
        int count2 = (Integer) items2.get(0);

        count1 -= 1;
        assertEquals(count1, count2);
    }
}
