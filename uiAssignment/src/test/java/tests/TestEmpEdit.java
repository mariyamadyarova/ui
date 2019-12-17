package tests;

import commonUtils.Setup;
import commonUtils.Urls;
import commonUtils.Utils;
import enums.Buttons;
import enums.TextFields;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.*;
import projectUtils.EmployeeUtils;

import static interfaces.ILocators.EMAIL_FIELD;
import static interfaces.ILocators.UPDATE_BUTTON;
import static org.junit.Assert.assertTrue;

public class TestEmpEdit {

    static EmployeeUtils empUtil = new EmployeeUtils();
    private static final Logger LOGGER = Logger.getLogger(TestEmpCreate.class);
    static Utils utils = new Utils();
    static Urls url = Urls.getInstance();
    String empCreated;

    @BeforeAll
    public static void envSetup() {
        LOGGER.info("Setting up environment");
        new Setup();
    }

    @BeforeEach
    public void testSetup() {
        url.openBaseUrl();
        empUtil.doSuccessfullLogin();
        empCreated = empUtil.createRandomEmployee();
    }

    @AfterEach
    public void cleanTestData() {
        empUtil.deleteEmployee(empCreated);
        empUtil.clickButton(Buttons.logout);
    }

    @AfterAll
    public static void teardown() {
        Setup.browser.quit();
    }

    @DisplayName("Test that editing employee's name is successful")
    @Test
    public void testEditEmployeeName() {
        String changedLastName = "LastName" + RandomStringUtils.randomAlphabetic(3);
        empUtil.selectEmployee(empCreated).clickButton(Buttons.edit);
        empUtil.setTextField(TextFields.lastname,changedLastName).clickButton(Buttons.update);
        assertTrue("Employee is not edited", empUtil.isEmployeeExist(changedLastName));
    }

    @DisplayName("Test that editing employee's email is successful")
    @Test
    public void testEditEmail() {
        String changedText = "changed@email.com";
        empUtil.selectEmployee(empCreated).clickButton(Buttons.edit);
        empUtil.setTextField(TextFields.email,changedText).clickButton(Buttons.update);
        empUtil.selectEmployee(empCreated).clickButton(Buttons.edit);
        assertTrue("Employee is not edited", utils.element(EMAIL_FIELD).getAttribute("value").equals(changedText));
    }

    @DisplayName("Test that employee can be edited by double clicking")
    @Test
    public void testEditOnDoubleClick() {
        empUtil.selectEmployeeByDoubleClick(empCreated);
        assertTrue("Edit form is not open", utils.element(UPDATE_BUTTON).isDisplayed());
    }
}
