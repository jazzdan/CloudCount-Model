/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudcount.models.createTests;

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
public class BudgetCreateTest2 {

    public BudgetCreateTest2() {
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
     * Tests to make sure the budget ID is different each insert
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
        assertNotSame(insertId, Integer.valueOf(-1));

        Budget b2 = (Budget) bf.create();
        b2.setName("derp2");

        Integer insertId2 = MongoHelper.insert(b2, "ccmodel", b2.getRepositoryName());
        assertNotSame(insertId, insertId2);

        MongoHelper.delete(b, "ccmodel", b.getRepositoryName());
        MongoHelper.delete(b2, "ccmodel", b2.getRepositoryName());
    }
}
