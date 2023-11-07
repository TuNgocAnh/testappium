package testcases;

import common.AppiumDriver;
import constants.FrameworkConstants;
import functions.AccountFunction.ProfileFunction;
import helpers.ExcelHelpers;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import functions.LoginFunction.InputOTPFunction;
import functions.LoginFunction.LoginPageFunction;


public class InputOTPTest extends AppiumDriver {

    private AndroidDriver driver;
    private InputOTPFunction inputOTP;
    private LoginPageFunction loginPage;
    private ProfileFunction profilePage;

    public InputOTPTest(AndroidDriver driver) {
        super();
    }

    @BeforeClass
    public void setup() {
        driver = getDriver();
    }

    @Test
    public void TC_LoginOTPSuccess() throws Exception {
        loginPage = new LoginPageFunction(driver);

        ExcelHelpers excel = new ExcelHelpers();
        excel.setExcelFile(FrameworkConstants.EXCEL_LOGIN, "Sheet1");

        inputOTP =  loginPage.loginPhoneSucess(excel.getCellData("phone", 3));

        inputOTP.loginOTPSucess("00000");

//        profilePage = inputOTP.navigateToProfile();
    }
}
