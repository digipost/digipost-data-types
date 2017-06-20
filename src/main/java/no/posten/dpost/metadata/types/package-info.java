@XmlSchema(namespace = DIGIPOST_METADATA_NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlJavaTypeAdapter(ZonedDateTimeXmlAdapter.class)
package no.posten.dpost.metadata.types;

import no.posten.dpost.metadata.marshalling.ZonedDateTimeXmlAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchema;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import static no.posten.dpost.metadata.marshalling.MetadataJAXBContext.DIGIPOST_METADATA_NAMESPACE;
