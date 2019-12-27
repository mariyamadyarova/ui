package interfaces;

import enums.Country;
import enums.Vertical;

public interface IVertical {

    void selectCountry(Country country);
    void selectVertical(Vertical vertical);
    void clickInfoToolTip();
    void assertStartingPriceRange();

}
