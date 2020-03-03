package fr.epita.maths.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.epita.maths.FactorialService;

public class TestFactorialService {

	
	private static final Logger LOGGER = LogManager.getLogger(TestFactorialService.class);
	
	@BeforeClass
	public static void beforeAll() {
		LOGGER.info("beforeAll");
	}
	
	@Before
	public void beforeEachTest() {
		System.out.println("before");
	}
	
	
	@Test
	public void passingNegativeSmallIntegerTest() throws Exception {
		System.out.println("passingNegativeSmallIntegerTest");
		//passing test
		//given
		int negativeInt = -5;
		FactorialService factorial = new FactorialService();
		
		
		//when
		try {
			int result = factorial.calculateFactorial(negativeInt);
		}catch(Exception e) {
			System.out.println("we got this exception " + e.getMessage());
			Assert.assertTrue(e instanceof IllegalArgumentException);
			return;
		}
		
		throw new Exception();
		
	
		
	}

	@Test
	public void passingPositiveSmallIntegerTest() throws Exception {
		System.out.println("passingPositiveSmallIntegerTest");
		//passing test
		//given
		int positiveInt = 5;
		FactorialService factorial = new FactorialService();
		
		
		//when
		int result = factorial.calculateFactorial(positiveInt);
		
		
		//then
		if (result != 120) {
			throw new Exception("Bad value for 5! : expected 120 and got " + result );
		}
	}
	
	@After
	public void afterEach() {
		System.out.println("after");
	}
	
	
	@AfterClass
	public static void afterAll() {
		System.out.println("afterAll");
	}
	
	
}
