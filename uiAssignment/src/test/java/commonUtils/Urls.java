package commonUtils;

import org.apache.log4j.Logger;

public class Urls {

    private static Urls url = null;
    private static final Logger LOGGER = Logger.getLogger(Urls.class);

    private Urls() {
    }

    public static Urls getInstance() {
        if (url == null) {
            url = new Urls();
        }
        return url;
    }

    public void openUrl(String url) {
        LOGGER.info("Opening url: " + url);
        Setup.browser.get(url);
    }

    public void openBaseUrl() {
        String url = Setup.baseUrl;
        LOGGER.info("Opening base url: " + url);
        Setup.browser.get(url);
    }

    public void closeBrowser() {
        LOGGER.info("Closing browser");
        Setup.browser.close();
    }

    public void refreshBrowser() {
        LOGGER.info("Refreshing browser");
        Setup.browser.navigate().refresh();
    }


}
