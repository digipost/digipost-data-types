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
@Description("Represents a legal document (Certificate, Licence, Permit, etc.) issued to a single person, valid for one or more time periods.")
public class Proof implements DataType {

    @XmlElement(name = "authorizer-name", required = true)
    @NotNull
    @Size(max = 30)
    @Description("Name of e.g. the organization issuing this proof")
    String authorizerName;

    @XmlElement(name = "background-color")
    @Pattern(regexp = "#[A-SFa-f0-9]{6}")
    @Description("#RRGGBB color code")
    String backgroundColor;

    @XmlElement(name = "issued-time")
    @Description("The point of time the proof is issued")
    ZonedDateTime issuedTime;

    @XmlElement(name = "valid-period", required = true)
    @NotNull
    @Description("A description of when the proof is valid")
    ValidPeriod validPeriod;

    @XmlElement(name = "proof-holder", required = true)
    @NotNull
    @Description("")
    ProofHolder proofHolder;

    @XmlElement(name = "title", required = true)
    @NotNull
    @Size(max = 30)
    @Description("")
    String title;

    @XmlElement(name = "proof-id-name")
    @Size(max = 100)
    @Description("A name describing the content of the proofIdValue field")
    String proofIdName;

    @XmlElement(name = "proof-id-value")
    @Size(max = 250)
    @Description("A field for extra information identifying this proof, such as a membership number")
    String proofIdValue;

    @XmlElement(name = "attribute")
    @Size(max = 5)
    @Description("Extra information for the proof, a set of key-value pairs")
    List<Info> attribute;

    @XmlElement(name = "info")
    @Size(max = 3)
    @Description("Extra instructions for the holder of the proof, such as special terms")
    List<Info> info;


    public static Proof EXAMPLE =
            new Proof(
                    "Bekkestua Bibliotek",
                    "#e1e1e1",
                    ZonedDateTime.of(2019, 5, 23, 10, 0, 0, 0, ZoneId.systemDefault()),
                    ValidPeriod.EXAMPLE,
                    ProofHolder.EXAMPLE,
                    "Lånekort",
                    "Lånekortnummer",
                    "a-132415124-xyzzy-21341",
                    singletonList(new Info("Kaffeklubb", "Premium deluxe medlem")),
                    singletonList(new Info("Regler", "Det er ikke lov å rive ut sider i bøkene, eller søle med ketchup. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec aliquet urna condimentum, pulvinar neque ac, tempor tellus. Vestibulum ante ipsum primis in faucibus orci luctus et "))
            );
}
