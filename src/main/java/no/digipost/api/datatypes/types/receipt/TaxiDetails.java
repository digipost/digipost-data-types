package no.digipost.api.datatypes.types.receipt;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;
import lombok.experimental.Wither;
import no.digipost.api.datatypes.documentation.Description;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@XmlType
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@With
@Description("Details for taxi receipts")
public class TaxiDetails {
    @XmlElement
    String carPlateNumber;
    @XmlElement
    String license;
    @XmlElement
    String orgNumberLicenseHolder;
    @XmlElement
    ZonedDateTime startTime;
    @XmlElement
    ZonedDateTime stopTime;
    @XmlElement
    BigDecimal tips;
    @XmlElement
    BigDecimal totalMeterPrice;
    @XmlElement
    Integer totalDistanceBeforeBoardingInMeters;
    @XmlElement
    Integer totalDistanceInMeters;
    @XmlElement
    Integer totalDistanceWithPassengerInMeters;
    @XmlElement
    Integer totalTimeBeforeBoardingInSeconds;
    @XmlElement
    Integer totalTimeInSeconds;
    @XmlElement
    Integer totalTimeWithPassengerInSeconds;
    @Valid
    VatDetails vat;

    public static final TaxiDetails EXAMPLE = new TaxiDetails(
            "EK99999", "12341ASDF", "123456789",
            ZonedDateTime.of(2018, 6, 5, 10, 0, 0, 0, ZoneId.systemDefault()),
            ZonedDateTime.of(2018, 6, 5, 10, 30, 0, 0, ZoneId.systemDefault()),
            new BigDecimal("8.00"), new BigDecimal("438.50"), 2000, 8500,
            6500, 320, 1220, 900,
            VatDetails.EXAMPLE);
}
