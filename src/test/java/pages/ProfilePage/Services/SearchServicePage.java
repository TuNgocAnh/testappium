package pages.ProfilePage.Services;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SearchServicePage {
    private AndroidDriver driver;
    public SearchServicePage(AndroidDriver driver) {
        this.driver = driver;
    }

    //input search Dịch vụ
    private final By inputsearchService = By.className("android.widget.EditText");
    private By searchResultElement = By.xpath("//android.view.View[@class='android.view.View']");


    private String searchServiceKeyword;

    public String searchService (String keyword) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(inputsearchService));

        // Nhập từ khoá tìm kiếm
        searchInput.click();
        searchInput.sendKeys(keyword);

        searchServiceKeyword = keyword;
        return keyword;
    }

    public By searchResultElement() {


        System.out.println(driver.findElement(searchResultElement).getText());
        return searchResultElement;
    }
    public List<String> getSearchResultElementsText() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Đợi tối đa 10 giây
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(searchResultElement));


        List<WebElement> searchResultElements = driver.findElements(searchResultElement);
        List<String> resultTextList = new ArrayList<>();


        for (WebElement element : searchResultElements) {
            resultTextList.add(element.getText());
        }

        return resultTextList;
    }

    public boolean compareSearchResult2() {
        List<String> resultTextList = getSearchResultElementsText();

        for (String resultText : resultTextList) {
            if (resultText.toLowerCase().contains(searchServiceKeyword.toLowerCase())) {
                System.out.println("Kết quả tìm kiếm chứa từ khoá: " + searchServiceKeyword);
                return true; // Trả về true nếu có bất kỳ kết quả nào chứa từ khoá
            }
        }

        System.out.println("Không có kết quả nào chứa từ khoá: " + searchServiceKeyword);
        return false; // Trả về false nếu không tìm thấy kết quả chứa từ khoá
    }



    public boolean compareSearchResult() {

        return driver.findElement(searchResultElement).getText().toLowerCase().contains(searchServiceKeyword.toLowerCase());

//        String searchResultElement = "//android.view.View[contains(@content-desc, '" + searchServiceKeyword + "')]";
//        return !driver.findElements(By.xpath(searchResultElement)).isEmpty();

//        By searchResultElement = By.xpath("//android.view.View[contains(@content-desc, '\" + searchServiceKeyword + \"')]");
//        return driver.findElement(searchResultElement).getText().toLowerCase().contains(searchServiceKeyword.toLowerCase());


//        // Lấy nội dung hiển thị trong ô kết quả
//        String searchResultText = searchResultElement.getText();
//
//        // So sánh từ khóa với nội dung hiển thị
//        return searchResultText.contains(searchKeyword);
    }

//    public boolean compareSearchResultContainsKeyword(String keyword) {
//        String searchResult = compareSearchResult();
//        return searchResult.contains(keyword);
//    }

}
