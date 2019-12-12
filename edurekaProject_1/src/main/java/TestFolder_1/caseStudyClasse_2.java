package TestFolder_1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class caseStudyClasse_2 {

	public static WebDriver driver;
	

	public static void main(String[] args) throws InterruptedException {
		
		// 1. Launch Chrome browser using Selenium WebDrive
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\azirq\\Documents\\Selenium\\DriverForSelenium\\chromedriver.exe");
		driver = new ChromeDriver();

		// 2. Navigate to “https://www.edureka.co/
		driver.get("https://www.edureka.co");

		// 3. Maximise the Browser Window
		driver.manage().window().maximize();
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		// 4. Inspect the search box.
		driver.findElement(By.id("search-inp3")).click();
		WebElement SearchText = driver.findElement(By.xpath("//input[@id='search-inp-overlay-new']"));
		SearchText.sendKeys("Search for a Course");
		driver.findElement(By.id("search-button-top")).click();
		driver.navigate().back();
				
		// 5. Get attributes id,name,xpath,class name,css values
		System.out.println("Attribute value for id : " + SearchText.getAttribute("id"));
		System.out.println("Attribute value for Name : " + SearchText.getAttribute("name"));
		System.out.println("Attribute value for class : " + SearchText.getAttribute("class"));
		System.out.println("Attribute value for CssLocator : " + SearchText.getCssValue("background"));

		// 6. Inspect the “Log In” link to get the link text and partial link text
		WebElement logLink = driver.findElement(By.linkText("Corporate Training"));
		logLink.click();
		System.out.println("Check by PartialLink -------");
		driver.navigate().back();
		WebElement PerLink = driver.findElement(By.partialLinkText("Corporate"));
		PerLink.click();
		driver.navigate().back();
		driver.navigate().refresh();
		
		// 7.8. Find element by different locator
		
		 WebElement findById = driver.findElement(By.id("top_banner_strip"));
		 System.out.println("Verify by checking Text value findById : " + findById.getText());
		 
		 WebElement findByName = driver.findElement(By.name("user_v1[query]"));
		 System.out.println("Verify by checking Text value findByName : " + findByName.getText());
		 
		 WebElement findByClass=driver.findElement(By.className("refertxt")); 
		 System.out.println("Verify by checking Text value findByClass : " + findByClass.getText());
		 
		 List<WebElement> findBytag = driver.findElements(By.tagName("a"));
		 System.out.println("Verify by checking Text value findBytag : " +findBytag.size());
		 
		 WebElement findByLink=driver.findElement(By.linkText("Corporate Training"));
		 System.out.println("Verify by checking Text value findByLink : " + findByLink.getText());
		 
		 WebElement findByPartialLink = driver.findElement(By.partialLinkText("Corporate"));
		 System.out.println("Verify by checking Text value findByPartialLink : " + findByPartialLink.getText());
		 
		 WebElement findByXpath = driver.findElement(By.xpath("//i[@class='icon-logo edu-logo-style']"));
		 System.out.println("Verify by checking Text value findByXpath : " + findByXpath.getText());
		 
		 WebElement findbyCss = driver.findElement(By.cssSelector("#pgp"));
		 System.out.println("Verify by checking Text value findbyCss : " + findbyCss.getText());
		 
		driver.quit();

	}
	// 9. The  same  code  should  work  with  different  browsers  as  well  (Chrome  and Firefox)
	public void browserSelect(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\azirq\\Documents\\Selenium\\DriverForSelenium\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\azirq\\Documents\\Selenium\\DriverForSelenium\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else {
			System.out.println("Please enter brwoser name on mathode signethure ");
		}
			
		
	}
}
