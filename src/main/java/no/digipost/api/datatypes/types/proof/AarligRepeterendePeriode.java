package no.digipost.api.datatypes.types.proof;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Wither;
import no.digipost.api.datatypes.documentation.Description;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Wither
@EqualsAndHashCode(callSuper = false)
public class AarligRepeterendePeriode implements TidsPeriode {
    @XmlElement(name = "start-aar")
    @Description("")
    Integer startaar;

    @XmlElement(name = "slutt-aar")
    @Description("")
    Integer sluttaar;

    @XmlElement(name = "fra", required = true)
    @NotNull
    @Description("")
    MaanedsTidspunkt fra;

    @XmlElement(name = "til", required = true)
    @NotNull
    @Description("")
    MaanedsTidspunkt til;

    public static AarligRepeterendePeriode EXAMPLE = new AarligRepeterendePeriode(
            2020,
            2022,
            new MaanedsTidspunkt(1, 1, null, null, "Europe/Oslo"),
            new MaanedsTidspunkt(12, 31, null, null, "+2:00")
    );
}
