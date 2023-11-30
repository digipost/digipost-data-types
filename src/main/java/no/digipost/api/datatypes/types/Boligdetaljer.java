package no.digipost.api.datatypes.types;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;
import no.digipost.api.datatypes.ComplementedBy;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;

@XmlRootElement
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@With
@Description("Details about a Residence, and may be joined with Residence to retrieve the core fields of a Residence.")
@ComplementedBy({Boligdetaljer.class})
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

    @XmlElement
    @Size(max = 20)
    String organisasjonsnummer;

    @XmlElement
    @Size(max = 10)
    String bruksenhet;

    @XmlElement
    String andelsnummer;

    @XmlElement
    @Valid
    List<Heftelse> heftelser;

    @XmlElement
    @Valid
    @Description("An optional ExternalLink prompting the user to perform an action on an external site")
    ExternalLink callToAction;

    @XmlElement(defaultValue = "NB")
    @Description("Languange for the document")
    Language language;

    public Boligdetaljer(Residence residence, List<Hjemmelshaver> hjemmelshavere, Integer bruksareal, Integer antallOppholdsrom,
                         Integer antallBaderom, List<Omsetningshistorikk> omsetningshistorikk, String organisasjonsnummer, String bruksenhet,
                         String andelsnummer, List<Heftelse> heftelser) {
        this(residence, hjemmelshavere, bruksareal, antallOppholdsrom, antallBaderom, omsetningshistorikk, organisasjonsnummer,
                bruksenhet, andelsnummer, heftelser, null, Language.NB);
    }

    public static Boligdetaljer EXAMPLE = new Boligdetaljer(
            Residence.EXAMPLE
            , Collections.singletonList(new Hjemmelshaver("Gunnar Gunnersen", "gunnargunnar@gunn.ar"))
            , 59, 3, 4
            , Collections.singletonList(new Omsetningshistorikk(ZonedDateTime.of(2017, 7, 27, 10, 0, 0, 0, ZoneId.of("+02:00"))
            , "Privat salg av sekundærbolig"
            , "Bill Isalg"
            , "Cooper Coopersen"
            , 12345678L))
            , "123456789"
            , "H1337"
            , "42"
            , Collections.singletonList(new Heftelse("TNT ASA", "Pantedokument", "3000000000"))
            , ExternalLink.EXAMPLE_NO_DEADLINE
            , Language.NB
    );
}
