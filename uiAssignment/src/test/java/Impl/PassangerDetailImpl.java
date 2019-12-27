package Impl;

import commonUtils.Utils;
import enums.PassangerDetails;
import interfaces.ILocators;
import interfaces.IPassangerDetail;

public class PassangerDetailImpl implements IPassangerDetail, ILocators {

    Utils utils = new Utils();

    @Override
    public PassangerDetailImpl setFieldText(int PassangerIndex, PassangerDetails field, String value) {
        utils.element(getFieldCss(PassangerIndex, field)).sendKeys(value);
        return this;
    }

    private String getFieldCss(int index, PassangerDetails field) {
        switch (field) {
            case firstname: return String.format("//form[%s]//input[contains(@name,'first')]", index);
            case lastname: return String.format("//form[%s]//input[contains(@name,'last')]", index);
            case bookerEmail: return BOOKER_EMAIL;
            case bookerTelNo: return BOOKER_TEL;
            case bookerHouseNo: return BOOKER_HOUSENO;
            case bookerPostCode: return BOOKER_POSTCODE;
            case emergencyEmail: return EMERGENCY_EMAIL;
            case emergencyName: return EMERGENCY_NAME;
            case emergencyTelNo: return EMERGENCY_TEL;
            default: return null;
        }
    }

    @Override
    public PassangerDetailImpl selectSalutation(int passangerIndex, boolean IsMale) {
        String salutationCss;
        if(IsMale == true)
            salutationCss  = String.format("//form[%s]//input[@value='M']", passangerIndex);
        else
            salutationCss = String.format("//form[%s]//input[@value='F']", passangerIndex);

        utils.mouseclickJS(utils.element(salutationCss));
        return this;
    }

    @Override
    public PassangerDetailImpl setDOB(int passangerIndex, int day, int month, int year) {
        String dayCss = String.format("//form[%s]//select[contains(@name,'-1')]",passangerIndex);
        utils.setDropDownValueByText(utils.element(dayCss), String.valueOf(day));
        String monthCss = String.format("//form[%s]//select[contains(@name,'-2')]",passangerIndex);
        utils.setDropDownValueByValue(utils.element(monthCss), String.valueOf(month-1));
        String yearCss = String.format("//form[%s]//select[contains(@name,'-3')]",passangerIndex);
        utils.setDropDownValueByText(utils.element(yearCss), String.valueOf(year));
        return this;
    }

    @Override
    public PassangerDetailImpl selectNationality(int passangerIndex, String nationality) {
        return null;
    }


    @Override
    public PassangerDetailImpl clickNextButton() {
        utils.mouseclickJS(utils.element(NEXT_STEP_BUTTON));
        return this;
    }

    @Override
    public PassangerDetailImpl verifyDetails() {
        utils.elements(VERIFY_CHECKBOX).stream().forEach(element -> utils.mouseclickJS(element));
        return this;
    }

    @Override
    public void clickVerifyDetailsOK() {
        utils.element(VERIFY_BUTTON).click();
    }

    public PassangerDetailImpl waitForModalToDisappear() {
        utils.waitUntilNotExistCSSorXpath(PROCESSING_MODAL,30);
        return this;
    }
}
