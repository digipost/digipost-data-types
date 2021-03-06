@XmlSchema(namespace = DIGIPOST_DATATYPES_NAMESPACE, elementFormDefault = javax.xml.bind.annotation.XmlNsForm.QUALIFIED)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlJavaTypeAdapter(ZonedDateTimeXmlAdapter.class)
@DataTypePackage
package no.digipost.api.datatypes.types.invoice;

import no.digipost.api.datatypes.documentation.DataTypePackage;
import no.digipost.api.datatypes.marshalling.ZonedDateTimeXmlAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchema;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import static no.digipost.api.datatypes.marshalling.DataTypesJAXBContext.DIGIPOST_DATATYPES_NAMESPACE;
