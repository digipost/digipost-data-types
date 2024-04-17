package no.digipost.api.datatypes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import no.digipost.api.datatypes.types.Appointment;
import no.digipost.api.datatypes.types.Boligdetaljer;
import no.digipost.api.datatypes.types.Event;
import no.digipost.api.datatypes.types.ExternalLink;
import no.digipost.api.datatypes.types.Inkasso;
import no.digipost.api.datatypes.types.Payslip;
import no.digipost.api.datatypes.types.Residence;
import no.digipost.api.datatypes.types.SignedDocument;
import no.digipost.api.datatypes.types.invoice.Invoice;
import no.digipost.api.datatypes.types.invoice.InvoicePayment;
import no.digipost.api.datatypes.types.pickup.PickupNotice;
import no.digipost.api.datatypes.types.pickup.PickupNoticeStatus;
import no.digipost.api.datatypes.types.proof.Proof;
import no.digipost.api.datatypes.types.receipt.Receipt;
import no.digipost.api.datatypes.types.share.ShareDocumentsRequest;
import no.digipost.api.datatypes.types.share.ShareDocumentsRequestDocumentsShared;
import no.digipost.api.datatypes.types.share.ShareDocumentsRequestSharingStopped;

@JsonTypeInfo(use = JsonTypeInfo.Id.SIMPLE_NAME, property = "type", include = JsonTypeInfo.As.EXISTING_PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(Appointment.class)
        , @JsonSubTypes.Type(Residence.class)
        , @JsonSubTypes.Type(ExternalLink.class)
        , @JsonSubTypes.Type(Boligdetaljer.class)
        , @JsonSubTypes.Type(Receipt.class)
        , @JsonSubTypes.Type(Payslip.class)
        , @JsonSubTypes.Type(SignedDocument.class)
        , @JsonSubTypes.Type(PickupNotice.class)
        , @JsonSubTypes.Type(PickupNoticeStatus.class)
        , @JsonSubTypes.Type(Event.class)
        , @JsonSubTypes.Type(Proof.class)
        , @JsonSubTypes.Type(Inkasso.class)
        , @JsonSubTypes.Type(Invoice.class)
        , @JsonSubTypes.Type(InvoicePayment.class)
        , @JsonSubTypes.Type(ShareDocumentsRequest.class)
        , @JsonSubTypes.Type(ShareDocumentsRequestSharingStopped.class)
        , @JsonSubTypes.Type(ShareDocumentsRequestDocumentsShared.class)
})
public interface DataType {

    @JsonProperty("type")
    default String getType() {
        return getClass().getSimpleName();
    }

    @JsonIgnore
    default DataTypeIdentifier getTypeIdentifier() {
        return DataTypeIdentifier.fromRepresentationType(getClass());
    }

    default DataType withDefaultsForMissingOptionalValues() {
        return this;
    }
    
}
