package no.digipost.api.datatypes.types;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Wither;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

import static java.util.Collections.singletonList;

@XmlRootElement
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Wither
@Description("Event represents an event that occurs over a time period or several days. Eg. a conference or an election")
public class Event implements DataType {
    
    @XmlElement(name = "sub-title")
    @Size(max = 150)
    @Description("Example: 'Kommunestyre- og fylkestingvalg'")
    String subTitle;
    
    @XmlElement(name = "start-time", required = true)
    @NotNull
    @NotEmpty
    @Description("List of time intervals")
    List<TimeInterval> time;

    @XmlElement
    @Description("Optional label for time. null yield default in gui, eg. 'Opening hours'")
    @Size(max = 150)
    String timeLabel;
    
    @XmlElement(name = "arrival-time")
    @Description("Free text but can contain a ISO8601 DateTime. Example: 'Please use entrance from street'")
    @Size(max = 150)
    String arrivalTime;

    @XmlElement
    @Description("The name of the place. Example: 'Sagene skole'")
    @Size(max = 150)
    String place;
    
    @XmlElement
    @Description("Optional label for place. null yield default in gui, eg. 'Venue location'")
    @Size(max = 150)
    String placeLabel;

    @XmlElement
    @Valid
    Address address;

    @XmlElement
    @Valid
    @Size(max = 2)
    @Description("Additional sections of information (max 2) with a title and text.")
    List<Info> info;

    @XmlElement(name = "barcode")
    @Description("Barcode")
    Barcode barcode;

    @XmlElement(name = "links")
    @Description("Links for releated information to the appointment")
    List<Link> links;

    public static Event EXAMPLE = new Event(
            "Kommunestyre- og fylkestingvalg"
            , singletonList(TimeInterval.EXAMPLE)
            , "Opening hours"
            , "Husk legitimasjon"
            , "Sagene skole"
            , "Election venue"
            , Address.EXAMPLE
            , singletonList(new Info("Forhåndsstemming", "Du kan forhåndsstemme fra 10. august"))
            , Barcode.EXAMPLE
            , singletonList(Link.EXAMPLE)
    );
}
