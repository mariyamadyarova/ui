package tests;

import commonUtils.Setup;
import commonUtils.Urls;
import commonUtils.Utils;
import enums.Buttons;
import enums.TextFields;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectUtils.EmployeeUtils;

import static interfaces.ILocators.*;
import static org.junit.Assert.assertTrue;


public class TestLogin {

    EmployeeUtils empUtil = new EmployeeUtils();
    private static final Logger LOGGER = Logger.getLogger(TestLogin.class);
    static Utils utils = new Utils();
    static Urls url = Urls.getInstance();

    @BeforeAll
    public static void envSetup() {
        LOGGER.info("Setting up environment");
        new Setup();
    }

    @BeforeEach
    public void setup() {
        url.openBaseUrl();
    }

    @AfterAll
    public static void teardown() {
        Setup.browser.quit();
    }

    @Test
    public void checkLoginError() {
        empUtil.setTextField(TextFields.username,"Luke")
                .setTextField(TextFields.password,"wrong")
                .clickButton(Buttons.login);
        assertTrue("Unsuccessful login is not displaying error",empUtil.isLoginErrorAppear());
    }

    @Test
    public void testLoginWithEmptyCredentials() {
        empUtil.setTextField(TextFields.username,"Luke").clickButton(Buttons.login);
        assertTrue("User is not getting error info tip ", utils.element(INVALID_FIELD).isDisplayed());
    }

    @Test
    public void testLogout() {
        empUtil.doSuccessfullLogin();
        assertTrue("User is not logged in", utils.element(CREATE_BUTTON).isDisplayed());
        empUtil.clickButton(Buttons.logout);
        assertTrue("User is not logged out", utils.element(USERNAME_FIELD).isDisplayed());
    }
}
