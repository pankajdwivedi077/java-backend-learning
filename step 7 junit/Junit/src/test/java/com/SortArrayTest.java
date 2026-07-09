package com;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;

import org.junit.jupiter.api.Test;

class SortArrayTest {

	@Test
	void testArray() {  // test case should pass if there is exception
		// array null pointer exception
		try {
			SortArray arr = new SortArray();
//			int[] unsorted = {2,1,3};
			int[] unsorted = null;
			int [] sorted = arr.sortingArray(unsorted);
			for(int el:sorted) {
				System.out.println(el);
			}
			fail();
		}
		catch(NullPointerException e) {
			System.out.println("Exception generated");
		}
	}
	
	@Test
	void testArray2() {  
	  SortArray arr = new SortArray();
	  int[] unsorted = null;
	  assertThrows(NullPointerException.class, ()-> arr.sortingArray(unsorted));
	}
	
	@Test
	void testSortingPerformance() {
		 SortArray arr = new SortArray();
		 int[] unsorted = {1,3,2};
		 assertTimeout(Duration.ofMillis(10), ()-> arr.performance(unsorted));
	}

}
