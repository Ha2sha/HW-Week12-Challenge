package testsuit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class TestSuit extends Utility {
    String baseUrl="https://www.amazon.co.uk/";
    @Before
    public void setup(){
        openBrowser(baseUrl);
    }

    @Test
    public void checkDellQuantityAndPrintInTheConsole() throws InterruptedException {
        //1. Type "Dell Laptop" in the search box and press enter or click on searchButton.
            sendTextToElement(By.xpath("//input[@id='twotabsearchtextbox']"),"Dell Laptop");
            clickOnElement(By.xpath("//input[@id='nav-search-submit-button']"));
            Thread.sleep(3000);

            clickOnElement(By.name("accept"));
        //2. Click on the checkbox brand dell on the left side.
        clickOnElement(By.xpath("//span[@class='a-size-base a-color-base'][normalize-space()='Dell']"));

        //3. Verify that the  30(May be different) products are displayed on the page.
        int expectedQty=30;
        List<WebElement> elementList=driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));
        int actualQty=elementList.size();
        Assert.assertEquals("Qty not matched",expectedQty,actualQty);

        //4. Print all product names in the console.
        List<WebElement> names=driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        for(WebElement e:names){
            System.out.println(e.getText());
            }
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
