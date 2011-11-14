import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;


public class TwitterModelTest {

	public static TwitterModel tm;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		tm = new TwitterModel();
	}

	@Test
	public void testAddFriendFail() {
		assertEquals("Message should be Could not find User", "Could not find User", tm.addFriend("Rudolf the Rednosed"));		
	}
	
	@Test
	public void testAddFriendSucces(){
		assertEquals("Message should be Following", "Following", tm.addFriend("FhbJbotporebskk"));		
	}

}
