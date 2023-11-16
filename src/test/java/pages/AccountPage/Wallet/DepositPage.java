package pages.AccountPage.Wallet;

import org.openqa.selenium.By;

public class DepositPage {
    public By inputMoney = By.xpath ("//android.widget.EditText");
    public By textIfNull = By.xpath ("//android.view.View[@content-desc=\"Vui lòng không để trống số tiền\"]");
    public By textIfMinimum = By.xpath("//android.view.View[@content-desc=\"Số tiền nạp tối thiểu phải là 10,000 VNĐ\"]");
    public By btnDeposit = By.xpath("(//android.view.View[@content-desc=\"Nạp tiền\"])[2]");
    public By btnBack = By.xpath("(//android.view.View[@content-desc=\"Nạp tiền\"])[1]");
    public By momoSource = By.xpath("//android.widget.ImageView[@content-desc=\"Momo\"]");

}
