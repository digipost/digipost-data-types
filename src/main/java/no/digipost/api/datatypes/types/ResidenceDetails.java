package no.digipost.api.datatypes.types;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;

import javax.validation.Valid;
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
public class ResidenceDetails implements DataType {

    @XmlElement
    @Description("List of people with legal rights associated with the residence")
    List<Person> hjemmelshavere;

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

    @XmlElement(name = "sales-history")
    @Description("Previous sales and transactions")
    List<Omsetningshistorikk> salesHistory;

    @XmlElement
    @Valid
    @Description("An additional section of information, consisting of a title- and text-field")
    Info info;

    @XmlElement
    @Valid
    @Size(max = 50)
    String source;

    @XmlElement(name = "external-id")
    @Valid
    @Size(max = 50)
    String externalId;


    public static ResidenceDetails EXAMPLE = new ResidenceDetails(
            Collections.singletonList(new Person("Gunnar Gunnersen", "gunnargunnar@gunn.ar")),
            59.0, 3, 4,
            Collections.singletonList(new Omsetningshistorikk(ZonedDateTime.of(2017, 7, 27, 10, 0, 0, 0, ZoneId.systemDefault()),
                            "Privat salg av sekundærbolig", 12345678L, "Bill Isalg", "Cooper Coopersen")),
            new Info("En spesiell bolig", "Spesielt med denne boligen er at den har vært til sjøs på en husbåt i flere år, før den ble heiset og plassert på Vippetangen."),
            "boligmappa", "externalId");
}
