package interfaces;

import Impl.FormImpl;
import enums.Buttons;
import enums.TextFields;
import org.openqa.selenium.WebElement;

public interface IForm {

    FormImpl setTextField(TextFields field, String value);

    void clickButton(Buttons button);

    void alertOK();

    void alertCancel();

    void doubleClick(WebElement element);

}
