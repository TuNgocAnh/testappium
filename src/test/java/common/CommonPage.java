package common;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class CommonPage {
    private AndroidDriver driver;

    public CommonPage(AndroidDriver driver) {
        this.driver = driver;
    }

    private int EXPLICIT_WAIT_TIMEOUT = 20;
    private int WAIT_PAGE_LEADED_TIMEOUT = 30;

    public WebElement getWebElement(By by) {
        return driver.findElement(by);
    }

    public void logConsole(String message) {
        System.out.println(message);
    }

    public void hoverOnElement(By by) {
        waitForElementVisible(by);
        Actions action = new Actions(driver);
        action.moveToElement(getWebElement(by));
        logConsole("Hover on element " + by);
    }

    public void clickElement(By by) {
        waitForElementVisible(by);
        getWebElement(by).click();
        logConsole("Click on element " + by);
    }

    public void setText(By by, String value) {
        waitForElementVisible(by);
        getWebElement(by).sendKeys(value);
        logConsole("Set text " + value + " on element " + by);
    }

    public void clearElement(By by) {
        waitForElementVisible(by);
        getWebElement(by).clear();
        logConsole("Clear all element " + by);
    }

    public String getTextElement(By by) {
        waitForElementVisible(by);
        logConsole("Get text of element " + by);
        logConsole("==> Text: " + getWebElement(by).getText());
        return getWebElement(by).getText();
    }

    public String getAttributeElement(By by, String attributeName) {
        waitForElementVisible(by);
        logConsole("Get attribute value of element " + by);
        logConsole("==> Attribute value: " + getWebElement(by).getAttribute(attributeName));
        return getWebElement(by).getAttribute(attributeName);
    }

    public void verifyElementTextContains(By by, String expectedText, String message) {
        Assert.assertTrue(getTextElement(by).contains(expectedText), message);
    }

    public String verifyAttrContains(By by, String attributeName, String expectedText, String message) {
        Assert.assertTrue(getAttributeElement(by, attributeName).contains(expectedText), message);

        waitForElementVisible(by);
        return getWebElement(by).getAttribute(attributeName);
    }


    public void scrollToElementWithJS(By by) {
        waitForElementPresent(by); // Đợi đến khi có phần tử tồn tại, khác với Visible là có trong UI

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", getWebElement(by));
        logConsole("Scroll to element " + by);
    }


    public WebElement scrollToAnElementByText(String text) {
        return driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector())" +
                ".scrollIntoView(new UiSelector().text(\"" + text + "\"));"));
    }

    public void testscroll(String text) {

        WebElement element = (WebElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + text + "\").instance(0))"));
        element.click();
    }

    public void scrollToBottomOfPage(By by) {
//        String scrollToEnd = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollToEnd(4)";
//        driver.findElement(MobileBy.AndroidUIAutomator(scrollToEnd));

        String scrollToEnd = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollToEnd(1)";
        int maxScrollAttempts = 10;

        for (int i = 0; i < maxScrollAttempts; i++) {

            try {
                // Thực hiện cuộn trang
                Thread.sleep(5000);
                waitForElementPresent(by);
                waitForElementVisible(by);
                driver.findElement(MobileBy.AndroidUIAutomator(scrollToEnd));


            } catch (NoSuchElementException e) {
                break;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public void waitForElementVisible(By by, int second) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second), Duration.ofMillis(500));

        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitForElementVisible(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_TIMEOUT), Duration.ofMillis(500));

        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitForElementPresent(By by, int second) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));

        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitForElementPresent(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_TIMEOUT));

        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void scrollVeriticalCalendar(By by, double ratio_start_y, double ratio_end_y, double ratio_x, int numberOfScroll) {
        Dimension size = driver.manage().window().getSize();
        System.out.println(size);
        double starty = (size.height * ratio_start_y);
        //Find endy point which is at top side of screen.
        double endy = (size.height * ratio_end_y);
        //Find horizontal point where you wants to swipe. It is in middle of screen width.
        double x = (double) size.width / ratio_x;
        System.out.println("starty = " + starty + " ,endy = " + endy + " , x = " + x);

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MICROSECONDS);

        for (int i = 0; i < numberOfScroll; i++) {
            TouchAction touch = new TouchAction(driver);
            touch.press(PointOption.point((int) x, (int) starty))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(0)))
                    .moveTo(PointOption.point((int) x, (int) endy)).release().perform();

            try {
                driver.findElement(by).isDisplayed();
                break;

            } catch (NoSuchElementException | TimeoutException e) {

            }

        }
    }


    public void WalletForm(double ratio_start_y, double ratio_end_y, double ratio_x, By by, String expectedText, int getPartFromString, String textWhenListEmpty, String textWhenConditionTrue, String textWhenConditionFalse) {

        Dimension size = driver.manage().window().getSize();
        System.out.println(size);

        double starty = size.height * ratio_start_y;
        double endy = size.height * ratio_end_y;
        double x = size.width / ratio_x;

        System.out.println("starty = " + starty + " ,endy = " + endy + " , x = " + x);

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MICROSECONDS);

        int elementCount = 0;

        int lastElementY = 0;

        do {
            TouchAction touch = new TouchAction(driver);
            touch.press(PointOption.point((int) x, (int) starty))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
                    .moveTo(PointOption.point((int) x, (int) endy)).release().perform();

            List<WebElement> elements = driver.findElements(by);

            // Lấy vị trí của phần tử cuối cùng
            int currentLastElementY = elements.get(elements.size()-1).getLocation().getY();

            // Kiểm tra xem vị trí có thay đổi hay không
            if (currentLastElementY == lastElementY) {
                System.out.println("Đã đến cuối danh sách.");
                break;
            }

            lastElementY = currentLastElementY;

            for (WebElement element : elements) {
                if (element.isDisplayed()) {
                    elementCount++;

                    String contentDesc = element.getAttribute("content-desc");
                    System.out.println("Thông tin của phần tử: " + contentDesc);
                }
            }

            System.out.println("Số phần tử hiển thị: " + elementCount);

            if (elementCount > 0) {
                List<String> texts = new ArrayList<>();

                for (WebElement element : elements) {
                    if (element.isDisplayed()) {  // Kiểm tra nếu phần tử hiển thị
                        String contentDesc = element.getAttribute("content-desc");

                        if (contentDesc != null) {
                            String text = contentDesc.split("\n")[getPartFromString]; // Lấy phần text từ chuỗi
                            texts.add(text);
                        }
                    }
                }

                boolean correctDeposit = texts.contains(expectedText);

                if (elementCount == 1 && elements.get(0).getAttribute("content-desc") == null) {
                    System.out.println(textWhenListEmpty);
                    break;
                }

                if (correctDeposit && elements.get(0).getAttribute("content-desc") != null) {
                    System.out.println(textWhenConditionTrue);
                } else {
                    System.out.println(textWhenConditionFalse);
                }
            }
        }
        while (true);
    }



//    public void WalletForm2(double ratio_start_y, double ratio_end_y, double ratio_x, By by, String expectedText, int getPartFromString, String textWhenListEmpty, String textWhenConditionTrue, String textWhenConditionFalse) {
//
//        Dimension size = driver.manage().window().getSize();
//        System.out.println(size);
//
//        double starty = size.height * ratio_start_y;
//        double endy = size.height * ratio_end_y;
//        double x = size.width / ratio_x;
//
//        System.out.println("starty = " + starty + " ,endy = " + endy + " , x = " + x);
//
//        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MICROSECONDS);
//
//        int elementCount = 0;
//
//        int lastElementY = 0;
//
//        do {
//            TouchAction touch = new TouchAction(driver);
//            touch.press(PointOption.point((int) x, (int) starty))
//                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
//                    .moveTo(PointOption.point((int) x, (int) endy)).release().perform();
//
//            List<WebElement> elements = driver.findElements(by);
//
//            // Lấy vị trí của phần tử cuối cùng
//            int currentLastElementY = elements.get(elements.size()-2).getLocation().getY();
//
//            // Kiểm tra xem vị trí có thay đổi hay không
//            if (currentLastElementY == lastElementY) {
//                System.out.println("Đã đến cuối danh sách.");
//                break;
//            }
//
//            lastElementY = currentLastElementY;
//
//            for (WebElement element : elements) {
//                if (element.isDisplayed()) {
//                    elementCount++;
//
//                    String contentDesc = element.getAttribute("content-desc");
//                    System.out.println("Thông tin của phần tử: " + contentDesc);
//                }
//            }
//
//            System.out.println("Số phần tử hiển thị: " + elementCount);
//
//            if (elementCount > 0) {
//                List<String> texts = new ArrayList<>();
//
//                for (WebElement element : elements) {
//                    if (element.isDisplayed()) {  // Kiểm tra nếu phần tử hiển thị
//                        String contentDesc = element.getAttribute("content-desc");
//
//                        if (contentDesc != null) {
//                            String text = contentDesc.split("\n")[getPartFromString]; // Lấy phần text từ chuỗi
//                            texts.add(text);
//                        }
//                    }
//                }
//
//                boolean correctDeposit = texts.contains(expectedText);
//
//                if (elementCount == 1 && elements.get(0).getAttribute("content-desc") == null) {
//                    System.out.println(textWhenListEmpty);
//                    break;
//                }
//
//                if (correctDeposit && elements.get(0).getAttribute("content-desc") != null) {
//                    System.out.println(textWhenConditionTrue);
//                } else {
//                    System.out.println(textWhenConditionFalse);
//                }
//            }
//        }
//        while (true);
//    }


//    public void WalletForm(  By by, String expectedText, int getPartFromString, String textWhenListEmpty, String textWhenConditionTrue, String textWhenConditionFalse) {
//
//        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MICROSECONDS);
//
//        String scrollToEnd = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollToEnd(1)";
//        int maxScrollAttempts = 10;
//
//        for (int i2 = 0; i2 < maxScrollAttempts; i2++) {
//            List<WebElement> elements = driver.findElements(by);
//
//            int elementCount = 0;
//
//            for (WebElement element : elements) {
//                if (element.isDisplayed()) {
//                    elementCount++;
//
//                    String contentDesc = element.getAttribute("content-desc");
//                    System.out.println("Thông tin của phần tử: " + contentDesc);
//                }
//            }
//
//            System.out.println("Số phần tử hiển thị: " + elementCount);
//
//            if (elementCount > 0) {
//                List<String> texts = new ArrayList<>();
//
//                for (WebElement element : elements) {
//                    if (element.isDisplayed()) {  // Kiểm tra nếu phần tử hiển thị
//                        String contentDesc = element.getAttribute("content-desc");
//
//                        if (contentDesc != null) {
//                            String text = contentDesc.split("\n")[getPartFromString]; // Lấy phần text từ chuỗi
//                            texts.add(text);
//                        }
//                    }
//                }
//
//                boolean correctDeposit = texts.contains(expectedText);
//
//                if (elementCount == 1 && elements.get(0).getAttribute("content-desc") == null) {
//                    System.out.println(textWhenListEmpty);
//                    break;
//                }
//
//                if (correctDeposit && elements.get(0).getAttribute("content-desc") != null) {
//                    System.out.println(textWhenConditionTrue);
//                } else {
//                    System.out.println(textWhenConditionFalse);
//                }
//            }
//
//            try {
//                // Thực hiện cuộn trang
//                waitForElementPresent(by);
//                waitForElementVisible(by);
//                driver.findElement(MobileBy.AndroidUIAutomator(scrollToEnd));
//
//            } catch (NoSuchElementException e) {
//                break;
//            }
//        }
//    }


    public void sortByDateAndRange(By by, double ratio_start_y, double ratio_end_y, double ratio_x, int numDays) {
        Dimension size = driver.manage().window().getSize();
        System.out.println(size);

        double starty = size.height * ratio_start_y;
        double endy = size.height * ratio_end_y;
        double x = size.width / ratio_x;

        System.out.println("starty = " + starty + " ,endy = " + endy + " , x = " + x);

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MICROSECONDS);

        List<String> dates = new ArrayList<>();
        boolean isSorted = true;
        boolean day = true;
        int lastElementY = 0;

        Set<String> uniqueDates = new LinkedHashSet<>();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        do {
            TouchAction touch = new TouchAction(driver);
            touch.press(PointOption.point((int) x, (int) starty))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
                    .moveTo(PointOption.point((int) x, (int) endy)).release().perform();

            List<WebElement> elements = driver.findElements(by);

            if (elements.isEmpty()) {
                System.out.println("Không còn phần tử nào hiển thị.");
                break;
            }

            // Lấy vị trí của phần tử cuối cùng
            int currentLastElementY = elements.get(elements.size()-1).getLocation().getY();

            // Kiểm tra xem vị trí có thay đổi hay không
            if (currentLastElementY == lastElementY)  {
                System.out.println("Đã đến cuối danh sách.");
                break;
            }

            lastElementY = currentLastElementY;

            for (WebElement element : elements) {
                if (element.isDisplayed()) {
                    String contentDesc = element.getAttribute("content-desc");

                    if (contentDesc != null) {
                        String date = contentDesc.split("\n")[1]; // Lấy phần ngày từ chuỗi

                        if (uniqueDates.add(date)) {
                            dates.add(date);
                        }

                    }
                }
            }

            System.out.println("Ngày: " + dates);

            for (int i = 1; i < dates.size(); i++) {
                try {
                    Date date1 = dateFormat.parse(dates.get(i - 1));
                    Date date2 = dateFormat.parse(dates.get(i));

                    if (date1.compareTo(date2) < 0) {
                        isSorted = false;
                        break;
                    }

                    long diffInMillies = Math.abs(date2.getTime() - date1.getTime());
                    long diffInDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

                    if (diffInDays > numDays) {
                        day = false;
                        break;
                    }

                } catch (ParseException e) {
                    System.out.println("Lỗi chuyển đổi ngày: " + e.getMessage());
                }
            }

        } while (true);

        if (dates.isEmpty()) {
            System.out.println("Danh sách trống");
            return;
        }

        if (isSorted) {
            System.out.println("Danh sách đã sắp xếp giảm dần theo ngày.");
        } else {
            Assert.assertTrue(isSorted, "Danh sách không sắp xếp giảm dần theo ngày.");
        }

        if (day) {
            System.out.println("Đúng - Ngày nằm trong thời gian đã chọn.");
        } else {
            Assert.assertTrue(day, "Sai - Khoảng cách giữa ngày đầu tiên và ngày cuối cùng không nằm trong thời gian đã chọn.");
        }
    }

//    public void sortByDateAndRange(By by, double ratio_start_y, double ratio_end_y, double ratio_x, int numDays) {
//        Dimension size = driver.manage().window().getSize();
//        System.out.println(size);
//
//        double starty = size.height * ratio_start_y;
//        double endy = size.height * ratio_end_y;
//        double x = size.width / ratio_x;
//
//        System.out.println("starty = " + starty + " ,endy = " + endy + " , x = " + x);
//
//        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MICROSECONDS);
//
//        List<String> dates = new ArrayList<>();
//        boolean isSorted = true;
//        boolean day = true;
//        int lastElementY = 0;
//
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//
//        do {
//            TouchAction touch = new TouchAction(driver);
//            touch.press(PointOption.point((int) x, (int) starty))
//                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
//                    .moveTo(PointOption.point((int) x, (int) endy)).release().perform();
//
//            List<WebElement> elements = driver.findElements(by);
//
//            if (elements.isEmpty()) {
//                System.out.println("Không còn phần tử nào hiển thị.");
//                break;
//            }
//
//            // Lấy vị trí của phần tử cuối cùng
//            int currentLastElementY = elements.get(elements.size()-1).getLocation().getY();
//
//            // Kiểm tra xem vị trí có thay đổi hay không
//            if (currentLastElementY == lastElementY) {
//                System.out.println("Đã đến cuối danh sách.");
//                break;
//            }
//
//            lastElementY = currentLastElementY;
//
//
//            for (WebElement element : elements) {
//                if (element.isDisplayed()) {
//                    String contentDesc = element.getAttribute("content-desc");
//
//                    if (contentDesc != null) {
//                        String date = contentDesc.split("\n")[1]; // Lấy phần ngày từ chuỗi
//                        dates.add(date);
//                    }
//                }
//            }
//
//            System.out.println("Ngày: " + dates);
//
//            for (int i = 1; i < dates.size(); i++) {
//                try {
//                    Date date1 = dateFormat.parse(dates.get(i - 1));
//                    Date date2 = dateFormat.parse(dates.get(i));
//
//                    if (date1.compareTo(date2) < 0) {
//                        isSorted = false;
//                        break;
//                    }
//
//                    long diffInMillies = Math.abs(date2.getTime() - date1.getTime());
//                    long diffInDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
//
//                    if (diffInDays > numDays) {
//                        day = false;
//                        break;
//                    }
//
//                } catch (ParseException e) {
//                    System.out.println("Lỗi chuyển đổi ngày: " + e.getMessage());
//                }
//            }
//
//
//        } while (true);
//
//        if (dates.isEmpty()) {
//            System.out.println("Danh sách trống");
//            return;
//        }
//
//        if (isSorted) {
//            System.out.println("Danh sách đã sắp xếp giảm dần theo ngày.");
//        } else {
//            Assert.assertTrue(isSorted, "Danh sách không sắp xếp giảm dần theo ngày.");
//        }
//
//        if (day) {
//            System.out.println("Đúng - Ngày nằm trong thời gian đã chọn.");
//        } else {
//            Assert.assertTrue(day, "Sai - Khoảng cách giữa ngày đầu tiên và ngày cuối cùng không nằm trong thời gian đã chọn.");
//        }
//    }


    private void assertAndPrint(String successMessage, String failureMessage, boolean condition) {
        if (condition) {
            System.out.println(successMessage);
        } else {
            Assert.fail(failureMessage);
        }
    }


}
