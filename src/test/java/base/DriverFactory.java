package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public static void initDriver() {
    if (tlDriver.get() == null) {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--no-default-browser-check");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--user-data-dir=" + System.getProperty("java.io.tmpdir") + "/temp_chrome_profile");
        options.addArguments("--guest");
        options.setExperimentalOption("prefs", new java.util.HashMap<String, Object>() {{
            put("credentials_enable_service", false);
            put("profile.password_manager_enabled", false);
            put("autofill.profile_enabled", false);
        }});

        tlDriver.set(new ChromeDriver(options));
        tlDriver.get().manage().window().maximize();
    }
}
    public static WebDriver getDriver() {
        return tlDriver.get();
        
    }

    public static void quitDriver() {
        if (tlDriver.get() != null) {
            tlDriver.get().quit();
            tlDriver.remove();
        }
    }
}