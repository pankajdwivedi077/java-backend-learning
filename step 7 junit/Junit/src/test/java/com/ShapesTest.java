package com;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ShapesTest {

	@Test
	void testcomputeSquareArea() {
		
		Shapes sp = new Shapes();
		
		assertEquals(576, sp.computeSquareArea(24), "Area of circle is wrong");
	}
	
	@Test
	void testcomputeSquareArea_Supplier() { // more efficient only evaluate if condition fails
		
		Shapes sp = new Shapes();
                                                    //Supplier interface
		assertEquals(576, sp.computeSquareArea(24), ()-> "Area of circle is wrong");
	}
	
	@Test
	void testcomputeSquareAreaAssert() { 
		
		Shapes sp = new Shapes();
		
		assertNotEquals(576, sp.computeSquareArea(24));
	}
	
	@Test
	void assertTrueQ() { 
		
//		Shapes sp = new Shapes();
        String str = "bell";
		assertTrue(str.equals("junit"));
	}

}
