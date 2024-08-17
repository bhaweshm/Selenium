import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class ActionsDemoClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
      WebDriver driver = new ChromeDriver();
      driver.get("https://www.amazon.in/");
      driver.manage().window().maximize();
      //Implicit wait
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
      Actions action = new Actions(driver);
      WebElement move =driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
      // moves to specific element and right click
      action.moveToElement(move).contextClick().build().perform();
      
     WebElement inputField = driver.findElement(By.id("twotabsearchtextbox"));
     action.moveToElement(inputField).click().keyDown(Keys.SHIFT).sendKeys("Hello").doubleClick().keyUp(Keys.SHIFT)
     .build().perform();
	}

}
