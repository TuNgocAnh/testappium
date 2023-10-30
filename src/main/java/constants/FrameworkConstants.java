package constants;

import helpers.PropertiesHelpers;

public final class FrameworkConstants {

    private FrameworkConstants() {
    }

    static {
        PropertiesHelpers.loadAllFiles();
    }

    public static final String EXCEL_LOGIN = PropertiesHelpers.getValue("EXCEL_LOGIN");
    public static final String EXCEL_CAREER = PropertiesHelpers.getValue("EXCEL_CAREER"); ;

}
