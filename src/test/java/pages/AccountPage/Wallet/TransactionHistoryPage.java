package pages.AccountPage.Wallet;

import org.openqa.selenium.By;

public class TransactionHistoryPage {

    public By btnBack = By.xpath("//android.view.View[@content-desc=\"Lịch sử giao dịch\"]");
    public By transactionList = By.className("android.widget.ImageView");
    public By textNull = By.xpath("//android.view.View[@content-desc=\"Bạn vẫn chưa có đơn rút tiền nào\"]");
    public By chooseTime = By.xpath("//android.view.View[@content-desc=\"Chọn thời gian\"]");
    public By allTime = By.xpath("//android.view.View[@content-desc=\"Tất cả\"]");
    public By oneMonth = By.xpath("//android.view.View[@content-desc=\"1 tháng\"]");
    public By threeMonth = By.xpath("//android.view.View[@content-desc=\"3 tháng\"]");
    public By sixMonth = By.xpath("//android.view.View[@content-desc=\"6 tháng\"]");
    public By timeOptions = By.xpath("//android.view.View[@content-desc=\"Chọn thời gian cụ thể\"]");
    public By specificTime = By.className("android.widget.SeekBar");
    public By btnConfirm = By.xpath("//android.view.View[@content-desc=\"Xác nhận\"]");
    public By btnClose = By.xpath("//android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]");
}
