package com;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReverseStringTest {  // Junit5

	@Test
	void test() {
		
		ReverseString st = new ReverseString();
		
		assertEquals("avaj", st.reverse("java"));
	}

}
