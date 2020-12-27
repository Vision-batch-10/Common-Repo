package framework;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class popups {

	
	WebDriver driver;
	@Before
	
	
	public  void setup() {
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://www.popuptest.com/goodpopups.html");
		
	}
	
	
	@Test
	
	
	public void test() {
		
		WebElement clickpopup = driver.findElement(By.xpath("//a[contains(text(),'Good PopUp #1')]"));
		clickpopup.click();
		
		
		Set<String> a = driver.getWindowHandles();
		
		Iterator<String> I = a.iterator();
		
		String parent = I.next();
		String child = I.next();
		
		driver.switchTo().window(child);
		
		System.out.println(driver.getTitle());
		
		driver.close();
		
		driver.switchTo().window(parent);
		
		System.out.println(driver.getTitle());
		
	}
}
