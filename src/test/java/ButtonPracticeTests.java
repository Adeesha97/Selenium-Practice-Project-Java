import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.openqa.selenium.Dimension;

public class ButtonPracticeTests {

    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage(){
        driver = new ChromeDriver();
        Dimension newSize = new Dimension(800, 600);
        driver.manage().window().setSize(newSize);
//        driver.manage().window().maximize();
        driver.get("https://leafground.com/button.xhtml;jsessionid=node06hqwnvq18x9y1ex4832sr28dg3608217.node0");
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    @Test
    public void buttonTests1(){
        WebElement clickButton = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt90']"));
        clickButton.click();

        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();
//        if (expectedTitle.equals(actualTitle)){
//            System.out.println("Same as Expected");
//        }else {
//            System.out.println("not Same as Expected");
//        }
        Assert.assertEquals(actualTitle,expectedTitle, "Title Mismatched");
        driver.navigate().back();
    }

    @Test
    public void buttonTests2(){
        WebElement submitPositionButton = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt94']"));
        Point xypoint = submitPositionButton.getLocation();
        int x = xypoint.getX();
        int y = xypoint.getY();
        System.out.println("X Position is : " + x + " Y Position is : " + y);
    }

    @Test
    public void buttonTests3(){
        WebElement saveColorButton = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt96']"));
        String backgroundColor = saveColorButton.getCssValue("background-color");
        System.out.println("Button Color is : " + backgroundColor);
    }

    @Test
    public void buttonTests4(){
        WebElement submitSizeButton = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt98']"));
        int submitSizeButtonHeight = submitSizeButton.getSize().getHeight();
        int submitSizeButtonWidth = submitSizeButton.getSize().getWidth();

        System.out.println("Button Height is : " + submitSizeButtonHeight);
        System.out.println("Button Width is : " + submitSizeButtonWidth);
    }



}
