package no.digipost.api.datatypes;

import no.digipost.api.datatypes.types.Appointment;
import no.digipost.api.datatypes.types.Inkasso;
import no.digipost.api.datatypes.types.invoice.Invoice;
import no.digipost.api.datatypes.types.invoice.InvoicePayment;
import no.digipost.api.datatypes.types.pickup.PickupNotice;
import no.digipost.api.datatypes.types.pickup.PickupNoticeStatus;
import no.digipost.api.datatypes.types.signing.SigningCompletedBy;
import no.digipost.api.datatypes.types.signing.SigningRejectedBy;
import no.digipost.api.datatypes.types.signing.SigningRequest;
import org.junit.jupiter.api.Test;

import static co.unruly.matchers.Java8Matchers.where;
import static co.unruly.matchers.Java8Matchers.whereNot;
import static org.hamcrest.MatcherAssert.assertThat;

class ComplementByTest {

    @Test
    void kan_komplementere() {
        assertThat(PickupNotice.EXAMPLE, where(s -> s.getTypeIdentifier().canBeComplementedBy(PickupNoticeStatus.EXAMPLE)));
        assertThat(PickupNotice.EXAMPLE, where(s -> s.getTypeIdentifier().canBeComplementedBy(PickupNotice.EXAMPLE)));
    }

    @Test
    void kan_IKKE_complementere_HVIS_target_type_ikke_komplementer() {
        assertThat(PickupNotice.EXAMPLE, whereNot(s -> s.getTypeIdentifier().canBeComplementedBy(Appointment.EXAMPLE)));
    }

    @Test
    void kan_IKKE_complementere_HVIS_original_ikke_komplementerer() {
        assertThat(Appointment.EXAMPLE, whereNot(s -> s.getTypeIdentifier().canBeComplementedBy(PickupNoticeStatus.EXAMPLE)));
    }

    @Test
    void kan_IKKE_complementere_seg_selv_med_mindre_eksplisitt_definert() {
        assertThat(Appointment.EXAMPLE, whereNot(s -> s.getTypeIdentifier().canBeComplementedBy(Appointment.EXAMPLE)));
        assertThat(PickupNotice.EXAMPLE, where(s -> s.getTypeIdentifier().canBeComplementedBy(PickupNotice.EXAMPLE)));
    }
    
    @Test
    void kan_komplementere_fakturadomene() {
        assertThat(Invoice.EXAMPLE, where(s -> s.getTypeIdentifier().canBeComplementedBy(InvoicePayment.EXAMPLE)));
        assertThat(Inkasso.EXAMPLE, where(s -> s.getTypeIdentifier().canBeComplementedBy(InvoicePayment.EXAMPLE)));
    }

    @Test
    void kan_komplementere_signering_med_hendelser() {
        assertThat(SigningRequest.EXAMPLE, where(s -> s.getTypeIdentifier().canBeComplementedBy(SigningCompletedBy.EXAMPLE)));
        assertThat(SigningRequest.EXAMPLE, where(s -> s.getTypeIdentifier().canBeComplementedBy(SigningRejectedBy.EXAMPLE)));
    }

    @Test
    void signering_fullfort_av_signatar_kan_komplementeres_med_ny_fullfort_av_signatar() {
        assertThat(SigningCompletedBy.EXAMPLE, where(s -> s.getTypeIdentifier().canBeComplementedBy(SigningCompletedBy.EXAMPLE)));
    }

    @Test
    void signering_avvist_av_signatar_kan_ikke_komplementeres_videre() {
        assertThat(SigningRejectedBy.EXAMPLE, whereNot(s -> s.getTypeIdentifier().canBeComplementedBy(SigningRejectedBy.EXAMPLE)));
        assertThat(SigningRejectedBy.EXAMPLE, whereNot(s -> s.getTypeIdentifier().canBeComplementedBy(SigningCompletedBy.EXAMPLE)));
    }
}
