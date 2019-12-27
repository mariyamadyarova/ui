package interfaces;

import Impl.SearchResultImpl;

public interface ISearchResult {

    void clickResultIndex(int i);

    boolean isFlightIncluded();

    boolean isOwnTransportArranged();

    ISearchResult selectAirport(String airport);

    ISearchResult selectBoardType(String board);
}
