//********************************************************************************************
//*    Guru99 eCommerce Live Project
//*    Participant : Raji Singaraju
//*                                                                                                                                                        *
//********************************************************************************************
/*  Verify user is able to purchase product using registered email id(USE CHROME BROWSER)
Test Steps:
1. Go to http://live.demoguru99.com/
2. Click on my account link
3. Login in application using previously created credential
4. Click on MY WISHLIST link
5. In next page, Click ADD TO CART link
6. Enter general shipping country, state/province and zip for the shipping cost estimate
7. Click Estimate
8. Verify Shipping cost generated
9. Select Shipping Cost, Update Total
10. Verify shipping cost is added to total
11. Click "Proceed to Checkout"
12a. Enter Billing Information, and click Continue
12b. Enter Shipping Information, and click Continue
13. In Shipping Method, Click Continue
14. In Payment Information select 'Check/Money Order' radio button. Click Continue
15. Click 'PLACE ORDER' button
16. Verify Oder is generated. Note the order number

NOTE: PROCEED TO CHECKOUT (step 6 ) was taken out, so as to allow the Estimate button step to get processed.
      Rest of the steps renumbered accordingly.
*/


package eCommerceProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCase06 {

    private WebDriver driver;
    private String baseUrl;
    public String firstName = "TestGuru"; // These testdata stuff will be placed
    public String lastName ="Guru99";  // in a TestData EXCEL file at some stage
    public String vEmail = "rtestguru99@gmail.com";
    private String vpwd = "Test12345678";


    @BeforeTest


    public void setUp() throws Exception{
        String driverpath = "D:\\Raji_Selenium\\geckodriver-v0.19.0-win64\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", driverpath);
        driver = new FirefoxDriver();
        baseUrl = "http://live.demoguru99.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


     @Test

    public void testTestCase06()throws Exception{
         // Step1: Go to http://live.demoguru99.com/
             driver.get(baseUrl);

         // Step2: Click on my account link
             driver.findElement(By.linkText("MY ACCOUNT")).click();

        // 3. Login in application using previously created credential

         driver.findElement(By.xpath("//input[@id='email']")).sendKeys("rtestguru99@gmail.com");
         driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Test12345678");
         driver.findElement(By.xpath(" //span[contains(text(),'Login')]")).click();
         Thread.sleep(5000);

        //Step4. Click on MY WISHLIST link

      driver.findElement(By.linkText("My Wishlist")).click();


        //Step5. In next page, Click ADD TO CART link



         /*


         6. Enter general shipping country, state/province and zip for the shipping cost estimate
         7. Click Estimate
         8. Verify Shipping cost generated
         9. Select Shipping Cost, Update Total
         10. Verify shipping cost is added to total
         11. Click "Proceed to Checkout"
         12a. Enter Billing Information, and click Continue
         12b. Enter Shipping Information, and click Continue
         13. In Shipping Method, Click Continue
         14. In Payment Information select 'Check/Money Order' radio button. Click Continue
         15. Click 'PLACE ORDER' button
         16. Verify Oder is generated. Note the order number
*/

     }

}
