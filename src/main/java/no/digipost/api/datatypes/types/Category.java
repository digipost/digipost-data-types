package no.digipost.api.datatypes.types;

import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlEnum
@Description("Category is a way to specify which category the data of a document is related to.")
public enum Category implements DataType {
    RESIDENCE;

    public static Category EXAMPLE = RESIDENCE;
}
