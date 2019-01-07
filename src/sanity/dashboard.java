package sanity;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

public class dashboard {
	public static WebDriver driver;
	public static WebElement element;

	@Test
	public void DasboardTest() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","/Users/premalathaeddyam/eclipse-workspace/chromedriver");
		driver=new ChromeDriver();

		// Scenario:1-Login to Marlin
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		driver.get("https://marlin-frontend2.uat.marlin.maestrano.io/user/login/");
		driver.findElement(By.name("email")).sendKeys("prema.eddyam+44@maestrano.com");
		driver.findElement(By.name("password")).sendKeys("Password1!");
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();

		// Scenario:2 - User should be redirected to dashboard when service is connected

		// clicking on marketplace
		//driver.findElement(By.xpath("//a[@data-pt-name='bb_hd_marketplace']")).click();

		// Scenario:3 - list of apps present on marketplace and printing name of apps

		/*
		 * List<WebElement> allApps = driver
		 * .findElements(By.xpath("//div[contains(@class,'row justify-content-center')]"
		 * ));
		 * 
		 * for( WebElement element:allApps) { System.out.println(element.getText());
		 * 
		 * }System.out.println("list of apps displayed and printed");System.out.println(
		 * "*******************************************"); // Scenario:4 - Dashboard
		 * button appearing on marketplace
		 * ////span[@class='ng-star-inserted']//a[@data-pt-name='bb_hd_dashboard']"-
		 * dashboard link Thread.sleep(4000);
		 * 
		 * boolean dashboardbutton = driver
		 * .findElement(By.xpath("//*[@data-pt-name='bb_hd_dashboard']"))
		 * .isDisplayed(); System.out.println(dashboardbutton);
		 * System.out.println("Dashboard button appearing on marketplace");System.out.
		 * println("*******************************************");
		 */

		/*// When user click on dashboard, should redirection to dashboard
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@data-pt-name='bb_hd_dashboard']")).click();
		System.out.println("user redirected to dashboard");
		System.out.println("*******************************************");*/

		// create dashboard
		driver.findElement(By.xpath("//*[@class='svg-inline--fa fa-plus fa-w-12']")).click();
		// enter text in textbox
		driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("Test Dashboard");
		// click on add button
		driver.findElement(By.xpath("(//button[contains(@class,'btn btn-outline-primary ')])[1]")).click();
		System.out.println("new dashboard created");
		System.out.println("*******************************************");
		// click on dashboard options
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

		// driver.findElement(By.xpath("//a[@data-pt-name='bb_lnk_addmodule']")).click();
		driver.findElement(By.xpath("//a[@class='chaseanalytics-track-link hide-link']")).click();
		// Thread.sleep(1000);

		driver.findElement(By.xpath("//a[@id='sales-tab']")).click();
		// select any module and click
		driver.findElement(By.xpath("//img[@alt='Customers']")).click();
		// click on add to dashboard button
		driver.findElement(By.xpath("//a[text()='Add to dashboard']")).click();
		System.out.println("selected module added to the dashboard");

		System.out.println("*******************************************");
		// click on plus icon to add kpi's
		driver.findElement(By.xpath("//button[contains(@class,'ml-auto kpi-config-menu-wrapper')]")).click();
		// select and click on cash on hand kpi
		driver.findElement(By.xpath("//li[contains(text(),'Cash on hand')]")).click();
		// click on done button
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'Done' )]")).click();
		// click on save button
		driver.findElement(By.xpath("//a[@data-pt-name='bb_hd_saveDelete']")).click();
		System.out.println("selected KPI added to the business metric");
		System.out.println("*******************************************");

	}

}
