package StepDefAssi2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
public class test {
 private static WebDriver myTestDriver;
 
 public static void main(String[] args) {
 
 
 myTestDriver = new ChromeDriver();
 
 myTestDriver.manage().window().maximize();
 myTestDriver.manage().timeouts().implicitlyWait(1L,TimeUnit.SECONDS);
 myTestDriver.get("https://jqueryui.com/droppable/");
 
 WebElement draggable = myTestDriver.findElement(By.cssSelector("#draggable > p"));
 
 WebElement droppable = myTestDriver.findElement(By.id("droppable"));
 
 new Actions(myTestDriver).dragAndDrop(draggable, droppable).build().perform();
 }
 
}
