package no.digipost.api.datatypes.types.proof;


import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class TimePeriodTest {

    @Test
    void period_fra_til() {
        TimePeriod period = new Period(
                ZonedDateTime.of(2019, 8, 1, 0, 0, 0, 0, ZoneId.of("+01:00")),
                ZonedDateTime.of(2022, 8, 1, 0, 0, 0, 0, ZoneId.of("+01:00"))
        );

        assertThat(period.getISO8601(), equalTo("2019-08-01T00:00+01:00/2022-08-01T00:00+01:00"));
    }

    @Test
    void period_fra() {
        TimePeriod period = new Period(
                ZonedDateTime.of(2019, 8, 1, 0, 0, 0, 0, ZoneId.of("+01:00")),
                null
        );

        assertThat(period.getISO8601(), equalTo("2019-08-01T00:00+01:00/.."));
    }

    @Test
    void period_til() {
        TimePeriod period = new Period(
                null,
                ZonedDateTime.of(2022, 8, 1, 0, 0, 0, 0, ZoneId.of("+01:00"))
        );

        assertThat(period.getISO8601(), equalTo("../2022-08-01T00:00+01:00"));
    }

    @Test
    void period() {
        TimePeriod period = new Period(
                null,
                null
        );

        assertThat(period.getISO8601(), containsString("../.."));
    }

    @Test
    void repeating_fra_til() {
        TimePeriod period = new YearlyRepeatingPeriod(
                2019, 2022
                , new CalendarDate(5, 1, 0, 0, "+01:00")
                , new CalendarDate(10, 1, 0, 0, "+01:00")
        );

        assertThat(period.getISO8601(), equalTo("R/2019-05-01T00:00+01:00/2022-10-01T00:00+01:00"));
    }

    @Test
    void repeating_fra() {
        TimePeriod period = new YearlyRepeatingPeriod(
                null, 2022
                , new CalendarDate(5, 1, 0, 0, "+01:00")
                , new CalendarDate(10, 1, 0, 0, "+01:00")
        );

        assertThat(period.getISO8601(), equalTo("R/05-01T00:00+01:00/2022-10-01T00:00+01:00"));
    }

    @Test
    void repeating_to() {
        TimePeriod period = new YearlyRepeatingPeriod(
                2019, null
                , new CalendarDate(5, 1, 0, 0, "+01:00")
                , new CalendarDate(10, 1, 0, 0, "+01:00")
        );

        assertThat(period.getISO8601(), equalTo("R/2019-05-01T00:00+01:00/10-01T00:00+01:00"));
    }

    @Test
    void repeating() {
        TimePeriod period = new YearlyRepeatingPeriod(
                null, null
                , new CalendarDate(5, 1, 0, 0, "+01:00")
                , new CalendarDate(10, 1, 0, 0, "+01:00")
        );

        assertThat(period.getISO8601(), equalTo("R/05-01T00:00+01:00/10-01T00:00+01:00"));
    }
}
