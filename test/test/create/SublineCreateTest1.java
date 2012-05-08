/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.create;

import cloudcount.models.Budget;
import cloudcount.models.BudgetFactory;
import cloudcount.models.Line;
import cloudcount.models.SubLine;
import org.junit.*;
import static org.junit.Assert.*;
import org.workplicity.task.NetTask;
import org.workplicity.util.MongoHelper;
import org.workplicity.worklet.WorkletContext;

/**
 *
 * @author joeycarmello
 */
public class SublineCreateTest1 {

    public SublineCreateTest1() {
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
     * Tests that inserting a subline sets the new insert ID on the object
     *
     * @param args
     * @throws Exception
     */
    @Test
    public void main() throws Exception {
        WorkletContext context = WorkletContext.getInstance();

        SubLine sl = new SubLine();
        sl.setSubNumber(1);

        Integer insertId = MongoHelper.insert(sl, "ccmodel", sl.getRepositoryName());
        assertEquals(new Integer(1), sl.getSubNumber());

        MongoHelper.delete(sl, "ccmodel", sl.getRepositoryName());
    }
}
