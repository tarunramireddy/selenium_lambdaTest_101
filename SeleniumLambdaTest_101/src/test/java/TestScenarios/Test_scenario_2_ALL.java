package TestScenarios; //<your package name>

import java.net.URL;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

class Test_1 implements Runnable {
public void run() {
    Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
    capsHashtable.put("browserName", "Chrome");
    capsHashtable.put("version", "88.0");
    capsHashtable.put("platform", "Windows 10");
    capsHashtable.put("resolution", "1024x768");
    capsHashtable.put("build", "Checking-lambdatest-build-2");
    capsHashtable.put("name", "Test 1");
    Test_scenario_2_ALL r1 = new Test_scenario_2_ALL();
    r1.executeTest(capsHashtable);
}
}
class Test_2 implements Runnable {
  public void run() {
      Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
      capsHashtable.put("browserName", "MicrosoftEdge");
      capsHashtable.put("version", "87.0");
      capsHashtable.put("platform", "macOS Sierra");
      capsHashtable.put("resolution", "1024x768");
      capsHashtable.put("build", "Checking-lambdatest-build-2");
      capsHashtable.put("name", "Test 2");
      Test_scenario_2_ALL r2 = new Test_scenario_2_ALL();
      r2.executeTest(capsHashtable);
  }
}
class Test_3 implements Runnable {
  public void run() {
      Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
      capsHashtable.put("browserName", "Firefox");
      capsHashtable.put("version", "82.0");
      capsHashtable.put("platform", "Windows 7");
      capsHashtable.put("resolution", "1024x768");
      capsHashtable.put("build", "Checking-lambdatest-build-2");
      capsHashtable.put("name", "Test 3");
      Test_scenario_2_ALL r3 = new Test_scenario_2_ALL();
      r3.executeTest(capsHashtable);
  }
}
class Test_4 implements Runnable {
	  public void run() {
	      Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
	      capsHashtable.put("browserName", "Internet Explorer");
	      capsHashtable.put("version", "11.0");
	      capsHashtable.put("platform", "Windows 10");
	      capsHashtable.put("resolution", "1024x768");
	      capsHashtable.put("build", "Checking-lambdatest-build-2");
	      capsHashtable.put("name", "Test 4");
	      Test_scenario_2_ALL r4 = new Test_scenario_2_ALL();
	      r4.executeTest(capsHashtable);
	  }
	}
public class Test_scenario_2_ALL {
  public static final String USERNAME = "tarunramireddy";
  public static final String AUTOMATE_KEY = "i7Bv2edQlgb8vMXlmkSMAk0CdsjpY76Ym85uWLKLLf39l8ASI7";
  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.lambdatest.com/wd/hub";
  public static void main(String[] args) throws Exception {
    Thread object1 = new Thread(new Test_1());
    object1.start();
    Thread object2 = new Thread(new Test_2());
    object2.start();
    Thread object3 = new Thread(new Test_3());
    object3.start();
    Thread object4 = new Thread(new Test_4());
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
		driver.get("https://www.lambdatest.com/selenium-playground");

		driver.findElement(By.xpath("//a[text()='Drag & Drop Sliders']")).click();

		// Select Slider
		WebElement slider = driver.findElement(By.cssSelector("input[value='15']"));

		for (int i = 1; i <= 80; i++) {
			slider.sendKeys(Keys.ARROW_RIGHT);
		}

		if (driver.findElement(By.xpath("//*[text()='95']")).getText().equalsIgnoreCase("95"))
			Assert.assertTrue(true);
		else
			Assert.assertTrue(false);

		driver.quit();
		System.out.println("Test-2 has been ended");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}