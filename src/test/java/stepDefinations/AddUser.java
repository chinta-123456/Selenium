package stepDefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddUser {
	WebDriver driver;
	@Given("^user navigate to OrangeHRM$")
	public void user_navigate_to_OrangeHRM() throws Throwable {
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("http://orangehrm.qedgetech.com/");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	}

	@When("^user logs in using username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void user_logs_in_using_username_as_and_password_as(String username, String password) throws Throwable {
	    driver.findElement(By.name("txtUsername")).sendKeys(username);
	    driver.findElement(By.name("txtPassword")).sendKeys(password);
	}

	@When("^user click login button$")
	public void user_click_login_button() throws Throwable {
		driver.findElement(By.name("Submit")).click();
	}

	@When("^user click Admin$")
	public void user_click_Admin() throws Throwable {
		driver.findElement(By.xpath("//b[normalize-space()='Admin']")).click();
	}

	@When("^user click Add$")
	public void user_click_Add() throws Throwable {
		driver.findElement(By.name("btnAdd")).click();
	}

	@When("^user selet role \"([^\"]*)\"$")
	public void user_selet_role(String UserRole) throws Throwable {
	   new Select(driver.findElement(By.name("systemUser[userType]"))).selectByVisibleText(UserRole);
	}

	@When("^user enter ename \"([^\"]*)\"$")
	public void user_enter_ename(String EName) throws Throwable {
		driver.findElement(By.name("systemUser[employeeName][empName]")).sendKeys(EName);
	}

	@When("^user enter uname \"([^\"]*)\"$")
	public void user_enter_uname(String Uname) throws Throwable {
		driver.findElement(By.name("systemUser[userName]")).sendKeys(Uname);
	}

	@When("^user enter pass \"([^\"]*)\"$")
	public void user_enter_pass(String Pass) throws Throwable {
		driver.findElement(By.name("systemUser[password]")).sendKeys(Pass);
		Thread.sleep(4000);
	}

	@When("^user enter cpass \"([^\"]*)\"$")
	public void user_enter_cpass(String CPass) throws Throwable {
		driver.findElement(By.name("systemUser[confirmPassword]")).sendKeys(CPass);
	}

	@When("^user click save button$")
	public void user_click_save_button() throws Throwable {
		driver.findElement(By.name("btnSave")).click();
		Thread.sleep(4000);
	}

	@Then("^user Validate url$")
	public void user_Validate_url() throws Throwable {
	    String expected = "viewSystemUsers";
	    String actual =driver.getCurrentUrl();
	    if(actual.contains(expected))
	    {
	    	System.out.println("Add User Success");
	    }
	    else
	    {
	    	System.out.println("Add User Fail");
	    }
	}
	@Then("^user close browser$")
	public void user_close_browser() throws Throwable {
	    driver.close();
}
}
