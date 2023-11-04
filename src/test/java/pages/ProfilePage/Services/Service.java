package pages.ProfilePage.Services;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class Service {
    private AndroidDriver driver;
    public Service(AndroidDriver driver) {
        this.driver = driver;
    }
    //Add Dịch vụ
    private By btnAddService = By.xpath("//android.widget.Button[@content-desc=\"Thêm ngay\"]");

    public SearchServicePage navigaitionToAddService () {
        driver.findElement(btnAddService).click();
        return new SearchServicePage(driver);
    }

}
