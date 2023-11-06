package testcases;

import common.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ProfilePage.ProfilePage;
import pages.ProfilePage.Wallet.Deposit;
import pages.ProfilePage.Wallet.TransactionHistory;
import pages.ProfilePage.Wallet.WalletBalanceChecker;

public class WalletTest extends AppiumDriver {

    private AndroidDriver driver;
    private ProfilePage profilePage;
    private WalletBalanceChecker walletBalanceChecker;
    private Deposit deposit;
    private TransactionHistory transactionHistory;

    @BeforeClass
    public void setup() {
        driver = getDriver();
    }

    @Test(priority = 1)
    public void TC_CheckBalanceWallet() throws Exception {
        profilePage = new ProfilePage(driver);
        profilePage.navigateToProfilePage();
        profilePage.closeWalletEye();

        profilePage.openWalletEye();

        walletBalanceChecker = profilePage.navigationToWallet();

        deposit = walletBalanceChecker.checkDeposit();
        deposit.checkDepositNullMessage("5000");
        deposit.checkMinimumDepositAmount("9999");
//        deposit.checkDepostEqual10("10000");
    }

    @Test(priority = 2)
    public void TC_CheckTransaction () throws InterruptedException {
        profilePage = new ProfilePage(driver);

        profilePage.navigateToProfilePage();
        walletBalanceChecker = profilePage.navigationToWallet();
        transactionHistory = walletBalanceChecker.navigationToTransactionHistory();

    }

}
