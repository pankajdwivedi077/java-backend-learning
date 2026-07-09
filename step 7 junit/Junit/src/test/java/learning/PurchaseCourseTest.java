package learning;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class PurchaseCourseTest {

	@Test
	void test() {
		PurchaseCourse pc = new PurchaseCourse();
		boolean st = pc.proceedWithCourse(new JavaCourse());
		assertFalse(st, "its failed");
	}
	
	@Test
	void testArray() {
		int [] arr = {1,2,3};
		int [] arr2 = {1,2,3};
		assertArrayEquals(arr2, arr);
	}

}
