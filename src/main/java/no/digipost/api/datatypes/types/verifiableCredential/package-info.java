@XmlSchema(namespace = DIGIPOST_DATATYPES_NAMESPACE, elementFormDefault = jakarta.xml.bind.annotation.XmlNsForm.QUALIFIED)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlJavaTypeAdapter(ZonedDateTimeXmlAdapter.class)
@DataTypePackage
package no.digipost.api.datatypes.types.verifiableCredential;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSchema;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import no.digipost.api.datatypes.documentation.DataTypePackage;
import no.digipost.api.datatypes.marshalling.ZonedDateTimeXmlAdapter;

import static no.digipost.api.datatypes.marshalling.DataTypesJAXBContext.DIGIPOST_DATATYPES_NAMESPACE;
