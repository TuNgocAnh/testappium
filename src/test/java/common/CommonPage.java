package common;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import pages.ActivitiesPage.ActivitiesPage;
import pages.FindJobPage.FindJobPage;
import pages.HomePage.HomePage;
import pages.ProfilePage.ProfilePage;
import pages.StorePage.StorePage;

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

    public HomePage navigateToHomePage() {
        // Thực hiện các tương tác để đến trang chính và trả về HomePage
        driver.findElement(getHomePage).click();
        return new HomePage(driver);
    }

    public StorePage navigateToStorePage() {
        // Thực hiện các tương tác để đến trang cửa hàng và trả về StorePage
        driver.findElement(getStore).click();
        return new StorePage(driver);
    }

    public FindJobPage navigateToFindJobPage() {
        // Thực hiện các tương tác để đến trang tìm việc làm và trả về FindJobPage
        driver.findElement(getFindJob).click();
        return new FindJobPage(driver);
    }

    public ActivitiesPage navigateToActivitiesPage() {
        // Thực hiện các tương tác để đến trang hoạt động và trả về ActivitiesPage
        driver.findElement(getActivities).click();
        return new ActivitiesPage(driver);
    }

    public ProfilePage navigateToProfilePage() throws InterruptedException {
        // Thực hiện các tương tác để đến trang hồ sơ và trả về ProfilePage
        driver.findElement(getProfile).click();

        return new ProfilePage(driver);
    }

}
