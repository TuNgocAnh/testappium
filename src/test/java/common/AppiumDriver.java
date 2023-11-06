package common;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import utils.MobileCapabilityType;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumDriver{

    private AndroidDriver driver;
    public AndroidDriver getDriver() {
        return driver;
    }

    @BeforeClass

    public void Setup() throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "SM-G973N");
        cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");

        cap.setCapability(MobileCapabilityType.APP_PACKAGE, "com.ldmnq.launcher3");
        cap.setCapability(MobileCapabilityType.APP_ACTIVITY,"com.android.launcher3.Launcher");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,120);


        driver = new AndroidDriver(new URL(
                "http://localhost:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws IOException {

        driver.closeApp();
        driver.launchApp();
    }

}
