package no.digipost.api.datatypes.types.pickup;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;
import no.digipost.api.datatypes.documentation.Description;
import no.digipost.api.datatypes.types.Address;

@XmlType
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@With
public class Sender {

    @XmlElement(name = "name")
    @Description("The senders name")
    String name;
    
    @XmlElement(name = "reference")
    @Description("The senders reference")
    String reference;
    
    @XmlElement
    Address address;
    
    public static final Sender EXAMPLE = new Sender("Avsenderservice as", "13372500", Address.EXAMPLE);
    
}
