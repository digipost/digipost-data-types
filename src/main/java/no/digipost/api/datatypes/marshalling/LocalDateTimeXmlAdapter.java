package no.digipost.api.datatypes.marshalling;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeXmlAdapter extends XmlAdapter<String, LocalDateTime> {
    @Override
    public String marshal(LocalDateTime v) {
        if (v == null) {
            return null;
        }
        return v.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    @Override
    public LocalDateTime unmarshal(final String s) {
        if (s == null) {
            return null;
        }
        return LocalDateTime.from(DateTimeFormatter.ISO_DATE_TIME.parse(s));
    }

}
