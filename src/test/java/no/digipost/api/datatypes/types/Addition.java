package no.digipost.api.datatypes.types;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Description("Addition")
@XmlRootElement
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class Addition implements DataType {

    @XmlElement(required = true)
    @Description("Your extra status update")
    public String status;
}
