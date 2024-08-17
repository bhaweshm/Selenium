import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class RelativeLocatorsClass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);
		WebElement elem = driver.findElement(By.name("name"));
		String name = driver.findElement(with(By.tagName("label")).above(elem)).getText();
		System.out.println(name);
		Thread.sleep(1000);
		WebElement dateOfBirth = driver.findElement(By.xpath("//label[@for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(dateOfBirth)).click();
		Thread.sleep(1000);
		WebElement checkbox = driver.findElement(By.xpath("//label[@for='exampleCheck1']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(checkbox)).click();
		WebElement radioBtn = driver.findElement(By.id("inlineRadio1"));
		String radioText = driver.findElement(with(By.tagName("label")).toRightOf(radioBtn)).getText();
		System.out.println(radioText);
		
		
		
	}

}
