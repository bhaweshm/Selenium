import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class TakingWebElementPartialScreenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String courseName ="Taking WebEelement Partial Screenshot";
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.name("name")).sendKeys(courseName);
		//screenshot
		//src is object of File Class but we need a physical file with a screenshot
		File src =driver.findElement(By.name("name")).getScreenshotAs(OutputType.FILE);
		// FileUtils ->Class to get physical file from file object 
		//copyFile -> src to destination file --> where we have to create another file
		//object and give the name of the file
		//fileUtils actually convert the file object it into file in our system with name.png
		FileUtils.copyFile(src, new File("name.png"));
		
		
		// get Height and width of element
		System.out.println(driver.findElement(By.name("name")).getRect().getDimension().getWidth());
		System.out.println(driver.findElement(By.name("name")).getRect().getDimension().getHeight());
	}
	

}
