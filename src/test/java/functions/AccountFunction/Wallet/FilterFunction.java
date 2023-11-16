package functions.AccountFunction.Wallet;

import common.CommonPage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.AccountPage.Wallet.FilterPage;
import pages.AccountPage.Wallet.TransactionHistoryPage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FilterFunction {
    private AndroidDriver driver;
    private CommonPage commonPage;

    public FilterFunction(AndroidDriver driver) {
        this.driver = driver;
        commonPage = new CommonPage(driver);
    }

    FilterPage filterPage = new FilterPage();
    TransactionHistoryPage transactionHistoryPage = new TransactionHistoryPage();


    public void depositForm (boolean clickConfirmButton, boolean sortTransaction) {
        commonPage.clickElement(filterPage.deposit);

        if (clickConfirmButton) {
            commonPage.clickElement(filterPage.btnConfirm);
        }

        if (sortTransaction) {
            commonPage.WalletForm(0.95, 0.1625, 2,transactionHistoryPage.transactionList, "Nạp tiền vào MOMO",0, "Bạn vẫn chưa có đơn nạp tiền nào",
                    "Danh sách hiển thị đúng là nạp tiền", "Danh sách hiển thị sai danh sách nạp tiền");
        }
    }
    public void withdrawalForm (boolean clickConfirmButton, boolean sortTransaction) {
        commonPage.clickElement(filterPage.withdrwal);

        if (clickConfirmButton) {
            commonPage.clickElement(filterPage.btnConfirm);
        }

        if (sortTransaction) {
            commonPage.WalletForm(0.95, 0.1625, 2,transactionHistoryPage.transactionList, "Rút tiền từ Ví", 0,"Bạn vẫn chưa có đơn rút tiền nào",
                    "Danh sách hiển thị đúng là rút tiền", "Danh sách hiển thị sai danh sách rút tiền");
        }
    }

    public void sucessFilterSatus (boolean clickConfirmButton, boolean sortTransaction) {
        commonPage.clickElement(filterPage.sucess);

        if (clickConfirmButton) {
            commonPage.clickElement(filterPage.btnConfirm);
        }

        if (sortTransaction) {
            commonPage.WalletForm(0.95, 0.1625, 2,transactionHistoryPage.transactionList, "Thành công",3, "Bạn vẫn chưa có đơn rút tiền nào",
                    "Danh sách hiển thị đúng là trạng thái thành công", "Danh sách hiển thị sai trạng thái - Thành công");
        }
    }



    public void closeFilter () {
        commonPage.clickElement(filterPage.btnClose);
    }

    public void failFilterSatus (boolean clickConfirmButton, boolean sortTransaction) {
        commonPage.clickElement(filterPage.failure);

        if (clickConfirmButton) {
            commonPage.clickElement(filterPage.btnConfirm);
        }

        if (sortTransaction) {
            commonPage.WalletForm(0.95, 0.1625, 2,transactionHistoryPage.transactionList, "Thất bại",3, "Bạn vẫn chưa có đơn rút tiền nào",
                    "Danh sách hiển thị đúng là trạng thái thất bại", "Danh sách hiển thị sai trạng thái - Thất bại");
        }
    }


}
