package sanity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	public static void main(String[] args) {
		
		String os= System.getProperty("os.name").toLowerCase();
		
        WebDriver driver = new ChromeDriver();
        
        if(os.contains("mac")) {
        System.setProperty("webdriver.chrome.driver",("user.dir")+"/chromedriver");
        
        }else {
        System.setProperty("webdriver.chrome.driver",("user.dir")+"/chromedriver.exe");
        
        }
     
        driver.get("https://marlin-frontend2.uat.marlin.maestrano.io/user/login/");
        try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
       // driver.manage().window().maximize();
        driver.findElement(By.name("email")).sendKeys("prema.eddyam+32@maestrano.com");
        driver.findElement(By.name("password")).sendKeys("Password1!");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
        
        /*WebDriverWait wait = new WebDriverWait(driver,30);
        WebElement element = wait.until(
        ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Connect'])[1]")));
*/		        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            
            e.printStackTrace();
            
    // not clicking on connect button ,though not throwing any error
           driver.findElement(By.xpath("(//a[text()='Connect'])[1]")).click();
                
        }

}
}




