/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.special;

import org.workplicity.worklet.WorkletContext;
import org.workplicity.task.NetTask;
import org.workplicity.util.Helper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dan
 */
public class loginTest {

	@Test
	public void loginTest() {
		WorkletContext context = WorkletContext.getInstance();
		boolean login = Helper.login("admin","gazelle",context);
		assertTrue(login);
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
}
