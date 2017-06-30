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
  "start-time" : "2017-06-27T10:00:00+02:00",
  "end-time" : "2017-06-27T11:00:00+02:00",
  "arrival-time" : "Oppmøte senest 15 minutter før timen",
  "place" : "Oslo City Røntgen",
  "address" : {
    "street-address" : "Storgata 23",
    "postal-code" : "0011",
    "city" : "Oslo"
  },
  "sub-title" : "Undersøke smerter i ryggen",
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
    "street-address" : "Storgata 23",
    "postal-code" : "0011",
    "city" : "Oslo"
  },
  "source" : "boligmappa",
  "external-id" : "externalId",
  "type" : "Residence"
}
```

### XML

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<ns2:residence xmlns:ns2="http://api.digipost.no/schema/datatypes">
    <address>
        <street-address>Storgata 23</street-address>
        <postal-code>0011</postal-code>
        <city>Oslo</city>
    </address>
    <source>boligmappa</source>
    <external-id>externalId</external-id>
</ns2:residence>
```
