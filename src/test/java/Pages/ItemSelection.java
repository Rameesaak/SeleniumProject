package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItemSelection {
	WebDriver driver;
	By select=By.xpath("//*[@id=\"women_category\"]/div");
	By item=By.xpath("/html/body/div[2]/div[4]/div/div[2]/div/div[2]/div[1]/div/div[1]/div[2]/a");
	By trendButton=By.xpath("/html/body/div[2]/main/div[1]/div/div[4]/div[1]/label");
	By product=By.xpath("/html/body/div[2]/main/div[2]/div/div[3]");
	By size=By.xpath("/html/body/div[2]/main/div/div/div[3]/div[1]/div[4]/div[1]/div[3]/div[2]/span[1]");
	By addcartbutton=By.xpath("/html/body/div[2]/main/div/div/div[3]/div[1]/div[4]/div[4]/div[2]/div[2]");
	By cart=By.xpath("/html/body/div[2]/div[4]/div/div[5]/div/div/div[3]/a/div[2]/div[1]/svg");
	By cancelitem=By.xpath("/html/body/div[2]/main/div/div/div[1]/div[1]/div/div[2]/div[1]/div/div[2]/div/svg");
	By movebutton=By.xpath("/html/body/div[2]/main/div/div/div[1]/div[2]/div[2]/div/div[2]/div[1]");

public ItemSelection(WebDriver driver )
{
	this.driver=driver;
	
}
public WebElement buyitem()
{
	return driver.findElement(select);
}
public void selectitem()
{
	driver.findElement(item).click();
}
//check radio button trending  selected or not
public Boolean buttonSelected()
{
	return driver.findElement(trendButton).isSelected();
}
public void additem()
{
	driver.findElement(product).click();
	driver.findElement(size).click();
	driver.findElement(addcartbutton).click();
}
public void cartby() {
	
	driver.findElement(cart).click();
	//close the item
	driver.findElement(cancelitem).click();
	driver.findElement(movebutton).click();
	
}
}