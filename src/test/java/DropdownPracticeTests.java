import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropdownPracticeTests {
    WebDriver driver;

    @BeforeMethod
    public void openDropdownTestPage(){
        driver = new ChromeDriver();
//        Dimension newSize = new Dimension(1440, 800);
//        driver.manage().window().setSize(newSize);
        driver.manage().window().maximize();
        driver.get("https://leafground.com/select.xhtml;jsessionid=node01tzrb8k9l4yp21r2c2pugovfnq3619720.node0");
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    @Test
    public void DropdownTests() throws InterruptedException {

        WebElement dropdownUIAutomation = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
        Select select = new Select(dropdownUIAutomation);
        select.selectByIndex(3);
        Thread.sleep(3000);
        select.selectByVisibleText("Puppeteer");
        Thread.sleep(3000);

        List<WebElement> listOfOptions = select.getOptions();
        int sizeOfDropdown = listOfOptions.size();
        System.out.println("Number of Elements in Dropdown " + sizeOfDropdown);

        for (WebElement element:listOfOptions) {
            System.out.println(element.getText());
        }

        dropdownUIAutomation.sendKeys("Playwright");
        Thread.sleep(3000);
    }


    @Test
    public void BootstrapDropdownTests(){
        WebElement dropdownBootstrap = driver.findElement(By.xpath("//div[@id='j_idt87:country']"));
        dropdownBootstrap.click();
        List<WebElement> listOfBootstrapDropdownValues = driver.findElements(By.xpath("//ul[@id='j_idt87:country_items']//li"));
        for(WebElement element:listOfBootstrapDropdownValues){
            String dropdownValue = element.getText();
            if (dropdownValue.equals("USA")){
                 element.click();
                 break;
            }
        }
    }

    @Test
    public void GoogleSearchDropdownTests() throws InterruptedException {
        driver.get("https://www.google.com/");
        WebElement searchBoxGoogle = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        searchBoxGoogle.sendKeys("Yamal");
        Thread.sleep(3000);
        List<WebElement> googleSearchList = driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@class='wM6W7d']"));
        System.out.println(googleSearchList.size());
        for (WebElement element:googleSearchList){
            System.out.println(element.getText());
        }
    }
}
