import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class CheckBoxClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("input[id *='friendsandfamily']")).isSelected();
		driver.findElement(By.cssSelector("input[id *='friendsandfamily']")).click();
		driver.findElement(By.cssSelector("input[id *='friendsandfamily']")).isSelected();
		//count the no of checkboxes
		int res =driver.findElements(By.xpath("//input[contains(@type,'checkbox')]")).size();
		System.out.println(res);
	}

}
