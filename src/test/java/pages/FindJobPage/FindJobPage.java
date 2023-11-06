package pages.FindJobPage;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FindJobPage {
    private AndroidDriver driver;

    public FindJobPage(AndroidDriver driver) {
    }
    private By getFindJob = By.xpath("//android.view.View[@content-desc=\"Tìm việc\"]");

}
