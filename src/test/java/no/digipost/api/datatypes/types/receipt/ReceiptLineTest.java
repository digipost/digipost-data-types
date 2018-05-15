package no.digipost.api.datatypes.types.receipt;

import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ReceiptLineTest {

    @Test
    public void vatPercent_should_be_zero_when_vat_amount_is_zero() {
        assertThat(ReceiptLine.EXAMPLE.withItemVat(new BigDecimal("0.0")).getVatPercent(), is(BigDecimal.ZERO));
    }

    @Test
    public void vatPercent_should_be_100_when_vat_amount_is_equal_to_unit_price() {
        BigDecimal price = new BigDecimal("100.0");
        assertThat(ReceiptLine.EXAMPLE.withItemPrice(price).withItemVat(price).getVatPercent(), is(BigDecimal.valueOf(100, 0)));
    }

    @Test
    public void vatPercent_should_be_null_when_vat_amount_is_null() {
        assertThat(ReceiptLine.EXAMPLE.withItemVat(null).getVatPercent(), nullValue());
    }

    @Test
    public void vatPercent_should_be_null_when_item_price_is_null() {
        assertThat(ReceiptLine.EXAMPLE.withItemPrice(null).getVatPercent(), nullValue());
    }
}
