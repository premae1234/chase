package sanity;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class dashboard {
	public static WebDriver driver;
	public static WebElement element;
	public static JavascriptExecutor js = (JavascriptExecutor) driver;

	// public static void main(String[] args) {
	@Test
	public void openBrowser() {

		String os = System.getProperty("os.name").toLowerCase();

		WebDriver driver = new ChromeDriver();

		if (os.contains("mac")) {
			System.setProperty("webdriver.chrome.driver", ("user.dir") + "/chromedriver");

		} else {
			System.setProperty("webdriver.chrome.driver", ("user.dir") + "/chromedriver.exe");

		}

		// Scenario:1-Login to Marlin
		driver.get("https://marlin-frontend2.uat.marlin.maestrano.io/user/login/");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElement(By.name("email")).sendKeys("prema.eddyam+32@maestrano.com");
		driver.findElement(By.name("password")).sendKeys("Password1!");
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();

		// Scenario:2 - User should be redirected to dashboard when service is connected
		boolean dashboardnavigationbar = driver.findElement(By.xpath("//div[contains(@class,'dashboard')]"))
				.isDisplayed();
		System.out.println(dashboardnavigationbar);
		System.out.println("Existing dasboards displayed");

		// driver.findElement(By.xpath("//span[text()='Next']")).click();

		// clicking on marketplace
		driver.findElement(By.xpath("//a[@data-pt-name='bb_hd_marketplace']")).click();

		// Scenario:3 - list of apps present on marketplace and printing name of apps

		List<WebElement> allApps = driver
				.findElements(By.xpath("//div[contains(@class,'row justify-content-center')]"));

		for (WebElement element : allApps) {
			System.out.println(element.getText());

		}

		// Scenario:4 - Dashboard button appearing on marketplace

		boolean dashboardbutton = driver
				.findElement(By.xpath("//span[@class='ng-star-inserted']//a[@data-pt-name='bb_hd_dashboard']"))
				.isDisplayed();
		System.out.println(dashboardbutton);
		System.out.println("Dashboard button appearing on marketplace");

		// When user click on dashboard, should redirection to dashboard
		driver.findElement(By.xpath("//span[@class='ng-star-inserted']//a[@data-pt-name='bb_hd_dashboard']")).click();

		// create dashboard
		driver.findElement(By.xpath("//*[@class='svg-inline--fa fa-plus fa-w-12'and @ data-icon='plus']")).click();
		// enter text in textbox
		driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("Test Dashboard");
		// click on add button
		driver.findElement(By.xpath("(//button[contains(@class,'btn btn-outline-primary ')])[1]")).click();
		//
		/*
		 * Actions actions = new Actions(driver); WebElement mainMenu =
		 * driver.findElement(By.
		 * xpath("//div[contains(@class,'d-flex flex-row justify-content-end')]"));
		 * actions.moveToElement(mainMenu);
		 * 
		 * WebElement subMenu = driver.findElement(By.
		 * xpath("(//a[contains(@class,'px-3 text-white text-left more-services-link')])[1]"
		 * )); actions.moveToElement(subMenu); actions.click().build().perform();
		 */

		driver.findElement(By.xpath("//div[contains(@class,'d-flex flex-row justify-content-end')]")).click();
		// Actions actions = new Actions(driver);
		driver.findElement(By.xpath("(//a[contains(@class,'px-3 py-3  d-block pointer')])[1]")).click();
		// actions.moveToElement(editdashboard).click().build().perform();*/

		// click on add module

		//driver.findElement(By.xpath("//a[@data-pt-name='bb_lnk_addmodule']")).click();
		driver.findElement(By.xpath("//a[@class='chaseanalytics-track-link hide-link']")).click();

		driver.findElement(By.xpath("//a[@class='nav-link'and @id='sales-tab']")).click();
		// select any module and click
		driver.findElement(By.xpath("//img[@alt='Customers']")).click();
		// click on add to dashboard button
		driver.findElement(By.xpath("//a[text()='Add to dashboard']")).click();
	    //click on plus icon to add kpi's
		driver.findElement(By.xpath("//button[contains(@class,'ml-auto kpi-config-menu-wrapper')]")).click();
		//select and click on cash on hand kpi
		driver.findElement(By.xpath("//li[contains(text(),'Cash on hand')]")).click();
		//click on done button
		driver.findElement(By.xpath("//button[contains(text(),'Done' )]")).click();
		// click on save button
	    driver.findElement(By.xpath("//a[@data-pt-name='bb_hd_saveDelete']")).click();
	}

}
