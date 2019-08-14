package no.digipost.api.datatypes;

import no.digipost.api.datatypes.types.Appointment;
import no.digipost.api.datatypes.types.pickup.PickupNotice;
import no.digipost.api.datatypes.types.pickup.PickupNoticeStatus;
import org.junit.Test;

import static co.unruly.matchers.Java8Matchers.where;
import static co.unruly.matchers.Java8Matchers.whereNot;
import static org.hamcrest.MatcherAssert.assertThat;

public class ComplementByTest {
    
    @Test
    public void kan_komplementere() {
        assertThat(PickupNotice.EXAMPLE, where(s -> s.getTypeIdentifier().canBeComplementedBy(PickupNoticeStatus.EXAMPLE)));
        assertThat(PickupNotice.EXAMPLE, where(s -> s.getTypeIdentifier().canBeComplementedBy(PickupNotice.EXAMPLE)));
    }

    @Test
    public void kan_IKKE_complementere_HVIS_target_type_ikke_komplementer() {
        assertThat(PickupNotice.EXAMPLE, whereNot(s -> s.getTypeIdentifier().canBeComplementedBy(Appointment.EXAMPLE)));
    }

    @Test
    public void kan_IKKE_complementere_HVIS_original_ikke_komplementerer() {
        assertThat(Appointment.EXAMPLE, whereNot(s -> s.getTypeIdentifier().canBeComplementedBy(PickupNoticeStatus.EXAMPLE)));
    }

    @Test
    public void kan_IKKE_complementere_seg_selv_med_mindre_eksplisitt_definert() {
        assertThat(Appointment.EXAMPLE, whereNot(s -> s.getTypeIdentifier().canBeComplementedBy(Appointment.EXAMPLE)));
        assertThat(PickupNotice.EXAMPLE, where(s -> s.getTypeIdentifier().canBeComplementedBy(PickupNotice.EXAMPLE)));
    }
}
