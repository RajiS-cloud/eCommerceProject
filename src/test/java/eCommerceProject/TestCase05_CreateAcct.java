package eCommerceProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class TestCase05_CreateAcct {

    private WebDriver driver;
    private String baseUrl;
    public String firstName = "TestGuru"; // These testdata stuff will be placed
    public String lastName ="Guru99";  // in a TestData EXCEL file at some stage
    public String vEmail = "rtestguru99@gmail.com";
    private String vpwd = "Test12345678";


//*    Participant : Krishna Rungta
//*                                                                                                                                                        *
//********************************************************************************************
/*

Test Steps:
1. Goto http://live.demoguru99.com/
2. Click on my account link
3. Click Create Account link and fill New User Information except Email ID
4. Click Register
5. Verify Registration is done
6. Go to TV menu
7. Add product in your wish list
8. Click SHARE WISHLIST
9. In next page enter  Email and and click on SHARE WISHLIST
10. Check WishList is shared

*/

@BeforeTest

    public void setUP() throws Exception{

    String driverpath = "D:\\Raji_Selenium\\geckodriver-v0.19.0-win64\\geckodriver.exe";
    System.setProperty("webdriver.gecko.driver", driverpath);
    driver = new FirefoxDriver();
    //FirefoxDriver driver = new FirefoxDriver();
    baseUrl = "http://live.demoguru99.com/";

}

 @Test
    public void test05CreateAccount() throws Exception{

    //1. Goto http://live.demoguru99.com/
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

     //2. Click on my account link
        driver.findElement(By.xpath("//div[@class='footer']//a[contains(text(),'My Account')]")).click();

    //3. Click Create Account link and fill New User Information except Email ID

        driver.findElement(By.xpath("//span[contains(text(),'Create an Account')]")).click();


        driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("TestGuru");
        driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Guru99");
        driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys("rtestguru99@gmail.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Test12345678");
        driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys("Test12345678");

        driver.findElement(By.xpath("//span[contains(text(),'Register')]")).click();


     //5. Verify Registration is done

       driver.findElement(By.xpath("//a[contains(text(),'click here')]")).click();
       driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys("rtestguru99@gmail.com");

       driver.findElement(By.xpath("//span[contains(text(),'Submit')]")).click();
     driver.findElement(By.xpath("//input[@id='email']")).sendKeys("rtestguru99@gmail.com");
     driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Test12345678");

     String vWelcome = ("WELCOME, " + firstName + " " + lastName + "!");
    // String tWelcome = driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[1]/div/p")).getText();
     String tWelcome  = driver.findElement(By.xpath("//p[@class=\"Welcome-msg']")).getText();
     System.out.println("tWelcome = "+tWelcome);

     try {
         assertEquals(tWelcome, vWelcome);
     } catch (Exception e) {
         e.printStackTrace();
     }

     //6. Go to TV menu

    driver.findElement((By.xpath("//a[contains(text(),'TV')]"))).click();

     //7. Add product in your wish list

     driver.findElement(By.xpath("//li[1]//div[1]//div[3]//ul[1]//li[1]//a[1]")).click();

    // 8. Click SHARE WISHLIST

     //6. Go to TV menu

     driver.findElement((By.xpath("//a[contains(text(),'TV')]"))).click();
     driver.findElement(By.xpath("//li[1]//div[1]//div[3]//ul[1]//li[1]//a[1]")).click();

     driver.findElement(By.xpath("span[contains(text(),'Share Wishlist')]")).click();

   //  9. In next page enter  Email and and click on SHARE WISHLIST
     driver.findElement(By.xpath("//textarea[@id='email_address']")).sendKeys("rtestguru99@gmail.com");
   //  10. Check WishList is shared

        // //span[contains(text(),'Share Wishlist')]
}
    @AfterTest
    public void tearDown() throws Exception {
        Thread.sleep(2000);
      //  driver.quit();
    }

}
