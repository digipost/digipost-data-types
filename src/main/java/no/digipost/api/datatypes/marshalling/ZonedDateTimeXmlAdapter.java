package no.digipost.api.datatypes.marshalling;

import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
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
        return ZonedDateTime.from(DateTimeFormatter.ISO_DATE_TIME.parse(s)).withZoneSameInstant(ZoneId.systemDefault());
    }

}
