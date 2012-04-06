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
public class LineCreateTest0 {
    
    public LineCreateTest0() {
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
     * Tests that inserting a line results in an integer that is not -1 
     * @param args
     * @throws Exception 
     */
    @Test
        public static void main(String[] args) throws Exception {
            WorkletContext context = WorkletContext.getInstance();
        
            Line l = new Line();
            l.setNumber(2);

            Integer insertId = MongoHelper.insert(l, "ccmodel", l.getRepositoryName());
            assertNotSame(insertId, Integer.valueOf(-1));
            
            MongoHelper.delete(l, "ccmodel", l.getRepositoryName());
        }
}
