package pages.ProfilePage.Services;

import common.TextManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.FindJobPage.FindJobPage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SearchServicePage {
    private AndroidDriver driver;

    public SearchServicePage(AndroidDriver driver) {
        this.driver = driver;
    }


    //input search Dịch vụ
    private final By inputsearchService = By.className("android.widget.EditText");
    private By requestServiceButton = By.xpath("//android.view.View[@content-desc=\"Yêu cầu dịch vụ\"]");

    public void searchCorrectService(String keyword) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(inputsearchService));

        // Nhập từ khoá tìm kiếm
        searchInput.click();
        searchInput.sendKeys(keyword);

        WebElement elements = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[contains(@content-desc, 'Chọn')]")));

        String actualResult = elements.getAttribute("content-desc");

        Assert.assertTrue(actualResult.toUpperCase().contains(keyword.toUpperCase()), "Kết quả tìm kiếm không khớp với từ khoá.");

        // Xóa nội dung trong ô tìm kiếm để chuẩn bị cho tìm kiếm tiếp theo
        searchInput.clear();
    }

    public void searchIncorrectService (String keyword) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(inputsearchService));

        searchInput.click();
        searchInput.sendKeys(keyword);

//        WebElement noResultsText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[contains(@content-desc, '" + TextManager.getNoResultsText() + "')]")));

        WebElement noResultsText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Hiện tại dịch vụ này chưa có, vui lòng yêu cầu dịch vụ này với chúng tôi để có thể đáp ứng công việc cho bạn một cách tốt nhất\"]")));

        Assert.assertEquals(noResultsText.getAttribute("content-desc"),TextManager.getNoResultsText());

        WebElement requestService = driver.findElement(requestServiceButton);
        Assert.assertEquals(requestService.getAttribute("content-desc"), "Yêu cầu dịch vụ");

        searchInput.clear();
        Thread.sleep(2000);
    }

    public FindJobPage returnToStart() {
        driver.findElement(By.xpath("//android.view.View[@content-desc=\"Tìm kiếm dịch vụ\"]")).click();
        driver.findElement(By.xpath("//android.view.View[@content-desc=\"Dịch vụ\"]")).click();
        driver.findElement(By.xpath("//android.view.View[@content-desc=\"Tìm việc\"]")).click();
        return new FindJobPage(driver);
    }
}
