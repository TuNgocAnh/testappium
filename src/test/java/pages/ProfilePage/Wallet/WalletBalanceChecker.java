package pages.ProfilePage.Wallet;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class WalletBalanceChecker {
    private AndroidDriver driver;

    private By closeWallet = By.xpath("//android.view.View[contains(@content-desc, 'đ']/android.widget.Button");
    private By openWallet = By.xpath("//android.view.View[contains(@content-desc=\"*********\"]/android.widget.Button");



    public WalletBalanceChecker(AndroidDriver driver) {
        this.driver = driver;
    }

    public void openWalletEye () {
        driver.findElement(openWallet).click();
    }
    public void closeWalletEye () {
        driver.findElement(closeWallet).click();
    }
}
