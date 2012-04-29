/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudcount.models.specialTests;

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
public class massCreateBudgetTest {

		public massCreateBudgetTest() {
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
				BudgetFactory bf = new BudgetFactory();

				System.out.println("Adding 1000 budgets");

				for(int i=0; i<999; i++){
						Budget b = (Budget) bf.create();
						b.setName("derp" + i);
						b.add(new Line());
						Integer insertId = MongoHelper.insert(b, "ccmodel", b.getRepositoryName());
						assertNotSame(insertId, Integer.valueOf(-1));
				}

				System.err.println("1000 Budgets added. Deleting budgets (JUST KIDDING NOT REALLY)");

				/*for(int i=0; i<999; i++){
						//TODO: Delete everything in the repository
				}*/
		}
}
