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
@Description("Proof description here")
public class Proof implements DataType {

    @XmlElement(name = "utsteder-visningsnavn", required = true)
    @NotNull
    @Size(max = 30)
    @Description("")
    String utstederVisningsnavn;

    @XmlElement(name = "bakgrunnsfarge")
    @Pattern(regexp = "#[A-SFa-f0-9]{6}")
    @Description("#RRGGBB fargekode")
    String bakgrunnsfarge;

    @XmlElement(name = "utstedt-tidspunkt")
    @Description("")
    ZonedDateTime utstedtTidspunkt;

    @XmlElement(name = "gyldighetsperioder", required = true)
    @NotNull
    @Description("")
    GyldighetsPeriode gyldighetsPerioder;

    @XmlElement(name = "bevis-bruker", required = true)
    @NotNull
    @Description("")
    Bruker bevisBruker;

    @XmlElement(name = "tittel", required = true)
    @NotNull
    @Size(max = 30)
    @Description("")
    String tittel;

    @XmlElement(name = "bevis-id-navn")
    @Size(max = 100)
    @Description("")
    String bevisIdNavn;

    @XmlElement(name = "bevis-id-verdi")
    @Size(max = 250)
    @Description("")
    String bevisIdVerdi;

    @XmlElement(name = "attributt")
    @Size(max = 5)
    @Description("")
    List<Info> attributt;

    @XmlElement(name = "info")
    @Size(max = 3)
    @Description("")
    List<Info> info;


    public static Proof EXAMPLE =
            new Proof(
                    "Stedsnavn",
                    "#ff0000",
                    ZonedDateTime.of(2019, 5, 23, 10, 0, 0, 0, ZoneId.systemDefault()),
                    GyldighetsPeriode.EXAMPLE,
                    Bruker.EXAMPLE,
                    "Tittel",
                    "ID Navn",
                    "ID Verdi",
                    singletonList(new Info("Key", "Value")),
                    singletonList(new Info("Title", "Text"))
            );
}
