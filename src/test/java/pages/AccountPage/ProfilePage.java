package pages.AccountPage;

import org.openqa.selenium.By;

public class ProfilePage {
    public By getServices = By.xpath("//android.view.View[@content-desc=\"Kiểm tra chất lượng\"]");
    public By iconVuaTho = By.xpath("//android.widget.TextView[@content-desc=\"Vua Thợ\"]");
    public By getProfile = By.xpath("//android.view.View[@content-desc=\"Tài khoản\"]");
    public By getWalletWhenOnEye = By.xpath("//android.view.View[contains(@content-desc, 'đ')][2]");
    public By onToOffEye = By.xpath("//android.view.View[contains(@content-desc, 'đ')]/android.widget.Button");
    public By offToOnEye = By.xpath("//android.view.View[@content-desc=\"*********\"]/android.widget.Button");
    public By contentOffEye = By.xpath("//android.view.View[@content-desc=\"*********\"]");
    public By contentOnEye = By.xpath("//android.view.View[contains(@content-desc, 'đ')][2]");
}
