package no.digipost.api.datatypes.types;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import no.digipost.api.datatypes.documentation.Description;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.time.ZonedDateTime;

@XmlType
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Description("A previous transaction or sale")
public class Omsetningshistorikk {

    @XmlElement(name = "start-time", required = true)
    @NotNull
    @Description("ISO8601 full DateTime")
    ZonedDateTime date;

    @XmlElement
    @Size(max = 50)
    String description;

    @XmlElement
    Long amount;

    @XmlElement
    @Size(max = 50)
    String seller;

    @XmlElement
    @Size(max = 50)
    String buyer;
}
