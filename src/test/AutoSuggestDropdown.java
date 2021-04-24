package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestDropdown {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","F:\\driver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
	    driver.get("https://www.makemytrip.com/");
	    driver.findElement(By.id("fromCity")).click();
	    WebElement sourse=driver.findElement(By.xpath("//*[@placeholder='From']"));
	    sourse.sendKeys("Nag");
	    sourse.sendKeys(Keys.DOWN,Keys.ENTER);
	    Thread.sleep(2000);
	    
	    WebElement destination=driver.findElement(By.xpath("//*[@placeholder='To']"));
	    destination.sendKeys("pun");
	    for(int i=0;i<=3;i++) {
	    destination.sendKeys(Keys.ARROW_DOWN);
	    }
	    destination.sendKeys(Keys.ENTER);
		

	}

}
