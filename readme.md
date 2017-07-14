## Data types

|Type|Description|
|----|-----------|
|[Appointment](#appointment)|Appointment represents a meeting set for a specific place and time|
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
|address|[AppointmentAddress](#appointmentaddress)|no||
|subTitle|String|no|Example: MR-undersøkelse av høyre kne|
|info|List|no|Additional sections of information (max 2) with a title and text|

### AppointmentAddress

|Name|Type|Required|Description|
|----|----|--------|-----------|
|streetAddress|String|yes|E.g. Storgata 11|
|postalCode|String|yes||
|city|String|yes||

### XML

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<ns2:appointment xmlns:ns2="http://api.digipost.no/schema/datatypes">
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
</ns2:appointment>
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
<ns2:residence xmlns:ns2="http://api.digipost.no/schema/datatypes">
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
</ns2:residence>
```
