package interfaces;

import Impl.SearchImpl;
import enums.Country;
import enums.Months;

public interface ISearch {

    SearchImpl selectDestination(Country country);
    SearchImpl selectDate(Months month, int date);
    SearchImpl selectDuration(int i);
    SearchImpl selectFlexibleOption();
    void clickSearch();
}
