package no.digipost.api.datatypes.types.verifiableCredential;

import jakarta.xml.bind.annotation.XmlElement;
import lombok.*;

@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@With
public class SimpleQuery {

    @XmlElement(name = "type")
    String type;

    @XmlElement(name = "format")
    Format format;
}
