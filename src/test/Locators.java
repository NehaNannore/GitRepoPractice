package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) {

		// create driver object specific to browser

		System.setProperty("webdriver.chrome.driver", "F:\\driver\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("neha");
		driver.findElement(By.id("password")).sendKeys("neha");
		// css// driver.findElement(By.cssSelector("#password")).sendKeys("aaa");
		// driver.findElement(By.xpath("//*[@id='Login']"));

		driver.findElement(By.cssSelector("#Login")).click();
		System.out.println(driver.findElement(By.cssSelector("div#error.loginError")).getText());

	}

}
