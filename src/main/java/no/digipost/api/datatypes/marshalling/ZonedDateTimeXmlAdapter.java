package no.digipost.api.datatypes.marshalling;

import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.GregorianCalendar;

public class ZonedDateTimeXmlAdapter extends XmlAdapter<String, ZonedDateTime> {
    @Override
    public String marshal(ZonedDateTime v) {
        if (v == null) {
            return null;
        }
        return DatatypeConverter.printDateTime(GregorianCalendar.from(v));
    }

    @Override
    public ZonedDateTime unmarshal(final String s) {
        if (s == null) {
            return null;
        }
        final TemporalAccessor parsed = DateTimeFormatter.ISO_DATE_TIME.parse(s);
        if (parsed.isSupported(ChronoField.OFFSET_SECONDS)) {
            return ZonedDateTime.from(parsed);
        } else {
            return LocalDateTime.from(parsed).atZone(ZoneOffset.UTC);
        }
    }

}
