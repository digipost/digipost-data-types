package no.digipost.api.datatypes.types.bevis;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Wither;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;

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
@Description("Bevis description here")
public class Bevis implements DataType {

    @XmlElement(name = "utsteder-visningsnavn", required = true)
    @NotNull
    @Description("")
    String30MedSpraak utstederVisningsnavn;

    @XmlElement(name = "bakgrunnsfarge")
    @Pattern(regexp = "[A-Fa-f0-9]{6}")
    @Description("RRGGBB fargekode")
    String bakgrunnsfarge;

    @XmlElement(name = "logo")
    @Size(min = 1, max = 50)
    @Description("")
    String logo;

    @XmlElement(name = "utstedt-tidspunkt")
    @Description("")
    ZonedDateTime utstedtTidspunkt;

    @XmlElement(name = "gyldighetsperioder", required = true)
    @NotNull
    @Description("")
    PeriodeListe gyldighetsPerioder;

    @XmlElement(name = "bevis-bruker")
    @Description("")
    Bruker bevisBruker;

    @XmlElement(name = "tittel", required = true)
    @NotNull
    @Description("")
    String30MedSpraak tittel;

    @XmlElement(name = "bevis-id-navn", required = true)
    @NotNull
    @Description("")
    String30MedSpraak bevisIdNavn;

    @XmlElement(name = "bevis-id-verdi", required = true)
    @NotNull
    @Description("")
    String100MedSpraak bevisIdVerdi;

    @XmlElement(name = "attributt")
    @Size(max = 5)
    @Description("")
    List<Attributt> attributt;

    @XmlElement(name = "info")
    @Size(max = 3)
    @Description("")
    List<BevisInfo> info;


    public static Bevis EXAMPLE =
            new Bevis(
                    new String30MedSpraak("Stedsnavn", new SpraakKode("NO")),
                    "ff0000",
                    "logo.png",
                    ZonedDateTime.of(2019, 5, 23, 10, 0, 0, 0, ZoneId.systemDefault()),
                    PeriodeListe.EXAMPLE,
                    Bruker.EXAMPLE,
                    new String30MedSpraak("Tittel", new SpraakKode("NO")),
                    new String30MedSpraak("ID Navn", new SpraakKode("NO")),
                    new String100MedSpraak("ID Verdi", new SpraakKode("NO")),
                    singletonList(Attributt.EXAMPLE),
                    singletonList(BevisInfo.EXAMPLE)
            );
}