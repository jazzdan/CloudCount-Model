/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import cloudcount.models.SubLine;
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
public class MassCreateSublineTest {

		public MassCreateSublineTest() {
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
		@Test
		public void main() throws Exception {
			WorkletContext context = WorkletContext.getInstance();

			for(int i=0; i>99; i++){
				SubLine sl = new SubLine();
				sl.setSubNumber(i);
				Integer insertId = MongoHelper.insert(sl, "ccmodel", sl.getRepositoryName());
				assertNotSame(insertId, Integer.valueOf(-1));
			}
		}
}
