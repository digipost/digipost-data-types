package no.digipost.api.datatypes.types.receipt;


import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

class ReceiptLineTest {

    @Test
    void vatPercent_should_be_zero_when_vat_amount_is_zero() {
        assertThat(ReceiptLine.EXAMPLE.withItemVat(new BigDecimal("0.0")).getVatPercent(), is(BigDecimal.ZERO));
    }

    @Test
    void vatPercent_should_be_100_when_vat_amount_is_equal_to_unit_price() {
        BigDecimal price = new BigDecimal("100.0");
        assertThat(ReceiptLine.EXAMPLE.withItemPrice(price).withItemVat(price).getVatPercent(), is(BigDecimal.valueOf(100, 0)));
    }

    @Test
    void vatPercent_should_be_null_when_vat_amount_is_null() {
        assertThat(ReceiptLine.EXAMPLE.withItemVat(null).getVatPercent(), nullValue());
    }

    @Test
    void vatPercent_should_be_null_when_item_price_is_null() {
        assertThat(ReceiptLine.EXAMPLE.withItemPrice(null).getVatPercent(), nullValue());
    }
}
