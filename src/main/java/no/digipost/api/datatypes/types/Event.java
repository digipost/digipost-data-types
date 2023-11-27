package no.digipost.api.datatypes.types;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

import static java.util.Collections.singletonList;

@XmlRootElement
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@With
@Description("Event represents an event that occurs over a time period or several days. Eg. a conference or an election")
public class Event implements DataType {
    
    @XmlElement(name = "sub-title")
    @Size(max = 100)
    @Description("Example: 'Kommunestyre- og fylkestingvalg'")
    String subTitle;
    
    @XmlElement(name = "start-time", required = true)
    @NotEmpty
    @Description("List of time intervals")
    List<TimeInterval> time;

    @XmlElement
    @Description("Optional label for time. null yield default in gui, eg. 'Opening hours'")
    @Size(max = 100)
    String timeLabel;
    
    @XmlElement(name = "description")
    @Description("Free text but can contain a ISO8601 DateTime. Example: 'Please use entrance from street'")
    @Size(max = 120)
    String description;

    @XmlElement
    @Description("The name of the place. Example: 'Sagene skole'")
    String place;
    
    @XmlElement
    @Description("Optional label for place. null yield default in gui, eg. 'Venue location'")
    @Size(max = 100)
    String placeLabel;

    @XmlElement
    @Valid
    Address address;

    @XmlElement
    @Valid
    @Size(max = 10)
    @Description("Additional sections of information (max 10) with a title and text.")
    List<Info> info;

    @XmlElement
    @Description("Optional label for barcode. null yield default in gui, eg. ''")
    @Size(max = 100)
    String barcodeLabel;
    
    @XmlElement(name = "barcode")
    @Description("Barcode")
    Barcode barcode;

    @XmlElement(name = "links")
    @Description("Links for releated information to the appointment")
    List<Link> links;

    @XmlElement
    @Description("Languange for the document")
    Language language;

    public static Event EXAMPLE = new Event(
            "Kommunestyre- og fylkestingvalg"
            , singletonList(TimeInterval.EXAMPLE)
            , "Opening hours"
            , "Velkommen til valg! Husk legitimasjon."
            , "Sagene skole"
            , "Election venue"
            , Address.EXAMPLE
            , singletonList(new Info("Forhåndsstemming", "Du kan forhåndsstemme fra 10. august"))
            , "Barcode for use on election day:"
            , Barcode.EXAMPLE
            , singletonList(Link.EXAMPLE)
            , Language.NB
    );
}
