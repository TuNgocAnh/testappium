package pages.ProfilePage;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ProfilePage.Services.Service;
import pages.ProfilePage.Wallet.WalletBalanceChecker;

import java.time.Duration;

public class ProfilePage {
    private AndroidDriver driver;
    public ProfilePage(AndroidDriver driver) {
        this.driver = driver;
    }
    private By getServices = By.xpath("//android.view.View[@content-desc=\"Kiểm tra chất lượng\"]");
    private By iconVuaTho = By.xpath("//android.widget.TextView[@content-desc=\"Vua Thợ\"]");
    private By getProfile = By.xpath("//android.view.View[@content-desc=\"Tài khoản\"]");
    private By getWalletWhenOpenEye = By.xpath("//android.view.View[contains(@content-desc, 'đ')]");
    private By getWalletWhenCloseEye = By.xpath("//android.view.View[@content-desc=\"*********\"]");

    private By closeWallet = By.xpath("//android.view.View[contains(@content-desc, 'đ')]/android.widget.Button");
    private By openWallet = By.xpath("//android.view.View[contains(@content-desc=\"*********\"]/android.widget.Button");


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

    public WalletBalanceChecker navigationToWallet () {
        driver.findElement(getWalletWhenCloseEye).click();
        return new WalletBalanceChecker(driver);
    }

    public void openWalletEye () {
        driver.findElement(openWallet).click();
    }
    public void closeWalletEye () {
        driver.findElement(closeWallet).click();
    }
}
