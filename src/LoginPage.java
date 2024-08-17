
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginPage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String name ="rahul";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("Rahul");
		driver.findElement(By.name("inputPassword")).sendKeys("abc123");
		driver.findElement(By.className("signInBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder=\"Name\"]")).sendKeys("john");
		driver.findElement(By.xpath("//input[@placeholder=\"Email\"]")).sendKeys("john@acre.com");
		driver.findElement(By.xpath("//input[@placeholder=\"Email\"]")).clear();
		driver.findElement(By.xpath("//input[@placeholder=\"Email\"]")).sendKeys("john@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder=\"Phone Number\"]")).sendKeys("8861839260");
		driver.findElement(By.xpath("//div/button[@class='reset-pwd-btn']")).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.xpath("//p[@class='infoMsg']")).getText());
		String text = driver.findElement(By.xpath("//p[@class='infoMsg']")).getText();
		String password = text.split("'")[1];
		System.out.println(password);
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(name);
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(password);
		driver.findElement(By.id("chkboxTwo")).click();
		driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		Thread.sleep(5000);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText(), "Hello "+name+",");
		driver.findElement(By.xpath("//button[@class='logout-btn']")).click();
		driver.close();
		
		
	}

}
