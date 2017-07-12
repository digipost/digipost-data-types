package no.digipost.api.datatypes.types;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.regex.Pattern;

@XmlType
@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class Matrikkel {

    public Matrikkel(String kommunenummer, String gaardsnummer, String bruksnummer) {
        this(kommunenummer,gaardsnummer,bruksnummer, "0", "0");
    }

    public Matrikkel(String kommunenummer, String gaardsnummer, String bruksnummer, String festenummer, String seksjonsnummer) {
        if (!Pattern.matches("\\d{4}", kommunenummer)) {
            throw new IllegalArgumentException("Kommunenummer must be 4 digits");
        }
        if (!Pattern.matches("\\d+", gaardsnummer)) {
            throw new IllegalArgumentException("Gaardsnummer can only be digits");
        }
        if (!Pattern.matches("\\d+", bruksnummer)) {
            throw new IllegalArgumentException("Bruksnummer can only be digits");
        }
        if (!Pattern.matches("\\d+", festenummer)) {
            throw new IllegalArgumentException("Festenummer can only be digits");
        }
        if (!Pattern.matches("\\d+", seksjonsnummer)) {
            throw new IllegalArgumentException("Seksjonsnummer can only be digits");
        }

        this.kommunenummer = kommunenummer;
        this.gaardsnummer = gaardsnummer;
        this.bruksnummer = bruksnummer;
        this.festenummer = festenummer;
        this.seksjonsnummer = seksjonsnummer;
    }

    @XmlElement(required = true)
    @Valid
    @NotNull
    @Size(max = 4)
    String kommunenummer;

    @XmlElement(required = true)
    @Valid
    @NotNull
    @Size(max = 4)
    String gaardsnummer;

    @XmlElement(required = true)
    @Valid
    @NotNull
    String bruksnummer;

    @XmlElement()
    @Valid
    String festenummer;

    @XmlElement()
    @Valid
    String seksjonsnummer;

}
