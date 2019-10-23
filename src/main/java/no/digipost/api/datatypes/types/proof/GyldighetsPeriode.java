package no.digipost.api.datatypes.types.proof;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Wither;
import no.digipost.api.datatypes.documentation.Description;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.*;

@XmlType
@Value
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Wither
public class GyldighetsPeriode {
    @XmlElements(
            {
                    @XmlElement(name = "periode", type = Periode.class, required = true),
                    @XmlElement(name = "aarlig-repeterende-periode", type = AarligRepeterendePeriode.class, required = true)
            })
    @Size(min = 1, max = 1)
    @Description("")
    TidsPeriode periodeListe;

    public static GyldighetsPeriode EXAMPLE = new GyldighetsPeriode(AarligRepeterendePeriode.EXAMPLE);
}
