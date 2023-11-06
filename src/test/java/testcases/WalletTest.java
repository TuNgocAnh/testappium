package testcases;

import common.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ProfilePage.ProfilePage;
import pages.ProfilePage.Wallet.WalletBalanceChecker;

public class WalletTest extends AppiumDriver {

    private AndroidDriver driver;
    private ProfilePage profilePage;
    private WalletBalanceChecker walletBalanceChecker;

    @BeforeClass
    public void setup() {
        driver = getDriver();
    }

    @Test(priority = 1)

    public void TC_Wallet() throws Exception {

        profilePage = new ProfilePage(driver);

        profilePage.navigateToProfilePage();

        profilePage.closeWalletEye();

        profilePage.openWalletEye();

        walletBalanceChecker = profilePage.navigationToWallet();

        walletBalanceChecker.checkDeposit();
        walletBalanceChecker.checkDepositNullMessage("111");
    }

}
