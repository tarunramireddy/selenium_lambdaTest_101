package TestScenarios; //<your package name>

import java.net.URL;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

class TestClass1 implements Runnable {      // With chrome 88.0 in windows 10
public void run() {
    Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
    capsHashtable.put("browserName", "Chrome");
    capsHashtable.put("version", "88.0");
    capsHashtable.put("platform", "Windows 10");
    capsHashtable.put("resolution", "1024x768");
    capsHashtable.put("build", "Checking-lambdatest-build-1");
    capsHashtable.put("name", "Test 1");
    Test_scenario_1_ALL r1 = new Test_scenario_1_ALL();
    r1.executeTest(capsHashtable);
}
}
class TestClass2 implements Runnable {
  public void run() {                         // with MicrosoftEdge 87.0 in macOS sierra
      Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
      capsHashtable.put("browserName", "MicrosoftEdge");
      capsHashtable.put("version", "87.0");
      capsHashtable.put("platform", "macOS Sierra");
      capsHashtable.put("resolution", "1024x768");
      capsHashtable.put("build", "Checking-lambdatest-build-1");
      capsHashtable.put("name", "Test 2");
      Test_scenario_1_ALL r2 = new Test_scenario_1_ALL();
      r2.executeTest(capsHashtable);
  }
}
class TestClass3 implements Runnable { 
  public void run() {                        // with Firefox 82.0 in windows 7
      Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
      capsHashtable.put("browserName", "Firefox");
      capsHashtable.put("version", "82.0");
      capsHashtable.put("platform", "Windows 7");
      capsHashtable.put("resolution", "1024x768");
      capsHashtable.put("build", "Checking-lambdatest-build-1");
      capsHashtable.put("name", "Test 3");
      Test_scenario_1_ALL r3 = new Test_scenario_1_ALL();
      r3.executeTest(capsHashtable);
  }
}
class TestClass4 implements Runnable {
	  public void run() {                    // With InternetExplorer 11.0 in windows 10
	      Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
	      capsHashtable.put("browserName", "Internet Explorer");
	      capsHashtable.put("version", "11.0");
	      capsHashtable.put("platform", "Windows 10");
	      capsHashtable.put("resolution", "1024x768");
	      capsHashtable.put("build", "Checking-lambdatest-build-1");
	      capsHashtable.put("name", "Test 4");
	      Test_scenario_1_ALL r4 = new Test_scenario_1_ALL();
	      r4.executeTest(capsHashtable);
	  }
	}
public class Test_scenario_1_ALL {
  public static final String USERNAME = "tarunramireddy";
  public static final String AUTOMATE_KEY = "i7Bv2edQlgb8vMXlmkSMAk0CdsjpY76Ym85uWLKLLf39l8ASI7";
  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.lambdatest.com/wd/hub";
  public static void main(String[] args) throws Exception {
    Thread object1 = new Thread(new TestClass1());
    object1.start();
    Thread object2 = new Thread(new TestClass2());
    object2.start();
    Thread object3 = new Thread(new TestClass3());
    object3.start();
    Thread object4 = new Thread(new TestClass4());
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
	    driver.findElement(By.linkText("Simple Form Demo")).click();
	    String Text = driver.getCurrentUrl();
	    Assert.assertTrue(Text.contains("simple-form-demo"));
	    String expected = "welcome to lambda test";
	    driver.findElement(By.id("user-message")).sendKeys(expected);
	    driver.findElement(By.id("showInput")).click();
	    String actual=driver.findElement(By.id("message")).getText();
	    Assert.assertEquals(expected,actual);
	    System.out.println(actual);
	    System.out.println("Test-1 has been Ended");
	    driver.quit();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}