package framework;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



public class ToolTip {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Automation jars and softwares\\projects\\selenium\\chromedriver.exe");
		WebDriver driver;
		driver=new ChromeDriver();
		String tooltipdef= "telescope";
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://app.patseer.com");
		////span[@id='tooltip_42099_0']
		WebElement username=driver.findElement(By.id("LoginForm:loginName"));
		username.sendKeys("mnighut@patentinsightpro.com");
		
		WebElement password=driver.findElement(By.id("LoginForm:password"));
		password.sendKeys("771baner");
		
		WebElement login=driver.findElement(By.id("LoginForm:submitButton"));
		login.click();
		
		WebElement project=driver.findElement(By.xpath("//span[contains(text(),'telescope ')]"));
		
		Actions act=new Actions(driver);
		act.moveToElement(project).build().perform();
		Assert.assertEquals(tooltipdef, project.getText());
		System.out.println(project.getText());
	}

}
