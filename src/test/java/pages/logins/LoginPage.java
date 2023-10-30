package pages.logins;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginPage {
    private AndroidDriver driver;
    public LoginPage (AndroidDriver driver) {
        this.driver = driver;
    }

    private By iconVuaTho = By.xpath("//android.widget.TextView[@content-desc=\"Vua Thợ\"]");
    private By welcomeScreen = By.xpath("//android.view.View[@content-desc=\"Tiếp tục\"]");
    private By btnDangNhap = By.xpath("//android.view.View[@content-desc=\"Đăng nhập\"]");
    private By btnTiepTuc = By.xpath("//android.view.View[@content-desc=\"Tiếp tục\"]");

    public void openLoginPage() {
        driver.findElement(iconVuaTho).click();

        for (int i=1; i<4;i++) {
            driver.findElement(welcomeScreen).click();
        }

        driver.findElement(btnDangNhap).click();
    }

    public InputOTP loginPhoneSucess (String phone) {
        openLoginPage();
        driver.findElement(By.className("android.widget.EditText")).sendKeys(phone);

        driver.findElement(btnTiepTuc).click();

        return new InputOTP(driver);
    }

//    public void loginOTPSucess (String OTP) throws InterruptedException {
//
//        char[] otpChars = OTP.toCharArray(); // Chuyển đổi chuỗi OTP thành một mảng ký tự
//
//        for (int i = 0; i < otpChars.length; i++) {
//            String singleDigit = String.valueOf(otpChars[i]);
//            driver.findElement(By.xpath("//android.widget.EditText[" + (i + 1) + "]")).sendKeys(singleDigit);
//        }


//        StringBuffer otpBuffer = new StringBuffer().append(OTP);
//
//        for (int i = 1; i <= 5; i++) {
//            driver.findElement(By.xpath("//android.widget.EditText[" + i + "]")).sendKeys(otpBuffer);
//        }
    }
