package pages.AccountPage.Wallet;

import org.openqa.selenium.By;

public class WalletBalanceCheckerPage {
    public By btnDeposit = By.xpath ("//android.widget.ImageView[@content-desc=\"Nạp tiền\"]");
    public By btnWithdrawal = By.xpath ("//android.widget.ImageView[@content-desc=\"Rút tiền\"]");
    public By btnMargin = By.xpath ("//android.widget.ImageView[@content-desc=\"Ký quỹ\"]");
    public By btnBack = By.xpath("//android.view.View[@content-desc=\"Ví\"]");
    public By transactionHistory = By.xpath("//android.view.View[@content-desc=\"Lịch sử giao dịch\"]");
}
