import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextboxPractise {

    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage(){

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("137");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://leafground.com/input.xhtml");
    }

    @AfterMethod
    public void closeBrowser(){
//        driver.quit();
    }

    @Test
    public void textBoxTests(){

        WebElement name = driver.findElement(By.id("j_idt88:name"));
        name.sendKeys("Test User");

        WebElement city = driver.findElement(By.id("j_idt88:j_idt91"));
        city.clear();
        city.sendKeys("Test City");

        boolean enableTextbox = driver.findElement(By.id("j_idt88:j_idt93")).isEnabled();
        System.out.println("TextBox is - " + enableTextbox);

        WebElement clearText = driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt95\"]"));
        clearText.clear();

        WebElement retrieveTextbox = driver.findElement(By.id("j_idt88:j_idt97"));
        String retrieveTextValueTextbox = retrieveTextbox.getAttribute("value");
        System.out.println(retrieveTextValueTextbox);

        WebElement typeTextbox = driver.findElement(By.id("j_idt88:j_idt99"));
        typeTextbox.sendKeys("test@test.com" + Keys.TAB + "Confirm control moved to next element");


    }
}
