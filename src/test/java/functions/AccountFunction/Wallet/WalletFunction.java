package functions.AccountFunction.Wallet;

import functions.AccountFunction.ProfileFunction;
import io.appium.java_client.android.AndroidDriver;
import pages.AccountPage.Wallet.WalletBalanceCheckerPage;

public class WalletFunction {

    public WalletFunction(AndroidDriver driver) {
        this.driver = driver;
    }
    private AndroidDriver driver;
    WalletBalanceCheckerPage walletBalanceCheckerPage = new WalletBalanceCheckerPage();


    //Viết hàm nếu chưa KYC thì chưa thể làm được, hiển thị popup. còn nếu KYc rồi thì nhấn được
    //Hiện tại chưa có popup đó ở bản test

    public DepositFunction checkDeposit () {
        driver.findElement(walletBalanceCheckerPage.btnDeposit).click();
        return new DepositFunction(driver);
    }

    public WithdrawalFunction navigateToWithdrawal () {
        driver.findElement(walletBalanceCheckerPage.btnDeposit).click();
        return new WithdrawalFunction(driver);
    }

    public MarginFunction navigateToMargin () {
        driver.findElement(walletBalanceCheckerPage.btnMargin).click();
        return new MarginFunction(driver);
    }


    public TransactionHistoryFunction navigationToTransactionHistory () {
        driver.findElement(walletBalanceCheckerPage.transactionHistory).click();
        return new TransactionHistoryFunction(driver);
    }

    public ProfileFunction returnToProfile () {
        driver.findElement(walletBalanceCheckerPage.btnBack).click();
        return new ProfileFunction(driver);
    }

}
