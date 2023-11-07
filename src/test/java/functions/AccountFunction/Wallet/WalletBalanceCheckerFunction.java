package functions.AccountFunction.Wallet;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AccountPage.Wallet.WalletBalanceCheckerPage;

import java.time.Duration;

public class WalletBalanceCheckerFunction {

    public WalletBalanceCheckerFunction(AndroidDriver driver) {
        this.driver = driver;
    }
    private AndroidDriver driver;
    WalletBalanceCheckerPage walletBalanceCheckerPage = new WalletBalanceCheckerPage();
    public DepositFunction checkDeposit () {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(walletBalanceCheckerPage.btnDeposit).click();
        return new DepositFunction(driver);
    }

    public TransactionHistoryFunction navigationToTransactionHistory () {
        driver.findElement(walletBalanceCheckerPage.transactionHistory).click();
        return new TransactionHistoryFunction(driver);
    }

}
