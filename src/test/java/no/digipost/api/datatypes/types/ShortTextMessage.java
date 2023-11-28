package no.digipost.api.datatypes.types;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import no.digipost.api.datatypes.ComplementedBy;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

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
