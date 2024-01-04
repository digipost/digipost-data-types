@XmlSchema(namespace = DIGIPOST_DATATYPES_NAMESPACE, elementFormDefault = jakarta.xml.bind.annotation.XmlNsForm.QUALIFIED)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlJavaTypeAdapters({
        @XmlJavaTypeAdapter(ZonedDateTimeXmlAdapter.class),
        @XmlJavaTypeAdapter(LocalDateXmlAdapter.class)
})
@DataTypePackage
package no.digipost.api.datatypes.types.invoice;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSchema;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapters;
import no.digipost.api.datatypes.documentation.DataTypePackage;
import no.digipost.api.datatypes.marshalling.LocalDateXmlAdapter;
import no.digipost.api.datatypes.marshalling.ZonedDateTimeXmlAdapter;

import static no.digipost.api.datatypes.marshalling.DataTypesJAXBContext.DIGIPOST_DATATYPES_NAMESPACE;
