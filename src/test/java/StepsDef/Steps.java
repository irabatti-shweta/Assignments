package StepsDef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;


public class Steps {
	static WebDriver driver;
	
	@Given("Open Chrome browser")
	public void open_chrome_browser() {
	    //driver=new ChromeDriver();
		driver=new FirefoxDriver();
	}

	@And("Navigate to Gmail {string}")
	public void navigate_to_gmail(String url) {
	    driver.get(url);
	    System.out.println("Entered URL");
	}

	@When("I enter Email {string} and click Next")
	public void i_enter_email_and_click_next(String email) {
		
	    driver.findElement(By.xpath("//*[@id=\'identifierId\']")).sendKeys(email);
	    driver.findElement(By.xpath("//*[@id=\'identifierNext\']/div/button")).click();
	    System.out.println("Entered email");
	}

	@And("I enter Password {string} and click Next")
	public void i_enter_password_and_click_next(String password) {
	    driver.findElement(By.xpath("//*[@id=\'password\']/div[1]/div/div[1]/input")).sendKeys(password);
	    driver.findElement(By.xpath("//*[@id=\'passwordNext\']/div/button/span")).click();
	    System.out.println("Entered Password");
	}

	@And("Click to Not Now")
	public void click_to_not_now() {
		System.out.println("Clicked not now");
	    
	}

	@Then("I logged into my Gmail account")
	public void i_logged_into_my_gmail_account() {
	    
	}
	
	public static void stackoverflowlogin() {
		driver = new FirefoxDriver();
		driver.get("https://stackoverflow.com/users/login");
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("shwetairabatti99@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Test@1234");
		driver.findElement(By.xpath("//*[@id=\"submit-button\"]")).click();		
	}

}
