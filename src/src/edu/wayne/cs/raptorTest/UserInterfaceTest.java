package edu.wayne.cs.raptorTest;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.wayne.cs.raptor.User;

public class UserInterfaceTest {
	
	@Test
	public void testSetAndGetUsername() {
		String expected = "beercan";
		String actual;
		User ui = new User();
		ui.setUsername(expected);
		actual = ui.getUsername();
		assert(expected.equals(actual));
	}

	@Test
	public void testSetAndGetPassword() {
		String expected = "hairpiece";
		String actual;
		User ui = new User();
		ui.setPassword(expected);
		actual = ui.getPassword();
		assert(expected.equals(actual));
	}

	//there are several issues changing how these tests may operate, deal with them after those have been resolved.  
	//including but not limited to github issue #10, #11
//	@Test
//	public void testGetValidLoginAttemptResult() 
//	{
//		String successAttempt = "Valid password";
//		String validPw = "raptor";
//		User ui = new User();
//		ui.setPassword(validPw);
//		ui.checkPassword();
//		assert(ui.getLoginAttemptResult().equals(successAttempt));
//	}
//	
//	@Test
//	public void testGetInvalidLoginAttemptResult()
//	{
//		
//		String failAttempt = "Invalid password.  Try again.";
//		String invalidPw = "pterodactyl";
//		User ui = new User();
//		ui.setPassword(invalidPw);
//		ui.checkPassword();
//		assert(ui.getLoginAttemptResult().equals(failAttempt));
//	}
//
//	//will this method be used or was it just auto-generated?
////	@Test
////	public void testSetloginAttemptResult() {
////		fail("Not yet implemented");
////	}
//
//	@Test
//	public void testCheckValidPassword() 
//	{
//		String success = "valid";
//		String validPw = "raptor";
//		User ui = new User();
//		ui.setPassword(validPw);
//		assert(ui.checkPassword().equals(success));
//	}
//	
//	@Test
//	public void testCheckInvalidPassword()
//	{
//		String fail= "invalid";
//		String invalidPw = "pterodactyl";
//		User ui = new User();
//		ui.setPassword(invalidPw);
//		assert(ui.checkPassword().equals(fail));
//	}

}
