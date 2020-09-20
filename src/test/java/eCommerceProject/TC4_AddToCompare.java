package eCommerceProject;

/*
Test Steps:
1. Goto http://live.demoguru99.com/
2. Click on ‘MOBILE’ menu
3. In mobile products list , click on ‘Add To Compare’ for 2 mobiles (Sony Xperia & Iphone)
4. Click on ‘COMPARE’ button. A popup window opens
5. Verify the pop-up window and check that the products are reflected in it
   Heading "COMPARE PRODUCTS" with selected products in it.
6. Close the Popup Windows
*/
//import com.sun.tools.javac.util.List;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
//import sun.tools.tree.StringExpression;
import javax.swing.*;
import java.io.File;
import java.util.concurrent.TimeUnit;

//import java.util.List;
import static org.testng.AssertJUnit.assertEquals;

public class TC4_AddToCompare {

    private WebDriver driver;
    private String baseUrl;
    public int scc =0;
    private StringBuffer verificationErrors = new StringBuffer();

   @BeforeTest
    public void setUp() throws Exception{
        String driverpath = "D:\\Raji_Selenium\\geckodriver-v0.19.0-win64\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", driverpath);
        driver = new FirefoxDriver();
        baseUrl = "http://live.demoguru99.com/";
        //driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    public void testDay1DemoSite() throws Exception {
        // 1.Step 1 Goto http://live.demoguru99.com/
                driver.get(baseUrl);
        // 2. Click on Mobile menu
            driver.findElement(By.xpath("//a[contains(text(),'Mobile')]")).click();
            Thread.sleep(1000);
       // 3. In mobile products list , click on ‘Add To Compare’ for 2 mobiles (Sony Xperia & Iphone)

      // WebElement test1= driver.findElement(By.linkText("Add to Compare"));
        List<WebElement> linklists = driver.findElements(By.linkText("Add to Compare"));
      // linklists.click();
        System.out.println("Print linklists " + linklists.size());
        for (int i= 0; i <= linklists.size(); i++) {
            // String mobile_MainSonyXperia = driver.findElement(By.xpath("//h2/a[@title='Sony Xperia']")).getText();
            // System.out.println("Main Mobile1 :" + mobile_MainSonyXperia);
            //driver.findElement(By.linkText("Add to Compare")).click();
            // String mobile_MainIPhone = driver.findElement(By.xpath("//h2/a[@title='IPhone']")).getText();
            //  System.out.println("Main Mobile2: " + mobile_MainIPhone);
            Actions action = new Actions(driver);
            action.click(linklists.get(i));
            action.perform();
            //link-compare
            String mobile1 = driver.findElement(By.className("link-compare")).getText();
            System.out.println("mobile name:" + mobile1);
        }

       }
        /*
        //Step 2. Verify Title of the page
        String demoSite = driver.findElement(By.cssSelector("h2")).getText();
        System.out.println("This is the demo site:" + demoSite );
        try {
            assertEquals("THIS IS DEMO SITE FOR  ", demoSite);
        } catch(Error e){
            verificationErrors.append(e.toString());

        // Step 3. Click on ‘MOBILE’ menu

            driver.findElement(By.xpath("//a[contains(text(),'Mobile')]")).click();

        // Step 5. In the list of all mobile , select ‘SORT BY’ dropdown as ‘name’

          Select mobilelistByName =  new Select(driver.findElement(By.xpath("//*[@id=\"top\"]//select")));  -- Correct using xpath
           mobilelistByName.selectByVisibleText("Name");
        */

        // using cssselector another method
        // Select mobilelistByName =  new Select(driver.findElement(By.cssSelector("select[title=\"Sort By\"]")));
        // mobilelistByName.selectByVisibleText("Name");
        // Step 6. Verify all products are sorted by name
        // this will take a screen shot of the manager's page after a successful login
        /*  scc= scc+1;
            System.out.println("Take Screenshot");
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Thread.sleep(300);
            System.out.println("Screenshot exists >>>>>" + scrFile);
            scrFile.exists();
        // Code to save screenshot at desired location
            String png = ("D:\\Raji_Selenium\\eCommerceProject\\Mobile Products are sorted by Name"+scc+".png");
            FileUtils.copyFile(scrFile, new File(png));
         */
         /*  @Test
              public void testDay2MobilePriceCompare() throws Exception{
        // 6. In the list of all mobile , read the cost of Sony Xperia mobile (which is $100)
              String xperiapPrice1 = driver.findElement(By.cssSelector("#product-price-1 > span.price")).getText();
              System.out.println("The price of the Sony Xperia is the search list is : " + xperiapPrice1);
        //7. Click on the Sony Xperia link
             driver.findElement(By.xpath("//h2[@class='product-name']//a[contains(text(),'Sony Xperia')]")).click();
        // 8.  Read the XPeria mobile price from details page
        String xperiaPriceDetail1 = driver.findElement(By.cssSelector("#product-price-1>span.price")).getText();
        System.out.println("The price of the Sony Xperia in detail page is: "  + xperiaPriceDetail1 );

        // 9. Compare the prices - Product price in list and details page should be equal ($100)
        try{
            assertEquals(xperiapPrice1,xperiaPriceDetail1);
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
       WebElement eMobiles= driver.findElement((By.xpath("//a[contains(text(),'Mobiles')]")));
       driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        */
        // Actions act = new Actions(driver);
       //  act.moveToElement(mQty).build().perform();
       // Get the value entered in the qty.
      // String reqQty1 = driver.findElement(By.xpath("//input[@id='qty']")).getAttribute("value");
      // String reqQty = driver.findElement(By.id("qty")).getText();
       /*
        String reqQty1 = mQty.getAttribute("value");
        String reqQty = mQty.getText();
        String reqQty2 = mQty.getAttribute("innerText");
        System.out.println("The quantity added to the cart is: " + reqQty1 );

        // Add the cart the qty entered
        driver.findElement(By.xpath("//*[@id=\"product_addtocart_form\"]")).submit();

        //verify the error message

        String reqQtyMessage = driver.findElement(By.xpath("//span[contains(text(),'The maximum quantity allowed for purchase is 500.')]")).getText();
        String msgQty ="The maximum quantity allowed for purchase is 500.";

       /*   try {
            assertEquals(reqQtyMessage, msgQty);
            System.out.println("Pass: "  + reqQtyMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        */
      //    Thread.sleep(2000);
     //  }

    @AfterTest
    public void teardown() throws Exception {
       // driver.close();
    }
}

