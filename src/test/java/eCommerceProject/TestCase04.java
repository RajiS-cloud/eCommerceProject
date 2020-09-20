package eCommerceProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class TestCase04 {

    private WebDriver driver;
    private String baseUrl;

//*    Participant : Krishna Rungta
//*                                                                                                                                                        *
//********************************************************************************************
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

    @BeforeTest
    public void setUp() throws Exception {

        String driverpath = "D:\\Raji_Selenium\\geckodriver-v0.19.0-win64\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", driverpath);
        driver = new FirefoxDriver();
        //FirefoxDriver driver = new FirefoxDriver();
        baseUrl = "http://live.demoguru99.com/";
        //driver.get(baseUrl);
       // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void TestCase4() throws Exception {

        // Step 1. Go to http://live.demoguru99.com
        // driver.get(baseUrl);
          driver.get(baseUrl);
          driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // Step 2. Click on ‘MOBILE’ menu
        driver.findElement(By.xpath("//a[contains(text(),'Mobile')]")).click();
        Thread.sleep(2000);

        // Step 3. In mobile products list , click on ‘Add To Compare’ for 2 mobiles (Iphone & Sony Xperia)

        //note: store the title of the 2 mobiles for comparison for verification later when popup page comes up
       /*
        driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[2]/ul/li[2]/a")).click();
        String mainMobile1 = driver.findElement(By.xpath("//h2/a[@title='IPhone']")).getText();  // text captured - upperCase "IPHONE"
        System.out.println("mainMobile1 = "+mainMobile1);
       */


        //driver.findElement(By.linkText("Add to Compare")).click();

        driver.findElement(By.xpath("(//a[@class='link-compare'])[2]")).click();

       /* driver.findElement(By.cssSelector("\n" +
                "\n" +
                "body.catalog-category-view.categorypath-mobile-html.category-mobile:nth-child(2) div.wrapper div.page:nth-child(2) div.main-container.col3-layout div.main div.col-wrapper div.col-main div.category-products ul.products-grid.products-grid--max-4-col.first.last.odd:nth-child(2) li.item.last:nth-child(2) div.product-info div.actions ul.add-to-links li:nth-child(2) > a.link-compare")).click(); */
        String mobile_MainIPhone = driver.findElement(By.xpath("//h2/a[@title='IPhone']")).getText();
        System.out.println("Main Mobile1: " + mobile_MainIPhone);
        Thread.sleep(1000);


        //driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[3]/div/div[3]/ul/li[2]/a")).click();
        //String mainMobile2 = driver.findElement(By.xpath("//h2/a[@title='Sony Xperia']")).getText();  // text captured - upperCase "SONY XPERIA"
        //System.out.println("mainMobile2 = "+mainMobile2);

        //driver.findElement(By.linkText("Add to Compare")).click();
        driver.findElement(By.xpath("(//a[@class='link-compare'])[1]")).click(); // using xPath Axess method

        String mobile_MainSonyXperia = driver.findElement(By.xpath("//h2/a[@title='Sony Xperia']")).getText();
        System.out.println("Main Mobile2 :" + mobile_MainSonyXperia);

        Thread.sleep(1000);

        int listAddtocompareelements = driver.findElements(By.xpath("//a[@class='link-compare']")).size();
        System.out.println("The list count for compare " +listAddtocompareelements);
/*
        for(int i=1; i<=listAddtocompareelements; i++) {
            driver.findElement(By.xpath("(//a[@class='link-compare'])[i]")).click();
            if (i ==1) {
                String mobile_MainSonyXperia1 = driver.findElement(By.xpath("//h2/a[@title='Sony Xperia']")).getText();
                System.out.println("Main Mobile2 :" + mobile_MainSonyXperia1);
            } else if(i==2){
                String mobile_MainIPhone1 = driver.findElement(By.xpath("//h2/a[@title='IPhone']")).getText();
                System.out.println("Main Mobile1: " + mobile_MainIPhone1);
                Thread.sleep(1000);

            } else
                break;
            }

            int listAddtocompareelements = driver.findElements(By.xpath("//a[@class='link-compare']")).size();

  */


        // 4. Click on ‘COMPARE’ button. A popup window opens
        driver.findElement(By.xpath("//button[@title='Compare']")).click();
        Thread.sleep(1000);

        // switching to new window
         for (String handle : driver.getWindowHandles()) {
              driver.switchTo().window(handle);
         }

        /* String handle = driver.getWindowHandle();
        driver.switchTo().window(handle);
        */

        // 5. Verify the pop-up window and check that the products are reflected in it
        //    Heading "COMPARE PRODUCTS" with selected products in it.
        String strHead = ("COMPARE PRODUCTS");
        //String compHead = driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div[1]/h1")).getText();
        String compHead = driver.findElement(By.xpath("//h1[contains(text(),'Compare Products')]")).getText();
        System.out.println("compHead = " + compHead);
        String popupMobile1 = driver.findElement(By.xpath("//h2/a[@title='IPhone']")).getText();  // text captured is "IPHONE" in uppercase
        String popupMobile2 = driver.findElement(By.xpath("//h2/a[@title='Sony Xperia']")).getText();  // text captured "SONY XPERIA" in uppercase
        System.out.println("popupMobile1 = " + popupMobile1);
        System.out.println("popupMobile2 = " + popupMobile2);
        Thread.sleep(1000);
        // to check the popup heading/title
        try {
            assertEquals(strHead, compHead);
            System.out.println("Pass: the heading in Popup window is same as main window: COMPARE PRODUCTS");
        } catch (Exception e) {
            e.printStackTrace();
        }
        // to check the 2 mobiles selected are the two in the popup - this is tp check the IPhone
        try {
            assertEquals(mobile_MainIPhone, popupMobile1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // to check the 2 mobiles selected are the two in the popup - this is to check Sony X
        try {
            assertEquals(mobile_MainSonyXperia, popupMobile2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 6. Close the Popup Windows
        driver.findElement(By.xpath("//button[@title='Close Window']")).click();

        // switching to new window
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }



       /*
       String handleold = driver.getWindowHandle();
       driver.switchTo().window(handleold);

        */
    }

    @AfterTest
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }

}
