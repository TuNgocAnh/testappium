package pages.logins;

import common.CommonPage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import pages.ProfilePage.ProfilePage;

public class InputOTP {
    private AndroidDriver driver;

    public InputOTP(AndroidDriver driver) {
        this.driver = driver;
    }

    private By navigationToProfile = By.xpath("//android.view.View[@content-desc=\"Tài khoản\"]");

    public CommonPage loginOTPSucess (String OTP) throws InterruptedException {

        char[] otpChars = OTP.toCharArray(); // Chuyển đổi chuỗi OTP thành một mảng ký tự

        for (int i = 0; i < otpChars.length; i++) {
            String singleDigit = String.valueOf(otpChars[i]);
            driver.findElement(By.xpath("//android.widget.EditText[" + (i + 1) + "]")).sendKeys(singleDigit);
        }
        return new CommonPage(driver);
    }
//    public ProfilePage navigateToProfile (){
//        driver.findElement(navigationToProfile).click();
//        return new ProfilePage(driver);
//        }
}
