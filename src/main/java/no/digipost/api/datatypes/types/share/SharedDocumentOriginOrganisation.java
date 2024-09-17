package no.digipost.api.datatypes.types.share;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;
import no.digipost.api.datatypes.documentation.Description;

@XmlType
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@With
@Description("Origin of shared document is an organisation")
public class SharedDocumentOriginOrganisation {

    @XmlAttribute(name = "organisation-number", required = true)
    String organisationNumber;
    @XmlAttribute(name = "name", required = true)
    String name;

    public static final SharedDocumentOriginOrganisation EXAMPLE = new SharedDocumentOriginOrganisation(
            "984661185",
            "Posten Bring AS"
    );

}
