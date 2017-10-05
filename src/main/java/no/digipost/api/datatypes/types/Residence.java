package no.digipost.api.datatypes.types;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Wither;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Wither
@Description("Residence is a way of linking separate data for the same residence")
public class Residence implements DataType {

    @XmlElement(required = true)
    @NotNull
    @Valid
    ResidenceAddress address;

    @XmlElement
    @Valid
    Matrikkel matrikkel;

    @XmlElement
    @Valid
    @Size(max = 50)
    String source;

    @XmlElement(name = "external-id")
    @Valid
    @Size(max = 50)
    String externalId;

    public static Residence EXAMPLE = new Residence(ResidenceAddress.EXAMPLE, Matrikkel.EXAMPLE,
            "boligmappa", "externalId");
}
