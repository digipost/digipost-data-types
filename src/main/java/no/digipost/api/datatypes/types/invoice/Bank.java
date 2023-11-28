package no.digipost.api.datatypes.types.invoice;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;
import no.digipost.api.datatypes.documentation.Description;

@XmlType
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@With
public class Bank {

    @XmlElement(name = "id")
    @Description("Unique id of the bank to reference the payment with third party")
    String id;

    @XmlElement(name = "name")
    @Description("Display name of the bank")
    String name;
    
    public static final Bank EXAMPLE = new Bank("ce7ad8ba63d0ea5cd212580192a00156", "Acme Bank inc");
}
