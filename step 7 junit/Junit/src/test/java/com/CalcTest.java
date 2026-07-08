package com;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalcTest {

	@Test
	public void test() {
		Calc c = new Calc();
		int actual = c.divide(10, 2);
		int expectedResult = 5;
		assertEquals(expectedResult, actual);
	}

}
