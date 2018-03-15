package no.digipost.api.datatypes.types.receipt;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Wither;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Wither
public class Delivery {
    @XmlElement
    NameAndAddress nameAndAddress;
    @XmlElement
    String terms;

    public static final Delivery EXAMPLE = new Delivery(NameAndAddress.EXAMPLE, "Delivered to the doorstep");
}
