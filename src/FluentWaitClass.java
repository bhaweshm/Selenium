import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.util.NoSuchElementException;
import java.util.function.Function;


public class FluentWaitClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.xpath("//div[@id='start']/button")).click();
		//set up fluent wait
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).pollingEvery(Duration.ofSeconds(3))
				.withTimeout(Duration.ofSeconds(10)).ignoring(NoSuchElementException.class);

		//method
		WebElement foo = wait.until(new Function<WebDriver , WebElement>(){
			
			public WebElement apply(WebDriver driver) {
				if(driver.findElement(By.xpath("//div[@id='finish']/h4")).isDisplayed()) {
				return driver.findElement(By.xpath("//div[@id='finish']/h4"));
			}
				else
					return null;
			}
		});
		
		System.out.println(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText());
	}

}
