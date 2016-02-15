package test.dao;

import static org.junit.Assert.*;

import java.util.Date;

import javax.validation.constraints.AssertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import processApp.struct.Duration;
import processApp.struct.Step;
import processApp.struct.dao.Dao;

public class TestSteps
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
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
		
	}

	@Before
	public void setUp() throws Exception
	{

		dao=new Dao();
	}

	@After
	public void tearDown() throws Exception
	{
		dao.close();
	}

	@Test
	public void testSaveStep()
	{
		
		assertTrue( dao.saveStep(step));
		
	}

	@Test
	public void testDeleteStep()
	{
		dao.deleteStep(step);
	}

	@Test
	public void testGetStep()
	{
		Step temp = dao.getStep(step.getId());
		assertEquals(step.getId(),temp.getId());
		assertEquals(step.getName(),temp.getName());
	}
	Dao dao;
	static Step step;
}
