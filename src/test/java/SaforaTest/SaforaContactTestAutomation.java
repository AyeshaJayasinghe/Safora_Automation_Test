package SaforaTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SaforaContactTestAutomation {

    public static void main(String[] args) throws InterruptedException {

        // Launch Chrome Browser
        WebDriver driver = new ChromeDriver();

        // Maximize Browser Window
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        
        // Open Safora Website
        driver.get("https://safora.se/en/");

        System.out.println("Safora Home Page Opened");

        // Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Wait until page fully loads
        wait.until(webDriver ->
                ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState")
                        .equals("complete"));

        // Locate Contact Us link
        WebElement contactUs = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("(//a[contains(normalize-space(),'Contact')])[last()]")
                )
        );

        // Scroll to Contact link
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", contactUs);

        Thread.sleep(2000);

        // Click Contact link using JavaScript
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", contactUs);

        System.out.println("Clicked Contact Us");

        // Wait until Contact page loads
        wait.until(webDriver ->
                ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState")
                        .equals("complete"));

        // Fill Name
        WebElement name = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name']")));
        name.sendKeys("Test 4");
        System.out.println("Entered Name");

        // Fill Email
        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("testautomation517@gmail.com");
        System.out.println("Entered Email");

        // Fill Phone Number
        WebElement subject = driver.findElement(By.xpath("//input[@id='phone']"));
        subject.sendKeys("0771000004");
        System.out.println("Entered Subject");

        // Fill Message
        WebElement message = driver.findElement(By.xpath("//textarea[@id='message']"));
        message.sendKeys("This is a test message submitted for testing purposes");
        System.out.println("Entered Message");

        // Scroll to reCAPTCHA area
        js.executeScript("window.scrollBy(0,300)");
        Thread.sleep(2000);

        // Switch to reCAPTCHA iframe
        WebElement iframe = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//iframe[contains(@title,'reCAPTCHA')]")
                )
        );

        driver.switchTo().frame(iframe);

        // Locate reCAPTCHA checkbox
        WebElement captcha = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[@class='recaptcha-checkbox-border']")
                )
        );

        // Click reCAPTCHA
        captcha.click();

        System.out.println("Clicked reCAPTCHA");

        // Switch back to main page
        driver.switchTo().defaultContent();

        // Pause for manual verification if challenge appears
        System.out.println("Please complete CAPTCHA manually if image challenge appears.");

        Thread.sleep(30000);
     
        WebElement sendmsg = driver.findElement(By.xpath("//button[normalize-space()='Send Message']"));
        sendmsg.click();
        System.out.println("Send Message Clicked");
       
        
        // Wait after submission
        Thread.sleep(2000);
        
        // Wait for Success OK popup button
        WebElement okButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[normalize-space()='OK']")
                )
        );

        // Click OK button
        okButton.click();

        System.out.println("OK Button Clicked");


        // Close Browser
        //driver.quit();
    }
}

