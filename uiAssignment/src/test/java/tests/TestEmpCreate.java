package tests;

import commonUtils.Setup;
import commonUtils.Urls;
import commonUtils.Utils;
import enums.Buttons;
import enums.TextFields;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.*;
import projectUtils.EmployeeUtils;

import static interfaces.ILocators.INVALID_FIELD;
import static org.junit.Assert.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestEmpCreate {

    private static final Logger LOGGER = Logger.getLogger(TestEmpCreate.class);
    static EmployeeUtils empUtil = new EmployeeUtils();
    static Utils utils = new Utils();
    static Urls url = Urls.getInstance();


    @BeforeAll
    public static void envSetup() {
        LOGGER.info("Setting up environment");
        new Setup();
    }

    @BeforeEach
    public void testSetup() {
        LOGGER.info("TestSetUp Started : Opening base url and login");
        url.openBaseUrl();
        empUtil.doSuccessfullLogin();
    }

    @AfterEach
    public void testCleanup() {
        empUtil.clickButton(Buttons.logout);
    }

    @AfterAll
    public static void teardown() {
        Setup.browser.quit();
    }

    @DisplayName("Test that creating employee is successful")
    @Order(1)
    @Test
    public void testCreateEmployee() {
        empUtil.clickButton(Buttons.create);
        empUtil.createEmployee("testfirst", "testlast", "2019-12-12", "test@test.com");
        assertTrue("created employee doesn't exist",empUtil.isEmployeeExist("testfirst testlast"));
    }


    @DisplayName("Test that creating employee with invalid email is unsuccessful")
    @Order(2)
    @Test
    public void testInvalidEmail() {
        empUtil.clickButton(Buttons.create);
        empUtil.createEmployee("testfirst", "testlast", "2019-12-12", "wrongemail");
        assertTrue("", utils.element(INVALID_FIELD).isDisplayed());
    }

    @DisplayName("Test that creating employee with invalid start date is unsuccessful")
    @Order(3)
    @Test
    public void testInvalidStartDate() {
        empUtil.clickButton(Buttons.create);
        empUtil.setTextField(TextFields.startdate,"12-12-2019");
        assertTrue("", utils.element(INVALID_FIELD).isDisplayed());
    }
}
