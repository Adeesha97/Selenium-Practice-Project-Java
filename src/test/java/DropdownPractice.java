import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropdownPractice {
    WebDriver driver;

    @BeforeMethod
    public void openDropdownTestPage(){
        driver = new ChromeDriver();
        Dimension newSize = new Dimension(800, 600);
        driver.manage().window().setSize(newSize);
//        driver.manage().window().maximize();
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
        select.selectByIndex(1);
        Thread.sleep(3000);
        select.selectByVisibleText("Puppeteer");
        Thread.sleep(3000);

        List<WebElement> listOfOptions = select.getOptions();
        int sizeOfDropdown = listOfOptions.size();
        System.out.println("Number of Elements in Dropdown" + sizeOfDropdown);

        for (WebElement element:listOfOptions) {
            System.out.println(element.getText());
        }

        dropdownUIAutomation.sendKeys("Playwright");

    }

}
