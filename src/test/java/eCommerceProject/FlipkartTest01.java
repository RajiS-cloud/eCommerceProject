package eCommerceProject;

//import com.sun.tools.javac.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FlipkartTest01 {

    private WebDriver driver;
    String baseUrl;
    String expectedTitle ;
    String flipkartHomepage;

    private static String[] links = null;
    private static int linksCount = 0;

    @BeforeTest
    public void setUp() throws Exception{

       String driverPath = "D:\\Raji_Selenium\\geckodriver-v0.19.0-win64\\geckodriver.exe";
       System.setProperty("webdriver.gecko.driver" , driverPath);
       driver = new FirefoxDriver();
       baseUrl ="http://www.flipkart.com/";
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       driver.manage().window().maximize();
       // driver.findElement(By.class("//button[@class='_2AkmmA _29YdH8']"))

   }

   @Test
    public void testSamsungTC1() throws Exception{
        expectedTitle = "Flipkart";
        driver.get(baseUrl);



       driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
        flipkartHomepage = driver.getTitle();
        System.out.println("Print the tite of the page:" + flipkartHomepage);

       //Actions

       Actions act = new Actions(driver);
       WebElement mainmenu = driver.findElement(By.xpath("//ul[@class='_114Zhd']"));
       act.moveToElement(mainmenu).build().perform();  // taking mouse
       WebElement eElectronics = driver.findElement(By.xpath("//span[contains(text(),'Electronics')]"));
     // eElectronics.click();
       Action moveOverElectronics = act.moveToElement(eElectronics).build();
       moveOverElectronics.perform();
       WebElement eMobiles= driver.findElement((By.xpath("//a[contains(text(),'Mobiles')]")));
       driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

       WebElement eSamsung = driver.findElement(By.linkText("Samsung"));
       act.moveToElement(eSamsung).build().perform();
       eSamsung.click();
       WebElement eSearchbox = driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']"));
      eSearchbox.sendKeys("grand2");
      driver.findElement(By.xpath("//button[@class='vh79eN']")).click();

       List<WebElement> linksize = driver.findElements(By.className("_3O0U0u"));
       linksCount =linksize.size();
       System.out.println("Print the linkcount: " + linksCount);
       links= new String[linksCount];
       System.out.println("List of links Available: ");
       // print all the links from webpage
       for(int i=0;i<linksCount;i++)
       {
           links[i] = linksize.get(i).getAttribute("href");
           System.out.println(linksize.get(i).getAttribute("href"));
       }
// navigate to each Link on the webpage
       for(int i=0;i<linksCount;i++)
       {
           driver.navigate().to(links[i]);
           Thread.sleep(3000);
       }



      /*
      driver.get("www.xyz.com");
List<WebElement> linksize = driver.findElements(By.tagName("a"));
linksCount = linksize.size();
System.out.println("Total no of links Available: "+linksCount);
links= new String[linksCount];
System.out.println("List of links Available: ");
       */

       //List<String> allLinks = new ArrayList<String>();
       //List<WebElement> data = driver.findElements(By.xpath("//span[@class='_2yAnYN']"));
       //List<WebElement> data = driver.findElements((By.xpath("//div[contains(@class,'_1HmYoV _35HD7C')]//div[2]//div[1]//div[1]//div[1]//a[1]//div[1]//div[1]//div[1]//div[1]//img[1]")));
     //  List<WebElement> data = driver.findElements(By.xpath("//span[contains(text(),'grand2')]"));
      // System.out.println("Total phones displayed-> " + data.size());


      // List<WebElement> brands = driver.findElement(By)
       //driver. findElement(By.xpath("//span[contains(text(),'sports')]")).click();
       // new Select(driver.findElement(By.xpath("//a[contains(@href,'samsung-mobile-store')]")))
      // driver.findElement(By.xpath("//[@Title='Badminton']")).click();
     //  driver.findElement(By.xpath("//a[contains(text(),'Badminton')]")).click();

//       if(flipkartHomepage.contains(expectedTitle))
//       {
//           System.out.println("You are in the flipkart Homepage");
//           driver. findElement(By.xpath("//span[contains(text(),'Electronics')]")).click();
//           // new Select(driver.findElement(By.xpath("//a[contains(@href,'samsung-mobile-store')]")))
//           driver.findElement(By.xpath("//a[contains(@href,'samsung-mobile-store')]")).click();
//       } else {
//           System.out.println("Not Flipcart home page");
//       }
    }
}

