package no.digipost.api.datatypes.types.pickup;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Wither;
import no.digipost.api.datatypes.documentation.Description;
import no.digipost.api.datatypes.types.Address;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Wither
public class Recipient {

    @XmlElement(name = "name", required = true)
    @Description("The name of the recipient")
    String name;

    @XmlElement(name = "digipost-address", required = true)
    @Description("The digipost address for the recipient")
    String digipostAddress;

    @XmlElement
    Address address;

    @XmlElement(name = "email-address")
    String emailAddress;
    
    public static final Recipient EXAMPLE = new Recipient("Test Testesen", "test.testesen#0000", Address.EXAMPLE, "test.testesen@example.com");
    
}
