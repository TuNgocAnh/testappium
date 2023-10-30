package testcases;

import common.AppiumDriver;
import constants.FrameworkConstants;
import helpers.ExcelHelpers;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ProfilePage.ProfilePage;
import pages.logins.InputOTP;
import pages.logins.LoginPage;


public class InputOTPTest extends AppiumDriver {

    private AndroidDriver driver;
    private InputOTP inputOTP;
    private LoginPage loginPage;
    private ProfilePage profilePage;

    public InputOTPTest(AndroidDriver driver) {
        super();
    }

    @BeforeClass
    public void setup() {
        driver = getDriver();
    }

    @Test
    public void TC_LoginOTPSuccess() throws Exception {
        loginPage = new LoginPage(driver);

        ExcelHelpers excel = new ExcelHelpers();
        excel.setExcelFile(FrameworkConstants.EXCEL_LOGIN, "Sheet1");

        inputOTP =  loginPage.loginPhoneSucess(excel.getCellData("phone", 3));

        inputOTP.loginOTPSucess("00000");

//        profilePage = inputOTP.navigateToProfile();
    }
}
