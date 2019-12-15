package commonUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Setup {

    public static WebDriver browser;
    public static String baseUrl;
    Properties props = new Properties();
    InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties");

    public Setup() {
        String client = getProperty("browser");
        String path = System.getProperty("user.dir");
        baseUrl = getProperty("baseUrl");
        switch (client) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", path + "/src/test/resources/chromedriver");
                browser = new ChromeDriver();
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver", path + "/src/test/resources/geckodriver");
                DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                capabilities.setCapability("marionette", true);
                browser = new FirefoxDriver(capabilities);
                break;
        }
    }

    private String getProperty(String property) {
        try {
            props.load(input);
        }
        catch (IOException e) {
            e.getMessage();
        }
        return props.getProperty(property);
    }

}
