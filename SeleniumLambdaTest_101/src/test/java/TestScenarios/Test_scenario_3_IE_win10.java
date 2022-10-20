package TestScenarios; //<your package name>

import java.net.URL;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
 
class T4 implements Runnable {    // With InternetExplorer 11.0 in windows 10
public void run() {
    Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
    capsHashtable.put("browserName", "Internet Explorer");
    capsHashtable.put("version", "11.0");                      
    capsHashtable.put("platform", "Windows 10");
    capsHashtable.put("resolution", "1024x768");
    capsHashtable.put("build", "Checking-lambdatest-build-3");
    capsHashtable.put("name", "Test 4");
    Test_scenario_3_IE_win10 r1 = new Test_scenario_3_IE_win10();
    r1.executeTest(capsHashtable);
}
}
public class Test_scenario_3_IE_win10 {
  public static final String USERNAME = "tarunramireddy";
  public static final String AUTOMATE_KEY = "i7Bv2edQlgb8vMXlmkSMAk0CdsjpY76Ym85uWLKLLf39l8ASI7";
  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.lambdatest.com/wd/hub";
  public static void main(String[] args) throws Exception {
    Thread object4 = new Thread(new T4());
    object4.start();
  }
  public void executeTest(Hashtable < String, String > capsHashtable) {
    String key;
    DesiredCapabilities caps = new DesiredCapabilities();
    // Iterate over the hashtable and set the capabilities
    Set < String > keys = capsHashtable.keySet();
    Iterator < String > itr = keys.iterator();
    while (itr.hasNext()) {
      key = itr.next();
      caps.setCapability(key, capsHashtable.get(key));
    }
    WebDriver driver;
    try {
    	driver = new RemoteWebDriver(new URL(URL), caps);
    	driver.manage().window().maximize();
	    driver.get("https://www.lambdatest.com/selenium-playground/");
	    driver.findElement(By.linkText("Input Form Submit")).click();
	    JavascriptExecutor js= (JavascriptExecutor)driver;

		WebElement field =driver.findElement(By.name ("name"));

		String message =(String)js.executeScript("return arguments[0].validationMessage;", field); 
		String expected= "This is a required field";
		System.out.println(message);
		Assert.assertEquals(message, expected); // For InternetExplorer 11.0 version in windows 10 expected message is "This is a required field"
		
	    driver.findElement(By.id("name")).sendKeys("Tarun");
	    driver.findElement(By.id("inputEmail4")).sendKeys("tarunramireddy@gmai.com");
	    driver.findElement(By.id("inputPassword4")).sendKeys("tarun1234");
	    driver.findElement(By.id("company")).sendKeys("cognizant");
	    driver.findElement(By.id("websitename")).sendKeys("www.google.com");
	    driver.findElement(By.id("inputCity")).sendKeys("Guntur");
	    driver.findElement(By.id("inputAddress1")).sendKeys("nagar123");
	    driver.findElement(By.id("inputAddress2")).sendKeys("nagari");
	    driver.findElement(By.id("inputState")).sendKeys("Ap");
		driver.findElement(By.id("inputZip")).sendKeys("50000");
		
		//using "SELECT" Class
		driver.findElement(By.name("country")).click();
		WebElement Countries=driver.findElement(By.name("country"));
		Select country =new Select(Countries);
		country.selectByVisibleText("United States");
		driver.findElement(By.xpath("//button[.='Submit']")).click();
		
		//massage validating
		String successful="Thanks for contacting us, we will get back to you shortly.";
		//Grabbing text
		String message2=driver.findElement(By.xpath("//p[@class='success-msg hidden']")).getText();
		System.out.println(message2);
		Assert.assertEquals(successful, message2);
	   System.out.println("Test-3 has been ended");
	   driver.quit();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}