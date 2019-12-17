package tests;

import commonUtils.Setup;
import commonUtils.Urls;
import enums.Buttons;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.*;
import projectUtils.EmployeeUtils;
import static org.junit.Assert.assertTrue;

public class TestEmpDelete {

    static EmployeeUtils empUtil = new EmployeeUtils();
    private static final Logger LOGGER = Logger.getLogger(TestEmpDelete.class);
    static Urls url = Urls.getInstance();
    String empCreated;

    @BeforeAll
    public static void setup() {
        LOGGER.info("Setting up environment");
        new Setup();
        url.openBaseUrl();
        empUtil.doSuccessfullLogin();
    }

    @AfterAll
    public static void teardown() {
        Setup.browser.quit();
    }

    @DisplayName("Test that deleting employee is successful")
    @Test
    public void testDeleteEmployee() {
        empUtil.clickButton(Buttons.create);
        empCreated = empUtil.createRandomEmployee();
        empUtil.deleteEmployee(empCreated);
        assertTrue("Employee is not deleted", !empUtil.isEmployeeExist(empCreated));

    }
}
