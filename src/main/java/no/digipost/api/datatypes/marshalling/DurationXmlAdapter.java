package no.digipost.api.datatypes.marshalling;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.Duration;

public class DurationXmlAdapter extends XmlAdapter<String, Duration> {


    @Override
    public Duration unmarshal(String s) {
        if (s == null) {
            return null;
        }
        return Duration.parse(s);
    }

    @Override
    public String marshal(Duration duration) {
        if (duration == null) {
            return null;
        }
        return duration.toString();
    }
}
