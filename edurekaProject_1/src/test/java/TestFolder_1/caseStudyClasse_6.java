package TestFolder_1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class caseStudyClasse_6 {
	 WebDriver driver;
	 WebDriverWait wt;
  @Test
  public void f() {
  }
  @BeforeClass
  public void setUpBrowser() {	 
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\azirq\\Documents\\Selenium\\DriverForSelenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.edureka.co/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
  }
  @AfterClass
  public void afterClass() {
	  wt = new WebDriverWait(driver, 20);
		WebElement proLink = driver.findElement(By.xpath("//img[@class='user_image']"));
		wt.until(ExpectedConditions.elementToBeClickable(proLink));
		proLink.click();	
		driver.findElement(By.linkText("Log Out")).click();
  }
}
