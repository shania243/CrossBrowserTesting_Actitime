package pom;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generics.AutoConstant;
import generics.ExcelLibrary;

public class ActitimeLoginPage implements AutoConstant
{

	@FindBy(id="username")
	private WebElement usernameTextField;
	
	@FindBy(xpath="//input[@name='pwd']")
	private WebElement passwordTextField;

	@FindBy(id="keepLoggedInCheckBox")
	private WebElement keepmeloggedinCheckbox;
	
	@FindBy(id="loginButton")
	private WebElement loginButton;
	
	@FindBy(xpath="//a[contains(text(),'Forgot']")
	private WebElement forgotyourpasswordLink;
	
	@FindBy(xpath="//a[contains(text(),'actiTIME']")
	private WebElement actitimeincLink;

	
	//initialization
	public ActitimeLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//utilization
	public void loginMethod() throws IOException
	{
		//ExcelLibrary ex =new ExcelLibrary();    //excel library is made static, so calling statically.
		
		usernameTextField.sendKeys(ExcelLibrary.getcellvalue(sheet_name, 5, 5));
		passwordTextField.sendKeys(ExcelLibrary.getcellvalue(sheet_name, 5, 6));
		keepmeloggedinCheckbox.click();
		loginButton.click();
	}
	
	public void forgotyourpasswordMethod()
	{
		forgotyourpasswordLink.click();
	}
	
	public void actitimeincMethod()
	{
		actitimeincLink.click();
	}
}
