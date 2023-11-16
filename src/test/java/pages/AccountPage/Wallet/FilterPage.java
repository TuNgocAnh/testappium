package pages.AccountPage.Wallet;

import org.openqa.selenium.By;

public class FilterPage {
    public By textFilter = By.xpath ("//android.view.View[@content-desc=\"Bộ lộc\"]");
    public By textForm = By.xpath ("//android.view.View[@content-desc=\"Hình thức\"]");
    public By textStatus = By.xpath ("//android.view.View[@content-desc=\"Trạng thái\"]");
    public By btnClose = By.xpath("//android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]");
    public By allForm = By.xpath ("(//android.view.View[@content-desc=\"Tất cả\"])[1]");
    public By deposit = By.xpath ("//android.view.View[@content-desc=\"Nạp tiền\"]");
    public By withdrwal = By.xpath ("//android.view.View[@content-desc=\"Rút tiền\"]");
    public By payment = By.xpath ("//android.view.View[@content-desc=\"Thanh toán\"]");
    public By receivePayment = By.xpath ("//android.view.View[@content-desc=\"Nhận thanh toán\"]");
    public By marginDeposit = By.xpath ("//android.view.View[@content-desc=\"Nạp tiền ký quỹ\"]");
    public By allStatus = By.xpath ("(//android.view.View[@content-desc=\"Tất cả\"])[2]");
    public By pending = By.xpath ("//android.view.View[@content-desc=\"Đang duyệt\"]");
    public By failure = By.xpath ("//android.view.View[@content-desc=\"Thất bại\"]");
    public By sucess = By.xpath ("//android.view.View[@content-desc=\"Thành công\"]");
    public By btnConfirm = By.xpath ("//android.view.View[@content-desc=\"Xác nhận\"]");
}
