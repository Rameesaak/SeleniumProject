package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
	WebDriver driver;
	//registration
	By login=By.xpath("//*[@id=\"desktop_profile\"]/div[2]/div/div[2]");
	By button=By.xpath("//*[@id=\"desktop_profile_expand\"]/div[1]/div[3]/a/span");
	//login
	By phoneno=By.xpath("//*[@id=\"emph\"]");
	By nextbutton=By.xpath("/html/body/div[2]/main/div[1]/div/div/div[2]/form/div[3]/input");
	By otp=By.xpath("//*[@id=\"otp\"]");
	By submit=By.xpath("//*[@id=\"modify_for_ctob\"]");
	//logo
	By logo=By.xpath("//*[@id=\"DeskLogo\"]/a/div");

	public Login(WebDriver driver )
	{
		this.driver=driver;
		
	}
	public void login()
	{
	driver.findElement(login).click();
	driver.findElement(button).click();
	}
	public void Setnum() throws Exception
	{
		driver.findElement(phoneno).clear();
		driver.findElement(phoneno).sendKeys("9633584292");	
		driver.findElement(nextbutton).click();
		Thread.sleep(500);
		driver.findElement(otp).click();
	}
	public boolean display()
	{
		return driver.findElement(logo).isDisplayed();
		
	}
	public List<WebElement> linkDisplay()
	{

		return driver.findElements(By.tagName("a"));
		
	}
}
