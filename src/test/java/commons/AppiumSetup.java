package commons;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumSetup {
    private static final String ENV_DEVICE_KEY = "device";
    private static final String ENV_PLATFORM_KEY = "platformName";
    private static final String ENV_DEVICENAME_KEY = "deviceName";
    private static final String APK_NAME = "apk_name";
    private static final String ENV_PKGNAME_KEY = "pkg_name";

    public static AppiumDriver appiumDriver;
    static DesiredCapabilities capabilities;
    public static String pkgName;
    public static WebDriverWait webDriverWait;

    public static void prepareDriver(DRIVER_PREF driverPREF) throws MalformedURLException {
        String pathToApk = "apk_res";
        String apkName = TestUtils.getProperty(APK_NAME);

        File apk = new File(pathToApk, apkName);

        capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", apk.getAbsolutePath());
        //capabilities.setCapability("noReset", true);

        switch (driverPREF) {
            case IOS: {
            }
            break;
            case ANDROID: {
                prepareAndroidCap();
                appiumDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                pkgName = TestUtils.getProperty(ENV_PKGNAME_KEY);
            }
            break;
        }

        webDriverWait = new WebDriverWait(appiumDriver, 30);
    }

    private static void prepareAndroidCap() {
        //mandatories cap
        capabilities.setCapability("device", TestUtils.getProperty(ENV_DEVICE_KEY));
        capabilities.setCapability("platformName", TestUtils.getProperty(ENV_PLATFORM_KEY));
        capabilities.setCapability("deviceName", TestUtils.getProperty(ENV_DEVICENAME_KEY));
        //capabilities.setCapability("appPackage", TestUtils.getProperty(ENV_PKGNAME_KEY));
    }

    private static void prepareIOSCap() {
        //mandatories cap
        capabilities.setCapability("device", TestUtils.getProperty(ENV_DEVICE_KEY));
        capabilities.setCapability("platformName", TestUtils.getProperty(ENV_PLATFORM_KEY));
        capabilities.setCapability("deviceName", TestUtils.getProperty(ENV_DEVICENAME_KEY));
    }

    /**
     * Temp to settings which capabilities that will be run
     * <p>
     * Next -> change dynamically from environment.properties
     */
    public enum DRIVER_PREF {
        ANDROID,
        IOS
    }
}
