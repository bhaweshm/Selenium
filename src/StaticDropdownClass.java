import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;

public class StaticDropdownClass {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver  = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise");
		driver.manage().window().maximize();
		
		WebElement elem = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select sel = new Select(elem);
		sel.selectByValue("USD");
		String result = sel.getFirstSelectedOption().getText();
		System.out.println(result);
		List<WebElement> l1 =sel.getOptions();
		for(WebElement n : l1) {
			//System.out.println(n);
		}
		for(int i=0; i< l1.size();i++) {
			System.out.println(l1.get(i).getAttribute("value"));
		}
	}

}
