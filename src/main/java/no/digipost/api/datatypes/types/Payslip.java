package no.digipost.api.datatypes.types;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;
import no.digipost.api.datatypes.marshalling.LocalDateXmlAdapter;

import java.math.BigDecimal;
import java.time.LocalDate;

@XmlRootElement
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true)
@With
@Description("For treating documents as Payslips.")
public class Payslip implements DataType {

    @XmlElement(name = "payment-date")
    @XmlJavaTypeAdapter(LocalDateXmlAdapter.class)
    @Description("The date when the salary is paid out")
    LocalDate paymentDate;

    @XmlElement(name = "net-amount")
    @Description("Net salary, the actual amount received")
    BigDecimal netAmount;


    public static Payslip EXAMPLE = new Payslip(
            LocalDate.parse("2025-01-01"),
            new BigDecimal("42000.00"));
}
