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
|title|String|true||
|time|ZonedDateTime|true|Date and time for the appointment|
|place|[Address](#address)|true||
|description|String|false|Additional information about the appointment|
|timeInformation|String|false|Additional information about the appointment time. Example: Please arrive 10 minutes ahead of scheduled time|

### Address

|Name|Type|Required|Description|
|----|----|--------|-----------|
|streetAddress|String|false||
|postalCode|String|false||
|city|String|true||

### JSON

```json
{
  "title" : "Time hos Dr. Legesen",
  "time" : "2017-06-27T10:00:00+02:00",
  "place" : {
    "streetAddress" : "Storgata 23",
    "postalCode" : "0011",
    "city" : "Oslo"
  },
  "description" : "Undersøke smerter i ryggen",
  "timeInformation" : "Oppmøte senest 10 minutter før timen",
  "type" : "Appointment"
}
```

### XML

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<ns2:appointment xmlns:ns2="http://api.digipost.no/schema/datatypes">
    <title>Time hos Dr. Legesen</title>
    <time>2017-06-27T10:00:00+02:00</time>
    <place>
        <streetAddress>Storgata 23</streetAddress>
        <postalCode>0011</postalCode>
        <city>Oslo</city>
    </place>
    <description>Undersøke smerter i ryggen</description>
    <timeInformation>Oppmøte senest 10 minutter før timen</timeInformation>
</ns2:appointment>
```

## Residence

Residence is a way of linking separate data for the same residence

### Fields

|Name|Type|Required|Description|
|----|----|--------|-----------|
|address|[Address](#address)|true||
|source|String|false||
|externalId|String|false||

### Address

|Name|Type|Required|Description|
|----|----|--------|-----------|
|streetAddress|String|false||
|postalCode|String|false||
|city|String|true||

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
