package no.digipost.api.datatypes.types;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Value;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement
@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Description("Category is a way to specify which category the data of a document is related to.")
public class Category implements DataType {

    @XmlValue
    private String category;

    public Category(String name){
        this.category = name;
    }

    public boolean is(Category other){
        return other.category.equals(this.category);
    }

    public static Category RESIDENCE = new Category("RESIDENCE");
    public static Category EXAMPLE = RESIDENCE;

}
