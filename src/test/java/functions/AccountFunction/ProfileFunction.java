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
        commonPage.clickElement(profilePage.iconVuaTho);

        commonPage.waitForElementVisible(profilePage.getProfile);
        commonPage.clickElement(profilePage.getProfile);

    }
    public ServiceFunction navigationToGetServices () {
        commonPage.clickElement(profilePage.getServices);
        return new ServiceFunction(driver);
    }

    public void onToOffWalletEye () {
        commonPage.clickElement(profilePage.onToOffEye);
        Assert.assertEquals(driver.findElement(profilePage.contentOffEye).getAttribute("content-desc"), "*********");
    }

    public void offToOnWalletEye () {
        commonPage.clickElement(profilePage.offToOnEye);
        commonPage.verifyAttrContains(profilePage.contentOnEye,"content-desc","đ","Khi mở mắt ví không hiển thị số tiền");
    }

    public WalletFunction navigationToWallet () {
        commonPage.clickElement(profilePage.getWalletWhenOnEye);
        return new WalletFunction(driver);
    }
}
