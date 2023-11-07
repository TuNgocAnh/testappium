package functions.AccountFunction;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import functions.AccountFunction.ServicesFunction.ServiceFunction;
import functions.AccountFunction.Wallet.WalletBalanceCheckerFunction;
import pages.AccountPage.ProfilePage;

import java.time.Duration;

public class ProfileFunction {
    private AndroidDriver driver;
    public ProfileFunction(AndroidDriver driver) {
        this.driver = driver;
    }
    ProfilePage profilePage = new ProfilePage();

    public void navigateToProfilePage() throws InterruptedException {
        driver.findElement(profilePage.iconVuaTho).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Đợi tối đa 10 giây
        wait.until(ExpectedConditions.elementToBeClickable(profilePage.getProfile));
        driver.findElement(profilePage.getProfile).click();
    }
    public ServiceFunction navigationToGetServices () {
        driver.findElement(profilePage.getServices).click();
        return new ServiceFunction(driver);
    }

    public void onToOffWalletEye () {

        driver.findElement(profilePage.onToOffEye).click();

        Assert.assertEquals(driver.findElement(profilePage.contentOffEye).getAttribute("content-desc"), "*********");
    }

    public void offToOnWalletEye () {
        driver.findElement(profilePage.offToOnEye).click();

        Assert.assertTrue(driver.findElement(profilePage.contentOnEye).getAttribute("content-desc").contains("đ"), "Khi mở mắt ví không hiển thị số tiền");
    }

    public WalletBalanceCheckerFunction navigationToWallet () {
        driver.findElement(profilePage.getWalletWhenOnEye).click();
        return new WalletBalanceCheckerFunction(driver);
    }
}
