package Impl;

import commonUtils.Utils;
import interfaces.ILocators;
import interfaces.IOverviewPayment;

public class OverviewPaymentImpl implements IOverviewPayment, ILocators {

    Utils utils = new Utils();


    @Override
    public String getBookingPriceToPay() {
        return utils.element(BOOKING_PRICE_PAY).getText();
    }
}
