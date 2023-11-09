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
import org.testng.collections.Lists;
import pages.AccountPage.Wallet.TransactionHistoryPage;
import pages.AccountPage.Wallet.WalletBalanceCheckerPage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

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
        commonPage.clickElement(transactionHistoryPage.oneMonth);
        commonPage.clickElement(transactionHistoryPage.btnClose);
    }


    //        List<WebElement> elements = driver.findElements(transactionHistoryPage.transactionList);
//        commonPage.waitForElementVisible(transactionHistoryPage.transactionList);
//        commonPage.scrollToBottomOfPage();
//        System.out.println(elements.size());
    public void transHistory_OneMonth() {
        commonPage.clickElement(transactionHistoryPage.oneMonth);
        commonPage.clickElement(transactionHistoryPage.btnConfirm);

        String scrollToEnd = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollToEnd(1)";

        int maxScrollAttempts = 10;

        for (int i2 = 0; i2 < maxScrollAttempts; i2++) {

            List<WebElement> elements = driver.findElements(transactionHistoryPage.transactionList);

            int elementCount = 0;

            for (WebElement element : elements) {
                // Kiểm tra nếu phần tử hiển thị (có thể sử dụng phương thức isDisplayed())
                if (element.isDisplayed()) {
                    elementCount++;
                }
            }

            System.out.println("Số phần tử hiển thị: " + elementCount);

            List<String> dates = new ArrayList<>();

            for (WebElement element : elements) {
                String contentDesc = element.getAttribute("content-desc");

                //Xóa bớt số cho đỡ rối
//                System.out.println(contentDesc);

                String date = contentDesc.split("\n")[1]; // Lấy phần ngày từ chuỗi
                dates.add(date);
                System.out.println("Ngày: " + dates);
            }

            boolean isSorted = true;

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

            for (int i = 1; i < dates.size(); i++) {
                try {
                    Date date1 = dateFormat.parse(dates.get(i - 1));
                    Date date2 = dateFormat.parse(dates.get(i));

                    if (date1.compareTo(date2) < 0) {
                        isSorted = false;
                        break;


                    }
                } catch (ParseException e) {
                    // Xử lý lỗi khi không thể chuyển đổi ngày từ chuỗi
                    System.out.println("Lỗi chuyển đổi ngày: " + e.getMessage());
                }
            }

            if (isSorted) {
                System.out.println("Danh sách đã sắp xếp giảm dần theo ngày.");
            } else {
                System.out.println("Danh sách không sắp xếp giảm dần theo ngày.");
            }

            //Kiểm tra xem có lịch sử nào vượt quá 1 tháng không
//            if (areFirstAndLastDatesWithin30Days(dates)) {
//                System.out.println("Ngày đầu và cuối nằm trong phạm vi 30 ngày.");
//            } else {
//                System.out.println("Ngày đầu hoặc cuối vượt quá 30 ngày.");
//            }

            try {
                // Thực hiện cuộn trang
                commonPage.waitForElementPresent(transactionHistoryPage.transactionList);
                commonPage.waitForElementVisible(transactionHistoryPage.transactionList);
                driver.findElement(MobileBy.AndroidUIAutomator(scrollToEnd));

            } catch (NoSuchElementException e) {
                break;
            }
        }
    }

//    public boolean areFirstAndLastDatesWithin30Days(List<String> dates) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//
//        try {
//            Date firstDate = dateFormat.parse(dates.get(0));
//            Date lastDate = dateFormat.parse(dates.get(dates.size() - 1));
//
//            return lastDate;
//        } catch (ParseException e) {
//            // Xử lý lỗi khi không thể chuyển đổi ngày từ chuỗi
//            System.out.println("Lỗi chuyển đổi ngày: " + e.getMessage());
//            return false;
//        }
//    }


    public void transHistory_ThreeMonth() {
        commonPage.clickElement(transactionHistoryPage.threeMonth);
        commonPage.clickElement(transactionHistoryPage.btnConfirm);
    }

    public void transHistory_SixMonth() {
        commonPage.clickElement(transactionHistoryPage.sixMonth);
        commonPage.clickElement(transactionHistoryPage.btnConfirm);
    }

    public void transHistory_TimeOptions(double start_xd, double start_yd, double end_xd, double end_yd) throws InterruptedException {
        commonPage.clickElement(transactionHistoryPage.timeOptions);


//    driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"android.widget.SeekBar\").scrollable(true)).scrollIntoView(new UiSelector().text(\"tháng 1\"))"));
//    driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().driver.findElement(By.className(\"android.widget.SeekBar\")).scrollable(true)).scrollIntoView(new UiSelector().text(\"tháng 1\"))"));
//    driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().driver.findElement(By.xpath(\"//android.widget.SeekBar[@content-desc=\"tháng 10\"]\")).scrollable(true)).scrollIntoView(new UiSelector().text(\"tháng 1\"))"));

        //Thêm hàm chọn ngày
//        commonPage.testscroll("tháng 1");

//        driver.findElement(By.xpath("//android.widget.SeekBar[@content-desc=\"tháng 10\"]")).click();
//
//        Dimension dimension = driver.manage().window().getSize();
//        int start_x = (int) (dimension.width * start_xd);
//        int start_y = (int) (dimension.height *start_yd);
//        int end_x = (int) (dimension.width * end_xd);
//        int end_y= (int) (dimension.height * end_yd);
//        TouchAction touch = new TouchAction (driver);
//        touch.press(PointOption.point(start_x, start_y))
//                .waitAction(WaitOptions.waitOptions (Duration.ofSeconds (1)))
//                .moveTo(PointOption.point (end_x, end_y)).release().perform();
//        Thread.sleep(3000);

//        driver.findElement(By.xpath("//android.widget.SeekBar[@content-desc=\"23\"]")).click();


//        Dimension windowSize = driver.manage().window().getSize();
//        Map<String, Object> args = new HashMap<>();
//        args.put("command", "input");
//        args.put("args", Lists.newArrayList("swipe", windowSize.width / 4,
//                windowSize.height / 2, windowSize.width / 4, windowSize.height));
//        while (driver.findElements(By.xpath("//android.widget.SeekBar[@content-desc=\"23\"]")).size() == 0) {
//            driver.executeScript("mobile: shell", args);
//            Thread.sleep(5000);
//        }
//        driver.findElement(By.xpath("//android.widget.SeekBar[@content-desc=\"23\"]")).click();

//
//        List <WebElement> values = driver.findElements(transactionHistoryPage.specificTime);
//        for (int i=0;i<values.size();i++)
//        {
//            System.out.println(values.get(i).getAttribute("content-desc"));
//        }

//        driver.findElement(By.xpath("//android.widget.SeekBar[@index=0]")).sendKeys("10");
//        driver.findElement(By.xpath("//android.widget.SeekBar[@index=1]")).sendKeys("tháng 8");
//        driver.findElement(By.xpath("//android.widget.SeekBar[@index=2]")).sendKeys("2022");
////        driver.findElement(By.xpath("//android.widget.SeekBar[@index ='1']")).sendKeys("tháng 8");
//        values.get(0).sendKeys("10");
//
//
////        values.get(0).sendKeys (Keys.TAB);
//        values.get(1).sendKeys("tháng 8");
////        values.get(1).sendKeys (Keys. TAB);
//        values.get(2).sendKeys("2022");
////        values.get(2).sendKeys (Keys. TAB);

//        commonPage.clickElement(transactionHistoryPage.btnConfirm);
    }

    public void transHistory_AllTime() {
        commonPage.clickElement(transactionHistoryPage.allTime);
        commonPage.clickElement(transactionHistoryPage.btnConfirm);
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
