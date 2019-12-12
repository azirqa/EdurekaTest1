package TestFolder_1;

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

public class caseStudyClasse_3 {

	static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\azirq\\Documents\\Selenium\\DriverForSelenium\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.navigate().to("https://www.edureka.co");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.id("search-inp3")).click();
		WebElement SearchText = driver.findElement(By.xpath("//input[@id='search-inp-overlay-new']"));
		SearchText.sendKeys("Selenium");
		SearchText.sendKeys(Keys.ENTER);
		
		WebDriverWait explicitWait = new WebDriverWait(driver, 10);
		WebElement sCourse = driver
				.findElement(By.xpath("//div[@class='textinfoleft trainingcourse']//h3[contains(text(),'Selenium')]"));
		explicitWait.until(ExpectedConditions.visibilityOf(sCourse)).click();

		String actTitle = driver.getTitle();
		System.out.println("Title for Selenium courser is : " + actTitle);
		String expectedTitle = "Selenium 3.0 WebDriver Online Training";

		if (actTitle.equals(expectedTitle)) {
			System.out.println("Expectd tile displayed");
		} else {
			System.out.println("Tile did not match. Test case Passed. intentional mismatch to verify");
		}
		driver.navigate().back();
		driver.navigate().back();

		Wait<WebDriver> fluentwait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		WebElement allCoursesLink = fluentwait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement courses = driver
						.findElement(By.xpath("//li[@class='ga-allcourses']//a[contains(text(),'Courses')]"));
				if (courses.isEnabled()) {
					System.out.println("AllCourses Element are found and clicked");
				}
				return courses;
			}
		});
		allCoursesLink.click();

	}
}
