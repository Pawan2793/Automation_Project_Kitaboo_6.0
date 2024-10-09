package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;



public class TC_loginpage extends Baseclass {
	
	
	
@Test (priority=1)
public void verify_validusernamepassword()
{
	logger.info("*****Starting valid_username_and_valid_password");
	
	try
	{
	LoginPage lp=new LoginPage(driver);
	lp.setUserName("jsonlearner18@yopmail.com");
	lp.setPassWord("kitaboo@123");
	lp. ClickSignButton();
	logger.info("*****Clicked on the sign in button*********");
	}
	
	catch(Exception e)
	{
		logger.error("Test failed");
		logger.debug("Debug loga...");
		Assert.fail();
	}
	
	logger.info("Finished");
}




@Test (priority=3)
public void Verify_Invalidusername_validpassword()
{
	LoginPage lp=new LoginPage(driver);
	lp.setUserName("jsonlearner182@yopmail.com");
	lp.setPassWord("kitaboo@123");
	lp. ClickSignButton();
	driver.navigate().refresh();
}

@Test (priority=2)
public void Myaacount_Signout() throws InterruptedException
{
	LoginPage lp=new LoginPage(driver);
	lp.ClickProfileIcon();
	Thread.sleep(2000);
	lp.ClickProfileSignOut();
	Thread.sleep(2000);
	lp.ClickLogOutYesBtn();
	Thread.sleep(2000);
	driver.navigate().refresh();
			
}


@Test (priority=4)

void  To_Verify_valid_username_with_invalid_password() throws InterruptedException {
	
	LoginPage lp=new LoginPage(driver);
	lp.setUserName("jsonlearner18@yopmail.com");
	lp.setPassWord("kitaboo@1234");
	lp. ClickSignButton();
	Thread.sleep(2000);
	driver.navigate().refresh();
	
}

@Test (priority=5)

void To_verify_send_btn_enable_or_not() throws InterruptedException {
	LoginPage lp=new LoginPage(driver);
	lp.setUserName("jsonlearner18@yopmail.com");
	lp.setPassWord("Kitaboo2123");
	boolean signbutton=lp.IsSignInButtonEnabled();
	Assert.assertTrue(signbutton);

	
	Thread.sleep(2000);
	driver.navigate().refresh();
}



@Test (priority=6)

void To_verify_clickof_appstore() {
LoginPage lp=new LoginPage(driver);
lp.ClickDownloadFromAppStore();

driver.navigate().refresh();
	
}

@Test (priority=7)
void To_verify_androidapp() {
	LoginPage lp=new LoginPage(driver);
	lp.ClickDownloadFromAndroidStore();
	driver.navigate().refresh();
	
}

@Test (priority=8)
void To_verify_windowstore() {
	LoginPage lp=new LoginPage(driver);
	lp.ClickDownloadWindowStore();
	driver.navigate().refresh();
	
	
}


@Test (priority=9)

void To_verify_privacy_policy() {
	LoginPage lp=new LoginPage(driver);
	lp.ClicPrivacyPolicy();
	driver.navigate().refresh();
	
}

@Test (priority=10)

void To_terms_condition() {
	LoginPage lp=new LoginPage(driver);
	lp.ClickTermsCondition();
	driver.navigate().refresh();
}


}



