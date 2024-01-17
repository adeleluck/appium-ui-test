import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseConfig {

    /**
     * Ссылка на драйвер Appium, через который мы будем взаимодействовать с ним.
     */
    protected static AppiumDriver<MobileElement> driver;


    /**
     * Этот метод вызывается перед выполнением всех тестов.
     */
    @BeforeClass
    public static void setUp()
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.wildberries.ru");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "ru.wildberries.view.main.MainActivity");
        capabilities.setCapability(MobileCapabilityType.NO_RESET,false);
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);

        capabilities.setCapability(MobileCapabilityType.APP, "D:\\Temp\\Wildberries_6.4.5001_apkcombo.com.apk");

        try {
            // перехватываем возможные ошибки во время подключения к Appium Server
            driver = new AppiumDriver<MobileElement>(new URL("http://localhost:4723/wd/hub/"), capabilities);
        } catch (MalformedURLException e) {
            // если что-то пошло не так, завершаемся с ошибкой.
            throw new RuntimeException(e);
        }
    }


    /**
     * Этот метод вызывается после завершения всех тестов.
     */
    @AfterClass
    public static void tearDown()
    {
        // завершаем работу с драйвером и выходим
        if (driver != null)
        {
           // driver.close();
            driver.quit();
        }
    }

}
