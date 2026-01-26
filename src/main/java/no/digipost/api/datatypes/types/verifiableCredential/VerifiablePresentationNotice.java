package no.digipost.api.datatypes.types.verifiableCredential;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;

import java.util.List;

import static no.digipost.api.datatypes.types.verifiableCredential.Format.JWT_VC_JSON;

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
    @Description("A detailed explanation of the presentation request.")
    String description;

    @XmlElement
    @Description("A simplified credential query format")
    SimpleQuery simpleQuery;

    @XmlElement
    @Description("A credentials query following the Digital Credentials Query Language (DCQL) specification.")
    DcqlQuery dcqlQuery;


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
            "Driver’s License",
            "We would like to verify your driver’s license.",
            new SimpleQuery("driversLicence", JWT_VC_JSON),
            null
    );

    // example førerkort with DCQL
    public static VerifiablePresentationNotice DCQL_EXAMPLE = new VerifiablePresentationNotice(
            "Driver’s License",
            "We would like to verify your driver’s license.",
            null,
            new DcqlQuery(
                  List.of(
                          DcqlQuery.Credential.jwtVc(
                                  "credential1",
                                  List.of("driversLicence")
                          )
                  ),
                  null
            )
    );
}
