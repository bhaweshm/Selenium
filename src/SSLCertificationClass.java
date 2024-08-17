
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCertificationClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//FirefoxOptions optionsF = new FirefoxOptions();
		//optionsF.setAcceptInsecureCerts(true);
		//EdgeOptions optionsE = new EdgeOptions();
		//optionsE.setAcceptInsecureCerts(true);
		//WebDriver driverF = new FirefoxDriver(optionsF);
		//WebDriver driverE = new EdgeDriver(optionsE);
		
		//set up ssl certificate
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		
		//set up proxy
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("ipadress:2222");
		options.setCapability("proxy",proxy);
		
		//set a download 
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path");
		options.setExperimentalOption("prefs", prefs);
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		
		
	}

}
