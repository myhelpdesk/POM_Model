package commonFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AddCustomerPage {
	
	@FindBy(xpath = "(//a[contains(text(),'Customers')])[2]")
	WebElement ObjCustomerLink;
	@FindBy(xpath = "(//span[@data-caption='Add'])[1]")
	WebElement ObjClickAddIcon;
	@FindBy(xpath = "//*[@id=\"x_Customer_Number\"]")
	WebElement ObjCustomerNumber;
	@FindBy(xpath = "//input[@id='x_Customer_Name']")
	WebElement ObjCustomerName ;
	@FindBy(xpath = "//textarea[@id='x_Address']")
	WebElement ObjAddress ;
	@FindBy(xpath = "//input[@id='x_City']")
	WebElement ObjCity ;
	@FindBy(xpath = "//input[@id='x_Country']")
	WebElement ObjCountry ;
	@FindBy(xpath = "//input[@id='x_Contact_Person']")
	WebElement ObjContactPerson ;
	@FindBy(xpath = "//input[@id='x_Phone_Number']")
	WebElement ObjPhoneNumber ;
	@FindBy(xpath = "//input[@id='x__Email']")
	WebElement ObjEmail ;
	@FindBy(xpath = "//input[@id='x_Mobile_Number']")
	WebElement ObjMobileNumber ;
	@FindBy(xpath = "//input[@id='x_Notes']")
	WebElement ObjNotes ;
	@FindBy(id = "btnAction")
	WebElement ObjClickAdd ;
	@FindBy(xpath = "//button[normalize-space()='OK!']")
	WebElement ObjConfirmOkButton;
	@FindBy(xpath = "//button[@class='ajs-button btn btn-primary']")
	WebElement ObjAlertOkButton;
	@FindBy(xpath = "//span[@data-caption='Search']")
	WebElement ObjSearchPanel;
	@FindBy(xpath = "//input[@id='psearch']")
	WebElement ObjSearchtextbox;
	@FindBy(xpath = "//button[@id='btnsubmit']")
	WebElement ObjSearchButton;
	@FindBy(xpath = "//table[@class='table ewTable']/tbody/tr[1]/td[5]/div/span/span")
	WebElement webtable;

	public boolean addCustomer(String Cname,String Address,String City,String Country,String Cperson,
			String Pnumber,String Email,String Mnumber,String Notes) throws Throwable
	{
		ObjCustomerLink.click();
		ObjClickAddIcon.click();
		String Exp_Data =ObjCustomerNumber.getAttribute("value");
		ObjCustomerName.sendKeys(Cname);
		ObjAddress.sendKeys(Address);
		ObjCity.sendKeys(City);
		ObjCountry.sendKeys(Country);
		ObjContactPerson.sendKeys(Cperson);
		ObjPhoneNumber.sendKeys(Pnumber);
		ObjEmail.sendKeys(Email);
		ObjMobileNumber.sendKeys(Mnumber);
		ObjNotes.sendKeys(Notes);
		ObjClickAdd.click();
		Thread.sleep(2000);
		ObjConfirmOkButton.click();
		Thread.sleep(2000);
		ObjAlertOkButton.click();
		//if  search text box is not displayed
		//********************************************
		if(!ObjSearchtextbox.isDisplayed())
			//SearchPanel button will click
			ObjSearchPanel.click();
		ObjSearchtextbox.clear();
		ObjSearchtextbox.sendKeys(Exp_Data);
		ObjSearchButton.click();
		Thread.sleep(2000);
		String Act_data =webtable.getText();
		Reporter.log(Exp_Data+"================="+Act_data,true);
		if(Exp_Data.equals(Act_data))
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
	}
}
