package commonUtils;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Utils {

    private static final Logger LOGGER = Logger.getLogger(Urls.class);

        public boolean waitUntilForCSSorXpath(String cssOrXpath, long timeOutInSecs) {

            final boolean[] bFound = new boolean[1];
            String script = getScriptToExecute(cssOrXpath);

            try {
                new FluentWait<>(cssOrXpath).withTimeout(timeOutInSecs, TimeUnit.SECONDS)
                        .ignoring(org.openqa.selenium.TimeoutException.class).ignoring(StaleElementReferenceException.class)
                        .pollingEvery(500, TimeUnit.MILLISECONDS).until(input -> {
                    Object obj = getJavaScriptExecutor().executeScript(script);
                    bFound[0] = obj != null;
                    return bFound[0];
                });
                return bFound[0];
            } catch (TimeoutException ex) {
                return bFound[0];
            }

        }

    public static JavascriptExecutor getJavaScriptExecutor() {
        increaseScriptTimeout(10);
        return (JavascriptExecutor) Setup.browser;
    }

    public static void increaseScriptTimeout(long duration) {
        Setup.browser.manage().timeouts().setScriptTimeout(duration, TimeUnit.SECONDS);
    }

    private static String getScriptToExecute(String cssOrXpath) {
        String script;
        String escapedCss;
        if (cssOrXpath.startsWith("//")) {
            String nonFormattedScript = "return document.evaluate(\"%s\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue";
            script = String.format(nonFormattedScript, cssOrXpath);
        } else {
            escapedCss = getEscapedCss(cssOrXpath);
            script = "return document.querySelector(\'" + escapedCss + "\')";
        }
        return script;
    }

    public static String getEscapedCss(String css) {
        String escapedCss;
        String temp;
        if (css.contains("=\'")) {
            temp = css.replace("=\'", "=\\\"");
            temp = temp.replace("\']", "\\\"]");
        } else if (css.contains("='")) {
            temp = css.replaceAll("='", "=\\\"");
            temp = temp.replace("']", "\\\"]");
        } else {
            temp = css;
        }
        escapedCss = temp.replaceAll("'", "\\\\'");
        return escapedCss;
    }

    public WebElement element(String cssOrXpath) {
        LOGGER.info("Waiting for element with CSS:" + cssOrXpath);
                if (waitUntilForCSSorXpath(cssOrXpath, 30) == true) {
                    if (cssOrXpath.startsWith("/"))
                        return Setup.browser.findElement(By.xpath(cssOrXpath));
                    else
                        return Setup.browser.findElement(By.cssSelector(cssOrXpath));
                }
            return null;
    }

    public List<WebElement> elements(String cssOrXpath) {
        LOGGER.info("Waiting for elements with CSS:" + cssOrXpath);
        if (waitUntilForCSSorXpath(cssOrXpath, 30) == true) {
            if (cssOrXpath.startsWith("/"))
                return Setup.browser.findElements(By.xpath(cssOrXpath));
            else
                return Setup.browser.findElements(By.cssSelector(cssOrXpath));
        }
        return null;
    }

    public void mouseclickJS(WebElement element) {
        ((JavascriptExecutor) Setup.browser).executeScript("arguments[0].click();", element);
    }

    public void setDropDownValueByText(WebElement element, String value) {
            new Select(element).selectByValue(value);
    }

    public void setDropDownValueByValue(WebElement element, String value) {
        new Select(element).selectByValue(value);
    }

    public boolean waitUntilNotExistCSSorXpath(String cssOrXpath, long timeOutInSecs) {
       LOGGER.info("Waiting for element with CSS to be present:" + cssOrXpath);
            waitUntilForCSSorXpath(cssOrXpath, 30);

            final boolean[] bFound = new boolean[1];
            String script = getScriptToExecute(cssOrXpath);

            try {
                new FluentWait<>(cssOrXpath).withTimeout(timeOutInSecs, TimeUnit.SECONDS)
                        .ignoring(org.openqa.selenium.TimeoutException.class).ignoring(StaleElementReferenceException.class)
                        .pollingEvery(500, TimeUnit.MILLISECONDS).until(input -> {
                    Object obj = getJavaScriptExecutor().executeScript(script);
                    bFound[0] = obj == null;
                    return bFound[0];
                });
                return bFound[0];
            } catch (TimeoutException ex) {
                return bFound[0];
            }

    }
}
