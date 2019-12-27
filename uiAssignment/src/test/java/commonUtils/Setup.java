package commonUtils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Setup {

    public static WebDriver browser;
    public static String baseUrl;
    Properties props = new Properties();
    InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties");

    public Setup() {

        baseUrl = getProperty("baseUrl");

        switch (getProperty("browser")) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                browser = new ChromeDriver();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                browser = new FirefoxDriver();
                break;

                // It can be extended further to many more browsers

            default:
                if(System.getProperty("os.name").startsWith("win")) {
                    WebDriverManager.iedriver().setup();
                    browser = new InternetExplorerDriver();
                }
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
