package testcases;

import common.AppiumDriver;
import functions.AccountFunction.ProfileFunction;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import functions.AccountFunction.Wallet.DepositFunction;
import functions.AccountFunction.Wallet.TransactionHistoryFunction;
import functions.AccountFunction.Wallet.WalletBalanceCheckerFunction;

public class WalletTest extends AppiumDriver {

    private AndroidDriver driver;
    private ProfileFunction profileFunction;
    private WalletBalanceCheckerFunction walletBalanceCheckerFunction;
    private DepositFunction depositFunction;
    private TransactionHistoryFunction transactionHistory;

    @BeforeClass
    public void setup() {
        driver = getDriver();
    }

//    public WalletTest (){
//        profileFunction = new ProfileFunction(driver);
//    }

    @Test(priority = 1)
    public void TC_CheckBalanceWallet() throws Exception {
        profileFunction = new ProfileFunction(driver);
        profileFunction.navigateToProfilePage();
        profileFunction.onToOffWalletEye();

        profileFunction.offToOnWalletEye();

        walletBalanceCheckerFunction = profileFunction.navigationToWallet();

        depositFunction = walletBalanceCheckerFunction.checkDeposit();
        depositFunction.checkDepositNullMessage("5000");
        depositFunction.checkMinimumDepositAmount("9999");
//        deposit.checkDepostEqual10("10000");
    }

    @Test(priority = 2)
    public void TC_CheckTransaction () throws InterruptedException {
        profileFunction = new ProfileFunction(driver);

        profileFunction.navigateToProfilePage();
        walletBalanceCheckerFunction = profileFunction.navigationToWallet();
        transactionHistory = walletBalanceCheckerFunction.navigationToTransactionHistory();

    }

}
