package Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;


public class TestPage {

    public WebDriver driver;
    static String url = "https://swisnl.github.io/jQuery-contextMenu/demo.html?fbclid=IwAR1TGZZnl3hSwsNsHPlpqjOqjpaT35KVhD85Tq3iyzBi7qXLMO2YmLxAlIg";
    static String browser = "Chrome";
    @BeforeTest
    public void setup() {
        switch (browser) {
            case "Chrome":
                driver = WebDriverManager.chromedriver().create();
                break;
            case "Firefox":
                driver = WebDriverManager.firefoxdriver().create();
                break;

        }
        driver.navigate().to(url);

    }

    @AfterTest
    public void endSession() {
        driver.quit();
    }

    @BeforeMethod
    public void righClickBt() throws InterruptedException {
        WebElement bt = driver.findElement(By.xpath("//span[contains(text(), 'right click me')]"));
        Actions action = new Actions(driver);
        action.contextClick(bt).build().perform();
    }

    @Test
    public void edit() {
        WebElement edit = driver.findElement(By.xpath("//li[contains(@class, 'icon-edit')]"));
        edit.click();
        String popupTxt = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        Assert.assertEquals(popupTxt, "clicked: edit");

    }

    @Test
    public void cut() {
        WebElement cut = driver.findElement(By.xpath("//ul[@class='context-menu-list context-menu-root']//child::li//span[text()='Cut']"));
        cut.click();
        String popupTxt = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        Assert.assertEquals(popupTxt, "clicked: cut");

    }

    @Test
    public void copy() {
        WebElement copy = driver.findElement(By.xpath("//ul[@class='context-menu-list context-menu-root']//child::li//span[text()='Copy']"));
        copy.click();
        String popupTxt = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        Assert.assertEquals(popupTxt, "clicked: copy");

    }

    @Test
    public void paste() {
        WebElement paste = driver.findElement(By.xpath("//ul[@class='context-menu-list context-menu-root']//child::li//span[text()='Paste']"));
        paste.click();
        String popupTxt = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        Assert.assertEquals(popupTxt, "clicked: paste");

    }

    @Test
    public void delete() {
        WebElement delete = driver.findElement(By.xpath("//ul[@class='context-menu-list context-menu-root']//child::li//span[text()='Delete']"));
        delete.click();
        String popupTxt = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        Assert.assertEquals(popupTxt, "clicked: delete");

    }


}
