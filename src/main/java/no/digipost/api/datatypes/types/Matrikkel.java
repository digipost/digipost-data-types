package no.digipost.api.datatypes.types;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Wither;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Wither
public class Matrikkel {

    /**
     * Required args constructor
     */
    public Matrikkel(String kommunenummer, String gaardsnummer, String bruksnummer) {
        this(kommunenummer,gaardsnummer,bruksnummer, "0", "0");
    }

    @XmlElement(required = true)
    @Valid
    @NotNull
    @Size(min = 4, max = 4)
    @Pattern(regexp = "\\d+", message = "can only be digits")
    String kommunenummer;

    @XmlElement(required = true)
    @Valid
    @NotNull
    @Size(max = 4)
    @Pattern(regexp = "\\d+", message = "can only be digits")
    String gaardsnummer;

    @XmlElement(required = true)
    @Valid
    @NotNull
    @Pattern(regexp = "\\d+", message = "can only be digits")
    String bruksnummer;

    @XmlElement()
    @Pattern(regexp = "\\d+", message = "can only be digits")
    String festenummer;

    @XmlElement()
    @Pattern(regexp = "\\d+", message = "can only be digits")
    String seksjonsnummer;

    public static final Matrikkel EXAMPLE = new Matrikkel("0301", "208", "630", "0", "0");
}
