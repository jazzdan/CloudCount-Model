/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.create;

import cloudcount.models.Budget;
import cloudcount.models.BudgetFactory;
import cloudcount.models.Line;
import org.junit.*;
import static org.junit.Assert.*;
import org.workplicity.task.NetTask;
import org.workplicity.util.MongoHelper;
import org.workplicity.worklet.WorkletContext;

/**
 *
 * @author joeycarmello
 */
public class BudgetCreateTest1 {

    public BudgetCreateTest1() {
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
     * Tests that insert returns the actual budget object's ID
     *
     * @param args
     * @throws Exception
     */
    @Test
    public void main() throws Exception {
        WorkletContext context = WorkletContext.getInstance();

        BudgetFactory bf = new BudgetFactory();
        Budget b = (Budget) bf.create();
        b.setName("derp");

        Integer insertId = MongoHelper.insert(b, "ccmodel", b.getRepositoryName());
        assertEquals(insertId, b.getId());

        MongoHelper.delete(b, "ccmodel", b.getRepositoryName());
    }
}
