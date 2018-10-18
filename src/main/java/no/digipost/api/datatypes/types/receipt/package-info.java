@XmlSchema(namespace = DIGIPOST_DATATYPES_NAMESPACE, elementFormDefault = javax.xml.bind.annotation.XmlNsForm.QUALIFIED)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlJavaTypeAdapters({
        @XmlJavaTypeAdapter(ZonedDateTimeXmlAdapter.class),
        @XmlJavaTypeAdapter(MoneyBigDecimalXmlAdapter.class)
})
@DataTypePackage
package no.digipost.api.datatypes.types.receipt;

import no.digipost.api.datatypes.documentation.DataTypePackage;
import no.digipost.api.datatypes.marshalling.MoneyBigDecimalXmlAdapter;
import no.digipost.api.datatypes.marshalling.ZonedDateTimeXmlAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchema;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;

import static no.digipost.api.datatypes.marshalling.DataTypesJAXBContext.DIGIPOST_DATATYPES_NAMESPACE;

