package functions.AccountFunction.Wallet;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.AccountPage.Wallet.DepositPage;

public class DepositFunction {
    private AndroidDriver driver;

    public DepositFunction(AndroidDriver driver) {
        this.driver = driver;
    }
    DepositPage depositPage = new DepositPage();

    public void checkDepositNullMessage(String money) {
        driver.findElement(depositPage.inputMoney).click();
        driver.findElement(depositPage.inputMoney).sendKeys(money);
        driver.findElement(depositPage.inputMoney).clear();

        Assert.assertEquals(driver.findElement(depositPage.textIfNull).getAttribute("content-desc"), "Vui lòng không để trống số tiền" );
    }
    public void checkMinimumDepositAmount(String money) {

        driver.findElement(depositPage.inputMoney).sendKeys(money);
        Assert.assertEquals(driver.findElement(depositPage.textIfMinimum).getAttribute("content-desc"), "Số tiền nạp tối thiểu phải là 10,000 VNĐ" );
    }
    //Apk chưa có tính năng enable này
//    public void checkDepostEqual10 (String money) {
//
//        driver.findElement(depositPage.inputMoney).sendKeys(money);
//
//        // Kiểm tra xem nút "Nạp tiền" có được kích hoạt (enable) hay không
//        boolean isButtonEnabled = driver.findElement(depositPage.btnDeposit).isEnabled();
//
//        // Kiểm tra kết quả
//        Assert.assertTrue(isButtonEnabled, "Nút 'Nạp tiền' phải được kích hoạt.");
//    }

    //Viết hàm so sánh số dư ví ở trang Ví và trang nạp tiền

    //Hàm chuyển qua màn hình Lịch sử giao dịch


}
