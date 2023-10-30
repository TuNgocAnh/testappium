package testcases;

import constants.FrameworkConstants;
import io.appium.java_client.android.AndroidDriver;
import helpers.ExcelHelpers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.logins.InputOTP;
import pages.logins.LoginPage;
import common.AppiumDriver;


public class LoginPageTest extends AppiumDriver {
    private AndroidDriver driver;
    private LoginPage loginPage;
    private InputOTP inputOTP;

    @BeforeClass
    public void setup() {
        driver = getDriver();
    }

    @Test
    public void TC_LoginSuccess() throws Exception {

        loginPage = new LoginPage(driver);

        ExcelHelpers excel = new ExcelHelpers();
        excel.setExcelFile(FrameworkConstants.EXCEL_LOGIN, "Sheet1");

        loginPage.loginPhoneSucess(excel.getCellData("phone", 3));

//        loginPage.loginOTPSucess("00000");

    }
}


//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@content-desc=\"Vua Thợ\"]")));

//        excel.setExcelFile("src/test/resources/Login.xlsx", "Sheet1");

//        Ghi data vào file excel
//        excel.setCellData("12345678", 4, 1);
