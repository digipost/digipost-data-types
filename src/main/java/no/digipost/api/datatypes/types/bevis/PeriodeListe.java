package no.digipost.api.datatypes.types.bevis;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Wither;
import no.digipost.api.datatypes.documentation.Description;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.*;
import java.util.List;

import static java.util.Collections.singletonList;

@XmlType
@Value
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Wither
public class PeriodeListe {
    @XmlElements(
            {
                    @XmlElement(name = "periode", type = Periode.class, required = true),
                    @XmlElement(name = "aarlig-repeterende-periode", type = AarligRepeterendePeriode.class, required = true)
            })
    @Size(min = 1, max = 100)
    @Description("")
    List<TidsPeriode> periodeListe;

    public static PeriodeListe EXAMPLE = new PeriodeListe(singletonList(AarligRepeterendePeriode.EXAMPLE));
}
