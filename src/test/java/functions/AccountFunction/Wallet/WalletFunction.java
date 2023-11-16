package functions.AccountFunction.Wallet;

import common.CommonPage;
import functions.AccountFunction.ProfileFunction;
import io.appium.java_client.android.AndroidDriver;
import pages.AccountPage.Wallet.WalletBalanceCheckerPage;

public class WalletFunction {

    public WalletFunction(AndroidDriver driver) {
        this.driver = driver;
        commonPage = new CommonPage(driver);
    }
    private AndroidDriver driver;
    private CommonPage commonPage;
    WalletBalanceCheckerPage walletBalanceCheckerPage = new WalletBalanceCheckerPage();


    //Viết hàm nếu chưa KYC thì chưa thể làm được, hiển thị popup. còn nếu KYc rồi thì nhấn được
    //Hiện tại chưa có popup đó ở bản test

    public DepositFunction navigateToDeposit () {
        commonPage.clickElement(walletBalanceCheckerPage.btnDeposit);
        return new DepositFunction(driver);
    }

    public WithdrawalFunction navigateToWithdrawal () {
        commonPage.clickElement(walletBalanceCheckerPage.btnDeposit);
        return new WithdrawalFunction(driver);
    }

    public MarginFunction navigateToMargin () {
        commonPage.clickElement(walletBalanceCheckerPage.btnMargin);
        return new MarginFunction(driver);
    }


    public TransactionHistoryFunction navigationToTransactionHistory () {
        commonPage.clickElement(walletBalanceCheckerPage.transactionHistory);
        return new TransactionHistoryFunction(driver);
    }

    public ProfileFunction returnToProfile () {
        commonPage.clickElement(walletBalanceCheckerPage.btnBack);
        return new ProfileFunction(driver);
    }

}
