package no.digipost.api.datatypes.marshalling;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.time.LocalDate;
public class LocalDateXmlAdapter extends XmlAdapter<String, LocalDate> {
    @Override
    public String marshal(LocalDate v) {
        if (v == null) {
            return null;
        }
        return v.toString();
    }

    @Override
    public LocalDate unmarshal(final String s) {
        if (s == null) {
            return null;
        }
        return LocalDate.parse(s);
    }

}
