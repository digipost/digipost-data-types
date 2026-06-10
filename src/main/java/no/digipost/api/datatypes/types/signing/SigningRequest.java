package no.digipost.api.datatypes.types.signing;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;
import no.digipost.api.datatypes.ComplementedBy;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@XmlRootElement(name = "signing-request")
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@With
@Description("A signing request in Digipost's internal signing flow.")
@ComplementedBy({SigningCompletedBy.class, SigningRejectedBy.class})
public class SigningRequest implements DataType {

    @XmlElement(name = "oppdrag-ref", required = true)
    @Description("UUID reference to the signing assignment.")
    @NotNull
    UUID oppdragRef;

    @XmlElement(name = "gyldig-til", required = true)
    @Description("When the signing request expires. ISO8601 full DateTime with timezone.")
    @NotNull
    ZonedDateTime gyldigTil;

    @XmlElement(name = "signatarer", required = true)
    @Description("Non-empty list of signers.")
    @NotEmpty
    @Valid
    List<Signatar> signatarer;

    public static final SigningRequest EXAMPLE = new SigningRequest(
            UUID.fromString("264f2cf0-6cd9-4a26-9f9f-560d0df7e69a"),
            ZonedDateTime.of(2026, 5, 31, 23, 59, 0, 0, ZoneId.of("+02:00")),
            List.of(
                    Signatar.EXAMPLE,
                    new Signatar("kari.nordmann#1234", "Kari Nordmann")
            )
    );
}

