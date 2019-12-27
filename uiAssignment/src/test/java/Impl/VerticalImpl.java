package Impl;

import commonUtils.Utils;
import enums.Country;
import enums.Vertical;
import interfaces.ILocators;
import interfaces.IVertical;
import org.apache.log4j.Logger;

public class VerticalImpl implements IVertical, ILocators {

    Utils utils = new Utils();
    private static final Logger LOGGER = Logger.getLogger(VerticalImpl.class);

    @Override
    public void selectCountry(Country country) {

    }

    @Override
    public void selectVertical(Vertical vertical) {
        LOGGER.info("Selecting vertical " + vertical.toString());
        String css = VERTICALS + "." + vertical.toString();
        utils.element(css).click();
    }

    @Override
    public void clickInfoToolTip() {

    }

    @Override
    public void assertStartingPriceRange() {

    }

    public void acceptCookie() {
        utils.element(COOKIE_WINDOW).click();
    }
}
