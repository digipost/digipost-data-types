package no.digipost.api.datatypes.types.verifiableCredential;

import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import lombok.*;
import no.digipost.api.datatypes.documentation.Description;

import java.util.List;

@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@With
public class DcqlQuery {

    @XmlElementWrapper(name = "credentials")
    @XmlElement(name = "credential")
    @Description("List of credential queries as per DCQL.")
    @NotNull
    List<Credential> credentials;

    @XmlElementWrapper(name = "credential_sets")
    @XmlElement(name = "credential_set")
    @Description("Optional credential sets for advanced DCQL queries.")
    List<CredentialSet> credentialSets;


    @Value
    @AllArgsConstructor
    @NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
    @With
    public static class Credential {
        @XmlElement(name = "id")
        String id;

        @XmlElement(name = "format")
        Format format;

        @XmlElement(name = "meta")
        Meta meta;

        @XmlElementWrapper(name = "claims")
        @XmlElement(name = "claim")
        List<Claim> claims;

        @XmlElementWrapper(name = "claim_sets")
        @XmlElement(name = "claim_set")
        List<ClaimSet> claimSets;
    }

    @Value
    @AllArgsConstructor
    @NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
    @With
    public static class Meta {
        @XmlElement(name = "type_values")
        @Description("Must be specified when format is JWT_VC_JSON")
        List<String> typeValues;

        @XmlElement(name = "doctype_value")
        @Description("Must be specified when format is MSO_MDOC")
        String doctypeValue;

        @XmlElementWrapper(name = "vct_values")
        @XmlElement(name = "vct_value")
        @Description("Must be specified when format is SD_JWT")
        List<String> vctValues;
    }

    @Value
    @AllArgsConstructor
    @NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
    @With
    public static class Claim {
        @XmlElementWrapper(name = "path")
        @XmlElement(name = "path_element")
        List<String> path;

        @XmlElement(name = "id")
        String id;

        @XmlElementWrapper(name = "values")
        @XmlElement(name = "value")
        List<String> values;
    }

    @Value
    @AllArgsConstructor
    @NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
    @With
    public static class ClaimSet {
        @XmlElementWrapper(name = "claims")
        @XmlElement(name = "claim_id")
        List<String> claims;
    }

    @Value
    @AllArgsConstructor
    @NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
    @With
    public static class CredentialSet {
        @XmlElementWrapper(name = "options")
        @XmlElement(name = "option")
        List<VerifiablePresentationNotice.Option> options;

        @XmlElement(name = "required")
        Boolean required;
    }
}
