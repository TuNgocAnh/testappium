package functions.AccountFunction.Wallet;

import common.CommonPage;
import functions.AccountFunction.ProfileFunction;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.collections.Lists;
import pages.AccountPage.Wallet.TransactionHistoryPage;
import pages.AccountPage.Wallet.WalletBalanceCheckerPage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class ChooseTimeInTransactionFunc {
    private AndroidDriver driver;
    private CommonPage commonPage;


    public ChooseTimeInTransactionFunc(AndroidDriver driver) {
        this.driver = driver;
        commonPage = new CommonPage(driver);
    }

    TransactionHistoryPage transactionHistoryPage = new TransactionHistoryPage();
    WalletBalanceCheckerPage walletBalanceCheckerPage = new WalletBalanceCheckerPage();


    public void closetransHistory() {
        commonPage.clickElement(transactionHistoryPage.btnClose);
    }

    public void transHistory_OneMonth() {
        commonPage.clickElement(transactionHistoryPage.oneMonth);
        commonPage.clickElement(transactionHistoryPage.btnConfirm);

        commonPage.sortByDateAndRange(transactionHistoryPage.transactionList,0.95,0.1625,2,30);

    }


    public void transHistory_ThreeMonth() {
        commonPage.clickElement(transactionHistoryPage.threeMonth);
        commonPage.clickElement(transactionHistoryPage.btnConfirm);
    }

    public void transHistory_SixMonth(boolean clickConfirmButton) {
        commonPage.clickElement(transactionHistoryPage.sixMonth);

        if (clickConfirmButton) {
            commonPage.clickElement(transactionHistoryPage.btnConfirm);
        }
    }

    public void transHistory_TimeOptions(boolean clickConfirmButton, boolean sortTransaction) throws InterruptedException {
        commonPage.clickElement(transactionHistoryPage.timeOptions);


        //Từ ngày 7/11/2023 đến ngày 8/11/2023
        commonPage.scrollVeriticalCalendar(By.xpath("//android.widget.SeekBar[@content-desc=\"7\"]"), 0.53125,0.57,3.6,30 );
        commonPage.scrollVeriticalCalendar(By.xpath("//android.widget.SeekBar[@content-desc=\"tháng 11\"]"), 0.57,0.53125,2,12);
//        commonPage.scrollVeriticalCalendar(By.xpath("//android.widget.SeekBar[@content-desc=\"2024\"]"),0.57 ,0.53125,1.5,20);

        commonPage.clickElement(By.xpath("//android.view.View[@index =8]"));

        commonPage.scrollVeriticalCalendar(By.xpath("//android.widget.SeekBar[@content-desc=\"8\"]"), 0.53125,0.57,3.6,30 );

        if (clickConfirmButton) {
            commonPage.clickElement(transactionHistoryPage.btnConfirm);
        }

        if (sortTransaction) {
            commonPage.sortByDateAndRange(transactionHistoryPage.transactionList, 0.97, 0.09375, 2, 1);
        }

    }



    public void transHistory_AllTime(boolean sortTransaction) {
        commonPage.clickElement(transactionHistoryPage.allTime);

        commonPage.clickElement(transactionHistoryPage.btnConfirm);

        if (sortTransaction) {
            commonPage.sortByDateAndRange(transactionHistoryPage.transactionList, 0.95, 0.1625, 2, 100);
        }
    }


    public ProfileFunction returnToProfile() {

        commonPage.clickElement(transactionHistoryPage.btnBack);
        commonPage.clickElement(walletBalanceCheckerPage.btnBack);
        return new ProfileFunction(driver);
    }

    public TransactionHistoryFunction returnToTransactionHistoryFunc() {
        commonPage.clickElement(transactionHistoryPage.btnClose);
        return new TransactionHistoryFunction(driver);
    }


}
