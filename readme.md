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
|endTime|ZonedDateTime|no|ISO8601 full DateTime. Default value 1 hour after startTime|
|arrivalTime|String|no|Free text but can contain a ISO8601 DateTime. Example: Please arrive 15 minutes early|
|place|String|no|The name of the place. Example: Oslo City Røntgen|
|address|[Address](#address)|no||
|subTitle|String|no|Example: MR-undersøkelse av høyre kne|
|info|List|no|Additional sections of information (max 2) with a title and text|

### Address

|Name|Type|Required|Description|
|----|----|--------|-----------|
|streetAddress|String|no||
|postalCode|String|yes||
|city|String|yes||

### JSON

```json
{
  "startTime" : "2017-06-27T10:00:00+02:00",
  "endTime" : "2017-06-27T11:00:00+02:00",
  "arrivalTime" : "Oppmøte senest 15 minutter før timen",
  "place" : "Oslo City Røntgen",
  "address" : {
    "streetAddress" : "Storgata 23",
    "postalCode" : "0011",
    "city" : "Oslo"
  },
  "subTitle" : "Undersøke smerter i ryggen",
  "info" : [ {
    "title" : "Informasjon om Oslo City Røntgen",
    "text" : "Oslo City Røntgen er et spesialistsenter for avansert bildediagnostikk."
  } ],
  "type" : "Appointment"
}
```

### XML

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<ns2:appointment xmlns:ns2="http://api.digipost.no/schema/datatypes">
    <startTime>2017-06-27T10:00:00+02:00</startTime>
    <endTime>2017-06-27T11:00:00+02:00</endTime>
    <arrivalTime>Oppmøte senest 15 minutter før timen</arrivalTime>
    <place>Oslo City Røntgen</place>
    <address>
        <streetAddress>Storgata 23</streetAddress>
        <postalCode>0011</postalCode>
        <city>Oslo</city>
    </address>
    <subTitle>Undersøke smerter i ryggen</subTitle>
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
|address|[Address](#address)|yes||
|source|String|no||
|externalId|String|no||

### Address

|Name|Type|Required|Description|
|----|----|--------|-----------|
|streetAddress|String|no||
|postalCode|String|yes||
|city|String|yes||

### JSON

```json
{
  "address" : {
    "streetAddress" : "Storgata 23",
    "postalCode" : "0011",
    "city" : "Oslo"
  },
  "source" : "boligmappa",
  "externalId" : "externalId",
  "type" : "Residence"
}
```

### XML

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<ns2:residence xmlns:ns2="http://api.digipost.no/schema/datatypes">
    <address>
        <streetAddress>Storgata 23</streetAddress>
        <postalCode>0011</postalCode>
        <city>Oslo</city>
    </address>
    <source>boligmappa</source>
    <externalId>externalId</externalId>
</ns2:residence>
```
