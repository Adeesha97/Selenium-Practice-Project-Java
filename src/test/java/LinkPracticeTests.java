import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class LinkPracticeTests {

    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://leafground.com/link.xhtml;jsessionid=node0cr2xq3qt415115avxe8srtqtz3285357.node0");
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void linkTests1() {
        WebElement homeLink = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink.click();
        driver.navigate().back();
    }

    @Test
    public void linkTests2() {
        WebElement findUserLink = driver.findElement(By.partialLinkText("Find the URL"));
        String path = findUserLink.getAttribute("href");
        System.out.println("This link is going to - " + path);
        driver.navigate().back();
    }

    @Test
    public void linkTests3() {
//        driver.get("https://leafground.com/link.xhtml;jsessionid=node0cr2xq3qt415115avxe8srtqtz3285357.node0");
        WebElement homeLink1 = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink1.click();
        driver.navigate().back();
    }

    @Test
    public void linkTests4() {
        List<WebElement> linkCount = driver.findElements(By.tagName("a"));
        int pageLinkCount = linkCount.size();
        System.out.println("Count of full page links - " + pageLinkCount);
    }

    @Test
    public void linkTests5() {
        WebElement layoutElement = driver.findElement(By.className("layout-main-content"));
        List<WebElement> countOfLayoutLink = layoutElement.findElements(By.tagName("a"));
        System.out.println("Count of layout links - " + countOfLayoutLink);
    }

    @Test
    public void linkTests6() {
        WebElement brokenLink = driver.findElement(By.partialLinkText("Broken"));
        brokenLink.click();
        String linkTitle = driver.getTitle();
        if (linkTitle.contains("404")){
            System.out.println("The link is broken");
        }else {
            System.out.println("The link is not broken");
        }
        driver.navigate().back();
    }
}
