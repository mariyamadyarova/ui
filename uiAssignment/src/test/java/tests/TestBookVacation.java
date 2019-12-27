package tests;

import Impl.*;
import commonUtils.Setup;
import commonUtils.Urls;
import enums.Country;
import enums.Months;
import enums.PassangerDetails;
import enums.Vertical;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class TestBookVacation {

    static VerticalImpl vertical = new VerticalImpl();
    SearchImpl search = new SearchImpl();
    SearchResultImpl result = new SearchResultImpl();
    DetailsImpl details = new DetailsImpl();
    PassangerDetailImpl passangerDetail = new PassangerDetailImpl();
    OverviewPaymentImpl overviewPayment = new OverviewPaymentImpl();
    static Urls url = Urls.getInstance();

    @BeforeAll
    public static void setup() {
        new Setup();
        url.openBaseUrl();
        vertical.acceptCookie();
    }

    @AfterAll
    public static void tearDown() {
        url.closeBrowser();
    }

    @Test
    public void bookSunVacation() {

        String bookingPrice;

        vertical.selectVertical(Vertical.sun);
        search.selectDestination(Country.Spanje).selectDate(Months.juni,30).selectDuration(2).clickSearch();

        Assertions.assertEquals(result.isFlightIncluded(), true);
        result.selectAirport("Schiphol").selectBoardType("All inclusive");
                result.clickResultIndex(1);

        bookingPrice = details.clickCheckPrice().getBookingPrice();
        details.clickBookNow();
        passangerDetail.selectSalutation(1,true)
                .setFieldText(1,PassangerDetails.firstname,"Jan")
                .setFieldText(1,PassangerDetails.lastname,"Visser")
                .setDOB(1,10,10,1972)

                .selectSalutation(2,false)
                .setFieldText(2,PassangerDetails.firstname,"Mirjam")
                .setFieldText(2,PassangerDetails.lastname,"Visser")
                .setDOB(2,3,4,1975)

                .setFieldText(0,PassangerDetails.bookerEmail,"jan.visser.dummy@gmail.com")
                .setFieldText(0, PassangerDetails.bookerHouseNo, "23")
                .setFieldText(0, PassangerDetails.bookerPostCode, "1852TB")
                .setFieldText(0, PassangerDetails.bookerTelNo, "0612345678")

                .setFieldText(0, PassangerDetails.emergencyName, "Fam. Visser")
                .setFieldText(0, PassangerDetails.emergencyTelNo, "0612345687")

                .clickNextButton()
                .verifyDetails().clickVerifyDetailsOK();

        passangerDetail.waitForModalToDisappear().clickNextButton();
        Assertions.assertEquals(bookingPrice, overviewPayment.getBookingPriceToPay());

    }
}
