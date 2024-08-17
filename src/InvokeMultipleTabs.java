import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;


public class InvokeMultipleTabs {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		//to open new tab / window
		Thread.sleep(2000);
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it= handles.iterator();	
		String parentWindow = it.next();
		String childWindow = it.next();
		//now driver has scope in the child window
		driver.switchTo().window(childWindow);
		Thread.sleep(2000);
		driver.get("https://rahulshettyacademy.com/");
		Thread.sleep(2000);
	   String courseName = driver.findElements(By.cssSelector("a[href *='/p/']")).get(1).getText();
	   driver.switchTo().window(parentWindow);
	   driver.findElement(By.name("name")).sendKeys(courseName);
		
		
	}

}
