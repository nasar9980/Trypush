package pac1;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MultiWindow {
	WebDriver driver;
	@BeforeTest
	public void OpenBrowser(){
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
	}
	@AfterTest
	public void CloseBrowser(){
		driver.quit();
	}
	@Test(priority=0)
	public void WindowHandele(){
		driver.get("file:///C:/WebSite/SuperTech.html");
		String Title=driver.getTitle();
		System.out.println("Title Is :"+Title);
		
		WebElement SM=driver.findElement(By.linkText("Social Media"));
		Actions act=new Actions(driver);
		act.moveToElement(SM).build().perform();
		
		driver.findElement(By.partialLinkText("Facebook")).click();
		
		String MainWindow=driver.getWindowHandle();
		Set<String>ChildWindows=driver.getWindowHandles();
		
		for(String Child : ChildWindows){
			driver.switchTo().window(Child);
		}
		String SecondWindowTitle=driver.getTitle();
		System.out.println("Second window title is :"+SecondWindowTitle);
	}
		@Test(priority=1)
		public void firstName(){
		
			WebElement FName=driver.findElement(By.id("u_0_2"));
			FName.sendKeys("nasar");
			System.out.println("First Name is :"+FName.getAttribute("value"));
			
		}
			
		
		
	}


