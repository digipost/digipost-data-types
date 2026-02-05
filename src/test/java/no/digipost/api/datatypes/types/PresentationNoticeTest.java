package no.digipost.api.datatypes.types;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import no.digipost.api.datatypes.types.verifiableCredential.DcqlQuery;
import no.digipost.api.datatypes.types.verifiableCredential.VerifiablePresentationNotice;
import org.junit.jupiter.api.Test;

public class PresentationNoticeTest {

    @Test
    public void dcqlShouldSerializeCorrectlyAsJson() throws JsonProcessingException {
        VerifiablePresentationNotice dcqlExample = VerifiablePresentationNotice.DCQL_EXAMPLE;

        DcqlQuery dcqlQuery = dcqlExample.getDcqlQuery();
        ObjectMapper jsonMapper = new ObjectMapper();

        String dcqlJson = jsonMapper.writeValueAsString(dcqlQuery);
        String expected = "{\"credentials\":[{\"id\":\"credential1\",\"format\":\"dc+sd-jwt\",\"meta\":{\"vct_values\":[\"driversLicence\"]},\"claims\":null,\"claim_sets\":null}],\"credential_sets\":null}";

        assert dcqlJson.equals(expected);
    }
}
