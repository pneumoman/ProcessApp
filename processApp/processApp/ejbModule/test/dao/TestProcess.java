package test.dao;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import processApp.struct.Duration;
import processApp.struct.Step;
import processApp.struct.dao.Dao;

public class TestProcess
{

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		
		step = new Step("Test1");
		step.setType("bob");
		step.setSched(
				new Duration(
						new Date(9999),
						new Date(15000)
						)
				);
		P = new processApp.struct.Process("tester");
		P.addStep(step);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
	}

	@Before
	public void setUp() throws Exception
	{
		dao  = new Dao();
	}

	@After
	public void tearDown() throws Exception
	{
		dao.close();
	}

	@Test
	public void testSaveProcess()
	{
		assertTrue(dao.saveProcess(P));
	}

	@Test
	public void testDeleteProcess()
	{
		processApp.struct.Process temp = dao.getProcess(P.getId());
		assertTrue(dao.deleteProcess(temp));
	}

	@Test
	public void testGetProcess()
	{
		processApp.struct.Process temp = dao.getProcess(P.getId());
		assertEquals(temp.getId(), P.getId());
		assertEquals(temp.getSteps().get(0).getId(),step.getId());
	}
	Dao dao;
	
	static processApp.struct.Process P;
	static processApp.struct.Step step;
}
