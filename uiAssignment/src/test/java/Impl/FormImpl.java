package Impl;

import commonUtils.Setup;
import commonUtils.Utils;
import enums.Buttons;
import enums.TextFields;
import interfaces.IForm;
import interfaces.ILocators;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FormImpl implements IForm, ILocators {

    Utils utils = new Utils();
    private static final Logger LOGGER = Logger.getLogger(FormImpl.class);

    @Override
    public FormImpl setTextField(TextFields field, String value) {
        String textFieldCss = "";

        switch (field) {
            case username: textFieldCss = USERNAME_FIELD; break;
            case password: textFieldCss = PASSWORD_FIELD; break;
            case firstname: textFieldCss = FIRSTNAME_FIELD; break;
            case lastname: textFieldCss = LASTNAME_FIELD; break;
            case startdate: textFieldCss = STARTDATE_FIELD; break;
            case email: textFieldCss = EMAIL_FIELD; break;
            default:
        }
            utils.element(textFieldCss).clear();
            LOGGER.info("Setting textfield " + field.toString() + " with value: " + value);
            utils.element(textFieldCss).sendKeys(value);
        return this;
    }


    @Override
    public void clickButton(Buttons button) {
        String buttonCss = "";
        switch (button) {
            case create: buttonCss = CREATE_BUTTON; break;
            case edit: buttonCss = EDIT_BUTTON; break;
            case deleteOnHomePage: buttonCss = DELETE_BUTTON_HOME; break;
            case add: buttonCss = ADD_BUTTON; break;
            case update: buttonCss = UPDATE_BUTTON; break;
            case deleteOnEditPage: buttonCss = DELETE_BUTTON_EDIT; break;
            case back: buttonCss = BACK_BUTTON; break;
            case cancel: buttonCss = CANCEL_BUTTON; break;
            case logout: buttonCss = LOGOUT_BUTTON; break;
            case login : buttonCss = LOGIN_BUTTON; break;
            default:
        }

        LOGGER.info("Clicking button " + button.toString());
        utils.element(buttonCss).click();
    }

    @Override
    public void alertOK() {
        LOGGER.info("Clicking OK on alert window");
        Alert alert = Setup.browser.switchTo().alert();
        alert.accept();
    }

    @Override
    public void alertCancel() {
        LOGGER.info("Clicking cancel on alert window");
        Alert alert = Setup.browser.switchTo().alert();
        alert.dismiss();
    }

    @Override
    public void doubleClick(WebElement element) {
        LOGGER.info("Double click on element");
        new Actions(Setup.browser).doubleClick(element).perform();
    }


}
