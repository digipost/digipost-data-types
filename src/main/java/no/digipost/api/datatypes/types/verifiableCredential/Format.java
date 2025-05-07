package no.digipost.api.datatypes.types.verifiableCredential;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Format {

    JWT_VC_JSON("jwt_vc_json"),
    MSO_MDOC("mso_mdoc"),
    SD_JWT("sd_jwt");

    private final String value;

    Format(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
