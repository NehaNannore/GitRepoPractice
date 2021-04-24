package Base;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Base {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "F:\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait w=new WebDriverWait(driver,7);

		String[] itemsNeeded = { "Cucumber", "Tomato", "Potato" };
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");

		Thread.sleep(3000);
		addItems(driver, itemsNeeded);
		driver.findElement(By.xpath("//*[@alt='Cart']")).click();
		driver.findElement(By.xpath("//*[text()='PROCEED TO CHECKOUT']")).click();// use of link bz it is static
		driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector(".promoBtn")).click();
		//explicit wait
		//WebDriverWait w=new WebDriverWait(driver,7);
		w.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[text()='Code applied ..!']"), "Code applied ..!"));
		//Assert.assertEquals(driver.findElement(By.xpath("//*[text()='Code applied ..!']")).getText(),"Code applied ..!");

	}

	public static void addItems(WebDriver driver, String[] itemsNeeded) {
		int j = 0;
		List<WebElement> product = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < product.size(); i++) {

			String[] name = product.get(i).getText().split("-");// split giving 2 value
			String formatedName = name[0].trim();// format it to get actual vegitable name
			// convert array into array list for easy search
			// check name u extracted present in arraylist or not

			List<String> itemsNeededlist = Arrays.asList(itemsNeeded);
			if (itemsNeededlist.contains(formatedName)) {
				j++;
				driver.findElements(By.xpath("//*[@class='product-action']/button")).get(i).click();
				if (j == itemsNeeded.length) {
					break;
				}
			}

		}
	}
}
