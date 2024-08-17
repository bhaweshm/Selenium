import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PrintTheLinkCountClass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		int totalLinkCount = driver.findElements(By.tagName("a")).size();
		System.out.println(totalLinkCount);
		int footerLinkCount = driver.findElements(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td/ul/li/a")).size();
		System.out.println(footerLinkCount);
		//limit your scope of driver
		WebElement footerSubdriver = driver.findElement(By.xpath("//div[@id='gf-BIG']"));
		int footerLinkCountWithsubdriver = footerSubdriver.findElements(By.tagName("a")).size();
		System.out.println(footerLinkCountWithsubdriver);
		//scope for first colum
		WebElement columnSubDriver = footerSubdriver.findElement(By.xpath("//table/tbody/tr/td/ul[1]"));
		int columnLinkCount = columnSubDriver.findElements(By.tagName("a")).size();
		System.out.println(columnLinkCount);
		//click on each link 
		List<WebElement> lst = columnSubDriver.findElements(By.tagName("a"));
		for(int i =1 ; i <columnLinkCount ; i++) {
			String clickOnLinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
			columnSubDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
			Thread.sleep(1000);
		}
		
		//Handle mutliple child tabs
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		while(it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
			
		}
		
		
	}

	

}
