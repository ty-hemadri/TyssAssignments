package com.te.junit.mathutil;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
@TestInstance(Lifecycle.PER_CLASS)// it creates instance globally for every method
class MathUtilTest {
	MathUtil mathUtil = new MathUtil();
	@BeforeAll
	public static void beforeAll()
	{
		System.out.println("before all method");
	}
	
//	MathUtil mathUtil ;
//	@BeforeEach  //it will be executed no of times depends on no of test methods 
//	public void initEach(){
//	    System.out.println("Before Each initEach() method called");
//	    mathUtil = new MathUtil();
//	}

	@Test
	@DisplayName("adding")
//	@Disabled // it is used to skip the method
	void testAddNumbers() {
//		MathUtil mathUtil = new MathUtil();
		int exp=10;
		int act = mathUtil.addNumbers(5,5);
//		assertEquals(exp, act);
		assertEquals(exp, act,"Actual value is not matching with expected value");
		
	}
	@Test
	@DisplayName("dividingtwonumbers")
	@RepeatedTest(5)
	void dividing()
	{
//		MathUtil mathUtil = new MathUtil();
		assertThrows(ArithmeticException.class, ()-> mathUtil.dividing(10, 0)); //success
//		assertThrows(NullPointerException.class, ()-> mathUtil.dividing(10, 0));//failure
	}
     @AfterEach
	public void afterEach()
	{
		System.out.println("After Each method");
	}
     @AfterAll
 	public static void afterAll()
 	{
 		System.out.println("After All method");
 	}
}
