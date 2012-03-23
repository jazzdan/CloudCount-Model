/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudcount.models;

import cc.test.bridge.TransactionInterface;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.workplicity.util.WorkDate;

/**
 *
 * @author dan
 */
public class SubLineTest {

		public SubLineTest() {
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
		 * Test of getName method, of class SubLine.
		 */
		@Test
		public void testGetName() {
				System.out.println("getName");
				SubLine instance = new SubLine();
				String expResult = "";
				String result = instance.getName();
				assertEquals(expResult, result);
				// TODO review the generated test code and remove the default call to fail.
				fail("The test case is a prototype.");
		}

		/**
		 * Test of setName method, of class SubLine.
		 */
		@Test
		public void testSetName() {
				System.out.println("setName");
				String name = "";
				SubLine instance = new SubLine();
				instance.setName(name);
				// TODO review the generated test code and remove the default call to fail.
				fail("The test case is a prototype.");
		}

		/**
		 * Test of getParent method, of class SubLine.
		 */
		@Test
		public void testGetParent() {
				System.out.println("getParent");
				SubLine instance = new SubLine();
				Line expResult = null;
				Line result = instance.getParent();
				assertEquals(expResult, result);
				// TODO review the generated test code and remove the default call to fail.
				fail("The test case is a prototype.");
		}

		/**
		 * Test of setParent method, of class SubLine.
		 */
		@Test
		public void testSetParent() {
				System.out.println("setParent");
				Line parent = null;
				SubLine instance = new SubLine();
				instance.setParent(parent);
				// TODO review the generated test code and remove the default call to fail.
				fail("The test case is a prototype.");
		}

		/**
		 * Test of getRepositoryName method, of class SubLine.
		 */
		@Test
		public void testGetRepositoryName() {
				System.out.println("getRepositoryName");
				SubLine instance = new SubLine();
				String expResult = "";
				String result = instance.getRepositoryName();
				assertEquals(expResult, result);
				// TODO review the generated test code and remove the default call to fail.
				fail("The test case is a prototype.");
		}

		/**
		 * Test of fetchTransactions method, of class SubLine.
		 */
		@Test
		public void testFetchTransactions() {
				System.out.println("fetchTransactions");
				SubLine instance = new SubLine();
				ArrayList expResult = null;
				ArrayList result = instance.fetchTransactions();
				assertEquals(expResult, result);
				// TODO review the generated test code and remove the default call to fail.
				fail("The test case is a prototype.");
		}

		/**
		 * Test of createTransaction method, of class SubLine.
		 */
		@Test
		public void testCreateTransaction() {
				System.out.println("createTransaction");
				SubLine instance = new SubLine();
				TransactionInterface expResult = null;
				TransactionInterface result = instance.createTransaction();
				assertEquals(expResult, result);
				// TODO review the generated test code and remove the default call to fail.
				fail("The test case is a prototype.");
		}

		/**
		 * Test of getSubNumber method, of class SubLine.
		 */
		@Test
		public void testGetSubNumber() {
				System.out.println("getSubNumber");
				SubLine instance = new SubLine();
				Integer expResult = null;
				Integer result = instance.getSubNumber();
				assertEquals(expResult, result);
				// TODO review the generated test code and remove the default call to fail.
				fail("The test case is a prototype.");
		}

		/**
		 * Test of setSubNumber method, of class SubLine.
		 */
		@Test
		public void testSetSubNumber() {
				System.out.println("setSubNumber");
				Integer subNumber = null;
				SubLine instance = new SubLine();
				instance.setSubNumber(subNumber);
				// TODO review the generated test code and remove the default call to fail.
				fail("The test case is a prototype.");
		}

		/**
		 * Test of add method, of class SubLine.
		 */
		@Test
		public void testAdd() {
				System.out.println("add");
				TransactionInterface ti = null;
				SubLine instance = new SubLine();
				instance.add(ti);
				// TODO review the generated test code and remove the default call to fail.
				fail("The test case is a prototype.");
		}

		/**
		 * Test of delete method, of class SubLine.
		 */
		@Test
		public void testDelete() {
				System.out.println("delete");
				TransactionInterface ti = null;
				SubLine instance = new SubLine();
				instance.delete(ti);
				// TODO review the generated test code and remove the default call to fail.
				fail("The test case is a prototype.");
		}

		/**
		 * Test of commit method, of class SubLine.
		 */
		@Test
		public void testCommit() {
				System.out.println("commit");
				SubLine instance = new SubLine();
				Boolean expResult = null;
				Boolean result = instance.commit();
				assertEquals(expResult, result);
				// TODO review the generated test code and remove the default call to fail.
				fail("The test case is a prototype.");
		}

		/**
		 * Test of getId method, of class SubLine.
		 */
		@Test
		public void testGetId() {
				System.out.println("getId");
				SubLine instance = new SubLine();
				Integer expResult = null;
				Integer result = instance.getId();
				assertEquals(expResult, result);
				// TODO review the generated test code and remove the default call to fail.
				fail("The test case is a prototype.");
		}

		/**
		 * Test of getUpdateDate method, of class SubLine.
		 */
		@Test
		public void testGetUpdateDate() {
				System.out.println("getUpdateDate");
				SubLine instance = new SubLine();
				WorkDate expResult = null;
				WorkDate result = instance.getUpdateDate();
				assertEquals(expResult, result);
				// TODO review the generated test code and remove the default call to fail.
				fail("The test case is a prototype.");
		}
}
