package no.digipost.api.datatypes.marshalling;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.math.BigDecimal;

import static java.math.BigDecimal.ROUND_HALF_UP;

/**
 * Ensures that all money values has exactly 2 descimals, rounding if neccessary.
 */
public class MoneyBigDecimalXmlAdapter extends XmlAdapter<String, BigDecimal> {
    @Override
    public String marshal(BigDecimal v) {
        if (v == null) {
            return null;
        }
        return v.setScale(2, ROUND_HALF_UP).toString();
    }

    @Override
    public BigDecimal unmarshal(final String s) {
        if (s == null) {
            return null;
        }
        return new BigDecimal(s).setScale(2, ROUND_HALF_UP);
    }

}
