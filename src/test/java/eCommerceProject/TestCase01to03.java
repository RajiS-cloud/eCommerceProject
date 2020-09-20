/* Test Steps:
        1. Goto http://live.demoguru99.com/
        2. Click on ‘MOBILE’ menu
        3. In the list of all mobile , click on ‘ADD TO CART’ for Sony Xperia mobile
        4. Change ‘QTY’ value to 1000 and click ‘UPDATE’ button. Expected that an error is displayed
        "The requested quantity for "Sony Xperia" is not available.
        5. Verify the error message
        6. Then click on ‘EMPTY CART’ link in the footer of list of all mobiles. A message "SHOPPING CART IS EMPTY" is shown.
        7. Verify cart is empty
        */

package eCommerceProject;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Priority;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.swing.*;
import java.io.File;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class TestCase01to03 {

    private WebDriver driver;
    private String baseUrl;
    public int scc =0;

    private StringBuffer verificationErrors = new StringBuffer();



    @BeforeTest

    public void setUp() throws Exception{

        String driverpath = "D:\\Raji_Selenium\\geckodriver-v0.19.0-win64\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", driverpath);

        // Step 1 Goto http://live.demoguru99.com/
           baseUrl = "http://live.demoguru99.com/";
           driver = new FirefoxDriver();
           driver.get(baseUrl);
           driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
          // driver.findElement(By.xpath(("//*[@id=\"lightBoxCloseBtn\"]"))).click();
        // driver.switchTo().alert().dismiss();


    }
    @Test
    public void testDay1DemoSite() throws Exception {

        //Step 2. Verify Title of the page
             //String demoSite = driver.findElement(By.cssSelector("h2")).getText();
             String demoSite = driver.findElement(By.xpath("//h2[contains(text(), 'This is demo site for')]")).getText();
             System.out.println("This is the demo site:" + demoSite );
             try {
                 assertEquals("THIS IS DEMO SITE FOR", demoSite);
             } catch(Error e){
             verificationErrors.append(e.toString());

        // Step 3. Click on ‘MOBILE’ menu
            driver.findElement(By.xpath("//a[contains(text(),'Mobile')]")).click();

        // Step3.1  In the list of all mobile , select ‘SORT BY’ dropdown as ‘name’
        /*
           Select mobilelistByName =  new Select(driver.findElement(By.xpath("//*[@id=\"top\"]//select")));  -- Correct using xpath
           mobilelistByName.selectByVisibleText("Name");
        */
        // using cssselector another method
            Select mobilelistByName =  new Select(driver.findElement(By.cssSelector("select[title=\"Sort By\"]")));
            mobilelistByName.selectByVisibleText("Name");



        // Step 6. Verify all products are sorted by name
        // this will take a screen shot of the manager's page after a successful login
            scc= scc+1;
            System.out.println("Take Screenshot");
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Thread.sleep(300);
            System.out.println("Screenshot exists >>>>>" + scrFile);
            scrFile.exists();

       // Code to save screenshot at desired location
            String png = ("D:\\Raji_Selenium\\eCommerceProject\\Mobile Products are sorted by Name"+scc+".png");
            FileUtils.copyFile(scrFile, new File(png));
        }
    }

    @Test
     public void testDay2MobilePriceCompare() throws Exception {

        // 6. In the list of all mobile , read the cost of Sony Xperia mobile (which is $100)
       // String xperiapPrice1 = driver.findElement(By.cssSelector("#product-price-1 > span.price")).getText();  // another methhod to write
        String xperiapPrice1 = driver.findElement(By.xpath("//*[@id=\"product-price-1\"]")).getText();
        System.out.println("The price of the Sony Xperia is the search list is : " + xperiapPrice1);

        //7. Click on the Sony Xperia link
       // driver.findElement(By.xpath("//h2[@class='product-name']//a[contains(text(),'Sony Xperia')]")).click(); // another way og writing the Webelememt

        driver.findElement(By.xpath("//*[@title=\"Sony Xperia\"]")).click();


        // 8.  Read the XPeria mobile price from details page
        String xperiaPriceDetail1 = driver.findElement(By.cssSelector("#product-price-1>span.price")).getText();
        System.out.println("The price of the Sony Xperia in detail page is: " + xperiaPriceDetail1);

        // 9. Compare the prices - Product price in list and details page should be equal ($100)
        try {
            assertEquals(xperiapPrice1, xperiaPriceDetail1);
            System.out.println(" The price for Sony Xperia at search list and detail page is same = $100.00 ");

        } catch (Exception e) {

            e.printStackTrace();

        }
        // Clear the quantity in the quantity field
        driver.findElement(By.xpath("//input[@id='qty']")).clear();

        // Enter the Sony Xperia qty needed to add to the cart
        WebElement mQty = driver.findElement(By.xpath("//input[@id='qty']"));
        mQty.sendKeys("1000");

        Thread.sleep(2000);

       /*
       // eElectronics.click();
       Action moveOverElectronics = act.moveToElement(eElectronics).build();
       moveOverElectronics.perform();
       WebElement eMobiles= driver.findElement((By.xpath("//a[l(text(),'Mobiles')]")));
       driver.manage().t
       imeouts().implicitlyWait(30,TimeUnit.SECONDS);

        */
//        Actions act = new Actions(driver);
//        act.moveToElement(mQty).build().perform();

        // Get the value entered in the qty.
//       String reqQty1 = driver.findElement(By.xpath("//input[@id='qty']")).getAttribute("value");
//       String reqQty = driver.findElement(By.id("qty")).getText();

        String reqQty1 = mQty.getAttribute("value");
        String reqQty = mQty.getText();
        String reqQty2 = mQty.getAttribute("innerText");
        System.out.println("The quantity added to the cart is: " + reqQty1);

        // Add the cart the qty entered
        driver.findElement(By.xpath("//*[@id=\"product_addtocart_form\"]")).submit();

        //verify the error message
        String reqQtyMessage = driver.findElement(By.xpath("//span[contains(text(),'The maximum quantity allowed for purchase is 500.')]")).getText();
        String msgQty = "The maximum quantity allowed for purchase is 500.";

        try {
            assertEquals(reqQtyMessage, msgQty);
            System.out.println(" Maximum Quantity message displayed Pass: " + reqQtyMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }

         /*
             Unable to execute this piece of code
         */
         /* //  Verify the qty displayed in the cart .
            //ebElement cQty = driver.findElement(By.xpath("//span[@class='count']"));
            // WebElement cQty = driver.findElement(By.xpath("//*[@id=\"header\"]//span[3]/text()"));
                Thread.sleep(2000);
            //  String cartQty  = cQty.getAttribute("value");
            //  String cartQty= cQty.getText();
            // String cartQty = driver.findElement(By.xpath("//*[@id=\"product_addtocart_form\"]")).getText();
            //  System.out.println("Cart qty display : " + cartQty);

         try {
                assertEquals(reqQty1,cartQty);
                System.out.println("The qty should be : " + reqQty);
                } catch (Exception e){
                e.printStackTrace();
            }
        */


        // Clear the moblie phone SonyCXperia quantity in the quantity field and add to cart a valid quantity within the limits
        driver.findElement(By.xpath("//input[@id='qty']")).clear();
        WebElement mQty1 = driver.findElement(By.xpath("//input[@id='qty']"));
        mQty1.sendKeys("20");
        driver.findElement(By.xpath("//button[@class='button btn-cart']")).click();
    }
        @Test
        public void testDay3_EmptyCartMessageCompare() throws Exception {
        // 6. Click on ‘EMPTY CART’ link in the footer of list of all mobiles. A message "SHOPPING CART IS EMPTY" is shown.
              driver.findElement(By.xpath("//span[contains(text(),'Empty Cart')]")).click();

        // 7. Verify cart is empty
            String noItemStg = ("You have no items in your shopping cart.");
            String noItemMsg = driver.findElement(By.xpath("//div[@class='cart-empty']//p[contains(text(),'You have no items in your shopping cart.')]")).getText();
            System.out.println("Empty cart message - Pass: " + noItemMsg);
            try {
                assertEquals(noItemStg, noItemMsg);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    @AfterTest
    public void teardown() throws Exception {
       driver.close();
    }
}

