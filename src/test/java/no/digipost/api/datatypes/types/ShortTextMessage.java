package no.digipost.api.datatypes.types;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;
import no.digipost.api.datatypes.validation.ComplementedBy;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Description("150 character short message")
@XmlRootElement
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@ComplementedBy({Addition.class})
public class ShortTextMessage implements DataType {

    @XmlElement(required = true)
    @NotNull
    @Max(value = 150)
    @Description("Your short message goes here")
    String message;

    @Description("Some metadata for shortTextMessage")
    MetaData metaData;

    public static final ShortTextMessage EXAMPLE = new ShortTextMessage("Dette er en kort melding til deg", MetaData.EXAMPLE);
}
