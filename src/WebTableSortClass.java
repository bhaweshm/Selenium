import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
public class WebTableSortClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//click on column
		//capture all webelements into list
		//sort thr original list of step 3 -> sorted list
		//comapre the original list and sorted list
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//table[@class='table table-bordered'] //tr/th[1]")).click();
		List<WebElement> elementList = driver.findElements(By.xpath("//table[@class='table table-bordered'] //tbody/tr/td[1]"));
		System.out.println("old fashion :: for each loop");
		for(WebElement lt : elementList) {
			System.out.println(lt.getText());
		}
		
		//list<string for original list
		List<String> originalList = elementList.stream().map(s->s.getText()).collect(Collectors.toList());
		//list<string> for sorted lsit
		List<String> sortedList = elementList.stream().map(s->s.getText()).sorted().collect(Collectors.toList());
		//compare the original and sorted list
		Assert.assertTrue(originalList.equals(sortedList));
		//declare outside the do while loop 
		List<String> price;
		do
		{
		List<WebElement> newElementList = driver.findElements(By.xpath("//table[@class='table table-bordered'] //tbody/tr/td[1]"));
		//usecase: scan the name coloumn and get the price of rice
		 price  = newElementList.stream().filter(s->s.getText().contains("Wheat"))
		.map(s->getPriceVeggie(s)).collect(Collectors.toList());
		price.forEach(a->System.out.println(a));
		if(price.size()<1) {
			driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
		}
		
		}while(price.size()<1);
		
	}

	private static String getPriceVeggie(WebElement s) {
		// TODO Auto-generated method stub
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
	}

}
