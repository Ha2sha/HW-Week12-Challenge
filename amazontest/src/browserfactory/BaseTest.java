package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    //created static variable for WebDriver
    public static WebDriver driver;

    // method to launch browser
    public void openBrowser(String baseUrl){
        //setting property for chrome driver
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");

        //creating object of Webdriver interface/Chromedriver Class
        driver=new ChromeDriver();

        //Launch baseUrl
        driver.get(baseUrl);

        //maximise the window
        driver.manage().window().maximize();

        //Give implicit time to driver to find the element
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }
    //Instance method to Close the browser
    public void closeBrowser(){
        driver.quit();
    }
}
