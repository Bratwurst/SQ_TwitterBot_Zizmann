import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;


public class CutTest {

	public static Cut c;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
			c = new Cut();
	}
	
	
	@Test
	public void test() {
		assertEquals("largest = 6",6, c.getLargestNumber(new int[] {1,2,3,4,5,6}));
	}

}
