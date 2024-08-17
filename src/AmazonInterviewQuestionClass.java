import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class AmazonInterviewQuestionClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		//to maximize the window
		driver.manage().window().maximize();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		//create array of items needed
		String veggies[] = {"Cucumber","Beetroot"};
		addItems(driver , veggies,wait);
	    }
		
	
	public static void addItems(WebDriver driver,String veggies[],WebDriverWait wait)  {
		//convert it into arraylist
		List<String> al = Arrays.asList(veggies);
		List<WebElement> products = driver.findElements(By.xpath("//h4[@class='product-name']"));
		int j = 0;
		for(int i=0;i<products.size();i++) {
			
			j++;
			String name =  products.get(i).getText();
			//format it to only name
			name = name.split("-")[0].trim();
			
			/*if(j > veggies.length) 
				break;*/
			
			
			//in one line
			//String name = products.get(i).getText().split("-")[0].trim();
			
			if(al.contains(name)) {
				driver.findElements(By.xpath("//button[@type='button']")).get(i).click();
		
			}
			
		}
		
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//div[@class='cart-preview active'] //button[@type='button']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoCode")));
		driver.findElement(By.className("promoCode")).sendKeys("RahulShetty");
		driver.findElement(By.className("promoBtn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo")));
		System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo"))).getText());
		
	}
}
