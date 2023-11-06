package testcases;

import common.AppiumDriver;
import common.CommonPage;
import constants.FrameworkConstants;
import helpers.ExcelHelpers;
import io.appium.java_client.android.AndroidDriver;
import org.bouncycastle.tsp.TSPUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ProfilePage.ProfilePage;
import pages.ProfilePage.Services.SearchServicePage;
import pages.ProfilePage.Services.Service;
import pages.logins.InputOTP;
import pages.logins.LoginPage;

public class SearchServiceTest extends AppiumDriver {

    private AndroidDriver driver;
    private Service service;
    private SearchServicePage searchServicePage;
    private ProfilePage profilePage;
    private InputOTPTest inputOTPTest;
    private LoginPage loginPage;

    private InputOTP inputOTP;
    private CommonPage commonPage;

    public SearchServiceTest() {
    }

    @BeforeClass
    public void setup() {
        driver = getDriver();
    }
//
//    @Test (priority = 1)
//    public void TC_LoginOTPSuccess() throws Exception {
//
//        loginPage = new LoginPage(driver);
//
//        ExcelHelpers excel = new ExcelHelpers();
//        excel.setExcelFile(FrameworkConstants.EXCEL_LOGIN, "Sheet1");
//
//        inputOTP =  loginPage.loginPhoneSucess(excel.getCellData("phone", 3));
//
//
//        commonPage = inputOTP.loginOTPSucess("00000");
//
//    }


    @Test(priority = 1)

    public void TC_SeachSucess() throws Exception {

        profilePage = new ProfilePage(driver);

        //Vào mục profile
//        profilePage = commonPage.navigateToProfilePage();

        profilePage.navigateToProfilePage();

        //Vào Dịch vụ
        service = profilePage.navigationToGetServices();

        //Vào thêm dịch vụ

        searchServicePage = service.navigaitionToAddService();

    }

//    @Test(priority = 2)
//    public void search() throws Exception {
//
//        ExcelHelpers excel = new ExcelHelpers();
//        excel.setExcelFile(FrameworkConstants.EXCEL_CAREER, "Dịch vụ");
//
//        int rowCount = excel.getRowCount();
//
//        for (int i = 1; i <= rowCount; i++) {
//            String keyword = excel.getCellData("Nghề", i);
//
//            searchServicePage.searchCorrectService(keyword);
//        }
//    }


    @Test(priority = 3)
    public void TC_searchInCorrectService() throws Exception {

        ExcelHelpers excel = new ExcelHelpers();
        excel.setExcelFile(FrameworkConstants.EXCEL_CAREER, "Dịch vụ (Sai)");

        String keyword = excel.getCellData("Nghề", 2);
//        int rowCount = excel.getRowCount();
//        for (int i = 1; i <= rowCount; i++) {
//            String keyword = excel.getCellData("Nghề", i);
        searchServicePage.searchIncorrectService(keyword);

        searchServicePage.returnToStart();

    }

}
