package no.digipost.api.datatypes.types;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class Hjemmelshaver {

    @XmlElement
    @NotNull
    @Size(max = 75)
    String name;

    @XmlElement
    @Size(max = 50)
    // TODO: Add email-validator
    String email;
}
