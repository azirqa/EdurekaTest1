package TestFolder_1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.base.Function;

public class facebookt1 {

	static WebDriver driver;
	public void setBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\azirq\\Documents\\Selenium\\DriverForSelenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
		
	public static void main(String[] args) {
		facebookt1 finEl = new facebookt1();
		finEl.setBrowser();
		
		List<WebElement> footers = driver.findElements(By.xpath("//ul[@class='uiList pageFooterLinkList _509- _4ki _703 _6-i']/li"));
		System.out.println(footers.size());
	
		for(WebElement allfooter : footers ) {
			System.out.println(allfooter.getText());
			String footerText = allfooter.getText();
			allfooter.click();
		
			if(footerText.equalsIgnoreCase("Cookies")){
				allfooter.click();;
				//break;
			}
			
		//	driver.quit();
	}
	}
}
