package pageObjects;

import java.util.Set;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;


public class LoginPage extends basepage {
	
	public LoginPage (WebDriver driver) // Constructor
	{
		super(driver);
	}



// Element locate

@FindBy(xpath="//input[@id='email_address_input']")
WebElement txt_username;


@FindBy(xpath="//input[@id='password_input']")
WebElement txt_password;


@FindBy(className="btn-signin")
WebElement btn_signin;

@FindBy (xpath="/html/body/app-root/app-bookshelf/div/app-book-navbar/div[1]/mat-toolbar/div[3]/div[1]/div[2]/button")
WebElement btn_profileicon;

@FindBy (className="profile-signout")
WebElement btn_profile_signout;

@FindBy (className="logout_yes_btn")
WebElement btn_logout_yes_btn;


@FindBy (id="download_from_appStore")
WebElement download_from_appstore;


@FindBy (id="download_from_googlePlayStore")
WebElement download_from_androidstore;


@FindBy (id="download_from_windowsStore")
WebElement download_from_windowsstore;

@FindBy (xpath="//a[@id='privacy_policy_link']")
WebElement privacy_policy_link;

@FindBy (xpath="//a[@id='terms_conditions_link']")
WebElement terms_condition;


// Action method


public void setUserName(String user) {
	txt_username.clear();
    txt_username.sendKeys(user);  // Correct way to input text in the field
}

public void setPassWord(String pwd) {
	 txt_password.clear();
    txt_password.sendKeys(pwd); 
}

public void ClickSignButton() {
	 btn_signin.click();
}






public  boolean IsSignInButtonEnabled() {  /// FOr the sign in button is enabled or not
	
	try
	{
	
	return (btn_signin.isEnabled());
	
	}
	
	catch (Exception e)
	{
		return false;
	}
}







public void ClickProfileIcon() {
	btn_profileicon.click(); 
}

public void ClickProfileSignOut() {
	btn_profile_signout.click();
	
}

public void ClickLogOutYesBtn() {
	btn_logout_yes_btn.click();
}


public void ClickDownloadFromAppStore() {
	download_from_appstore.click();
	  // Capture all window handles after the click
    Set<String> windowHandles = driver.getWindowHandles();
    
    // Convert the Set to a List
    List<String> windowList = new ArrayList<String>(windowHandles);
    
    // Assuming the first window is the parent and the second is the child
    String parentID = windowList.get(0);
    String childID = windowList.get(1);
    
    // Switch to the new window (child)
    driver.switchTo().window(childID);
    
    // Print the title of the child window
    System.out.println(driver.getTitle());
    
    // Close the child window
    driver.close();
    
    // Switch back to the parent window
    driver.switchTo().window(parentID);
}






public void ClickDownloadFromAndroidStore() {
	download_from_androidstore.click();
	
	  // Capture all window handles after the click
    Set<String> windowHandles = driver.getWindowHandles();
    
    // Convert the Set to a List
    List<String> windowList = new ArrayList<String>(windowHandles);
    
    // Assuming the first window is the parent and the second is the child
    String parentID1 = windowList.get(0);
    String childID1 = windowList.get(1);
    
    // Switch to the new window (child)
    driver.switchTo().window(childID1);
    
    // Print the title of the child window
    System.out.println(driver.getTitle());
    
    // Close the child window
    driver.close();
    
    // Switch back to the parent window
    driver.switchTo().window(parentID1);
}
	




public void ClickDownloadWindowStore() {
	download_from_windowsstore.click();
	
	  // Capture all window handles after the click
    Set<String> windowHandles = driver.getWindowHandles();
    
    // Convert the Set to a List
    List<String> windowList = new ArrayList<String>(windowHandles);
    
    // Assuming the first window is the parent and the second is the child
    String parentID2 = windowList.get(0);
    String childID2 = windowList.get(1);
    
    // Switch to the new window (child)
    driver.switchTo().window(childID2);
    
    // Print the title of the child window
    System.out.println(driver.getTitle());
    
    // Close the child window
    driver.close();
    
    // Switch back to the parent window
    driver.switchTo().window(parentID2);
}

public void ClicPrivacyPolicy() {
	
	privacy_policy_link.click();
	
	  // Capture all window handles after the click
    Set<String> windowHandles = driver.getWindowHandles();
    
    // Convert the Set to a List
    List<String> windowList = new ArrayList<String>(windowHandles);
    
    // Assuming the first window is the parent and the second is the child
    String parentID3 = windowList.get(0);
    String childID3 = windowList.get(1);
    
    // Switch to the new window (child)
    driver.switchTo().window(childID3);
    
    // Print the title of the child window
    System.out.println(driver.getTitle());
    
    // Close the child window
    driver.close();
    
    // Switch back to the parent window
    driver.switchTo().window(parentID3);
}

public void ClickTermsCondition() {
	
	terms_condition.click();
	
	  // Capture all window handles after the click
    Set<String> windowHandles = driver.getWindowHandles();
    
    // Convert the Set to a List
    List<String> windowList = new ArrayList<String>(windowHandles);
    
    // Assuming the first window is the parent and the second is the child
    String parentID4 = windowList.get(0);
    String childID4 = windowList.get(1);
    
    // Switch to the new window (child)
    driver.switchTo().window(childID4);
    
    // Print the title of the child window
    System.out.println(driver.getTitle());
    
    // Close the child window
    driver.close();
    
    // Switch back to the parent window
    driver.switchTo().window(parentID4);	
	
}


	
}

