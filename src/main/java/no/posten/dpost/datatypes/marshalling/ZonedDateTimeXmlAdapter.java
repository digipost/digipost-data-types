package no.posten.dpost.datatypes.marshalling;

import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.ZonedDateTime;
import java.util.Calendar;
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
        Calendar parsed = DatatypeConverter.parseDate(s);
        return ZonedDateTime.ofInstant(parsed.toInstant(), parsed.getTimeZone().toZoneId());
    }

}
