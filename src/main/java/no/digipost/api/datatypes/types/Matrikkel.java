package no.digipost.api.datatypes.types;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;

@XmlType
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@With
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
    @Size(max = 4)
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
