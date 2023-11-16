package testcases;

import common.AppiumDriver;
import functions.AccountFunction.ProfileFunction;
import functions.AccountFunction.Wallet.*;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WalletTest extends AppiumDriver {
    private AndroidDriver driver;
    private ProfileFunction profileFunction;
    private WalletFunction walletBalanceCheckerFunction;
    private DepositFunction depositFunction;
    private TransactionHistoryFunction transactionHistoryFunction;
    private ChooseTimeInTransactionFunc chooseTimeInTransactionFunc;
    private FilterFunction filterFunction;

    @BeforeClass
    public void setup() {
        driver = getDriver();
    }


    @Test(priority = 1)
    // V1 Thợ truy cập vào ví từ màn hình profile
    public void TC_AccessWalletFromProfile() throws InterruptedException {
        profileFunction = new ProfileFunction(driver);
        profileFunction.navigateToProfilePage();
        walletBalanceCheckerFunction = profileFunction.navigationToWallet();
        walletBalanceCheckerFunction.returnToProfile();
    }

    @Test(priority = 2)
    // V2 Thợ xem tất cả lịch sử giao dịch
    public void TC_ViewsAllTransactionHistory() throws InterruptedException {
        walletBalanceCheckerFunction = profileFunction.navigationToWallet();
        transactionHistoryFunction = walletBalanceCheckerFunction.navigationToTransactionHistory();
        chooseTimeInTransactionFunc = transactionHistoryFunction.navigateToChooseTime();
        chooseTimeInTransactionFunc.transHistory_AllTime(true);
        transactionHistoryFunction.returnToProfile();
    }

    @Test(priority = 3)
    // V3 Thợ xem lịch sử giao dịch trong 1 tháng --> check sắp xếp theo ngày
    public void TC_OneMonthTransaction() throws InterruptedException {

        walletBalanceCheckerFunction = profileFunction.navigationToWallet();
        transactionHistoryFunction = walletBalanceCheckerFunction.navigationToTransactionHistory();

        chooseTimeInTransactionFunc = transactionHistoryFunction.navigateToChooseTime();
        chooseTimeInTransactionFunc.transHistory_OneMonth();
        profileFunction = transactionHistoryFunction.returnToProfile();
    }

    @Test(priority = 4)
    // V4 Thợ chọn thời gian 3 tháng (không lọc ngày), đổi lại thành tất cả
    public void TC_ChooseTimeChangeAll() throws InterruptedException {

        walletBalanceCheckerFunction = profileFunction.navigationToWallet();
        transactionHistoryFunction = walletBalanceCheckerFunction.navigationToTransactionHistory();
        chooseTimeInTransactionFunc = transactionHistoryFunction.navigateToChooseTime();
        chooseTimeInTransactionFunc.transHistory_ThreeMonth();

        chooseTimeInTransactionFunc.transHistory_AllTime(false);
        profileFunction = transactionHistoryFunction.returnToProfile();
    }

    @Test(priority = 5)
    // V5 Thợ Chọn thời gian cụ thể, OK --> Check sắp xếp theo ngày
    public void TC_TimeOptionTransaction() throws InterruptedException {

        walletBalanceCheckerFunction = profileFunction.navigationToWallet();
        transactionHistoryFunction = walletBalanceCheckerFunction.navigationToTransactionHistory();

        chooseTimeInTransactionFunc = transactionHistoryFunction.navigateToChooseTime();
        chooseTimeInTransactionFunc.transHistory_TimeOptions(true, true);
        profileFunction = transactionHistoryFunction.returnToProfile();
    }

    @Test(priority = 6)
    // V6 Thợ chọn thời gian cụ thể, Close
    public void TC_TimeOptionTransactionAndCancel() throws InterruptedException {

        walletBalanceCheckerFunction = profileFunction.navigationToWallet();
        transactionHistoryFunction = walletBalanceCheckerFunction.navigationToTransactionHistory();

        chooseTimeInTransactionFunc = transactionHistoryFunction.navigateToChooseTime();
        chooseTimeInTransactionFunc.transHistory_TimeOptions(false, false);

        chooseTimeInTransactionFunc.closetransHistory();

        profileFunction = transactionHistoryFunction.returnToProfile();
    }

    @Test(priority = 7)
    // V7 Hiển thị chọn sẵn button tất cả - Close - back về trang lịch sử giao dịch
    public void TC_ChooseTimeAndCancel() {

        walletBalanceCheckerFunction = profileFunction.navigationToWallet();
        transactionHistoryFunction = walletBalanceCheckerFunction.navigationToTransactionHistory();

        chooseTimeInTransactionFunc = transactionHistoryFunction.navigateToChooseTime();
        chooseTimeInTransactionFunc.closetransHistory();
        profileFunction = transactionHistoryFunction.returnToProfile();
    }

    @Test(priority = 8)
    // V8 Chọn thời gian có sẵn - 6 tháng (1,3,6 tháng) - Close - back về trang lịch sử giao dịch
    public void TC_ChooseAvailableTimeAndCancel() throws InterruptedException {

        walletBalanceCheckerFunction = profileFunction.navigationToWallet();
        transactionHistoryFunction = walletBalanceCheckerFunction.navigationToTransactionHistory();

        chooseTimeInTransactionFunc = transactionHistoryFunction.navigateToChooseTime();
        chooseTimeInTransactionFunc.transHistory_SixMonth(false);
        chooseTimeInTransactionFunc.closetransHistory();
        profileFunction = transactionHistoryFunction.returnToProfile();
    }

    //V9

    @Test(priority = 10)
    //V10 Thợ xem tất cả lịch sử giao dịch - Lọc, Nạp tiền
    public void TC_DepositFilter() throws InterruptedException {

        walletBalanceCheckerFunction = profileFunction.navigationToWallet();
        transactionHistoryFunction = walletBalanceCheckerFunction.navigationToTransactionHistory();
        filterFunction = transactionHistoryFunction.navigateToFilter();
        filterFunction.depositForm(true, true);
        profileFunction = transactionHistoryFunction.returnToProfile();
    }

    @Test(priority = 11)
    // V11 Thợ xem tất cả lịch sử giao dịch - Lọc, Rút tiền
    public void TC_WithdrawalFilter() throws InterruptedException {

        walletBalanceCheckerFunction = profileFunction.navigationToWallet();
        transactionHistoryFunction = walletBalanceCheckerFunction.navigationToTransactionHistory();
        filterFunction = transactionHistoryFunction.navigateToFilter();
        filterFunction.withdrawalForm(true, true);
        profileFunction = transactionHistoryFunction.returnToProfile();
    }

    @Test(priority = 12)
    // V12 Thợ xem tất cả lịch sử giao dịch - Lọc, Nạp tiền, Close
    public void TC_DepositFilterAndCancel() throws InterruptedException {

        walletBalanceCheckerFunction = profileFunction.navigationToWallet();
        transactionHistoryFunction = walletBalanceCheckerFunction.navigationToTransactionHistory();
        filterFunction = transactionHistoryFunction.navigateToFilter();

        filterFunction.depositForm(false, false);
        filterFunction.closeFilter();

        profileFunction = transactionHistoryFunction.returnToProfile();
    }

    @Test(priority = 13)
    // V12 Thợ xem tất cả lịch sử giao dịch - Lọc, Rút tiền, Close
    public void TC_WithdrawalFilterAndCancel() throws InterruptedException {

        walletBalanceCheckerFunction = profileFunction.navigationToWallet();
        transactionHistoryFunction = walletBalanceCheckerFunction.navigationToTransactionHistory();
        filterFunction = transactionHistoryFunction.navigateToFilter();

        filterFunction.withdrawalForm(false, false);
        filterFunction.closeFilter();

        profileFunction = transactionHistoryFunction.returnToProfile();
    }

    @Test(priority = 14)
    // V14 Thợ lọc trạng thái Thất bại, Xác nhận
    public void TC_FailFilter() throws InterruptedException {

        walletBalanceCheckerFunction = profileFunction.navigationToWallet();
        transactionHistoryFunction = walletBalanceCheckerFunction.navigationToTransactionHistory();
        filterFunction = transactionHistoryFunction.navigateToFilter();

        //**Đang làm , phần lọc chưa ổn, còn lặp lại quá nhiều
        filterFunction.failFilterSatus(true, true);

        profileFunction = transactionHistoryFunction.returnToProfile();
    }

    @Test(priority = 15)
    // V15 Thợ lọc trạng thái Thành công, Xác nhận
    public void TC_SucessFilter() throws InterruptedException {

        walletBalanceCheckerFunction = profileFunction.navigationToWallet();
        transactionHistoryFunction = walletBalanceCheckerFunction.navigationToTransactionHistory();
        filterFunction = transactionHistoryFunction.navigateToFilter();

        filterFunction.sucessFilterSatus(true, true);

        profileFunction = transactionHistoryFunction.returnToProfile();
    }

    @Test(priority = 16)
    // V16 Thợ lọc trạng thái Thất bại, Close
    public void TC_FailFilterAndClose() throws InterruptedException {

        walletBalanceCheckerFunction = profileFunction.navigationToWallet();
        transactionHistoryFunction = walletBalanceCheckerFunction.navigationToTransactionHistory();
        filterFunction = transactionHistoryFunction.navigateToFilter();

        filterFunction.failFilterSatus(false, false);

        filterFunction.closeFilter();

        profileFunction = transactionHistoryFunction.returnToProfile();
    }

    @Test(priority = 17)
    // V17 Thợ lọc trạng thái Thành công, Close
    public void TC_SucessFilterAndClose() throws InterruptedException {

        walletBalanceCheckerFunction = profileFunction.navigationToWallet();
        transactionHistoryFunction = walletBalanceCheckerFunction.navigationToTransactionHistory();
        filterFunction = transactionHistoryFunction.navigateToFilter();

        filterFunction.sucessFilterSatus(false, false);

        filterFunction.closeFilter();

        profileFunction = transactionHistoryFunction.returnToProfile();
    }

    @Test(priority = 18)
    //V18 Thợ nạp tiền vào ví - để trống hoặc dưới 10.000 VNĐ + Kiểm tra che/không che số dư bằng cách nhấn vào biểu tượng tắt/mở mắt
    public void TC_CheckBalanceWallet() throws Exception {

        //Kiểm tra che/không che số dư bằng cách nhấn vào biểu tượng tắt/mở mắt
        profileFunction.onToOffWalletEye();
        profileFunction.offToOnWalletEye();

        walletBalanceCheckerFunction = profileFunction.navigationToWallet();

        // Kiểm tra text cảnh báo khi thợ không nạp tiền và nạp tiền dưới 10.000
        depositFunction = walletBalanceCheckerFunction.navigateToDeposit();
        depositFunction.checkDepositNullMessage("5000");

        depositFunction.checkMinimumDepositAmount("9999");

//        depositFunction.check_btnDeposit_Enable("10000");

        profileFunction = depositFunction.returnToProfile();
    }

    @Test(priority = 19)
    //V19 Thợ nạp tiền vào ví - thành công
    public void TC_DepositWalletSucess() throws Exception {

        walletBalanceCheckerFunction = profileFunction.navigationToWallet();
        depositFunction = walletBalanceCheckerFunction.navigateToDeposit();
        depositFunction.depositMoney("10000");
        profileFunction = depositFunction.returnToProfile();

    }

    @Test(priority = 20)
    //V20 Thợ nạp tiền vào ví - không nhập số tiền, không chọn nguồn nạp, click nạp tiền --> Nút nạp tiền disable
    public void TC_DepositWalletFail_noMoney_noSource() throws Exception {

        walletBalanceCheckerFunction = profileFunction.navigationToWallet();
        depositFunction = walletBalanceCheckerFunction.navigateToDeposit();

        depositFunction.check_btnDeposit_Enable_Nomoney(false);

        profileFunction = depositFunction.returnToProfile();
    }

    @Test(priority = 21)
    //V21 Thợ nạp tiền vào ví - không nhập số tiền, chọn nguồn nạp, click nạp tiền --> Nút nạp tiền disable
    public void TC_DepositWalletFail_noMoney_MomoSource() throws Exception {

        walletBalanceCheckerFunction = profileFunction.navigationToWallet();
        depositFunction = walletBalanceCheckerFunction.navigateToDeposit();

        depositFunction.check_btnDeposit_Enable_Nomoney(true);

        profileFunction = depositFunction.returnToProfile();
    }

    @Test(priority = 21)
    //V22 Thợ nạp tiền vào ví - Nhập số tiền, không chọn nguồn nạp, click nạp tiền --> Nút nạp tiền disable
    public void TC_DepositWalletFail_inputMoney_noSource() throws Exception {

        walletBalanceCheckerFunction = profileFunction.navigationToWallet();
        depositFunction = walletBalanceCheckerFunction.navigateToDeposit();
        depositFunction.check_btnDeposit_Enable_inputMoney_noSource("11111");

        profileFunction = depositFunction.returnToProfile();
    }


}
