import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
public class CalenderUIClass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		String monthNumber = "8";
		String date = "7";
		String year = "2027";
		String[] expectedCaL = {monthNumber,date,year};
		driver.findElement(By.cssSelector(".react-date-picker__calendar-button.react-date-picker__button")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText.react-calendar__navigation__label__labelText--from")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__arrow.react-calendar__navigation__next-button")).click();
		String actualYear = driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText.react-calendar__navigation__label__labelText--from")).getText();
		System.out.println(actualYear);
		while(!actualYear.equals(year)) {
		driver.findElement(By.cssSelector(".react-calendar__navigation__arrow.react-calendar__navigation__next-button")).click();
		Thread.sleep(1000);
		actualYear =driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText.react-calendar__navigation__label__labelText--from")).getText();
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='react-calendar__year-view__months']/button/abbr[@aria-label='August 2027']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='react-calendar__month-view__days']/button/abbr[@aria-label='August 7, 2027']")).click();
		
		List<WebElement> actualCal = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		for(int i = 0; i <actualCal.size(); i++) {
			System.out.println(actualCal.get(i).getAttribute("value"));  
			Assert.assertEquals(actualCal.get(i).getAttribute("value"), expectedCaL[i]);
		}
		
	
	}

}
