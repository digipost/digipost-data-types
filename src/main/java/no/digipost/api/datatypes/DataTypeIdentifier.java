package no.digipost.api.datatypes;

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
import no.digipost.api.datatypes.types.openingreceipt.OpeningReceipt;
import no.digipost.api.datatypes.types.openingreceipt.OpeningReceiptAccepted;
import no.digipost.api.datatypes.types.pickup.PickupNotice;
import no.digipost.api.datatypes.types.pickup.PickupNoticeStatus;
import no.digipost.api.datatypes.types.proof.Proof;
import no.digipost.api.datatypes.types.receipt.Receipt;
import no.digipost.api.datatypes.types.share.ShareDocumentsRequest;
import no.digipost.api.datatypes.types.share.ShareDocumentsRequestDocumentsShared;
import no.digipost.api.datatypes.types.share.ShareDocumentsRequestSharingStopped;
import no.digipost.api.datatypes.types.verifiableCredential.VerifiableCredentialNotice;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.Optional.ofNullable;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;

/**
 * HOWTO: Add new data type
 *
 * 1. Create new data type enum in this class
 * 2. Create the class, annotate, implement the DataType interface (see Appointment.class for example)
 * 3. Add class with relative package name to jaxb.index
 * 4. profit!
 */
public enum DataTypeIdentifier {
    APPOINTMENT(Appointment.class, "APPT", Appointment.EXAMPLE)
    , RESIDENCE(Residence.class, "RESD", Residence.EXAMPLE)
    , EXTERNAL_LINK(ExternalLink.class, "EXTL", ExternalLink.EXAMPLE)
    , BOLIGDETALJER(Boligdetaljer.class, "RDTL", Boligdetaljer.EXAMPLE)
    , RECEIPT(Receipt.class, "RCPT", Receipt.EXAMPLE)
    , PAYSLIP(Payslip.class, "PAY", Payslip.EXAMPLE)
    , SIGNED_DOCUMENT(SignedDocument.class, "SIGN", SignedDocument.EXAMPLE)
    , PICKUP_NOTICE(PickupNotice.class, "PKUP", PickupNotice.EXAMPLE)
    , PICKUP_NOTICE_STATUS(PickupNoticeStatus.class, "PKUS", PickupNoticeStatus.EXAMPLE)
    , EVENT(Event.class, "EVNT", Event.EXAMPLE)
    , PROOF(Proof.class, "PRF", Proof.EXAMPLE)
    , INKASSO(Inkasso.class, "INKA", Inkasso.EXAMPLE)
    , INVOICE(Invoice.class, "INVO", Invoice.EXAMPLE)
    , INVOICE_PAYMENT(InvoicePayment.class, "INVP", InvoicePayment.EXAMPLE)
    , SHARE_DOCUMENT_REQUEST(ShareDocumentsRequest.class, "SHAR", ShareDocumentsRequest.EXAMPLE)
    , SHARE_DOCUMENT_REQUEST_SHARING_STOPPED(ShareDocumentsRequestSharingStopped.class, "SHSS", ShareDocumentsRequestSharingStopped.EXAMPLE)
    , SHARE_DOCUMENT_REQUEST_DOCUMENTS_SHARED(ShareDocumentsRequestDocumentsShared.class, "SHDS", ShareDocumentsRequestDocumentsShared.EXAMPLE)
    , OPENING_RECEIPT(OpeningReceipt.class, "OPRC", OpeningReceipt.EXAMPLE)
    , OPENING_RECEIPT_ACCEPTED(OpeningReceiptAccepted.class, "OPAC", OpeningReceiptAccepted.EXAMPLE)
    , VERIFIABLE_CREDENTIAL_NOTICE(VerifiableCredentialNotice.class, "VCNO", VerifiableCredentialNotice.EXAMPLE)
    ;

    private final Class<? extends DataType> dataType;
    private final String shortName;
    private final DataType example;

    private static final Map<Class<? extends DataType>, DataTypeIdentifier> byType;
    private static final Map<String, DataTypeIdentifier> byShortName;
    private final Set<Class<? extends DataType>> complementables;

    static {
        byType = Stream.of(values()).collect(toMap(DataTypeIdentifier::getDataType, identity()));
        byShortName = Stream.of(values()).collect(toMap(DataTypeIdentifier::getShortName, identity()));
    }

    DataTypeIdentifier(final Class<? extends DataType> dataType, final String shortName, final DataType example) {
        this.dataType = dataType;
        this.shortName = shortName;
        this.example = example;
        complementables = Optional.ofNullable(getDataType().getAnnotation(ComplementedBy.class))
                .map(ComplementedBy::value)
                .stream()
                .flatMap(Stream::of)
                .collect(collectingAndThen(toSet(), Collections::unmodifiableSet));
    }

    public static DataTypeIdentifier fromRepresentationType(final Class<? extends DataType> representation) {
        return ofNullable(byType.get(representation))
            .orElseThrow(() -> new IllegalStateException(String.format(
                "Could not find %s for type %s. All subtypes of %s must have a unique %s.",
                DataTypeIdentifier.class.getSimpleName(), representation,
                DataType.class.getSimpleName(), DataTypeIdentifier.class.getSimpleName())));
    }

    public static DataTypeIdentifier fromShortName(final String shortName) {
        return Optional.ofNullable(byShortName.get(shortName))
            .orElseThrow(() -> new IllegalArgumentException("No value for " + DataTypeIdentifier.class.getSimpleName() + " found for shortName " + shortName));
    }

    public static Set<Class<? extends DataType>> getAllClasses() {
        return byType.keySet();
    }

    public boolean canBeComplementedBy(DataType successor) {
        return complementables.contains(successor.getClass());
    }
    
    public Class<? extends DataType> getDataType() {
        return dataType;
    }

    public String getShortName() {
        return shortName;
    }

    public DataType getExample() {
        return example;
    }
}
