package interfaces;

public interface ILocators {

    String USERNAME_FIELD = "#login-form fieldset label:nth-child(3) input";
    String PASSWORD_FIELD = "#login-form fieldset label:nth-child(4) input";
    String LOGIN_BUTTON = "#login-form fieldset button";
    String LOGIN_ERROR = "#login-form .error-message";
    String INVALID_FIELD = ".ng-invalid";

    String LOGGED_USERNAME = "#greetings";
    String LOGOUT_BUTTON = ".header-container .main-button";
    String CREATE_BUTTON = "#bAdd";
    String EDIT_BUTTON = "#bEdit";
    String DELETE_BUTTON_HOME = "#bDelete";

    String FIRSTNAME_FIELD = "//fieldset/label[1]/input";
    String LASTNAME_FIELD = "//fieldset/label[2]/input";
    String STARTDATE_FIELD = "//fieldset/label[3]/input";
    String EMAIL_FIELD = "//fieldset/label[4]/input";
    String CANCEL_BUTTON = ".bCancel";
    String ADD_BUTTON = ".formFooter .main-button:nth-child(2)";
    String UPDATE_BUTTON = ".formFooter .main-button:nth-child(1)";
    String BACK_BUTTON = ".bBack";
    String DELETE_BUTTON_EDIT = ".formFooter .main-button:nth-child(3)";
    String DELETE_BUTTON_EDIT_DISABLED = ".formFooter .main-button:nth-child(3).ng-hide";
 }
