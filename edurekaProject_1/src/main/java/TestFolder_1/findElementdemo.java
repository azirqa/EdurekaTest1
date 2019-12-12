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

public class findElementdemo {

	static WebDriver driver;
	public void setBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\azirq\\Documents\\Selenium\\DriverForSelenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.goindigo.in/?linkNav=home_header");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
		
	public static void main(String[] args) {
		findElementdemo finEl = new findElementdemo();
		finEl.setBrowser();
		//String exloc = "Bengaluru, India";
		driver.findElement(By.name("or-src")).click();
		List<WebElement> location = driver.findElements(By.xpath("//div[@class='autocomplete-results autocomplete-main station-results']/div"));
		for(WebElement allloc : location ) {
			System.out.println(allloc.getText());
			String loc = allloc.getText();
			if(loc.contains("BLR")){
				allloc.click();;
				break;
			}
		}
			
		
	
//	public void selectCity() throws InterruptedException {
//		driver.navigate().refresh();
//		WebElement fromlink = driver.findElement(By.xpath("//input[@name='or-src']"));
//		fromlink.click();
//		Thread.sleep(3000);
//		List<WebElement> fromcity = driver.findElements(By.xpath("//div[@class='ig-input-group field-float']//div[@class='airport-city']"));
//		System.out.println(fromcity.size());		
//		for (WebElement allFCity : fromcity) {
//			System.out.println(allFCity.getText());
//			String allCityText = allFCity.getText();
//			if(allCityText.equalsIgnoreCase("Bengaluru, India")) {
//				driver.findElement(By.className("close-cookie")).click();
//				driver.findElement(By.xpath("//div[@class='close' and @onclick='window.ymCloseNotification(event);']")).click();
//				allFCity.click();
//				break;
//			}
		}
}