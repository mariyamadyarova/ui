package interfaces;

public interface ILocators {
    String VERTICALS = ".vertical";
    String DESTIN_DROPDOWN = "#select-destination";
    String COOKIE_WINDOW = ".cookiebar button";
    String CALENDAR = ".travel-date";
    String MONTH_DROPDOWN = ".has-future";
    String DURATION = "#select-duration";
    String SEARCH_BUTTON = ".box-submit";

    String FLIGHT_INCLUDED = ".active.transport-arranged";
    String AIRPORT_OPTION = "//section[@class='filter-option'][2]/ul/li";
    String BOARD_OPTION = "//section[@class='filter-option'][5]/ul/li";

    String CHECK_PRICE_BUTTON = ".details .main a";
    String BOOK_BUTTON = "#offer-receipt-bookbutton";
    String BOOKING_PRICE = ".price.no-marker .price-number";

    String BOOKER_EMAIL = ".passenger-01-contact-info [name$=email]";
    String BOOKER_TEL = ".passenger-01-contact-info [name$=primary]";
    String BOOKER_POSTCODE = ".passenger-01-contact-info [name$=postcode]";
    String BOOKER_HOUSENO = ".passenger-01-contact-info [name$=number]";
    String EMERGENCY_NAME = ".stay-emergency-contact-info [name$=name]";
    String EMERGENCY_EMAIL = ".stay-emergency-contact-info [name$=email]";
    String EMERGENCY_TEL = ".stay-emergency-contact-info [name$=tel]";

    String NEXT_STEP_BUTTON = ".booking-footer .btn--theme--primary";

    String VERIFY_CHECKBOX = ".options-list__input";
    String VERIFY_BUTTON = ".btn--theme--primary.btn--large";
    String PROCESSING_MODAL = "modal__dimmer";
    String BOOKING_PRICE_PAY = "//td[@class='rowtotal']//span[@class='price-block__amount']/span[1]";
}
