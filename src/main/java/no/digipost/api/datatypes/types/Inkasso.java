package no.digipost.api.datatypes.types;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Wither;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@XmlRootElement
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Wither
@Description("A debt collection payment")
public class Inkasso implements DataType {
    @XmlElement
    @Description("A link to more information, or further actions that can be taken")
    ExternalLink link;
    @XmlElement(required = true, name = "due-date")
    @Description("When the payment falls due")
    ZonedDateTime dueDate;
    @XmlElement
    @Description("The sum to be payed")
    BigDecimal sum;
    @XmlElement
    @Description("The creditor account for the payment")
    String account;
    @XmlElement
    @Description("The customer identification number")
    String kid;

    public static Inkasso EXAMPLE = new Inkasso(ExternalLink.EXAMPLE_NO_DEADLINE,
            ZonedDateTime.of(2019, 12, 10, 0, 0, 0, 0, ZoneId.systemDefault()),
            BigDecimal.valueOf(42), "012354243209523583", "1435025439583420243982723");

}
