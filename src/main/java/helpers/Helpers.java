package helpers;

import java.io.File;

public final class Helpers {

    public Helpers() {
        super();
    }

    public static String getCurrentDir() {
        String current = System.getProperty("user.dir") + File.separator;
        return current;
    }



}
