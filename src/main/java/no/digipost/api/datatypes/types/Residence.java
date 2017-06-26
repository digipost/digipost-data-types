package no.digipost.api.datatypes.types;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.UUID;

@XmlRootElement
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Description("Residence is a way of linking separate data for the same residence")
public class Residence implements DataType {

    @XmlElement(required = true)
    @NotNull
    @Valid
    Address address;

    @XmlElement
    @Valid
    @Size(max = 50)
    String source;

    @XmlElement
    @Valid
    @Size(max = 50)
    String externalId;

    public static  Residence EXAMPLE = new Residence(
            new Address("Storgata 23", "0011", "Oslo"), "boligmappa", UUID.randomUUID().toString());
}