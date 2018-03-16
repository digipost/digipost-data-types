## Data types

|Type|Description|
|----|-----------|
|[Appointment](#appointment)|Appointment represents a meeting set for a specific place and time|
|[Boligdetaljer](#boligdetaljer)|Details about a Residence, and may be joined with Residence to retrieve the core fields of a Residence.|
|[Category](#category)|Category is a way to specify which category the data of a document is related to.|
|[ExternalLink](#externallink)|An external URL, along with an optional description and deadline for resources such as a survey.|
|[Receipt](#receipt)|Receipt represents a document containing details about a purchase|
|[Residence](#residence)|Residence is a way of linking separate data for the same residence|

## Appointment

Appointment represents a meeting set for a specific place and time

### Fields

|Name|Type|Required|Description|
|----|----|--------|-----------|
|startTime|ZonedDateTime|yes|ISO8601 full DateTime|
|endTime|ZonedDateTime|no|ISO8601 full DateTime. Default value 30 minutes after startTime|
|arrivalTime|String|no|Free text but can contain a ISO8601 DateTime. Example: Please arrive 15 minutes early|
|place|String|no|The name of the place. Example: Oslo City Røntgen|
|address|[Address](#address)|no||
|subTitle|String|no|Example: MR-undersøkelse av høyre kne|
|info|List|no|Additional sections of information (max 2) with a title and text|

### Address

|Name|Type|Required|Description|
|----|----|--------|-----------|
|streetAddress|String|no|E.g. Storgata 11|
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
|residence|[Residence](#residence)|yes||
|hjemmelshavere|List|no|List of people with legal rights associated with the residence|
|bruksareal|Integer|no|BRA for bolig|
|antallOppholdsrom|Integer|no|Number of rooms, bathroom, kitchen and storage rooms excluded|
|antallBaderom|Integer|no|Number of bathrooms|
|omsetningshistorikk|List|no|Previous sales and transactions|
|organisasjonsnummer|String|no||
|bruksenhet|String|no||
|andelsnummer|String|no||
|heftelser|List|no||

### Residence

|Name|Type|Required|Description|
|----|----|--------|-----------|
|address|[ResidenceAddress](#residenceaddress)|yes||
|matrikkel|[Matrikkel](#matrikkel)|no||
|source|String|no||
|externalId|String|no||

### ResidenceAddress

|Name|Type|Required|Description|
|----|----|--------|-----------|
|unitNumber|String|no|Bolignummer. Must be of format [UKHL]0000. E.g. H0304|
|houseNumber|String|no|A house number with or without a house letter. E.g. 11 or 11A|
|streetName|String|no|The name of the street. E.g. Storgata|
|postalCode|String|no||
|city|String|no||

### Matrikkel

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
|merchantAddress|Address|no|Address of the store or merchant|
|organizationNumber|String|no|Organization number of the sales point|
|barcode|[Barcode](#barcode)|no||
|payments|List|no|List of payments done during this purchase|
|items|List|no|The individual items sold|
|taxiDetails|[TaxiDetails](#taxidetails)|no|Details for taxi receipts|
|customer|[Customer](#customer)|no|Name and address of customer|
|delivery|[Delivery](#delivery)|no|Name and address of delivery|
|orderNumber|String|no||

### Barcode

|Name|Type|Required|Description|
|----|----|--------|-----------|
|barcodeValue|String|no|The barcode on this receipt|
|barcodeType|String|no||

### TaxiDetails

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
|vat|[VatDetails](#vatdetails)|no||

### VatDetails

|Name|Type|Required|Description|
|----|----|--------|-----------|
|levels|List|no||
|sum|BigDecimal|no||

### Customer

|Name|Type|Required|Description|
|----|----|--------|-----------|
|name|String|no||
|address|Address|no||
|phoneNumber|String|no||

### Delivery

|Name|Type|Required|Description|
|----|----|--------|-----------|
|name|String|no||
|address|Address|no||
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
                <vatPercent>0.25</vatPercent>
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
</receipt>
```

## Residence

Residence is a way of linking separate data for the same residence

### Fields

|Name|Type|Required|Description|
|----|----|--------|-----------|
|address|[ResidenceAddress](#residenceaddress)|yes||
|matrikkel|[Matrikkel](#matrikkel)|no||
|source|String|no||
|externalId|String|no||

### ResidenceAddress

|Name|Type|Required|Description|
|----|----|--------|-----------|
|unitNumber|String|no|Bolignummer. Must be of format [UKHL]0000. E.g. H0304|
|houseNumber|String|no|A house number with or without a house letter. E.g. 11 or 11A|
|streetName|String|no|The name of the street. E.g. Storgata|
|postalCode|String|no||
|city|String|no||

### Matrikkel

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
