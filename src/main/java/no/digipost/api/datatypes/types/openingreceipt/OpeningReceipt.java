package no.digipost.api.datatypes.types.openingreceipt;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;
import no.digipost.api.datatypes.ComplementedBy;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;


@XmlRootElement(name = "opening-receipt")
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@With
@Description("To open the document the user must accept to send an opening receipt")
public class OpeningReceipt implements DataType {

    @XmlElement(name="group", required = true)
    @NotNull
    @Description("This is the group identifier for the opening receipt")
    @Size(max = 100)
    String group;

    public static final OpeningReceipt EXAMPLE = new OpeningReceipt(
           "aarsoppgave-bedriftAS-2025"
    );

}
