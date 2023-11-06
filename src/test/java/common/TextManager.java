package common;

public class TextManager {
    private static String noResultsText = "Hiện tại dịch vụ này chưa có, vui lòng yêu cầu dịch vụ " +
            "này với chúng tôi để có thể đáp ứng công việc cho bạn một cách tốt nhất";

    public static String getNoResultsText() {
        return noResultsText;
    }
}
