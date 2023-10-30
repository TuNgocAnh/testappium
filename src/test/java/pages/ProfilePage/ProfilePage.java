package pages.ProfilePage;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ProfilePage.Services.Service;

import java.time.Duration;

public class ProfilePage {
    private AndroidDriver driver;
    public ProfilePage(AndroidDriver driver) {
        this.driver = driver;
    }
    private By getServices = By.xpath("//android.view.View[@content-desc=\"Dịch vụ\"]");
    private By iconVuaTho = By.xpath("//android.widget.TextView[@content-desc=\"Vua Thợ\"]");
    private By getProfile = By.xpath("//android.view.View[@content-desc=\"Tài khoản\"]");


    public void navigateToProfilePage() throws InterruptedException {
        driver.findElement(iconVuaTho).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Đợi tối đa 10 giây
        wait.until(ExpectedConditions.elementToBeClickable(getProfile));
        driver.findElement(getProfile).click();
    }
    public Service navigationToGetServices () {
        driver.findElement(getServices).click();
        return new Service(driver);
    }
}
