package no.digipost.api.datatypes.types.bevis;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
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
public class MaanedsTidspunkt {
    @XmlElement(name = "maaned", required = true)
    @NotNull
    @Description("")
    Integer maaned;

    @XmlElement(name = "dag", required = true)
    @NotNull
    @Description("")
    Integer dag;

    @XmlElement(name = "time")
    @Description("")
    Integer time;

    @XmlElement(name = "min")
    @Description("")
    Integer min;

    @XmlElement(name = "tidssone")
    @Description("Java.Util.Timezone ID, default er system timezone")
    String tidssone;

    public static MaanedsTidspunkt EXAMPLE = new MaanedsTidspunkt(5, 9, null, null, TimeZone.getDefault().getID());
}
