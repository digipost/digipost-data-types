## Data types

|Type|Description|
|----|-----------|
|[ShortTextMessage](#shorttextmessage)|150 character short message|

## ShortTextMessage

150 character short message

### Complemented by: 
[Addition](#addition)

### Fields

|Name|Type|Required|Description|
|----|----|--------|-----------|
|message|String|yes|Your short message goes here|
|metaData|[MetaData](#shorttextmessagemetadata)|no|Some metadata for shortTextMessage|

### ShortTextMessage.MetaData

|Name|Type|Required|Description|
|----|----|--------|-----------|
|value|String|yes|Your extra information|

### JSON

```json
{
  "message" : "Dette er en kort melding til deg",
  "metaData" : {
    "value" : "Some text"
  },
  "type" : "ShortTextMessage"
}
```

### XML

```xml
<shortTextMessage xmlns="http://api.digipost.no/schema/datatypes">
    <message>Dette er en kort melding til deg</message>
    <metaData>
        <value>Some text</value>
    </metaData>
</shortTextMessage>
```
