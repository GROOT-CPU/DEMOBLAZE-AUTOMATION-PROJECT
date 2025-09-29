














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
        // Setup ChromeDriver
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        
        
        
        
        

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

     
        driver.get("https://demoblaze.com/");
        
        

        //  Login
        WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.id("login2")));
        login.click();

        
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
        username.sendKeys("suriyasriram");

        
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginpassword")));
        password.sendKeys("1234");

       
        WebElement loginbtn = driver.findElement(By.xpath("//*[@id='logInModal']//button[text()='Log in']"));
        loginbtn.click();

        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout2")));

        //phoneclick
        WebElement phonelink = wait.until(ExpectedConditions.elementToBeClickable( By.xpath("//a[@class='hrefch' and @href='prod.html?idp_=1']")));
        phonelink.click();

        //add to cart
        WebElement addcart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='btn btn-success btn-lg']")));
        addcart.click();

        //ALert handle
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(" text: " + alert.getText());
        alert.accept();
        
        //clickcart
        WebElement verfiy = driver.findElement(By.xpath("//a[@id='cartur']"));
        verfiy.click();
        
        
        
        WebElement purcha = driver.findElement(By.cssSelector(".btn.btn-success"));
        purcha.click();
        
       
        //form
        WebElement name = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id='name']")));
        name.click();
        name.sendKeys("sriram");
        
        
        WebElement country = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id='country']")));
        country.click();
        country.sendKeys("japan");
        
        
        WebElement city = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id='city']")));
        city.click();
        city.sendKeys("tokyo");
        
        
        WebElement credi = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id='card']")));
        credi.click();
        credi.sendKeys("112333");
        
        
        WebElement month = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id='month']")));
        month.click();
        month.sendKeys("june");
        
        
        WebElement year = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id='year']")));
        year.click();
        year.sendKeys("2025");
        
        
     
        WebElement buy = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[onclick='purchaseOrder()']")));
        buy.click();
        
        WebElement confirm = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("p[class='lead text-muted ()']")));
        confirm.getText();
        System.out.println(confirm);
        
        
        WebElement ok =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("button[text()='OK']")));
        ok.click();
        
        
        
      

    }
    
        
        
        
        
    }

