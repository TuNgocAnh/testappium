package common;

import functions.ActivitiesFunction.ActivitiesFunction;
import functions.AccountFunction.ProfileFunction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import functions.FindJobFunction.FindJobFunction;
import functions.StorePage.StorePage;

public class CommonPage {

    private AndroidDriver driver;

    public CommonPage(AndroidDriver driver) {
        this.driver = driver;
    }

    private By getHomePage = By.xpath("//android.view.View[@content-desc=\"Trang chủ\"]");
    private By getStore = By.xpath("//android.view.View[@content-desc=\"Cửa hàng\"]");
    private By getFindJob = By.xpath("//android.view.View[@content-desc=\"Tìm việc\"]");
    private By getActivities = By.xpath("//android.view.View[@content-desc=\"Hoạt động\"]");
    private By getProfile = By.xpath("//android.view.View[@content-desc=\"Tài khoản\"]");

    //Dịch vụ
    private By getServices = By.xpath("//android.view.View[@content-desc=\"Dịch vụ\"]");
    //Add Dịch vụ
    private By btnAddService = By.xpath("//android.view.View[@content-desc=\"+ Thêm dịch vụ\"]");
    //Nhập search Dịch vụ
    private By inputsearchService = By.className("android.widget.EditText");


    public StorePage navigateToStorePage() {
        // Thực hiện các tương tác để đến trang cửa hàng và trả về StorePage
        driver.findElement(getStore).click();
        return new StorePage(driver);
    }

    public FindJobFunction navigateToFindJobPage() {
        // Thực hiện các tương tác để đến trang tìm việc làm và trả về FindJobFunction
        driver.findElement(getFindJob).click();
        return new FindJobFunction(driver);
    }

    public ActivitiesFunction navigateToActivitiesPage() {
        // Thực hiện các tương tác để đến trang hoạt động và trả về ActivitiesFunction
        driver.findElement(getActivities).click();
        return new ActivitiesFunction(driver);
    }

    public ProfileFunction navigateToProfilePage() throws InterruptedException {
        // Thực hiện các tương tác để đến trang hồ sơ và trả về ProfileFunction
        driver.findElement(getProfile).click();

        return new ProfileFunction(driver);
    }

}
