package commonFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLoginPage {
	
	//Define Repository
		@FindBy(name = "btnreset")
		WebElement ObjReset;
		@FindBy(name = "username")
		WebElement ObjUser;
		@FindBy(xpath = "//input[@id='password']")
		WebElement ObjPass;
		@FindBy(id="btnsubmit")
		WebElement ObjLogin;
		//method for login
		public void adminLogin(String user,String pass)
		{
			ObjReset.click();
			ObjUser.sendKeys(user);
			ObjPass.sendKeys(pass);
			ObjLogin.click();
		}

}
