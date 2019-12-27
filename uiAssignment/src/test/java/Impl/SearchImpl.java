package Impl;

import commonUtils.Setup;
import commonUtils.Utils;
import enums.Country;
import enums.Months;
import interfaces.ILocators;
import interfaces.ISearch;
import org.openqa.selenium.JavascriptExecutor;

public class SearchImpl implements ISearch, ILocators {

    Utils utils = new Utils();

    @Override
    public SearchImpl selectDestination(Country country) {
        String countryCss = String.format("//ul//a[contains(text(),'%s')]", country.toString());
        utils.element(DESTIN_DROPDOWN).click();
        utils.element(countryCss).click();
        return this;
    }

    @Override
    public SearchImpl selectDate(Months month, int date) {
        utils.element(CALENDAR).click();
        utils.element(MONTH_DROPDOWN).click();
        String monthCss = String.format("//a[contains(text(),'%s')]", month.toString());
        utils.element(monthCss).click();

        String dateCss = String.format("//div[@class='datepicker']/div[3]/span[contains(text(),'%s')]", String.valueOf(date));
        utils.element(dateCss).click();
        return this;
    }

    @Override
    public SearchImpl selectDuration(int i) {
        utils.element(DURATION).click();
        String durationCss = String.format(".duration-list li:nth-child(%s)",i);
        utils.element(durationCss).click();
        return this;
    }

    @Override
    public void clickSearch() {
        ((JavascriptExecutor) Setup.browser).executeScript("arguments[0].style.visibility='hidden'", utils.element("#menudimmer"));
        utils.element(SEARCH_BUTTON).click();
    }

    @Override
    public SearchImpl selectFlexibleOption() {
        return this;
    }
}
