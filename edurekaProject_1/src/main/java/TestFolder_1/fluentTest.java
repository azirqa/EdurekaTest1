package TestFolder_1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class fluentTest {
	static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\azirq\\Documents\\Selenium\\DriverForSelenium\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.navigate().to("https://www.edureka.co");
		driver.manage().window().maximize();
		
	}
public void fluentWait() {
	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			.withTimeout(30, TimeUnit.SECONDS)
			.pollingEvery(5, TimeUnit.SECONDS)
			.ignoring(NoSuchElementException.class);
	WebElement element = wait.until(new Function<WebDriver, WebElement>() {
		public WebElement apply(WebDriver driver) {
		WebElement course = driver.findElement(By.xpath("//li[@class='ga-allcourses']//a[contains(text(),'Courses')]"));
		if(course.isEnabled()) {
			System.out.println("Element are found and clicked");
		}
		return course;
		}
		});	
	element.click();
	}

}
