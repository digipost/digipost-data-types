## Data types

|Type|Description|
|----|-----------|
|[Appointment](#appointment)|Appointment represents a meeting set for a specific place and time|
|[Boligdetaljer](#boligdetaljer)|Details about a Residence, and may be joined with Residence to retrieve the core fields of a Residence.|
|[Category](#category)|Category is a way to specify which category the data of a document is related to.|
|[Event](#event)|Event represents an event that occurs over a time period or several days. Eg. a conference or an election|
|[ExternalLink](#externallink)|An external URL, along with an optional description and deadline for resources such as a survey.|
|[Payslip](#payslip)|For treating documents as Payslips.|
|[PickupNotice](#pickupnotice)|Details about a pickup notice|
|[PickupNoticeStatus](#pickupnoticestatus)|Updates to status for PickupNotice|
|[Receipt](#receipt)|Receipt represents a document containing details about a purchase|
|[Residence](#residence)|Residence is a way of linking separate data for the same residence|
|[SignedDocument](#signeddocument)|Details about a signed document|

## Appointment

Appointment represents a meeting set for a specific place and time

### Fields

|Name|Type|Required|Description|
|----|----|--------|-----------|
|startTime|ZonedDateTime|yes|ISO8601 full DateTime|
|endTime|ZonedDateTime|no|ISO8601 full DateTime. Default value 30 minutes after startTime|
|arrivalTime|String|no|Free text but can contain a ISO8601 DateTime. Example: Please arrive 15 minutes early|
|place|String|no|The name of the place. Example: Oslo City Røntgen|
|address|[Address](#appointmentaddress)|no||
|subTitle|String|no|Example: MR-undersøkelse av høyre kne|
|info|List|no|Additional sections of information (max 2) with a title and text|

### Appointment.Address

|Name|Type|Required|Description|
|----|----|--------|-----------|
|streetAddress|String|no|E.g. Storgata 11|
|streetAddress2|String|no|E.g. Romerike Næringspark|
|postalCode|String|no||
|city|String|no||
|country|String|no||

### XML

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<appointment xmlns="http://api.digipost.no/schema/datatypes">
    <start-time>2017-06-27T10:00:00+02:00</start-time>
    <end-time>2017-06-27T11:00:00+02:00</end-time>
    <arrival-time>Oppmøte senest 15 minutter før timen</arrival-time>
    <place>Oslo City Røntgen</place>
    <address>
        <street-address>Storgata 23</street-address>
        <postal-code>0011</postal-code>
        <city>Oslo</city>
        <country>Norge</country>
    </address>
    <sub-title>Undersøke smerter i ryggen</sub-title>
    <info>
        <title>Informasjon om Oslo City Røntgen</title>
        <text>Oslo City Røntgen er et spesialistsenter for avansert bildediagnostikk.</text>
    </info>
</appointment>
```

## Boligdetaljer

Details about a Residence, and may be joined with Residence to retrieve the core fields of a Residence.

### Fields

|Name|Type|Required|Description|
|----|----|--------|-----------|
|residence|[Residence](#boligdetaljerresidence)|yes||
|hjemmelshavere|List|no|List of people with legal rights associated with the residence|
|bruksareal|Integer|no|BRA for bolig|
|antallOppholdsrom|Integer|no|Number of rooms, bathroom, kitchen and storage rooms excluded|
|antallBaderom|Integer|no|Number of bathrooms|
|omsetningshistorikk|List|no|Previous sales and transactions|
|organisasjonsnummer|String|no||
|bruksenhet|String|no||
|andelsnummer|String|no||
|heftelser|List|no||
|callToAction|[ExternalLink](#boligdetaljerexternallink)|no||

### Boligdetaljer.Residence

|Name|Type|Required|Description|
|----|----|--------|-----------|
|address|[ResidenceAddress](#boligdetaljerresidenceaddress)|yes||
|matrikkel|[Matrikkel](#boligdetaljermatrikkel)|no||
|source|String|no||
|externalId|String|no||

### Boligdetaljer.ResidenceAddress

|Name|Type|Required|Description|
|----|----|--------|-----------|
|unitNumber|String|no|Bolignummer. Must be of format [UKHL]0000. E.g. H0304|
|houseNumber|String|no|A house number with or without a house letter. E.g. 11 or 11A|
|streetName|String|no|The name of the street. E.g. Storgata|
|postalCode|String|no||
|city|String|no||

### Boligdetaljer.Matrikkel

|Name|Type|Required|Description|
|----|----|--------|-----------|
|kommunenummer|String|yes||
|gaardsnummer|String|yes||
|bruksnummer|String|yes||
|festenummer|String|no||
|seksjonsnummer|String|no||

### Boligdetaljer.ExternalLink

|Name|Type|Required|Description|
|----|----|--------|-----------|
|url|URI|yes|Target URL of this link. Must be http or https.|
|deadline|ZonedDateTime|no|Optional deadline for the user to respond. ISO8601 full DateTime.|
|description|String|no|A short, optional text-field, describing the external link.|
|buttonText|String|no|Optional text which will be displayed on the button.|

### XML

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<boligdetaljer xmlns="http://api.digipost.no/schema/datatypes">
    <residence>
        <address>
            <house-number>23</house-number>
            <street-name>Storgata</street-name>
            <postal-code>0011</postal-code>
            <city>Oslo</city>
        </address>
        <matrikkel>
            <kommunenummer>0301</kommunenummer>
            <gaardsnummer>208</gaardsnummer>
            <bruksnummer>630</bruksnummer>
            <festenummer>0</festenummer>
            <seksjonsnummer>0</seksjonsnummer>
        </matrikkel>
        <source>boligmappa</source>
        <external-id>externalId</external-id>
    </residence>
    <hjemmelshavere>
        <name>Gunnar Gunnersen</name>
        <email>gunnargunnar@gunn.ar</email>
    </hjemmelshavere>
    <bruksareal>59</bruksareal>
    <antall-oppholdsrom>3</antall-oppholdsrom>
    <antall-baderom>4</antall-baderom>
    <omsetningshistorikk>
        <dato>2017-07-27T10:00:00+02:00</dato>
        <beskrivelse>Privat salg av sekundærbolig</beskrivelse>
        <selger>Bill Isalg</selger>
        <kjoeper>Cooper Coopersen</kjoeper>
        <beloep>12345678</beloep>
    </omsetningshistorikk>
    <organisasjonsnummer>123456789</organisasjonsnummer>
    <bruksenhet>H1337</bruksenhet>
    <andelsnummer>42</andelsnummer>
    <heftelser>
        <panthaver>TNT ASA</panthaver>
        <type-pant>Pantedokument</type-pant>
        <beloep>3000000000</beloep>
    </heftelser>
    <callToAction>
        <url>https://www.example.com</url>
        <description>Gå til avsenders side for å gjøre en handling</description>
        <button-text>Ta meg til handling!</button-text>
    </callToAction>
</boligdetaljer>
```

## Category

Category is a way to specify which category the data of a document is related to.

### Fields

|Name|Type|Required|Description|
|----|----|--------|-----------|
|category|String|no||

### XML

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<category xmlns="http://api.digipost.no/schema/datatypes">RESIDENCE</category>
```

## Event

Event represents an event that occurs over a time period or several days. Eg. a conference or an election

### Fields

|Name|Type|Required|Description|
|----|----|--------|-----------|
|subTitle|String|no|Example: 'Kommunestyre- og fylkestingvalg'|
|time|List|yes|List of time intervals|
|timeLabel|String|no|Optional label for time. null yield default in gui, eg. 'Opening hours'|
|description|String|no|Free text but can contain a ISO8601 DateTime. Example: 'Please use entrance from street'|
|place|String|no|The name of the place. Example: 'Sagene skole'|
|placeLabel|String|no|Optional label for place. null yield default in gui, eg. 'Venue location'|
|address|[Address](#eventaddress)|no||
|info|List|no|Additional sections of information (max 10) with a title and text.|
|barcodeLabel|String|no|Optional label for barcode. null yield default in gui, eg. ''|
|barcode|[Barcode](#eventbarcode)|no|Barcode|
|links|List|no|Links for releated information to the appointment|

### Event.Address

|Name|Type|Required|Description|
|----|----|--------|-----------|
|streetAddress|String|no|E.g. Storgata 11|
|streetAddress2|String|no|E.g. Romerike Næringspark|
|postalCode|String|no||
|city|String|no||
|country|String|no||

### Event.Barcode

|Name|Type|Required|Description|
|----|----|--------|-----------|
|barcodeValue|String|no|The barcode on this receipt|
|barcodeType|String|no||
|barcodeText|String|no|Barcode text can be used to describe the barcode|
|showValueInBarcode|Boolean|no|If true, the barcode will render its value as part of the image|

### XML

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<event xmlns="http://api.digipost.no/schema/datatypes">
    <sub-title>Kommunestyre- og fylkestingvalg</sub-title>
    <start-time>
        <start-time>2019-05-23T10:00:00+02:00</start-time>
        <end-time>2019-05-23T16:00:00+02:00</end-time>
    </start-time>
    <timeLabel>Opening hours</timeLabel>
    <description>Velkommen til valg! Husk legitimasjon.</description>
    <place>Sagene skole</place>
    <placeLabel>Election venue</placeLabel>
    <address>
        <street-address>Storgata 23</street-address>
        <postal-code>0011</postal-code>
        <city>Oslo</city>
        <country>Norge</country>
    </address>
    <info>
        <title>Forhåndsstemming</title>
        <text>Du kan forhåndsstemme fra 10. august</text>
    </info>
    <barcodeLabel>Barcode for use on election day:</barcodeLabel>
    <barcode>
        <barcode-value>1234567890</barcode-value>
        <barcode-type>code-128</barcode-type>
        <barcode-text>Show barcode for faster identification</barcode-text>
        <show-value-in-barcode>true</show-value-in-barcode>
    </barcode>
    <links>
        <url>https://valg.no</url>
        <description>Les mer om valget på valg.no</description>
    </links>
</event>
```

## ExternalLink

An external URL, along with an optional description and deadline for resources such as a survey.

### Fields

|Name|Type|Required|Description|
|----|----|--------|-----------|
|url|URI|yes|Target URL of this link. Must be http or https.|
|deadline|ZonedDateTime|no|Optional deadline for the user to respond. ISO8601 full DateTime.|
|description|String|no|A short, optional text-field, describing the external link.|
|buttonText|String|no|Optional text which will be displayed on the button.|

### XML

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<externalLink xmlns="http://api.digipost.no/schema/datatypes">
    <url>https://www.oslo.kommune.no/barnehage/svar-pa-tilbud-om-plass/</url>
    <deadline>2017-09-30T13:37:00+02:00</deadline>
    <description>Oslo Kommune ber deg akseptere eller avslå tilbudet om barnehageplass.</description>
    <button-text>Svar på barnehageplass</button-text>
</externalLink>
```

## Payslip

For treating documents as Payslips.

### Fields

|Name|Type|Required|Description|
|----|----|--------|-----------|


### XML

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<payslip xmlns="http://api.digipost.no/schema/datatypes"/>
```

## PickupNotice

Details about a pickup notice

### Complemented by: 
[PickupNotice](#pickupnotice), [PickupNoticeStatus](#pickupnoticestatus)

### Fields

|Name|Type|Required|Description|
|----|----|--------|-----------|
|parcelId|String|yes|The id of the parcel in posten|
|parcelUUID|String|no|The uuid of the parcel|
|barcode|[Barcode](#pickupnoticebarcode)|yes|Barcode|
|productName|String|no|Mail Service product name|
|arrivalDateTime|ZonedDateTime|yes|ISO8601 full DateTime for arrival at pickup place|
|returnDateTime|ZonedDateTime|yes|ISO8601 full DateTime for return back to sender|
|recipient|[Recipient](#pickupnoticerecipient)|yes|The recipient of the parcel|
|sender|[Sender](#pickupnoticesender)|no|The sender of the parcel|
|pickupPlace|[PickupPlace](#pickupnoticepickupplace)|yes|where the parcel can be fetched|
|thePackage|[Package](#pickupnoticepackage)|no|package information|
|cost|[Cost](#pickupnoticecost)|no|Information about value, mva, customs processing and more|
|status|[Status](#pickupnoticestatus)|no|The state the package is at present time|
|tags|Set|no|Tags to describe the document|

### PickupNotice.Barcode

|Name|Type|Required|Description|
|----|----|--------|-----------|
|barcodeValue|String|no|The barcode on this receipt|
|barcodeType|String|no||
|barcodeText|String|no|Barcode text can be used to describe the barcode|
|showValueInBarcode|Boolean|no|If true, the barcode will render its value as part of the image|

### PickupNotice.Recipient

|Name|Type|Required|Description|
|----|----|--------|-----------|
|name|String|yes|The name of the recipient|
|digipostAddress|String|yes|The digipost address for the recipient|
|address|[Address](#pickupnoticeaddress)|no||

### PickupNotice.Address

|Name|Type|Required|Description|
|----|----|--------|-----------|
|streetAddress|String|no|E.g. Storgata 11|
|streetAddress2|String|no|E.g. Romerike Næringspark|
|postalCode|String|no||
|city|String|no||
|country|String|no||

### PickupNotice.Sender

|Name|Type|Required|Description|
|----|----|--------|-----------|
|name|String|no|The senders name|
|reference|String|no|The senders reference|
|address|[Address](#pickupnoticeaddress)|no||

### PickupNotice.PickupPlace

|Name|Type|Required|Description|
|----|----|--------|-----------|
|name|String|yes|The pickup place name|
|code|String|yes|The pickup code|
|instruction|String|yes|instructions for fetching the parcel|
|shelfLocation|String|no|shelf location at pickup point|
|address|[Address](#pickupnoticeaddress)|yes||

### PickupNotice.Package

|Name|Type|Required|Description|
|----|----|--------|-----------|
|length|Integer|no|Package lenght in cm|
|width|Integer|no|Package width in cm|
|height|Integer|no|Package height in cm|
|weight|Integer|no|Package weight in grams|

### PickupNotice.Cost

|Name|Type|Required|Description|
|----|----|--------|-----------|
|valueToBePayed|BigDecimal|yes|The value of the parcel in NOK|
|packageValue|BigDecimal|no|The value of the parcel in NOK|
|customsFeeOutlayed|BigDecimal|no|payed fee in customs|
|vasText|String|no|Information about the value added service (vas)|
|customsFee|BigDecimal|no|Fee payed for customs declaration|
|customsFeeOutlayCost|BigDecimal|no|Outlay for customs by the service|
|codAmount|BigDecimal|no|Cash on delivery (cod) amount|
|codFee|BigDecimal|no|Cash on delivery (cod) fee|

### PickupNotice.Status

Valid values:

* READY_FOR_PICKUP
* PICKED_UP
* RETURNED
* UNKNOWN
* DEVIATION

### XML

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<pickup-notice xmlns="http://api.digipost.no/schema/datatypes">
    <parcel-id>KB432788293NO</parcel-id>
    <parcel-uuid>70300492517312675</parcel-uuid>
    <barcode>
        <barcode-value>1234567890</barcode-value>
        <barcode-type>CODE_128</barcode-type>
        <barcode-text>Show barcode for faster identification</barcode-text>
        <show-value-in-barcode>true</show-value-in-barcode>
    </barcode>
    <product-name>Klimanøytral Servicepakke</product-name>
    <arrival-date-time>2018-09-10T10:00:00+02:00</arrival-date-time>
    <return-date-time>2018-09-24T10:00:00+02:00</return-date-time>
    <recipient>
        <name>Test Testesen</name>
        <digipost-address>test.testesen#0000</digipost-address>
        <address>
            <street-address>Storgata 23</street-address>
            <postal-code>0011</postal-code>
            <city>Oslo</city>
            <country>Norge</country>
        </address>
    </recipient>
    <sender>
        <name>Avsenderservice as</name>
        <reference>13372500</reference>
        <address>
            <street-address>Storgata 23</street-address>
            <postal-code>0011</postal-code>
            <city>Oslo</city>
            <country>Norge</country>
        </address>
    </sender>
    <pickup-place>
        <name>Coop Mega</name>
        <code>RC89</code>
        <instruction>Må hentes innen 010180</instruction>
        <shelf-location>H32</shelf-location>
        <address>
            <street-address>Storgata 23</street-address>
            <postal-code>0011</postal-code>
            <city>Oslo</city>
            <country>Norge</country>
        </address>
    </pickup-place>
    <package>
        <length>120</length>
        <width>60</width>
        <height>60</height>
        <weight>35000</weight>
    </package>
    <cost>
        <value-to-be-payed>128.00</value-to-be-payed>
        <package-value>1277.00</package-value>
        <customs-fee-outlayed>162.00</customs-fee-outlayed>
        <vas-text>FORENKLET TOLLBEHANDLING</vas-text>
        <customs-fee>0</customs-fee>
        <customs-fee-outlay-cost>0</customs-fee-outlay-cost>
        <cod-amount>0</cod-amount>
        <cod-fee>0</cod-fee>
    </cost>
    <status>READY_FOR_PICKUP</status>
    <tags>POSTEN</tags>
</pickup-notice>
```

## PickupNoticeStatus

Updates to status for PickupNotice

### Fields

|Name|Type|Required|Description|
|----|----|--------|-----------|
|status|[Status](#pickupnoticestatusstatus)|yes|The status of the PickupNotice|
|occurrenceDatetime|ZonedDateTime|no|ISO8601 full DateTime for time of occurrence|

### PickupNoticeStatus.Status

Valid values:

* READY_FOR_PICKUP
* PICKED_UP
* RETURNED
* UNKNOWN
* DEVIATION

### XML

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<pickup-notice-status xmlns="http://api.digipost.no/schema/datatypes">
    <status>READY_FOR_PICKUP</status>
    <occurrence-datetime>2019-01-10T10:10:00+01:00</occurrence-datetime>
</pickup-notice-status>
```

## Receipt

Receipt represents a document containing details about a purchase

### Fields

|Name|Type|Required|Description|
|----|----|--------|-----------|
|receiptId|String|no|The ID of this receipt in the system it was imported from|
|receiptNumber|String|no|The original receipt number from the store|
|purchaseTime|ZonedDateTime|yes|When the purchase was made. ISO8601 full DateTime|
|totalPrice|BigDecimal|yes|The total price paid for the item(s) purchased|
|totalVat|BigDecimal|yes|The total vat amount for the item(s) purchased|
|currencyCode|String|no|Currency of the price, ISO4217. Example: NOK|
|cashier|String|no|Identifier for cashier who made the sale|
|register|String|no|Identifier for the register where the purchase was made|
|merchantChain|String|no|Optional name of the chain that the merchant is a part of|
|merchantName|String|yes|Name of the store or merchant. Example: Grünerløkka Hip Coffee|
|merchantPhoneNumber|String|no||
|merchantAddress|[Address](#receiptaddress)|no|Address of the store or merchant|
|organizationNumber|String|no|Organization number of the sales point|
|barcode|[Barcode](#receiptbarcode)|no||
|payments|List|no|List of payments done during this purchase|
|items|List|no|The individual items sold|
|taxiDetails|[TaxiDetails](#receipttaxidetails)|no|Details for taxi receipts|
|customer|[Customer](#receiptcustomer)|no|Name and address of customer|
|delivery|[Delivery](#receiptdelivery)|no|Name and address of delivery|
|orderNumber|String|no||
|membershipNumber|String|no||
|comment|String|no||

### Receipt.Address

|Name|Type|Required|Description|
|----|----|--------|-----------|
|streetAddress|String|no|E.g. Storgata 11|
|streetAddress2|String|no|E.g. Romerike Næringspark|
|postalCode|String|no||
|city|String|no||
|country|String|no||

### Receipt.Barcode

|Name|Type|Required|Description|
|----|----|--------|-----------|
|barcodeValue|String|no|The barcode on this receipt|
|barcodeType|String|no||
|barcodeText|String|no|Barcode text can be used to describe the barcode|
|showValueInBarcode|Boolean|no|If true, the barcode will render its value as part of the image|

### Receipt.TaxiDetails

|Name|Type|Required|Description|
|----|----|--------|-----------|
|carPlateNumber|String|no||
|license|String|no||
|orgNumberLicenseHolder|String|no||
|startTime|ZonedDateTime|no||
|stopTime|ZonedDateTime|no||
|tips|BigDecimal|no||
|totalMeterPrice|BigDecimal|no||
|totalDistanceBeforeBoardingInMeters|Integer|no||
|totalDistanceInMeters|Integer|no||
|totalDistanceWithPassengerInMeters|Integer|no||
|totalTimeBeforeBoardingInSeconds|Integer|no||
|totalTimeInSeconds|Integer|no||
|totalTimeWithPassengerInSeconds|Integer|no||
|vat|[VatDetails](#receiptvatdetails)|no||

### Receipt.VatDetails

|Name|Type|Required|Description|
|----|----|--------|-----------|
|levels|List|no||
|sum|BigDecimal|no||

### Receipt.Customer

|Name|Type|Required|Description|
|----|----|--------|-----------|
|name|String|no||
|address|[Address](#receiptaddress)|no||
|phoneNumber|String|no||

### Receipt.Delivery

|Name|Type|Required|Description|
|----|----|--------|-----------|
|name|String|no||
|address|[Address](#receiptaddress)|no||
|terms|String|no||

### XML

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<receipt xmlns="http://api.digipost.no/schema/datatypes">
    <receiptId>F96B6805-2453-478A-B58B-CCDFA07E21ED</receiptId>
    <receiptNumber>364567</receiptNumber>
    <purchaseTime>2018-05-27T10:00:00+02:00</purchaseTime>
    <totalPrice>59.80</totalPrice>
    <totalVat>11.96</totalVat>
    <currency>NOK</currency>
    <cashier>Benny</cashier>
    <register>15</register>
    <merchant-chain>7F5A1EFF-ECAE-48A7-A07F-38D87576F815</merchant-chain>
    <merchant-name>Grünerløkka Hip Coffee</merchant-name>
    <merchant-phone-number>12345678</merchant-phone-number>
    <merchant-address>
        <street-address>Storgata 23</street-address>
        <postal-code>0011</postal-code>
        <city>Oslo</city>
        <country>Norge</country>
    </merchant-address>
    <orgnumber>123456789</orgnumber>
    <barcode>
        <barcode-value>1234567890</barcode-value>
        <barcode-type>code-128</barcode-type>
        <barcode-text>Show barcode for faster identification</barcode-text>
        <show-value-in-barcode>true</show-value-in-barcode>
    </barcode>
    <payments>
        <type>Bank Axept</type>
        <card-number>************1234</card-number>
        <cardName>Visa</cardName>
        <amount>100.00</amount>
        <currency-code>NOK</currency-code>
        <foreign-currency-payment>
            <currency-code>USD</currency-code>
            <amount>15</amount>
            <exchange-rate>7.534567</exchange-rate>
        </foreign-currency-payment>
    </payments>
    <items>
        <item-name>Tall Cafe latte</item-name>
        <item-description>Tall vanilla latte with extra sugar</item-description>
        <item-code>0000012</item-code>
        <unit>cup</unit>
        <quantity>2.0</quantity>
        <item-price>29.90</item-price>
        <item-vat>5.98</item-vat>
        <total-price>59.80</total-price>
        <total-vat>11.96</total-vat>
        <discount>5.50</discount>
        <serialNumber>XY12345325GF</serialNumber>
        <eanCode>1345678</eanCode>
    </items>
    <taxiDetails>
        <carPlateNumber>EK99999</carPlateNumber>
        <license>12341ASDF</license>
        <orgNumberLicenseHolder>123456789</orgNumberLicenseHolder>
        <startTime>2018-06-05T10:00:00+02:00</startTime>
        <stopTime>2018-06-05T10:30:00+02:00</stopTime>
        <tips>8.00</tips>
        <totalMeterPrice>438.50</totalMeterPrice>
        <totalDistanceBeforeBoardingInMeters>2000</totalDistanceBeforeBoardingInMeters>
        <totalDistanceInMeters>8500</totalDistanceInMeters>
        <totalDistanceWithPassengerInMeters>6500</totalDistanceWithPassengerInMeters>
        <totalTimeBeforeBoardingInSeconds>320</totalTimeBeforeBoardingInSeconds>
        <totalTimeInSeconds>1220</totalTimeInSeconds>
        <totalTimeWithPassengerInSeconds>900</totalTimeWithPassengerInSeconds>
        <vat>
            <levels>
                <grossAmount>400.00</grossAmount>
                <netAmount>320.00</netAmount>
                <vat>80.00</vat>
                <vatPercent>25.00</vatPercent>
            </levels>
            <sum>64.90</sum>
        </vat>
    </taxiDetails>
    <customer>
        <name>Ola Nordmann</name>
        <address>
            <street-address>Storgata 23</street-address>
            <postal-code>0011</postal-code>
            <city>Oslo</city>
            <country>Norge</country>
        </address>
        <phoneNumber>Delivered to the doorstep</phoneNumber>
    </customer>
    <delivery>
        <name>Ola Nordmann</name>
        <address>
            <street-address>Storgata 23</street-address>
            <postal-code>0011</postal-code>
            <city>Oslo</city>
            <country>Norge</country>
        </address>
        <terms>Delivered to the doorstep</terms>
    </delivery>
    <order-number>123456</order-number>
    <membership-number>HG1234HH8778</membership-number>
    <comment>Hip Coffee to the good citizens of Løkka</comment>
</receipt>
```

## Residence

Residence is a way of linking separate data for the same residence

### Fields

|Name|Type|Required|Description|
|----|----|--------|-----------|
|address|[ResidenceAddress](#residenceresidenceaddress)|yes||
|matrikkel|[Matrikkel](#residencematrikkel)|no||
|source|String|no||
|externalId|String|no||

### Residence.ResidenceAddress

|Name|Type|Required|Description|
|----|----|--------|-----------|
|unitNumber|String|no|Bolignummer. Must be of format [UKHL]0000. E.g. H0304|
|houseNumber|String|no|A house number with or without a house letter. E.g. 11 or 11A|
|streetName|String|no|The name of the street. E.g. Storgata|
|postalCode|String|no||
|city|String|no||

### Residence.Matrikkel

|Name|Type|Required|Description|
|----|----|--------|-----------|
|kommunenummer|String|yes||
|gaardsnummer|String|yes||
|bruksnummer|String|yes||
|festenummer|String|no||
|seksjonsnummer|String|no||

### XML

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<residence xmlns="http://api.digipost.no/schema/datatypes">
    <address>
        <house-number>23</house-number>
        <street-name>Storgata</street-name>
        <postal-code>0011</postal-code>
        <city>Oslo</city>
    </address>
    <matrikkel>
        <kommunenummer>0301</kommunenummer>
        <gaardsnummer>208</gaardsnummer>
        <bruksnummer>630</bruksnummer>
        <festenummer>0</festenummer>
        <seksjonsnummer>0</seksjonsnummer>
    </matrikkel>
    <source>boligmappa</source>
    <external-id>externalId</external-id>
</residence>
```

## SignedDocument

Details about a signed document

### Fields

|Name|Type|Required|Description|
|----|----|--------|-----------|
|documentIssuer|String|yes|The original issuer of the document to be signed.|
|documentSubject|String|yes|The original subject of the document to be signed.|
|signingTime|ZonedDateTime|yes|When the recipient signed the document. ISO8601 full DateTime.|

### XML

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<signedDocument xmlns="http://api.digipost.no/schema/datatypes">
    <document-issuer>Bedrift AS</document-issuer>
    <document-subject>Ansettelseskontrakt</document-subject>
    <signing-time>2018-07-11T10:00:00+02:00</signing-time>
</signedDocument>
```
