package pages.ProfilePage.Wallet;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Deposit {
    private AndroidDriver driver;

    public Deposit(AndroidDriver driver) {
        this.driver = driver;
    }
    private By inputMoney = By.xpath ("//android.widget.EditText");
    private By textIfNull = By.xpath ("//android.view.View[@content-desc=\"Vui lòng không để trống số tiền\"]");
    private By textIfMinimum = By.xpath("//android.view.View[@content-desc=\"Số tiền nạp tối thiểu phải là 10,000 VNĐ\"]");
    private By btnDeposit = By.xpath("(//android.view.View[@content-desc=\"Nạp tiền\"])[2]");


    public void checkDepositNullMessage(String money) {
        driver.findElement(inputMoney).click();
        driver.findElement(inputMoney).sendKeys(money);
        driver.findElement(inputMoney).clear();

        Assert.assertEquals(driver.findElement(textIfNull).getAttribute("content-desc"), "Vui lòng không để trống số tiền" );
    }
    public void checkMinimumDepositAmount(String money) {

        driver.findElement(inputMoney).sendKeys(money);
        Assert.assertEquals(driver.findElement(textIfMinimum).getAttribute("content-desc"), "Số tiền nạp tối thiểu phải là 10,000 VNĐ" );
    }
    //Apk chưa có tính năng enable này
//    public void checkDepostEqual10 (String money) {
//
//        driver.findElement(inputMoney).sendKeys(money);
//
//        // Kiểm tra xem nút "Nạp tiền" có được kích hoạt (enable) hay không
//        boolean isButtonEnabled = driver.findElement(btnDeposit).isEnabled();
//
//        // Kiểm tra kết quả
//        Assert.assertTrue(isButtonEnabled, "Nút 'Nạp tiền' phải được kích hoạt.");
//    }

    //Viết hàm so sánh số dư ví ở trang Ví và trang nạp tiền

    //Hàm chuyển qua màn hình Lịch sử giao dịch


}
