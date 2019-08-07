package no.digipost.api.datatypes.types;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Wither;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;

@XmlRootElement
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Wither
@Description("Details about a Residence, and may be joined with Residence to retrieve the core fields of a Residence.")
public class Boligdetaljer implements DataType {

    @XmlElement
    @NotNull
    @Valid
    Residence residence;

    @XmlElement
    @Description("List of people with legal rights associated with the residence")
    @Valid
    List<Hjemmelshaver> hjemmelshavere;

    @XmlElement
    @Min(value = 0, message = "The value must be positive")
    @Description("BRA for bolig")
    Integer bruksareal;

    @XmlElement(name = "antall-oppholdsrom")
    @Min(value = 0, message = "The value must be positive")
    @Description("Number of rooms, bathroom, kitchen and storage rooms excluded")
    Integer antallOppholdsrom;

    @XmlElement(name = "antall-baderom")
    @Min(value = 0, message = "The value must be positive")
    @Description("Number of bathrooms")
    Integer antallBaderom;

    @XmlElement(name = "omsetningshistorikk")
    @Description("Previous sales and transactions")
    @Valid
    List<Omsetningshistorikk> omsetningshistorikk;

    // Validering?
    @XmlElement
    @Size(max = 20)
    String organisasjonsnummer;

    @XmlElement
    @Size(max = 10)
    // Validering: "H0101"
    String bruksenhet;

    @XmlElement
    // validering?
    String andelsnummer;

    @XmlElement
    @Valid
    List<Heftelse> heftelser;

    @XmlElement
    @Valid
    ExternalLink extra;

    public static Boligdetaljer EXAMPLE = new Boligdetaljer(Residence.EXAMPLE,
            Collections.singletonList(new Hjemmelshaver("Gunnar Gunnersen", "gunnargunnar@gunn.ar")),
            59, 3, 4,
            Collections.singletonList(new Omsetningshistorikk(ZonedDateTime.of(2017, 7, 27, 10, 0, 0, 0, ZoneId.systemDefault()),
                            "Privat salg av sekundærbolig", "Bill Isalg", "Cooper Coopersen", 12345678L)),
            "123456789", "H1337", "42",
            Collections.singletonList(new Heftelse("TNT ASA", "Pantedokument", "3000000000")),
            ExternalLink.EXAMPLE);
}
