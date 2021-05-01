package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) {

		// create driver object specific to browser

		System.setProperty("webdriver.chrome.driver", "F:\\driver\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://google.com");

		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getPageSource());
		System.out.println("This is to test git untracked");
		

		driver.get("http://yahoo.com");
		driver.navigate().back();
		driver.navigate().forward();
		driver.quit();

	}

}
