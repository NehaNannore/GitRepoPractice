package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class E2E {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "F:\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.spicejet.com/");
	    
	    //select from and to date
	    driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_originStation1_CTXT")).click();
	    driver.findElement(By.xpath("//*[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //*[@value='JAI']")).click();
		Thread.sleep(2000);
	    driver.findElement(By.xpath("(//*[@value='DIB'])[4]")).click();
	     
	    
	    //select calendar
	    driver.findElement(By.cssSelector("#ctl00_mainContent_rbtnl_Trip_0")).click();
	    if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) { 
	    	
	    	Assert.assertTrue(true);
	     }
	    else
	    {
	    	Assert.assertTrue(false);
	    }
	    
	    //select checbox
	    driver.findElement(By.cssSelector("[id*='chk_friendsandfamily']")).click();
	    
	    //select passenger
	    driver.findElement(By.cssSelector(".paxinfo")).click();
		Select s1=new Select(driver.findElement(By.name("ctl00$mainContent$ddl_Adult")));
		s1.selectByIndex(1);
     	Select s2=new Select(driver.findElement(By.name("ctl00$mainContent$ddl_Child")));
		s2.selectByIndex(3);
	    Select s3=new Select(driver.findElement(By.name("ctl00$mainContent$ddl_Infant")));
	    s3.selectByIndex(1);
		   
		 //select curruncy
	    Select s= new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
	    s.selectByIndex(1);
	    s.selectByValue("INR");
	    s.selectByVisibleText("USD");
	    
	    //click on search
	    Assert.assertTrue(driver.findElement(By.xpath("(//*[@value='Search'])[1]")).isEnabled());
	    driver.findElement(By.xpath("(//*[@value='Search'])[1]")).click();
	    
	    
	    

	}

}
