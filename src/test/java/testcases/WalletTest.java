package testcases;

import common.AppiumDriver;
import functions.AccountFunction.ProfileFunction;
import functions.AccountFunction.Wallet.ChooseTimeInTransactionFunc;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import functions.AccountFunction.Wallet.DepositFunction;
import functions.AccountFunction.Wallet.TransactionHistoryFunction;
import functions.AccountFunction.Wallet.WalletFunction;

public class WalletTest extends AppiumDriver {
    private AndroidDriver driver;
    private ProfileFunction profileFunction;
    private WalletFunction walletBalanceCheckerFunction;
    private DepositFunction depositFunction;
    private TransactionHistoryFunction transactionHistoryFunction;
    private ChooseTimeInTransactionFunc chooseTimeInTransactionFunc;

    @BeforeClass
    public void setup() {
        driver = getDriver();
    }


    @Test (priority =2)
    //Thợ truy cập vào ví từ màn hình profile
    public void TC_AccessWalletFromProfile () throws InterruptedException {
        profileFunction = new ProfileFunction(driver);
        profileFunction.navigateToProfilePage();
        walletBalanceCheckerFunction = profileFunction.navigationToWallet();
        walletBalanceCheckerFunction.returnToProfile();
    }
    @Test (priority =2)
    //Thợ xem tất cả lịch sử giao dịch
    public void TC_ViewsAllTransactionHistory () throws InterruptedException {
        walletBalanceCheckerFunction = profileFunction.navigationToWallet();
        transactionHistoryFunction = walletBalanceCheckerFunction.navigationToTransactionHistory();
        chooseTimeInTransactionFunc = transactionHistoryFunction.navigateToChooseTime();
        chooseTimeInTransactionFunc.transHistory_AllTime();
        transactionHistoryFunction.returnToProfile();
    }

    @Test(priority = 3)
    //Thợ xem lịch sử giao dịch trong 1 tháng
    public void TC_OneMonthTransaction() throws InterruptedException {

        walletBalanceCheckerFunction = profileFunction.navigationToWallet();
        transactionHistoryFunction = walletBalanceCheckerFunction.navigationToTransactionHistory();

        //Viết hàm lọc lại tất cả các giao dịch có ngày tháng phù hợp cho mỗi mốc thời gian

        chooseTimeInTransactionFunc = transactionHistoryFunction.navigateToChooseTime();
        chooseTimeInTransactionFunc.transHistory_OneMonth();
        transactionHistoryFunction.returnToProfile();
    }

    @Test(priority = 4)
    public void TC_CheckBalanceWallet() throws Exception {

        //Kiểm tra che/không che số dư bằng cách nhấn vào biểu tượng tắt/mở mắt
        profileFunction.onToOffWalletEye();
        profileFunction.offToOnWalletEye();

        walletBalanceCheckerFunction = profileFunction.navigationToWallet();

        // Kiểm tra text cảnh báo khi thợ không nạp tiền và nạp tiền dưới 10.000
        depositFunction = walletBalanceCheckerFunction.checkDeposit();
        depositFunction.checkDepositNullMessage("5000");
        depositFunction.checkMinimumDepositAmount("9999");
//        deposit.checkDepostEqual10("10000");
        profileFunction = depositFunction.returnToProfile();
    }

//    @Test(priority = 3)
//    public void TC_CheckAllTransaction() throws InterruptedException {
//
//        walletBalanceCheckerFunction = profileFunction.navigationToWallet();
//        transactionHistoryFunction = walletBalanceCheckerFunction.navigationToTransactionHistory();
//
//        transactionHistoryFunction.transHistory_All();
//        profileFunction = transactionHistoryFunction.returnToProfile();
//    }

    @Test(priority = 4)
    public void TC_OneMonthTransactionBefore() throws InterruptedException {

        walletBalanceCheckerFunction = profileFunction.navigationToWallet();
        transactionHistoryFunction = walletBalanceCheckerFunction.navigationToTransactionHistory();

        //Chọn thời gian xong rồi nhấn close
//        chooseTimeInTransactionFunc = transactionHistoryFunction.navigateToChooseTime();
//        chooseTimeInTransactionFunc.closetransHistory();

        //Viết hàm lọc lại tất cả các giao dịch có ngày tháng phù hợp cho mỗi mốc thời gian

        chooseTimeInTransactionFunc = transactionHistoryFunction.navigateToChooseTime();
        chooseTimeInTransactionFunc.transHistory_OneMonth();


//        chooseTimeInTransactionFunc = transactionHistoryFunction.navigateToChooseTime();
//        chooseTimeInTransactionFunc.transHistory_ThreeMonth();
//
//        chooseTimeInTransactionFunc = transactionHistoryFunction.navigateToChooseTime();
//        chooseTimeInTransactionFunc.transHistory_SixMonth();
//
//        chooseTimeInTransactionFunc = transactionHistoryFunction.navigateToChooseTime();
//        chooseTimeInTransactionFunc.transHistory_TimeOptions();
//
//        chooseTimeInTransactionFunc = transactionHistoryFunction.navigateToChooseTime();
//        chooseTimeInTransactionFunc.transHistory_AllTime();
    }

    @Test(priority = 1)
    public void TC_TimeOptionTransaction() throws InterruptedException {
        profileFunction = new ProfileFunction(driver);
        profileFunction.navigateToProfilePage();

        walletBalanceCheckerFunction = profileFunction.navigationToWallet();
        transactionHistoryFunction = walletBalanceCheckerFunction.navigationToTransactionHistory();

        chooseTimeInTransactionFunc = transactionHistoryFunction.navigateToChooseTime();
        chooseTimeInTransactionFunc.transHistory_TimeOptions(0.5,1,1,0.5);
//        transactionHistoryFunction.returnToProfile();
    }


}
