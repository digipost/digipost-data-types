@XmlSchema(namespace = DIGIPOST_DATATYPES_NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlJavaTypeAdapter(ZonedDateTimeXmlAdapter.class)
package no.posten.dpost.datatypes.types;

import no.posten.dpost.datatypes.marshalling.ZonedDateTimeXmlAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchema;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import static no.posten.dpost.datatypes.marshalling.DataTypesJAXBContext.DIGIPOST_DATATYPES_NAMESPACE;
