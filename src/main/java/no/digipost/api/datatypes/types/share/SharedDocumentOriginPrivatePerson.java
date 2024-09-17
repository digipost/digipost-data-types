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
@Description("Origin of shared document is a private person")
public class SharedDocumentOriginPrivatePerson {

    @XmlAttribute(name = "name", required = true)
    String name;

    public static final SharedDocumentOriginPrivatePerson EXAMPLE = new SharedDocumentOriginPrivatePerson(
            "Test Testesen"
    );

}
