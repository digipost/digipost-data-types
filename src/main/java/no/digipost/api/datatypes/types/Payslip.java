package no.digipost.api.datatypes.types;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Value;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;

@XmlRootElement
@Value
@AllArgsConstructor
@Description("For treating documents as Payslips.")
public class Payslip implements DataType {
    public static Payslip EXAMPLE = new Payslip();
}
