package ASSEMENT;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DIVASSEMENT {

    public static void main(String[] args) throws InterruptedException {
        // -------------------------
        // Setup ChromeDriver
        // -------------------------
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");   // Open browser in incognito mode
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();   // Maximize browser window

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // -------------------------
        // Open Demoblaze website
        // -------------------------
        driver.get("https://demoblaze.com/");

        // -------------------------
        // Login
        // -------------------------
        WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.id("login2")));
        login.click();

        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
        username.sendKeys("suriyasriram");

        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginpassword")));
        password.sendKeys("1234");

        WebElement loginbtn = driver.findElement(By.xpath("//*[@id='logInModal']//button[text()='Log in']"));
        loginbtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout2"))); // Wait until logout button is visible

        // -------------------------
        // Select a phone product
        // -------------------------
        WebElement phonelink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[@class='hrefch' and @href='prod.html?idp_=1']")));
        phonelink.click();

        // -------------------------
        // Add to cart
        // -------------------------
        WebElement addcart = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[@class='btn btn-success btn-lg']")));
        addcart.click();

        // -------------------------
        // Handle Alert
        // -------------------------
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Alert text: " + alert.getText());
        alert.accept();

        // -------------------------
        // Go to Cart
        // -------------------------
        WebElement verify = driver.findElement(By.id("cartur"));
        verify.click();

        // -------------------------
        // Click Purchase
        // -------------------------
        WebElement purchase = driver.findElement(By.cssSelector(".btn.btn-success"));
        purchase.click();

        // -------------------------
        // Fill Purchase Form
        // -------------------------
        WebElement name = wait.until(ExpectedConditions.elementToBeClickable(By.id("name")));
        name.sendKeys("Sriram");

        WebElement country = wait.until(ExpectedConditions.elementToBeClickable(By.id("country")));
        country.sendKeys("Japan");

        WebElement city = wait.until(ExpectedConditions.elementToBeClickable(By.id("city")));
        city.sendKeys("Tokyo");

        WebElement card = wait.until(ExpectedConditions.elementToBeClickable(By.id("card")));
        card.sendKeys("112333");

        WebElement month = wait.until(ExpectedConditions.elementToBeClickable(By.id("month")));
        month.sendKeys("June");

        WebElement year = wait.until(ExpectedConditions.elementToBeClickable(By.id("year")));
        year.sendKeys("2025");

        // -------------------------
        // Click Buy
        // -------------------------
        WebElement buy = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[onclick='purchaseOrder()']")));
        buy.click();

        // -------------------------
        // Get Confirmation Text
        // -------------------------
        WebElement confirm = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("p.lead.text-muted")));
        System.out.println("Purchase Confirmation:\n" + confirm.getText());

        // -------------------------
        // Click OK
        // -------------------------
        WebElement ok = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button.confirm.btn.btn-lg.btn-primary")));
        ok.click();

        // -------------------------
        // Close Browser
        // -------------------------
        driver.quit();
    }
}
