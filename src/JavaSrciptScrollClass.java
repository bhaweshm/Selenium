import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaSrciptScrollClass {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		int colSum = 0 ;
		int colSum1 = 0;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		List<WebElement> columns =driver.findElements(By.xpath("//div[@class='tableFixHead'] //td[4]"));
		for(int i =0; i<columns.size();i++) {
			colSum = colSum + Integer.parseInt(columns.get(i).getText());
		}
		for(WebElement col :columns) {
			colSum1 +=  Integer.parseInt(col.getText());
		}
		System.out.println("colSum :" + colSum);
		System.out.println("colSum1 :" +colSum1);
		String temp =driver.findElement(By.className("totalAmount")).getText().split(":")[1].trim();
		int expectedCol = Integer.parseInt(temp);
		Assert.assertEquals(colSum, expectedCol);
		Assert.assertEquals(colSum1, expectedCol);
	}

}
