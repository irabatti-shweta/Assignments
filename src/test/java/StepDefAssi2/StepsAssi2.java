package StepDefAssi2;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.agent.builder.AgentBuilder.CircularityLock.Global;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class StepsAssi2 {
	WebDriver driver=new ChromeDriver();	//Created driver
 	String desTextBefore,desText,desColorBefore,desColor; 	//Created variables required
	@Given("Open Chrome browser and navigate to url {string}")	//Function to open browser and navigate to the given url.
	public void open_chrome_browser_and_navigate_to_url(String url) throws InterruptedException {
		driver.manage().window().maximize();	//Maximized the window
		driver.get(url);	//Navigating to URL
	   Thread.sleep(100);
	}

	@When("Dragged source and dropped to target")	//Function to drag source and drop to target
	public void dragged_source_and_dropped_to_target() throws InterruptedException {
		driver=driver.switchTo().frame(0);	//Switched to the frame where source and target are present
		Thread.sleep(100);
	    WebElement src=driver.findElement(By.id("draggable")); 	//Found source element 
	    WebElement des=driver.findElement(By.id("droppable"));	//Found target element
	    desTextBefore=des.getText();	//Getting text available at target before drag and drop operation for comparison
	    System.out.println(desTextBefore);	
	    desColorBefore=find_color(des);		//Getting color of target before drag and drop operation for comparison
	    Actions act=new Actions(driver);	//Created an object of action so that function under this can be used
	    act.dragAndDrop(src, des).build().perform();	//performed drag and drop operation using function available under Actions class
	    desText=des.getText();	//Getting text available at target after drag and drop operation for comparison
	    System.out.println(desText);
	    desColor=find_color(des);	//Getting color of target after drag and drop operation for comparison 
	}

	@Then("Verify Text and color changed")	//Function to verify text and color changed
	public void verify_text_and_color_changed() {
		//System.out.println(desTextBefore+","+desText+","+desColorBefore+","+desColor);
		System.out.println(verify_text_and_color(desTextBefore, desText, desColorBefore,desColor));
		driver.close();
	} 
	
	/*
	@Then("Verify Text changed to {string} and color changed to {string}")
	public void verify_text_changed_to_and_color_changed_to(String desTextV, String desColorV) {
		System.out.println(desText+","+desTextV+","+desColor+","+desColorV);
		System.out.println(verify_text_and_color(desText, desTextV, desColor,desColorV));
	    driver.close();
	}*/
	
	public static String verify_text_and_color(String desTextBefore, String desText, String desColorBefore, String desColor) {
		if(!desTextBefore.equals(desText) && !desColorBefore.equals(desColor)) 
			return "Text changed from "+desTextBefore+" to "+desText+" and color from "+desColorBefore+" To "+desColor;
		else return "Failed"; 
	}
	
	public static String find_color(WebElement desElem) {
	    String desColor=desElem.getCssValue("color");
	    desColor=Color.fromString(desColor).asHex();
		return desColor;
	}
	
}
