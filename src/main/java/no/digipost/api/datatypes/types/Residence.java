package no.digipost.api.datatypes.types;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;

@XmlRootElement
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@With
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
