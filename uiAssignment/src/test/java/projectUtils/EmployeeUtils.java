package projectUtils;

import Impl.FormImpl;
import commonUtils.Utils;
import enums.Buttons;
import enums.TextFields;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EmployeeUtils extends FormImpl {

    Utils utils = new Utils();
    private static final Logger LOGGER = Logger.getLogger(EmployeeUtils.class);

    public EmployeeUtils doSuccessfullLogin() {
        LOGGER.info("Logging with valid credentials");
        setTextField(TextFields.username,"Luke")
                .setTextField(TextFields.password,"Skywalker")
                .clickButton(Buttons.login);
        return this;
    }

    public boolean isLoginErrorAppear() {
        return utils.element(LOGIN_ERROR).isEnabled();
    }

    public EmployeeUtils selectEmployee(String employee) {
        LOGGER.info("Selecting employee: " + employee);
        String css = String.format("//li[contains(text(),\'%s\')]",employee);
        utils.element(css).click();
        return this;
    }

    public void selectEmployeeByDoubleClick(String employee) {
        LOGGER.info("Selecting employee: " + employee);
        String css = String.format("//li[contains(text(),\'%s\')]",employee);
        doubleClick(utils.element(css));
    }

    public boolean isEmployeeExist(String employee) {
        LOGGER.info("Checking if employee present:" + employee);
        String css = String.format("//li[contains(text(),\'%s\')]",employee);
        try{
            return utils.element(css).isDisplayed();
        }
        catch (NullPointerException e) { return false; }
    }

    public String createRandomEmployee() {
        LOGGER.info("Creating employee with random details");
        clickButton(Buttons.create);
        String firstName = "TestFirstname"+ RandomStringUtils.randomAlphabetic(3);
        setTextField(TextFields.firstname,firstName)
                .setTextField(TextFields.lastname,"TestLastname"+ RandomStringUtils.randomAlphabetic(3))
                .setTextField(TextFields.startdate, new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
                .setTextField(TextFields.email,"test@test.com")
                .clickButton(Buttons.add);
        return firstName;
    }

    public void deleteEmployee(String employee) {
        LOGGER.info("Deleting employee: " + employee);
        if(utils.element(DELETE_BUTTON_EDIT_DISABLED)==null)
            if(utils.element(DELETE_BUTTON_EDIT)!=null)
                clickButton(Buttons.back);
        selectEmployee(employee);
        clickButton(Buttons.deleteOnHomePage);
        alertOK();
        selectEmployee(employee).clickButton(Buttons.edit);
        clickButton(Buttons.back);
    }

    public void createEmployee(String firstname, String lastname, String startDate, String email) {
        LOGGER.info("Creating employee with details as parameter");
        setTextField(TextFields.firstname,firstname)
                .setTextField(TextFields.lastname,lastname)
                .setTextField(TextFields.startdate, startDate)
                .setTextField(TextFields.email,email)
                .clickButton(Buttons.add);
    }

    public void editEmployee(String fullname, String firstname, String lastname, String startDate, String email) {
        LOGGER.info("Editing employee: " + fullname);
        selectEmployee(fullname);
        clickButton(Buttons.edit);
        if(firstname !=null) setTextField(TextFields.firstname, firstname);

        if(lastname !=null) setTextField(TextFields.lastname, lastname);

        if(startDate !=null) setTextField(TextFields.startdate, startDate);

        if(email !=null) setTextField(TextFields.email, email);

        clickButton(Buttons.update);
    }
}
