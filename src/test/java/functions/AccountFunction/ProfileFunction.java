package functions.AccountFunction;

import common.CommonPage;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import functions.AccountFunction.ServicesFunction.ServiceFunction;
import functions.AccountFunction.Wallet.WalletFunction;
import pages.AccountPage.ProfilePage;

public class ProfileFunction {
    private AndroidDriver driver;
    private CommonPage commonPage;
    public ProfileFunction(AndroidDriver driver) {
        this.driver = driver;
        commonPage = new CommonPage(driver);
    }
    ProfilePage profilePage = new ProfilePage();

    public void navigateToProfilePage() throws InterruptedException {
        driver.findElement(profilePage.iconVuaTho).click();

        commonPage.waitForElementVisible(profilePage.getProfile);

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
        commonPage.verifyAttrContains(profilePage.contentOnEye,"content-desc","đ","Khi mở mắt ví không hiển thị số tiền");
    }

    public WalletFunction navigationToWallet () {
        driver.findElement(profilePage.getWalletWhenOnEye).click();
        return new WalletFunction(driver);
    }
}
