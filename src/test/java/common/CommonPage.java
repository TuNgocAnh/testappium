package common;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.time.Duration;

public class CommonPage {
    private AndroidDriver driver;

    public CommonPage(AndroidDriver driver) {
        this.driver = driver;
    }

    private int EXPLICIT_WAIT_TIMEOUT = 10;
    private int WAIT_PAGE_LEADED_TIMEOUT = 30;

    public WebElement getWebElement(By by) {
        return driver.findElement(by);
    }

    public void logConsole(String message) {
        System.out.println(message);
    }

    public void hoverOnElement(By by) {
        waitForElementVisible(by);
        Actions action = new Actions(driver);
        action.moveToElement(getWebElement(by));
        logConsole("Hover on element " + by);
    }

    public void clickElement(By by) {
        waitForElementVisible(by);
        getWebElement(by).click();
        logConsole("Click on element " + by);
    }

    public void setText(By by, String value) {
        waitForElementVisible(by);
        getWebElement(by).sendKeys(value);
        logConsole("Set text " + value + " on element " + by);
    }

    public String getTextElement(By by) {
        waitForElementVisible(by);
        logConsole("Get text of element " + by);
        logConsole("==> Text: " + getWebElement(by).getText());
        return getWebElement(by).getText();
    }

    public String getAttributeElement(By by, String attributeName) {
        waitForElementVisible(by);
        logConsole("Get attribute value of element " + by);
        logConsole("==> Attribute value: " + getWebElement(by).getAttribute(attributeName));
        return getWebElement(by).getAttribute(attributeName);
    }

    public void verifyElementTextContains(By by, String expectedText, String message) {
        Assert.assertTrue(getTextElement(by).contains(expectedText), message);
    }

    public String verifyAttrContains(By by, String attributeName, String expectedText, String message) {
        Assert.assertTrue(getAttributeElement(by, attributeName).contains(expectedText), message);

        waitForElementVisible(by);
        return getWebElement(by).getAttribute(attributeName);
    }


    public void scrollToElementWithJS(By by) {
        waitForElementPresent(by); // Đợi đến khi có phần tử tồn tại, khác với Visible là có trong UI

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", getWebElement(by));
        logConsole("Scroll to element " + by);
    }

    public WebElement scrollToAnElementByText(String text) {
        return driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"" + text + "\"));"));
    }

    public void testscroll(String text) {

    WebElement element = (WebElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + text + "\").instance(0))"));
        element.click();
}
    public void scrollToBottomOfPage(By by) {
//        String scrollToEnd = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollToEnd(4)";
//        driver.findElement(MobileBy.AndroidUIAutomator(scrollToEnd));

        String scrollToEnd = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollToEnd(1)";
        int maxScrollAttempts = 3;

        for (int i = 0; i < maxScrollAttempts; i++) {

            try {
                // Thực hiện cuộn trang
                Thread.sleep(5000);
                waitForElementPresent(by);
                waitForElementVisible(by);
                driver.findElement(MobileBy.AndroidUIAutomator(scrollToEnd));


            } catch (NoSuchElementException e) {
                break;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public void waitForElementVisible(By by, int second) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second), Duration.ofMillis(500));

        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitForElementVisible(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_TIMEOUT), Duration.ofMillis(500));

        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    public void waitForElementPresent(By by, int second) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));

        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitForElementPresent(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_TIMEOUT));

        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }



}
