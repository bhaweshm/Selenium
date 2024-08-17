import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebTableFilterStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		String input ="rice";
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.id("search-field")).sendKeys(input);
		List<WebElement> elementList = driver.findElements(By.xpath("//table[@class='table table-bordered'] //tr/td[1]"));
		for(WebElement elem : elementList) {
			System.out.println(elem.getText());
		}
		List<String> originalList = elementList.stream().map(s->s.getText()).collect(Collectors.toList());
		originalList.forEach(s->System.out.println("originalList :" +s));
		
		List<String> filteredList = elementList.stream().map(s->s.getText()).filter(s->s.contains("Rice")).collect(Collectors.toList());
		filteredList.forEach(s->System.out.println("filteredList :"+s));
		
		Assert.assertTrue(originalList.equals(filteredList));
		Assert.assertEquals(originalList.size(),filteredList.size());


	}

}
