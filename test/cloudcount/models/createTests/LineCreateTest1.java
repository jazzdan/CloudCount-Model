/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudcount.models.createTests;

import org.junit.*;
import static org.junit.Assert.*;
import org.workplicity.task.NetTask;

/**
 *
 * @author joeycarmello
 */
public class LineCreateTest1 {
    
    public LineCreateTest1() {
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
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
