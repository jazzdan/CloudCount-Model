/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudcount.models.deleteTests;

import cc.test.bridge.BudgetInterface;
import cloudcount.models.Budget;
import cloudcount.models.BudgetFactory;
import cloudcount.models.Line;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.workplicity.task.NetTask;
import org.workplicity.util.MongoHelper;
import org.workplicity.worklet.WorkletContext;

/**
 *
 * @author dan
 */
public class BudgetDeleteTest0 {

    public BudgetDeleteTest0() {
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
     * Test delete returns ID of the deleted budget
     *
     * @param args
     * @throws Exception
     */
    @Test
    public static void main(String[] args) throws Exception {
        WorkletContext context = WorkletContext.getInstance();

        BudgetFactory bf = new BudgetFactory();
        Budget b = (Budget) bf.create();
        b.setName("derp");
        b.add(new Line());

        Integer insertId = MongoHelper.insert(b, "ccmodel", b.getRepositoryName());

        Integer deleteId = MongoHelper.delete(b, "ccmodel", b.getRepositoryName());
        
        assertEquals(deleteId, insertId);
    }
}
