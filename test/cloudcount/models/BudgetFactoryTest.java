/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudcount.models;

import cc.test.bridge.BudgetInterface;
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
public class BudgetFactoryTest {

	public BudgetFactoryTest() {
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
	 * Test of create method, of class BudgetFactory.
	 */
	@Test
	public void testCreate() {
		System.out.println("create");
		BudgetFactory instance = new BudgetFactory();
		BudgetInterface expResult = null;
		BudgetInterface result = instance.create();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
}
