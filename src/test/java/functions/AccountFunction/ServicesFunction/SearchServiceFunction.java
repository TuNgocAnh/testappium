package functions.AccountFunction.ServicesFunction;

import common.TextManager;
import functions.FindJobFunction.FindJobFunction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.AccountPage.ServicesPage.SearchServicePage;
import pages.AccountPage.ServicesPage.ServicePage;
import pages.FindJobPage.FindJobPage;

import java.time.Duration;

public class SearchServiceFunction {
    private AndroidDriver driver;

    public SearchServiceFunction(AndroidDriver driver) {
        this.driver = driver;
    }
    SearchServicePage searchServicePage = new SearchServicePage();
    ServicePage servicePage = new ServicePage();
    FindJobPage findJobPage = new FindJobPage();

    public void searchCorrectService(String keyword) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(searchServicePage.inputsearchService));

        // Nhập từ khoá tìm kiếm
        searchInput.click();
        searchInput.sendKeys(keyword);

        WebElement elements = wait.until(ExpectedConditions.visibilityOfElementLocated(searchServicePage.choiceBtn));

        String actualResult = elements.getAttribute("content-desc");

        Assert.assertTrue(actualResult.toUpperCase().contains(keyword.toUpperCase()), "Kết quả tìm kiếm không khớp với từ khoá.");

        searchInput.clear();
    }

    public void searchIncorrectService (String keyword) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(searchServicePage.inputsearchService));

        searchInput.click();
        searchInput.sendKeys(keyword);

        WebElement noResultsText = wait.until(ExpectedConditions.visibilityOfElementLocated(searchServicePage.msgnoService));

        Assert.assertEquals(noResultsText.getAttribute("content-desc"),TextManager.getNoResultsText());

        WebElement requestService = driver.findElement(searchServicePage.requestServiceButton);
        Assert.assertEquals(requestService.getAttribute("content-desc"), "Yêu cầu dịch vụ");

        searchInput.clear();
        Thread.sleep(2000);
    }

    public FindJobFunction returnToStart() {
        driver.findElement(searchServicePage.backSearchService).click();
        driver.findElement(servicePage.backService).click();
        driver.findElement(findJobPage.menuFindJob).click();
        return new FindJobFunction(driver);
    }
}
