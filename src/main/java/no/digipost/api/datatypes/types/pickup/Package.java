package no.digipost.api.datatypes.types.pickup;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Wither;
import no.digipost.api.datatypes.documentation.Description;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Wither
public class Package {

    @XmlElement(name = "lenght")
    @Description("Package lenght in cm")
    Integer length;

    @XmlElement(name = "width")
    @Description("Package width in cm")
    Integer width;
    
    @XmlElement(name = "height")
    @Description("Package height in cm")
    Integer height;

    @XmlElement(name = "weight")
    @Description("Package weight in grams")
    Integer weight;
    
    public static final Package EXAMPLE = new Package(120, 60, 60, 35000);
}
