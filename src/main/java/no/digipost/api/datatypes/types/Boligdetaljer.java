package no.digipost.api.datatypes.types;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
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
@Description("Details about a Residence, and may be joined with Residence to retrieve the core fields of a Residence.")
public class Boligdetaljer implements DataType {

    @XmlElement
    @NotNull
    Residence residence;

    @XmlElement
    @Description("List of people with legal rights associated with the residence")
    List<Hjemmelshaver> hjemmelshavere;

    @XmlElement
    @Positive
    @Description("BRA for bolig")
    Integer bruksareal;

    @XmlElement(name = "antall-oppholdsrom")
    @Positive
    @Description("Number of rooms, bathroom, kitchen and storage rooms excluded")
    Integer antallOppholdsrom;

    @XmlElement(name = "antall-baderom")
    @Positive
    @Description("Number of bathrooms")
    Integer antallBaderom;

    @XmlElement(name = "omsetningshistorikk")
    @Description("Previous sales and transactions")
    List<Omsetningshistorikk> omsetningshistorikk;

    @XmlElement
    @Valid
    @Description("An additional section of information, consisting of a title- and text-field")
    Info info;

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
    Long andelsnummer;

    @XmlElement
    List<Heftelse> heftelser;

    public static Boligdetaljer EXAMPLE = new Boligdetaljer(Residence.EXAMPLE,
            Collections.singletonList(new Hjemmelshaver("Gunnar Gunnersen", "gunnargunnar@gunn.ar")),
            59, 3, 4,
            Collections.singletonList(new Omsetningshistorikk(ZonedDateTime.of(2017, 7, 27, 10, 0, 0, 0, ZoneId.systemDefault()),
                            "Privat salg av sekundærbolig", "Bill Isalg", "Cooper Coopersen", 12345678L)),
            new Info("En spesiell bolig", "Spesielt med denne boligen er at den har vært til sjøs på en husbåt i flere år, før den ble heiset og plassert på Vippetangen."),
            "123456789", "H1337", 42L,
            Collections.singletonList(new Heftelse("TNT ASA", "Pantedokument", 3000000000L)));
}