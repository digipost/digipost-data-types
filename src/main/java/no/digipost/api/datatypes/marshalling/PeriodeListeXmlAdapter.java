package no.digipost.api.datatypes.marshalling;

import no.digipost.api.datatypes.types.bevis.AaligRepeterendePeriode;
import no.digipost.api.datatypes.types.bevis.Periode;
import no.digipost.api.datatypes.types.bevis.PeriodeListe;
import no.digipost.api.datatypes.types.bevis.TidsPeriode;

import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.GregorianCalendar;

public class PeriodeListeXmlAdapter {
    /*
    @Override
    public String marshal(PeriodeListe v) {
        if (v == null) {
            return null;
        }

        StringBuilder xml = new StringBuilder();

        for (TidsPeriode tidsPeriode : v.getPeriodeListe()) {
            if (Periode.class.isAssignableFrom(tidsPeriode.getClass())) {
                xml.append(DatatypeConverter.printDateTime(GregorianCalendar.from(((Periode)tidsPeriode).)));
            } else if (AaligRepeterendePeriode.class.isAssignableFrom(tidsPeriode.getClass())) {
            }
        }

        return xml.toString();
    }

    @Override
    public PeriodeListe unmarshal(final String s) {
        if (s == null) {
            return null;
        }
        return ZonedDateTime.from(DateTimeFormatter.ISO_DATE_TIME.parse(s)).withZoneSameInstant(ZoneId.systemDefault());
    }
    */
}
