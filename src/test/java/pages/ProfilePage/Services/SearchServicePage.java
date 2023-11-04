package pages.ProfilePage.Services;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
//    private By elements =By.xpath("//android.view.View[contains(@content-desc, 'Sửa chữa nhà')]");

    public void searchService(String keyword) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(inputsearchService));

        // Nhập từ khoá tìm kiếm
        searchInput.click();
        searchInput.sendKeys(keyword);

        Thread.sleep(5000);


        WebElement elements = driver.findElement(By.xpath("//android.view.View[contains(@content-desc, 'Sửa chữa nhà')]"));
        String actualResult = elements.getAttribute("content-desc");
        System.out.println(actualResult);

        Assert.assertTrue(actualResult.toUpperCase().contains(keyword.toUpperCase()), "Kết quả tìm kiếm không khớp với từ khoá.");
    }
}
