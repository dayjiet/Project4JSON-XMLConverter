package servicing.service;

import java.util.List;

import static servicing.service.Lists.last;

/**
 * Element class represents an XML element, which can have attributes, children elements, and a single value.
 */
public class Element {
    private final List<Attribute> attributes;
    private final List<Element> children;
    private final String singleValue;
    private final List<String> path;

    /**
     * Constructs an Element object with the specified attributes, children elements, single value, and path.
     * @param attributes the attributes of the element
     * @param children the children elements of the element
     * @param singleValue the single value of the element
     * @param path the path of the element
     */
    public Element(List<Attribute> attributes, List<Element> children, String singleValue, List<String> path) {
        this.attributes = attributes;
        this.children = children;
        this.singleValue = singleValue;
        this.path = path;
    }

    /**
     * Creates an Element object with the specified attributes, single value, and path.
     * @param attributes the attributes of the element
     * @param value the single value of the element
     * @param path the path of the element
     * @return the created Element object
     */
    public static Element singleElement(List<Attribute> attributes, String value, List<String> path) {
        return new Element(attributes, null, value, path);
    }

    /**
     * Creates an Element object with the specified attributes, children elements, and path.
     * @param attributes the attributes of the element
     * @param children the children elements of the element
     * @param path the path of the element
     * @return the created Element object
     */
    public static Element withChildren(List<Attribute> attributes, List<Element> children, List<String> path) {
        return new Element(attributes, children, null, path);
    }

    /**
     * Returns the attributes of the element.
     * @return the attributes of the element
     */
    public List<Attribute> getAttributes() {
        return attributes;
    }

    /**
     * Returns the children elements of the element.
     * @return the children elements of the element
     */
    public List<Element> getChildren() {
        return children;
    }

    /**
     * Returns the single value of the element.
     * @return the single value of the element
     */
    public String getSingleValue() {
        return singleValue;
    }

    /**
     * Checks if the element is an array, which means it has no attributes and its content is an array.
     * @return true if the element is an array, false otherwise
     */
    public boolean isArray() {
        return attributes.isEmpty() && isContentArray();
    }

    /**
     * Checks if the content of the element is an array, which means it has multiple children elements with the same name.
     * @return true if the content is an array, false otherwise
     */
    public boolean isContentArray() {
        return children != null &&
                children.size() >= 2 &&
                children.stream()
                        .map(Element::name)
                        .distinct()
                        .count() == 1;
    }

    /**
     * Returns the name of the element, which is the last element in the path.
     * @return the name of the element
     */
    public String name() {
        return last(path);
    }
}