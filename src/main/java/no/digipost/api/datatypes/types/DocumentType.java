package no.digipost.api.datatypes.types;

import no.digipost.api.datatypes.documentation.Description;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlEnum
@Description("DocumentType is a way of specifying which kind of data this document is related to")
public enum DocumentType {
    RESIDENCE;


    public String value() {
        return name();
    }

    public static DocumentType fromValue(String value) {
        return valueOf(value);
    }
}
