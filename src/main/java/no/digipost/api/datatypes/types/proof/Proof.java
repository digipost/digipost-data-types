package no.digipost.api.datatypes.types.proof;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Wither;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;
import no.digipost.api.datatypes.types.Info;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import static java.util.Collections.singletonList;

@XmlRootElement
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Wither
@Description("Represents a legal document (Certificate, Lisence, Permit, etc.) issued to a single person, valid for one or more time periods.")
public class Proof implements DataType {

    @XmlElement(name = "utsteder-visningsnavn", required = true)
    @NotNull
    @Size(max = 30)
    @Description("")
    String authorizerName;

    @XmlElement(name = "bakgrunnsfarge")
    @Pattern(regexp = "#[A-SFa-f0-9]{6}")
    @Description("#RRGGBB fargekode")
    String backgroundColor;

    @XmlElement(name = "utstedt-tidspunkt")
    @Description("")
    ZonedDateTime issuedTime;

    @XmlElement(name = "gyldighetsperioder", required = true)
    @NotNull
    @Description("")
    ValidPeriod validPeriod;

    @XmlElement(name = "bevis-bruker", required = true)
    @NotNull
    @Description("")
    ProofHolder proofHolder;

    @XmlElement(name = "tittel", required = true)
    @NotNull
    @Size(max = 30)
    @Description("")
    String title;

    @XmlElement(name = "bevis-id-navn")
    @Size(max = 100)
    @Description("")
    String proofIdName;

    @XmlElement(name = "bevis-id-verdi")
    @Size(max = 250)
    @Description("")
    String proofIdValue;

    @XmlElement(name = "attributt")
    @Size(max = 5)
    @Description("")
    List<Info> attribute;

    @XmlElement(name = "info")
    @Size(max = 3)
    @Description("")
    List<Info> info;


    public static Proof EXAMPLE =
            new Proof(
                    "Stedsnavn",
                    "#ff0000",
                    ZonedDateTime.of(2019, 5, 23, 10, 0, 0, 0, ZoneId.systemDefault()),
                    ValidPeriod.EXAMPLE,
                    ProofHolder.EXAMPLE,
                    "Tittel",
                    "ID Navn",
                    "ID Verdi",
                    singletonList(new Info("Key", "Value")),
                    singletonList(new Info("Title", "Text"))
            );
}