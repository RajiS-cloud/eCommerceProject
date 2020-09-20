import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;


/**
 *
 * @author Rsji S
 *        Test Script 02
 *        **************
 *        This method will perform following Test Steps
 *
 *        1)  Go to http://www.demo.guru99.com/V4/
2) Enter valid UserId
3) Enter valid Password
4) Click Login
5) Verify the Page Title after login
 */


public class MainLoginPage {

    public static void main(String[] args) throws Exception {
        // WebDriver firefoxDriver;

        //Setup driver
        // WebDriver chromedriver = BaseSetup.getDriver("chrome");
        WebDriver firefoxDriver = BaseSetUp.getDriver("firefox");
        // System.out.println("<<<Firefox>>>");

        // Navigate to Home Page
        //   HomePage.NavigateToUrl(chromedriver);
        //  HomePage.NavigateToUrl(firefoxDriver);

        //Login(chromedriver);
      /*  LoginFromArrayData(chromedriver);
        System.out.println("<<<Chrome>>>");
        String actualTitle = chromedriver.getTitle();
        if (actualTitle.contains(Util.EXPECT_TITLE)) {
            System.out.println("Test case: Passed");
        } else {

            System.out.println("Test case : Failed: " + Util.EXPECT_ERROR);
        }*/
        // CloseDriver(chromedriver);

        //Login(firefoxDriver);
        LoginFromArrayData(firefoxDriver);
        System.out.println("<<<Firefox>>>");
        firefoxDriver.close();
        //String actualTitle2 = firefoxDriver.getTitle();
        //CloseDriver(firefoxDriver);
    }


    /* public static void Login(WebDriver driver) {
         String username, password;
         String actualTitle;

         driver.findElement(By.name("uid")).clear(); // Good practice to clear a field before use
         driver.findElement(By.name("uid")).sendKeys(Util.USER_NAME);  // Enter username


         driver.findElement(By.name("password")).clear(); // Good practice to clear a field before use
         driver.findElement(By.name("password")).sendKeys(Util.PASSWD);  // Enter Password

         driver.findElement(By.name("btnLogin")).click();

         actualTitle = driver.getTitle();
         if (actualTitle.contains(Util.EXPECT_TITLE)) {
             System.out.println("Test case: Passed");
         } else {
             System.out.println("Test case : Failed");
         }
     }
 */

    public static void LoginFromArrayData(WebDriver driver) throws Exception {


        // Method 	getDataFromExcel is defined in class Util

        String[][] testData = Util.getDataFromExcel(Util.FILE_PATH, Util.SHEET_NAME, Util.TABLE_NAME);

        String username, password;
        String actualTitle = "";
        String actualBoxTitle;


        //String[][] testData = {{"mngr256521", "ytEmysu"}, {"tetsdsd", "jytewydf"}};

        int i;


        for (i = 0; i <= testData.length - 1; i++) {
            username = testData[i][0];
            password = testData[i][1];

            // driver = BaseSetup.getDriver("firefox");

            try {
                HomePage.NavigateToUrl(driver);
            } catch (Exception e) {
                e.printStackTrace();
            }

            driver.findElement(By.name("uid")).clear(); // Good practice to clear a field before use
            driver.findElement(By.name("uid")).sendKeys(username);  // Enter username

            driver.findElement(By.name("password")).clear(); // Good practice to clear a field before use
            driver.findElement(By.name("password")).sendKeys(password);  // Enter Password

            driver.findElement(By.name("btnLogin")).click();
            Thread.sleep(4000);

            /* If login credentials are invalid, Alert is present. Code in try block is executed
             */
            try {
                Alert alt = driver.switchTo().alert();
                actualBoxTitle = alt.getText(); // get content of the Alter Message
                // alt.accept();9
                alt.dismiss();
                if (actualBoxTitle.contains(Util.EXPECT_ERROR)) { // Compare Error Text with Expected Error Value
                    System.out.println("InValid Username : " + username);
                    System.out.println("InValid Password: " + password);
                    System.out.println("Test case invalid data: Passed : " + Util.EXPECT_ERROR);
                } else {
                    System.out.println("InValid Username : " + username);
                    System.out.println("InValid Password: " + password);
                    System.out.println("Test case invalid data: failed : " + actualBoxTitle);
                }
            } catch (NoAlertPresentException Ex) { // NoAlertPresentException
                Ex.printStackTrace();
                actualTitle = driver.getTitle();
                //actualTitle = driver.getPageSource();
                if (actualTitle.contains(Util.EXPECT_TITLE)) {
                    System.out.println("Valid Username : " + username);
                    System.out.println("Valid Password: " + password);
                    System.out.println("Test case valid data: Passed : " + Util.EXPECT_TITLE);
                    //String loginManager = driver.findElement(By.xpath("//td[contains(text(),'Manger Id : mngr256521')]")).getText();
                    // System.out.println("Actual Manager logged in: " + loginManager );
                    // Assert.assertEquals("Login Manager ID: ", "Manger Id : mngr256521", loginManager );

                    // Get text displays on login page
                    String pageText = driver.findElement(By.tagName("tbody")).getText();

                    // Extract the dynamic text mngrXXXX on page
                        String[] parts = pageText.split(Util.PATTERN);
                        String dynamicText = parts[1];
                    System.out.println("Display the Dynamic text: " + dynamicText);
                    System.out.println("Display the Dynamic Substring  text: " + dynamicText.substring(1, 5));
                    System.out.println("Display the Dynamic Substring  text: " + dynamicText.substring(1, 4));
                    System.out.println("Display the Dynamic Substring  text: " + dynamicText.substring(1, 3));
                    System.out.println("Display the Dynamic Substring  text: " + dynamicText.substring(1, 6));


                    // Check that the dynamic text is of pattern mngrXXXX
                    // First 4 characters must be "mngr"

                        assertTrue(dynamicText.substring(1, 5).equals(Util.FIRST_PATTERN));
                        System.out.println("Remaim matches the First patern:  mngr ");


                    // remain stores the "XXXX" in pattern mngrXXXX

                    System.out.println("Display the total length of dynamic text:  " + dynamicText.length() );

                        String remain = dynamicText.substring(dynamicText.length() - 4);
                    System.out.println("Display the Remaining text or numeric value: " + remain);

                    String remain1 = dynamicText.substring(dynamicText.length() - 6);
                    System.out.println("Display the Remaining text or numeric value: " + remain1);


                    // Check remain string must be numbers;

                        assertTrue(remain.matches(Util.SECOND_PATTERN));
                    System.out.println("Remaim matches the second patern [0-9]");

                } else {
                    System.out.println("InValid Username : " + username);
                    System.out.println("InValid Password: " + password);
                    System.out.println("Test case valid data: failed :" + actualTitle);
                }
            }

            // driver.close();
        }
    }


}
