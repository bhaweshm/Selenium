import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLinksClass {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		ArrayList<String> urlsLinks = new ArrayList<>();
		SoftAssert a = new SoftAssert();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> links =driver.findElements(By.xpath("//table[@class='gf-t']  //li/a"));
		for(WebElement link : links) {
			
			
			System.out.println(link.getAttribute("href"));
			urlsLinks.add(link.getAttribute("href"));
			String url = link.getAttribute("href");
			 @SuppressWarnings("deprecation")
			HttpURLConnection   conn= (HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCode = conn.getResponseCode();
			System.out.println(respCode);
			a.assertTrue(respCode<400, " The link with Text : "+link.getText()+" is broken with code " +respCode);
			
		}
		a.assertAll();
	}

}
