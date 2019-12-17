package tests;

import commonUtils.Setup;
import commonUtils.Urls;
import commonUtils.Utils;
import enums.Buttons;
import enums.TextFields;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.*;
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

    @DisplayName("Test login functionality")
    @Test
    public void testLogin() {
        empUtil.doSuccessfullLogin();
        assertTrue("User is not logged in", utils.element(CREATE_BUTTON).isDisplayed());
    }

    @DisplayName("Test that wrong credentials gives login error")
    @Test
    public void checkLoginError() {
        empUtil.setTextField(TextFields.username,"Luke")
                .setTextField(TextFields.password,"wrong")
                .clickButton(Buttons.login);
        assertTrue("Unsuccessful login is not displaying error",empUtil.isLoginErrorAppear());
    }

    @DisplayName("Test that empty credentials gives login error")
    @Test
    public void testLoginWithEmptyCredentials() {
        empUtil.setTextField(TextFields.username,"Luke").clickButton(Buttons.login);
        assertTrue("User is not getting error info tip ", utils.element(INVALID_FIELD).isDisplayed());
    }

    @DisplayName("Test logout functionality")
    @Test
    public void testLogout() {
        empUtil.doSuccessfullLogin();
        assertTrue("User is not logged in", utils.element(CREATE_BUTTON).isDisplayed());
        empUtil.clickButton(Buttons.logout);
        assertTrue("User is not logged out", utils.element(USERNAME_FIELD).isDisplayed());
    }
}
