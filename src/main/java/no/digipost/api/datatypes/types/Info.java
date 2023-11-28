package no.digipost.api.datatypes.types;

import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import no.digipost.api.datatypes.documentation.Description;

@XmlType
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class Info {

    @XmlElement
    @Size(max = 150)
    String title;

    @XmlElement
    @Description("The body of the information. Newlines \\n and tabs \\t will be printed formatted.")
    String text;
    
}
