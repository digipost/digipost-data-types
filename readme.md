## Data types

|Type|Description|
|----|-----------|
|[Appointment](#appointment)|Appointment represents a meeting set for a specific place and time|
|[Category](#category)|Category is a way to specify which category the data of a document is related to.|
|[Residence](#residence)|Residence is a way of linking separate data for the same residence|
|[ResidenceDetails](#residencedetails)|Details about a Residence, and may be joined with Residence to retrieve the core fields of a Residence.|

## Appointment

Appointment represents a meeting set for a specific place and time

### Fields

|Name|Type|Required|Description|
|----|----|--------|-----------|
|startTime|ZonedDateTime|yes|ISO8601 full DateTime|
|endTime|ZonedDateTime|no|ISO8601 full DateTime. Default value 30 minutes after startTime|
|arrivalTime|String|no|Free text but can contain a ISO8601 DateTime. Example: Please arrive 15 minutes early|
|place|String|no|The name of the place. Example: Oslo City Røntgen|
|address|[AppointmentAddress](#appointmentaddress)|no||
|subTitle|String|no|Example: MR-undersøkelse av høyre kne|
|info|List|no|Additional sections of information (max 2) with a title and text|

### AppointmentAddress

|Name|Type|Required|Description|
|----|----|--------|-----------|
|streetAddress|String|no|E.g. Storgata 11|
|postalCode|String|yes||
|city|String|yes||

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
    </address>
    <sub-title>Undersøke smerter i ryggen</sub-title>
    <info>
        <title>Informasjon om Oslo City Røntgen</title>
        <text>Oslo City Røntgen er et spesialistsenter for avansert bildediagnostikk.</text>
    </info>
</appointment>
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
|streetName|String|yes|The name of the street. E.g. Storgata|
|postalCode|String|yes||
|city|String|yes||

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

## ResidenceDetails

Details about a Residence, and may be joined with Residence to retrieve the core fields of a Residence.

### Fields

|Name|Type|Required|Description|
|----|----|--------|-----------|
|hjemmelshavere|List|no|List of people with legal rights associated with the residence|
|bruksareal|Integer|no|BRA for bolig|
|antallOppholdsrom|Integer|no|Number of rooms, bathroom, kitchen and storage rooms excluded|
|antallBaderom|Integer|no|Number of bathrooms|
|salesHistory|List|no|Previous sales and transactions|
|info|[Info](#info)|no|An additional section of information, consisting of a title- and text-field|
|source|String|no||
|externalId|String|no||

### Info

|Name|Type|Required|Description|
|----|----|--------|-----------|
|title|String|no||
|text|String|no||

### XML

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<residenceDetails xmlns="http://api.digipost.no/schema/datatypes">
    <hjemmelshavere>
        <name>Gunnar Gunnersen</name>
        <email>gunnargunnar@gunn.ar</email>
    </hjemmelshavere>
    <bruksareal>59</bruksareal>
    <antall-oppholdsrom>3</antall-oppholdsrom>
    <antall-baderom>4</antall-baderom>
    <sales-history>
        <start-time>2017-07-27T10:00:00+02:00</start-time>
        <description>Privat salg av sekundærbolig</description>
        <amount>12345678</amount>
        <seller>Bill Isalg</seller>
        <buyer>Cooper Coopersen</buyer>
    </sales-history>
    <info>
        <title>En spesiell bolig</title>
        <text>Spesielt med denne boligen er at den har vært til sjøs på en husbåt i flere år, før den ble heiset og plassert på Vippetangen.</text>
    </info>
    <source>boligmappa</source>
    <external-id>externalId</external-id>
</residenceDetails>
```
