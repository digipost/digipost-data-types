package no.digipost.api.datatypes.types;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

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
    String email;
}
