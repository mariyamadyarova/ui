package Impl;

import commonUtils.Utils;
import interfaces.IDetails;
import interfaces.ILocators;

public class DetailsImpl implements IDetails, ILocators {

    Utils utils = new Utils();

    @Override
    public DetailsImpl clickCheckPrice() {
        utils.element(CHECK_PRICE_BUTTON).click();
        return this;
    }

    public void clickBookNow() {
        utils.element(BOOK_BUTTON).click();
    }

    public String getBookingPrice() {
        return utils.element(BOOKING_PRICE).getText().split(",")[0];
    }
}
