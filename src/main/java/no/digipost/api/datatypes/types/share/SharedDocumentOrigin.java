package no.digipost.api.datatypes.types.share;

import jakarta.xml.bind.annotation.XmlElement;
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
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@With
@Description("Contains details about a single item (line) on the receipt")
public class SharedDocumentOrigin {

    @XmlElement(name = "private-person", required = false)
    SharedDocumentOriginPrivatePerson privatePerson;
    @XmlElement(name = "organisation", required = false)
    SharedDocumentOriginOrganisation organisation;

}
