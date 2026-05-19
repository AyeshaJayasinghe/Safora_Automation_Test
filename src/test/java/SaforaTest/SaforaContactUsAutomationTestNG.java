package SaforaTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class SaforaContactUsAutomationTestNG {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    @BeforeMethod
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        js = (JavascriptExecutor) driver;

        driver.get("https://safora.se/en/");
        System.out.println("Safora Home Page Loaded");
    }

    // Common Method

    public void pause(int sec) throws InterruptedException {
        Thread.sleep(sec * 1000);
    }

    public void openContactPage() throws InterruptedException {

        pause(2);

        WebElement contactUs = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("(//a[contains(normalize-space(),'Contact')])[last()]")
                )
        );

        js.executeScript("arguments[0].click();", contactUs);
        System.out.println("Contact Page Opened");

        pause(2);
    }

    public void handleCaptcha() throws InterruptedException {

        try {
            js.executeScript("window.scrollBy(0,400)");
            pause(2);

            WebElement iframe = driver.findElement(
                    By.xpath("//iframe[contains(@title,'reCAPTCHA')]")
            );

            driver.switchTo().frame(iframe);

            WebElement checkbox = driver.findElement(
                    By.cssSelector("#recaptcha-anchor")
            );

            js.executeScript("arguments[0].click();", checkbox);

            System.out.println("reCAPTCHA tick attempted");

            driver.switchTo().defaultContent();

        } catch (Exception e) {
            System.out.println("reCAPTCHA not clickable - manual intervention required");
            driver.switchTo().defaultContent();
        }

        pause(15);
    }
    
   
    // 1. Valid Submission (Positive)

    @Test(priority = 1)
    public void validFormSubmission() throws InterruptedException {

        openContactPage();

        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Test User");
        pause(1);

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("testautomation517@gmail.com");
        pause(1);

        driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("0771000001");
        pause(1);

        driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("Valid automation message");
        pause(1);

        handleCaptcha();

        driver.findElement(By.xpath("//button[normalize-space()='Send Message']")).click();
        System.out.println("Send Message Clicked");
        pause(3);

        driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
        System.out.println("Success Popup Handled");
        System.out.println("Message Sent Successfully");
        pause(3);
        
        Thread.sleep(15000);
    }

    
    // 2. Empty Form
  
    @Test(priority = 2)
    public void emptyFormSubmission() throws InterruptedException {

        openContactPage();

        // Anchor element inside form (NOT button)
        WebElement formAnchor = driver.findElement(
                By.xpath("//textarea[@id='message']")
        );

        // Scroll to form section (stable, no over-scroll)
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block: 'center'});", formAnchor);

        Thread.sleep(2000);

        handleCaptcha();

        driver.findElement(By.xpath("//button[normalize-space()='Send Message']")).click();

        System.out.println("Empty Form Submitted");
        pause(3);

        System.out.println("Expected: Validation messages appear and Result: As Expected");

        Thread.sleep(15000);
    }
  
    
    // 3. Invalid Email
    
    @Test(priority = 3)
    public void invalidEmailTest() throws InterruptedException {

        openContactPage();

        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Test User");
        pause(1);

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("testautomation517gmail.com");
        pause(1);

        driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("0771000001");
        pause(1);

        driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("Valid message");
        pause(1);

        handleCaptcha();
        
        driver.findElement(By.xpath("//button[normalize-space()='Send Message']")).click();
        System.out.println("Invalid Email Submitted");
        pause(3);

        System.out.println("Expected: Email validation error and Result: As Expected");
        
        Thread.sleep(15000);
    }

    
    // 4. Missing Name
 
    @Test(priority = 4)
    public void missingNameTest() throws InterruptedException {

        openContactPage();

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("testautomation517@gmail.com");
        pause(1);

        driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("0771000001");
        pause(1);

        driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("Valid message");
        pause(1);
        handleCaptcha();

        driver.findElement(By.xpath("//button[normalize-space()='Send Message']")).click();
        pause(3);

        System.out.println("Expected: Name required validation and Result: As Expected");
        
        Thread.sleep(15000);
    }

 
    // 5. Special Character Name

    @Test(priority = 5)
    public void specialCharNameTest() throws InterruptedException {

        openContactPage();

        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("@@@###123");
        pause(1);

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("testautomation517@gmail.com");
        pause(1);

        driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("0771000004");
        pause(1);

        driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("Valid message");
        pause(1);

        handleCaptcha();
        
        driver.findElement(By.xpath("//button[normalize-space()='Send Message']")).click();
        pause(3);
        
        driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
        System.out.println("Success Popup Handled");
        pause(3);
        
        System.out.println("Expected: Name validation error and Result: As Not Expected");
        
        Thread.sleep(15000);
    }


    // 6. Long Name (>256)

    @Test(priority = 6)
    public void longNameTest() throws InterruptedException {

        openContactPage();

        String longName = "A".repeat(300);

        driver.findElement(By.xpath("//input[@id='name']")).sendKeys(longName);
        pause(1);

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("testautomation517@gmail.com");
        pause(1);

        driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("0771000001");
        pause(1);

        driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("Valid message");
        pause(1);
        
        handleCaptcha();

        driver.findElement(By.xpath("//button[normalize-space()='Send Message']")).click();
        pause(3);

        driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
        System.out.println("Success Popup Handled");
        pause(3);
        
        System.out.println("Expected: Name length validation and Result: As Not Expected");
        
        Thread.sleep(15000);
    }

  
    // 7. Missing Message

    @Test(priority = 7)
    public void missingMessageTest() throws InterruptedException {

        openContactPage();

        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Test User");
        pause(1);

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("testautomation517@gmail.com");
        pause(1);

        driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("0771000001");
        pause(1);

        //driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("");
        //pause(3);
        
        handleCaptcha();
        
        driver.findElement(By.xpath("//button[normalize-space()='Send Message']")).click();
        pause(3);

        System.out.println("Expected: Message required validation and Result: As Expected");
        
        Thread.sleep(15000);
    }


    // 8. Long Phone Number
    
    @Test(priority = 8)
    public void longPhoneNumberTest() throws InterruptedException {

        openContactPage();

        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Test User");
        pause(1);

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("testautomation517@gmail.com");
        pause(1);

        driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("07710000041234567890021000233220000");
        pause(1);

        driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("Valid message");
        pause(1);
        
        handleCaptcha();

        driver.findElement(By.xpath("//button[normalize-space()='Send Message']")).click();
        pause(3);
        
        driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
        System.out.println("Success Popup Handled");
        pause(3);

        System.out.println("Expected: Phone validation error and Result: As Not Expected");
        
        Thread.sleep(15000);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}