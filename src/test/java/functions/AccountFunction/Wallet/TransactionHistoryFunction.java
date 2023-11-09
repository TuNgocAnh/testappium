package functions.AccountFunction.Wallet;

import common.CommonPage;
import functions.AccountFunction.ProfileFunction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.AccountPage.ProfilePage;
import pages.AccountPage.Wallet.TransactionHistoryPage;
import pages.AccountPage.Wallet.WalletBalanceCheckerPage;

import java.util.List;

public class TransactionHistoryFunction {

    private AndroidDriver driver;
    private CommonPage commonPage;

    public TransactionHistoryFunction(AndroidDriver driver) {
        this.driver = driver;
        commonPage = new CommonPage(driver);
    }

    TransactionHistoryPage transactionHistoryPage = new TransactionHistoryPage();
    WalletBalanceCheckerPage walletBalanceCheckerPage = new WalletBalanceCheckerPage();

    public void transHistory_All() {

        commonPage.verifyAttrContains(transactionHistoryPage.chooseTime, "content-desc", "Chọn thời gian", "Sai");

        // Tìm các phần tử theo XPath
        List<WebElement> elements = driver.findElements(transactionHistoryPage.transactionList);

        System.out.println(elements.size());

        // Kiểm tra danh sách phần tử
        if (elements.isEmpty()) {
            commonPage.verifyAttrContains(transactionHistoryPage.textNull, "content-desc", "Bạn vẫn chưa có đơn rút tiền nào", "Hiển thị sai text khi không có giao dịch");
            System.out.println("Danh sách giao dịch hiện đang trống");
        } else {

            //Viết hàm hiển thị toàn bộ danh sách giao dịch từ ngày gần nhất đến xa nhất
            //Hiện chưa nạp tiền được vào ví

            System.out.println("Danh sách hiện đang có là: " + elements.size() + "phần tử" + elements);
        }
    }

    public ChooseTimeInTransactionFunc navigateToChooseTime() {
        commonPage.clickElement(transactionHistoryPage.chooseTime);
        return new ChooseTimeInTransactionFunc(driver);
    }

    public ProfileFunction returnToProfile() {

        driver.findElement(transactionHistoryPage.btnBack).click();
        driver.findElement(walletBalanceCheckerPage.btnBack).click();
        return new ProfileFunction(driver);
    }

}


