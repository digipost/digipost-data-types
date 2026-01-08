package no.digipost.api.datatypes.marshalling;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateXmlAdapter extends XmlAdapter<String, LocalDate> {
    @Override
    public LocalDate unmarshal(String s) {
        if (s == null) {
            return null;
        }
        return LocalDate.from(DateTimeFormatter.ISO_LOCAL_DATE.parse(s));
    }
    @Override
    public String marshal(LocalDate v) {
        if (v == null) {
            return null;
        }
        return v.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}

