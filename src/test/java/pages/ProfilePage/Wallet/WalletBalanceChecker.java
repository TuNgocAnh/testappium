package pages.ProfilePage.Wallet;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class WalletBalanceChecker {
    private AndroidDriver driver;
    private By btnDeposit = By.xpath ("//android.widget.ImageView[@content-desc=\"Nạp tiền\"]");
    private By inputMoney = By.xpath ("//android.widget.EditText");
    private By textIfNull = By.xpath ("//android.view.View[@content-desc=\"Vui lòng không để trống số tiền\"]");
    private By textIfMinimum = By.xpath("//android.view.View[@content-desc=\"Số tiền nạp tối thiểu phải là 10,000 VNĐ\"]");

    public WalletBalanceChecker(AndroidDriver driver) {
        this.driver = driver;
    }

    public void checkDeposit () {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(btnDeposit).click();

        driver.findElement(inputMoney).click();

//        Assert.assertEquals(driver.findElement(textIfNull).getAttribute("content-desc"),"Vui lòng không để trống số tiền");
    }
    public void checkDepositNullMessage(String money) {
        driver.findElement(inputMoney).sendKeys(money);
        driver.findElement(inputMoney).clear();

        Assert.assertEquals(driver.findElement(textIfNull).getAttribute("content-desc"), "Vui lòng không để trống số tiền" );
    }
    public void checkMinimumDepositAmount(String money) {

        driver.findElement(inputMoney).sendKeys(money);
        Assert.assertEquals(driver.findElement(textIfMinimum).getAttribute("content-desc"), "Số tiền nạp tối thiểu phải là 10,000 VNĐ" );
    }

}
