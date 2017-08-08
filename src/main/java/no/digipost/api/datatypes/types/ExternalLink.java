package no.digipost.api.datatypes.types;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

@XmlRootElement
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Description("An external URL, along with an optional description and deadline for resources such as a survey.")
public class ExternalLink implements DataType {

    @XmlElement
    @NotNull
    String uuid;

    @XmlElement
    @NotNull
    String url;

    @XmlElement
    @Description("ISO8601 full DateTime. After the deadline, the button with the external url will be deactivated.")
    ZonedDateTime deadline;

    @XmlElement
    @Size(max = 70)
    @Description("A short, optional text-field, describing the external url.")
    String description;

    @XmlElement(name = "button-text")
    @Size(max = 30)
    @Description("The text which will be displayed on the button which links the user to the url-field.")
    String buttonText;

    @XmlElement(name = "url-is-active")
    @Description("A status indicating whether the button and URL will be available to the user or not.")
    Boolean urlIsActive;

    @XmlElement
    public boolean isExpired() {
        return this.deadline != null && this.deadline.isBefore(ZonedDateTime.now());
    }

    public static ExternalLink EXAMPLE = new ExternalLink(UUID.randomUUID().toString(), "https://www.digipost.no",
            ZonedDateTime.of(2017, 9, 9, 13, 37, 0, 0, ZoneId.systemDefault()),
            "Lenke til vår hovedside.", "Gå til Digipost", Boolean.TRUE);
}
