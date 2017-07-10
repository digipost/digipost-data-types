package no.digipost.api.datatypes.types;

import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlEnum
@Description("DocumentType is a way to specify which kind of data a document is related to.")
public enum DocumentType implements DataType {
    RESIDENCE;

    public static DocumentType EXAMPLE = DocumentType.RESIDENCE;
}
