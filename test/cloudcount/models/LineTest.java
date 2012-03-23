/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudcount.models;

import cc.test.bridge.SublineInterface;
import java.util.ArrayList;
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
public class LineTest {

		public LineTest() {
		}

		@BeforeClass
		public static void setUpClass() throws Exception {
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
		 * Test of getBudget method, of class Line.
		 */
		@Test
		public void testGetBudget() {
				System.out.println("getBudget");
				Line instance = new Line();
				Integer expResult = null;
				Integer result = instance.getBudget();
				assertEquals(expResult, result);
				// TODO review the generated test code and remove the default call to fail.
				fail("The test case is a prototype.");
		}

		/**
		 * Test of setBudget method, of class Line.
		 */
		@Test
		public void testSetBudget() {
				System.out.println("setBudget");
				Integer budgetId = null;
				Line instance = new Line();
				instance.setBudget(budgetId);
				// TODO review the generated test code and remove the default call to fail.
				fail("The test case is a prototype.");
		}

		/**
		 * Test of getNumber method, of class Line.
		 */
		@Test
		public void testGetNumber() {
				System.out.println("getNumber");
				Line instance = new Line();
				Integer expResult = null;
				Integer result = instance.getNumber();
				assertEquals(expResult, result);
				// TODO review the generated test code and remove the default call to fail.
				fail("The test case is a prototype.");
		}

		/**
		 * Test of setNumber method, of class Line.
		 */
		@Test
		public void testSetNumber() {
				System.out.println("setNumber");
				Integer number = null;
				Line instance = new Line();
				instance.setNumber(number);
				// TODO review the generated test code and remove the default call to fail.
				fail("The test case is a prototype.");
		}

		/**
		 * Test of getName method, of class Line.
		 */
		@Test
		public void testGetName() {
				System.out.println("getName");
				Line instance = new Line();
				String expResult = "";
				String result = instance.getName();
				assertEquals(expResult, result);
				// TODO review the generated test code and remove the default call to fail.
				fail("The test case is a prototype.");
		}

		/**
		 * Test of setName method, of class Line.
		 */
		@Test
		public void testSetName() {
				System.out.println("setName");
				String name = "";
				Line instance = new Line();
				instance.setName(name);
				// TODO review the generated test code and remove the default call to fail.
				fail("The test case is a prototype.");
		}

		/**
		 * Test of fetchSublines method, of class Line.
		 */
		@Test
		public void testFetchSublines() {
				System.out.println("fetchSublines");
				Line instance = new Line();
				ArrayList expResult = null;
				ArrayList result = instance.fetchSublines();
				assertEquals(expResult, result);
				// TODO review the generated test code and remove the default call to fail.
				fail("The test case is a prototype.");
		}

		/**
		 * Test of createSubline method, of class Line.
		 */
		@Test
		public void testCreateSubline() {
				System.out.println("createSubline");
				Line instance = new Line();
				SublineInterface expResult = null;
				SublineInterface result = instance.createSubline();
				assertEquals(expResult, result);
				// TODO review the generated test code and remove the default call to fail.
				fail("The test case is a prototype.");
		}

		/**
		 * Test of add method, of class Line.
		 */
		@Test
		public void testAdd() {
				System.out.println("add");
				SublineInterface si = null;
				Line instance = new Line();
				instance.add(si);
				// TODO review the generated test code and remove the default call to fail.
				fail("The test case is a prototype.");
		}

		/**
		 * Test of delete method, of class Line.
		 */
		@Test
		public void testDelete() {
				System.out.println("delete");
				SublineInterface si = null;
				Line instance = new Line();
				instance.delete(si);
				// TODO review the generated test code and remove the default call to fail.
				fail("The test case is a prototype.");
		}

		/**
		 * Test of commit method, of class Line.
		 */
		@Test
		public void testCommit() {
				System.out.println("commit");
				Line instance = new Line();
				Boolean expResult = null;
				Boolean result = instance.commit();
				assertEquals(expResult, result);
				// TODO review the generated test code and remove the default call to fail.
				fail("The test case is a prototype.");
		}

		/**
		 * Test of getRepositoryName method, of class Line.
		 */
		@Test
		public void testGetRepositoryName() {
				System.out.println("getRepositoryName");
				Line instance = new Line();
				String expResult = "";
				String result = instance.getRepositoryName();
				assertEquals(expResult, result);
				// TODO review the generated test code and remove the default call to fail.
				fail("The test case is a prototype.");
		}
}
