package no.digipost.api.datatypes.types;

import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;

import java.util.List;
import java.util.Map;

@XmlRootElement(name = "verifiable-presentation-notice")
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@With
@Description("DCQL-aligned request for one or more credentials.")
public class VerifiablePresentationNotice implements DataType {

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
        String format;

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
        @XmlElement(name = "doctype_value")
        String doctypeValue;

        @XmlElementWrapper(name = "vct_values")
        @XmlElement(name = "vct_value")
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
        List<Option> options;

        @XmlElement(name = "required")
        Boolean required;
    }

    @Value
    @AllArgsConstructor
    @NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
    @With
    public static class Option {
        @XmlElementWrapper(name = "credential_ids")
        @XmlElement(name = "credential_id")
        List<String> credentialIds;
    }
}