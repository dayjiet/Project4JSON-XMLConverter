package servicing.service;

/**
 * Attribute class represents an attribute in XML, consisting of a name and a value.
 */
public class Attribute {
    private final String name;
    private final String value;

    /**
     * Constructs an Attribute object with the specified name and value.
     * @param name the name of the attribute
     * @param value the value of the attribute
     */
    public Attribute(String name, String value) {
        this.name = name;
        this.value = value;
    }

    /**
     * Returns the name of the attribute.
     * @return the name of the attribute
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the value of the attribute.
     * @return the value of the attribute
     */
    public String getValue() {
        return value;
    }
}