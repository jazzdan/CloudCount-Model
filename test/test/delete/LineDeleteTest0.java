/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.delete;

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
public class LineDeleteTest0 {

    public LineDeleteTest0() {
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
     * Tests that delete on a line returns the id of the line object that was
     * deleted
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

        Integer deleteId = MongoHelper.delete(l, "ccmodel", l.getRepositoryName());

        assertEquals(deleteId, insertId);
    }
}
