package functions.AccountFunction.Wallet;

import common.CommonPage;
import functions.AccountFunction.ProfileFunction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.AccountPage.Wallet.DepositPage;
import pages.AccountPage.Wallet.WalletBalanceCheckerPage;

public class DepositFunction {
    private AndroidDriver driver;
    private CommonPage commonPage;

    public DepositFunction(AndroidDriver driver) {
        this.driver = driver;
        commonPage = new CommonPage(driver);
    }
    DepositPage depositPage = new DepositPage();
    WalletBalanceCheckerPage walletBalanceCheckerPage = new WalletBalanceCheckerPage();

    public void depositMoney (String money) {
        commonPage.clickElement(depositPage.inputMoney);
        commonPage.setText(depositPage.inputMoney, money);
        commonPage.clickElement(depositPage.momoSource);
        commonPage.clickElement(depositPage.btnDeposit);
    }

    public void checkDepositNullMessage(String money) {
        commonPage.clickElement(depositPage.inputMoney);
        commonPage.setText(depositPage.inputMoney, money);
        commonPage.clearElement(depositPage.inputMoney);

        Assert.assertEquals(driver.findElement(depositPage.textIfNull).getAttribute("content-desc"), "Vui lòng không để trống số tiền" );
    }
    public void checkMinimumDepositAmount(String money) {
        commonPage.clickElement(depositPage.inputMoney);
        commonPage.setText(depositPage.inputMoney, money);

        Assert.assertEquals(driver.findElement(depositPage.textIfMinimum).getAttribute("content-desc"), "Số tiền nạp tối thiểu phải là 10,000 VNĐ" );

    }
//    Xác nhận xem nút Nạp tiền có enable không
    public void check_btnDeposit_Enable_Nomoney (boolean moneySource) {
//        commonPage.clickElement(depositPage.inputMoney);
//        commonPage.setText(depositPage.inputMoney, money);

        if (moneySource) {
            commonPage.clickElement(depositPage.momoSource);
        }

        // Kiểm tra xem nút "Nạp tiền" có được kích hoạt (enable) hay không khi nhập 10.000 VNĐ
        boolean isButtonEnabled = driver.findElement(depositPage.btnDeposit).isEnabled();

        // Log before asserting
        System.out.println("Button enabled status: " + isButtonEnabled);

        // Kiểm tra kết quả
        Assert.assertTrue(isButtonEnabled, "Nút 'Nạp tiền' chưa được kích hoạt.");
    }


    public void check_btnDeposit_Enable_inputMoney_noSource (String money) {
        commonPage.clickElement(depositPage.inputMoney);
        commonPage.setText(depositPage.inputMoney, money);

        // Kiểm tra xem nút "Nạp tiền" có được kích hoạt (enable) hay không khi nhập 10.000 VNĐ
        boolean isButtonEnabled = driver.findElement(depositPage.btnDeposit).isEnabled();

        // Log before asserting
        System.out.println("Button enabled status: " + isButtonEnabled);

        // Kiểm tra kết quả
        Assert.assertTrue(isButtonEnabled, "Nút 'Nạp tiền' chưa được kích hoạt.");
    }


    //Viết hàm so sánh số dư ví ở trang Ví và trang nạp tiền

    //Hàm back về trang profile
    public ProfileFunction returnToProfile() {
        commonPage.clickElement(depositPage.btnBack);
        commonPage.clickElement(walletBalanceCheckerPage.btnBack);
        return new ProfileFunction(driver);
    }

}
