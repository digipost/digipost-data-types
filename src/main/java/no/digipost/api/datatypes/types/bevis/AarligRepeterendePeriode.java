package no.digipost.api.datatypes.types.bevis;

import lombok.*;
import lombok.experimental.Wither;
import no.digipost.api.datatypes.documentation.Description;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.TimeZone;

@XmlType
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Wither
@EqualsAndHashCode(callSuper = false)
public class AarligRepeterendePeriode extends TidsPeriode {
    @XmlElement(name = "start-aar", required = true)
    @NotNull
    @Description("")
    Integer startaar;

    @XmlElement(name = "slutt-aar", required = true)
    @NotNull
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

    @XmlElement(name = "tidssone", required = true)
    @NotNull
    @Description("Java.Util.Timezone ID, default er system timezone")
    String tidssone;

    public static AarligRepeterendePeriode EXAMPLE = new AarligRepeterendePeriode(
            2020,
            2022,
            new MaanedsTidspunkt(1, 1, null, null, TimeZone.getDefault().getID()),
            new MaanedsTidspunkt(12, 31, null, null, TimeZone.getDefault().getID()),
            TimeZone.getDefault().getID()
    );
}
