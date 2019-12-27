package Impl;

import commonUtils.Utils;
import interfaces.ILocators;
import interfaces.ISearchResult;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultImpl implements ISearchResult, ILocators {

    Utils utils = new Utils();

    @Override
    public void clickResultIndex(int i) {
        String resultCss = String.format(".search-results-list .search-result:nth-child(%s) a:nth-child(2)", i);
        utils.mouseclickJS(utils.element(resultCss));
    }

    @Override
    public boolean isFlightIncluded() {
        return utils.element(FLIGHT_INCLUDED).isDisplayed();
    }

    @Override
    public boolean isOwnTransportArranged() {
        return false;
    }

    @Override
    public SearchResultImpl selectAirport(String airport) {
        List<WebElement> options = utils.elements(AIRPORT_OPTION);
        for (int index = 0; index < options.size(); index ++) {
            if(options.get(index).getText().contains(airport)) {
                utils.mouseclickJS(utils.element(AIRPORT_OPTION + "[" + (index + 1) + "]/label/input"));
                break;
            }
        }
        return this;
    }

    @Override
    public SearchResultImpl selectBoardType(String board) {
        List<WebElement> options = utils.elements(BOARD_OPTION);
        for (int index = 0; index < options.size(); index ++) {
            if(options.get(index).getText().contains(board)) {
                utils.mouseclickJS(utils.element(BOARD_OPTION + "[" + (index + 1) + "]/label/input"));
                break;
            }
        }
        return this;
    }
}
