import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropDemoClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		//To find How many frames are present in the html document
		int iframeCount = driver.findElements(By.tagName("iframe")).size();
		System.out.println(iframeCount);
		//step to switch Frame
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		//click on specific element inside frame
		driver.findElement(By.id("draggable")).click();
		//drag and drop comes under action class
		Actions action = new Actions(driver);
		WebElement src = driver.findElement(By.id("draggable"));
		WebElement dest = driver.findElement(By.id("droppable"));
		action.dragAndDrop(src, dest).build().perform();
		//Leave a Frames
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[text()='Default functionality']")).click();
	}

}
