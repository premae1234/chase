package sanity;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class dashboard {

	public static void main(String[] args) {
		String os = System.getProperty("os.name").toLowerCase();

		WebDriver driver = new ChromeDriver();

		if (os.contains("mac")) {
			System.setProperty("webdriver.chrome.driver", ("user.dir") + "/chromedriver");

		} else {
			System.setProperty("webdriver.chrome.driver", ("user.dir") + "/chromedriver.exe");

		}

		// Scenario:1-Login to Marlin

		driver.get("https://marlin-frontend2.uat.marlin.maestrano.io/user/login/");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {

			e1.printStackTrace();
		}
		// driver.manage().window().maximize();
		driver.findElement(By.name("email")).sendKeys("prema.eddyam+32@maestrano.com");
		driver.findElement(By.name("password")).sendKeys("Password1!");
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// User should be redirected to dashboard when service is connected
		boolean dashboardnavigationbar = driver.findElement(By.xpath("//div[@class='dashboard-nav']")).isDisplayed();
		System.out.println(dashboardnavigationbar);
		System.out.println("Existing dasboards displayed");

		// driver.findElement(By.xpath("//span[text()='Next']")).click();

		// clicking on marketplace
		driver.findElement(By.xpath("//a[@data-pt-name='bb_hd_marketplace']")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// list of apps present on marketplace and printing name of apps

		List<WebElement> allApps = driver
				.findElements(By.xpath("//div[contains(@class,'row justify-content-center')]"));

		for (WebElement element : allApps) {
			System.out.println(element.getText());

		}
		
		//Dashboard button appearing on marketplace
		
		/*boolean dashboardbutton = driver.findElement(By.xpath("//div[@class='dashboard-nav']")).isDisplayed();
		System.out.println(dashboardbutton);
		System.out.println("Existing dasboards displayed");*/
	}
}
