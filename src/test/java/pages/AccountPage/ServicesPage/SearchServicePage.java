package pages.AccountPage.ServicesPage;

import org.openqa.selenium.By;

public class SearchServicePage {

    public By inputsearchService = By.className("android.widget.EditText");
    public By requestServiceButton = By.xpath("//android.view.View[@content-desc=\"Yêu cầu dịch vụ\"]");
    public By choiceBtn = By.xpath("//android.view.View[contains(@content-desc, 'Chọn')]");
    public By msgnoService = By.xpath("//android.view.View[@content-desc=\"Hiện tại dịch vụ này chưa có, vui lòng yêu cầu dịch vụ này với chúng tôi để có thể đáp ứng công việc cho bạn một cách tốt nhất\"]");
    public By backSearchService = By.xpath("//android.view.View[@content-desc=\"Tìm kiếm dịch vụ\"]");
}
