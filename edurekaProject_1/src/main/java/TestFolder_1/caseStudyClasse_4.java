package TestFolder_1;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class caseStudyClasse_4 {

	public static WebDriver driver;

	public static void main(String[] args) throws Exception {
		caseStudyClasse_4 fl = new caseStudyClasse_4();

		fl.setBrowser();
		fl.selectCity();	
		fl.selectDate();
		fl.pssingers();
		fl.submitbutton();
		fl.availableFlights();
	}

	public void setBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\azirq\\Documents\\Selenium\\DriverForSelenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.goindigo.in/?linkNav=home_header");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}
	public void selectCity() throws InterruptedException {
		WebElement fromlink = driver.findElement(By.xpath("//input[@name='or-src']"));
		fromlink.click();
		fromlink.sendKeys("Bengaluru");
		fromlink.sendKeys(Keys.ENTER);
		Thread.sleep(2000);


		WebElement tolink = driver.findElement(By.xpath("//input[@name='or-dest']"));
		tolink.sendKeys("Lucknow");
		tolink.sendKeys(Keys.ENTER);
		driver.findElement(By.className("close-cookie")).click();
		Thread.sleep(2000);

	}
	public void selectDate() {
		driver.findElement(By.className("ui-datepicker-current-day")).click();		
	}
	public void pssingers() throws Exception {
		driver.findElement(By.name("passenger")).click();
		driver.findElement(By.xpath("//div[@class='passenger-dropdown pax-selection-row']//li[@class='adult-pax-list']//span[@class='icon-plus']")).click();

		driver.findElement(By.xpath("//div[@class='passenger-dropdown pax-selection-row']//li[@class='child-pax-list']//button[@class='pax-plus btn btn-info']")).click();
		driver.findElement(By.xpath("//div[@class='passenger-dropdown pax-selection-row']//li[@class='child-pax-list']//button[@class='pax-plus btn btn-info']")).click();

		WebElement pButton = driver.findElement(By.xpath("//button[@class='btn btn-primary pax-done btn-pad-y']"));
		WebDriverWait wt = new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(pButton));
		pButton.sendKeys(Keys.ENTER);


	}
	public void submitbutton() {
		driver.findElement(By.xpath("//span[@class='hp-src-btn']")).click();
	}
	public void availableFlights() {
		List<WebElement> FlightsList =driver.findElements(By.xpath("//div[@class='trips-body ios-scroll ow']/div[@class='row trips-row d-none d-flex']//div[@class='time']"));
		WebDriverWait wt2 = new WebDriverWait(driver, 15);
		wt2.until(ExpectedConditions.visibilityOfAllElements(FlightsList));
		int FSize = FlightsList.size();
		System.out.println("Total Available Flights  = "+ FSize);
		for(int i=0;i<FSize;i++) {
			String Ftext = FlightsList.get(i).getText();
			System.out.println("Available Flights Number: "+i+ "  Flight Time: " + Ftext);
		}
		driver.quit();
	}
}




