package interfaces;

import Impl.PassangerDetailImpl;
import enums.Months;
import enums.PassangerDetails;

public interface IPassangerDetail {

    PassangerDetailImpl setFieldText(int PassangerIndex, PassangerDetails field, String value);

    PassangerDetailImpl selectSalutation(int passangerIndex, boolean salutation);
    PassangerDetailImpl setDOB(int passangerIndex, int day, int month, int year);
    PassangerDetailImpl selectNationality(int passangerIndex, String nationality);
    PassangerDetailImpl clickNextButton();
    PassangerDetailImpl verifyDetails();
    void clickVerifyDetailsOK();

}
