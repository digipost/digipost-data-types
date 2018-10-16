package no.digipost.api.datatypes.types;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Wither;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Wither
public class Location implements DataType {

    @XmlElement(name = "id", required = true)
    @Description("The unique identification for the location")
    @NotNull
    public String id;

    @XmlElement(name = "name", required = true)
    @Description("The name of the pickup place")
    @NotNull
    public String name;

    @XmlElement(name = "type", required = true)
    @Description("The type is used in conjunction with id above to fetch more information about a particular pickup place")
    @NotNull
    public LocationType locationType;
    
}
