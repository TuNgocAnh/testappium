package pages.ProfilePage.Wallet;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class WalletBalanceChecker {

    public WalletBalanceChecker(AndroidDriver driver) {
        this.driver = driver;
    }
    private AndroidDriver driver;
    private By btnDeposit = By.xpath ("//android.widget.ImageView[@content-desc=\"Nạp tiền\"]");
    private By transactionHistory = By.xpath("//android.view.View[@content-desc=\"Lịch sử giao dịch\"]");

    public Deposit checkDeposit () {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(btnDeposit).click();
        return new Deposit(driver);
    }

    public TransactionHistory navigationToTransactionHistory () {
        driver.findElement(transactionHistory).click();
        return new TransactionHistory(driver);
    }

}
