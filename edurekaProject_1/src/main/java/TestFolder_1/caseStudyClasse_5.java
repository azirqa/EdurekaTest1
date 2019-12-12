package TestFolder_1;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class caseStudyClasse_5 {

	public static WebDriver driver;
	public WebDriverWait wt;

	public static void main(String[] args) throws Exception {
		caseStudyClasse_5 lg = new caseStudyClasse_5();

		lg.setBrowser();
		lg.logIn("azirqa@gmail.com","123456789");	
		lg.myProfile();
		lg.profileEditPage1();
		lg.profileEditPage2();
		lg.blogs();
		lg.logOut();
	}
	public void setBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\azirq\\Documents\\Selenium\\DriverForSelenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.edureka.co/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}	
	public void logIn(String uName, String pWord) throws InterruptedException{
		WebElement logInlink = driver.findElement(By.linkText("Log In"));
		logInlink.click();
		WebElement userName = driver.findElement(By.id("si_popup_email"));
		userName.sendKeys(uName);
		Thread.sleep(1000);
		WebElement passWord = driver.findElement(By.id("si_popup_passwd"));
		passWord.sendKeys(pWord);
		WebElement submit = driver.findElement(By.xpath("//button[@class='clik_btn_log btn-block']"));
		submit.click();

	}
	public void myProfile() throws InterruptedException {
		wt = new WebDriverWait(driver, 30);
		try {
			driver.findElement(By.xpath("//div[@class='loaderbackoverlay']")).click();
		}catch(Exception e) {
			e.getStackTrace();
		}		
		WebElement mUser = driver.findElement(By.xpath("//img[@class='user_image']"));
		wt.until(ExpectedConditions.elementToBeClickable(mUser));
		mUser.click();
		WebElement fFrofil = driver.findElement(By.linkText("My Profile"));
		wt.until(ExpectedConditions.elementToBeClickable(fFrofil));
		fFrofil.click();

	}
	public void profileEditPage1() throws Exception {
		wt = new WebDriverWait(driver, 30);
		driver.findElement(By.xpath("//div[@class='details-heading']//a[@id='professional_details']")).click();

		WebElement companyName = driver.findElement(By.name("companyName"));
		wt.until(ExpectedConditions.elementToBeClickable(companyName));
		companyName.clear();
		companyName.sendKeys(" Crestron Electronic ");

		WebElement midManagement = driver.findElement(By.xpath("//select[@name='currentjob']"));
		Select sl = new Select(midManagement);	
		sl.selectByIndex(1);;

		WebElement industry = driver.findElement(By.xpath("//select[@name='currentIndustry']"));
		wt.until(ExpectedConditions.elementToBeClickable(industry));
		Select sl2 = new Select(industry);
		sl2.selectByIndex(7);
		Thread.sleep(3000);

		WebElement linkInProfile = driver.findElement(By.xpath("//input[@name='linkedinLink']"));
		wt.until(ExpectedConditions.elementToBeClickable(linkInProfile));
		linkInProfile.clear();
		linkInProfile.sendKeys("www.linkedin.com/in/aizruddin71");

		WebElement skils = driver.findElement(By.xpath("//input[@name='userSkill']"));
		wt.until(ExpectedConditions.elementToBeClickable(skils));
		skils.clear();
		skils.sendKeys("Selenium WebDriver");

		try {
			WebElement existingFile = driver.findElement(By.xpath("//i[@class='icon-close_ico']"));
			existingFile.click();
		}catch(Exception e) {}
		WebElement document = driver.findElement(By.xpath("//div[@class='upload-resume']//input[@id='resume']"));

		document.sendKeys("C:\\Users\\azirq\\Documents\\Selenium\\edurekaProject_1\\libFloler\\Testpage.pdf");
		Thread.sleep(2000);
		WebElement next1 = driver.findElement(By.xpath("//button[@class='btn pull-right onboarding-primary-button']"));
		wt.until(ExpectedConditions.elementToBeClickable(next1));
		next1.click();
	}	
	public void profileEditPage2() {
		wt = new WebDriverWait(driver, 30);
		WebElement jobInterest = driver.findElement(By.xpath("//select[@name='interestedJob']"));
		wt.until(ExpectedConditions.elementToBeClickable(jobInterest));
		Select sl3 = new Select(jobInterest);
		sl3.selectByIndex(1);

		WebElement elementType = driver.findElement(By.xpath("//select[@name='elementType']"));
		wt.until(ExpectedConditions.elementToBeClickable(elementType));
		Select sl4 = new Select(elementType);
		sl4.selectByIndex(2);

		WebElement currentCity = driver.findElement(By.xpath("//input[@name='currentCity']"));
		wt.until(ExpectedConditions.elementToBeClickable(currentCity));
		currentCity.clear();
		currentCity.sendKeys("Totowa");

		WebElement lastDrawnSalaryUS = driver.findElement(By.xpath("//select[@name='lastDrawnSalaryUS']"));
		wt.until(ExpectedConditions.elementToBeClickable(lastDrawnSalaryUS));
		Select sl5 = new Select(lastDrawnSalaryUS);
		sl5.selectByIndex(4);

		WebElement nButton=driver.findElement(By.xpath("//button[@class='btn onboarding-primary-button pull-right']"));
		wt.until(ExpectedConditions.elementToBeClickable(nButton));
		nButton.click();

		WebElement saveButton=driver.findElement(By.xpath("//button[@class='btn pull-right onboarding-primary-button']"));
		wt.until(ExpectedConditions.elementToBeClickable(saveButton));
		saveButton.click();
	}
	public void blogs() throws Exception {
		driver.navigate().refresh();
		driver.findElement(By.linkText("Blog")).click();

	//	ArrayList<String> windowList = new ArrayList<String>(driver.getWindowHandles());	
	//	driver.switchTo().window(windowList.get(1));
		try {
			driver.findElement(By.xpath("//div[@class='wzrk-alert wiz-show-animate']//button[@id='wzrk-cancel']")).click();
		}catch(Exception e) {
			e.getStackTrace();
		}
		driver.findElement(By.linkText("Explore Online Courses")).click();

		ArrayList<String> windowList = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(windowList);
		
		String mainWindow = windowList.get(0);
		String window2 = windowList.get(1);
		
		driver.switchTo().window(window2).close();
		driver.switchTo().window(mainWindow);
		driver.navigate().back();
}
	public void logOut() {
		WebElement proLink = driver.findElement(By.xpath("//img[@class='user_image']"));
		wt.until(ExpectedConditions.elementToBeClickable(proLink));
		proLink.click();	
		driver.findElement(By.linkText("Log Out")).click();
		driver.quit();
	}
}




