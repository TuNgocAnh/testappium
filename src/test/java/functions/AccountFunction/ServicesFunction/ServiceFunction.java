package functions.AccountFunction.ServicesFunction;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import pages.AccountPage.ServicesPage.ServicePage;

public class ServiceFunction {
    private AndroidDriver driver;
    public ServiceFunction(AndroidDriver driver) {
        this.driver = driver;
    }
    ServicePage servicePage = new ServicePage();

    public SearchServiceFunction navigaitionToAddService () {
        driver.findElement(servicePage.btnAddService).click();
        return new SearchServiceFunction(driver);
    }

}
