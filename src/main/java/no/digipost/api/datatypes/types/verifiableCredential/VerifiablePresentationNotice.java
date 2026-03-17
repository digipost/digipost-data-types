package no.digipost.api.datatypes.types.verifiableCredential;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;

import java.util.List;


@XmlRootElement(name = "verifiable-presentation-notice")
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@With
@Description("A request for a verifiable presentation. The request must include a credentials query of either dcql_query og simple_query.")
public class VerifiablePresentationNotice implements DataType {

    @XmlElement(required = true)
    @Description("The title of the presentation request")
    String title;

    @XmlElement(required = true)
    @Description("A detailed explanation of the presentation request containing the purpose for this particular presentation request.")
    String description;

    @Value
    @AllArgsConstructor
    @NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
    @With
    public static class Option {
        @XmlElementWrapper(name = "credential_ids")
        @XmlElement(name = "credential_id")
        List<String> credentialIds;
    }

    public static VerifiablePresentationNotice EXAMPLE = new VerifiablePresentationNotice(
            "Request for Driver's licence",
            "We would like to verify your driver’s license before we can rent you a Toyota."
    );
}
