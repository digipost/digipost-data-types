## Data types

|Type|Description|
|----|-----------|
|[ShortTextMessage](#shorttextmessage)|150 character short message|

## ShortTextMessage

150 character short message

### Fields

|Name|Type|Required|Description|
|----|----|--------|-----------|
|message|String|true|Your short message goes here|

### JSON

```json
{
  "message" : "Dette er en kort melding til deg",
  "type" : "ShortTextMessage"
}
```

### XML

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<ns2:shortTextMessage xmlns:ns2="http://api.digipost.no/schema/datatypes">
    <message>Dette er en kort melding til deg</message>
</ns2:shortTextMessage>
```
