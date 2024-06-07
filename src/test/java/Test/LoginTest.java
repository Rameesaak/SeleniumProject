package Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.ItemSelection;
import Pages.Login;



public class LoginTest {
	public ChromeDriver driver;
	@BeforeTest
	public void browseropen()
	{
		driver=new ChromeDriver();
		
		
	}
	@BeforeMethod
	public void url()
	{
		driver.get("https://www.limeroad.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}
	@Test
	public void test() throws Exception
	{
		Login p=new  Login(driver);//object creation
		ItemSelection obj=new ItemSelection(driver);//object creation
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)", "");
		//screenshot
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("C:\\Users\\remiz\\eclipse-workspace\\Limeroad\\src\\test\\java\\screenshot\\limerod.png"));
		
		//logo display
				boolean b=p.display();
				 if(b)
					{
						System.out.println("logo displayed");
					}
					else
					{
						System.out.println("logo is not displayed");
					}
				 //links display
				List<WebElement> li =p.linkDisplay();
				for(WebElement link:li)
		{
			String attr=link.getAttribute("href");
			String text=link.getText();
			System.out.println(attr+"---" +text);
			
		}
				
		p.login();
		p.Setnum();
		//mousehover for selecting kurthas from women
		WebElement m=obj.buyitem();
		Actions act=new Actions(driver);
		act.moveToElement(m);
		act.perform();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		obj.selectitem();
		// trending radio button selected or not
		Boolean a=obj.buttonSelected();
		if(a)
		{
			System.out.println("enabled");
		}
		else
		{
			System.out.println("disabled");
		}
		obj.additem();
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
		obj.cartby();
	}
}
		
		
	
		

