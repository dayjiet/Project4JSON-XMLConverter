package servicing.view;

import servicing.service.Element;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents a formatter that formats elements into a specific output format.
 */
public interface Formatter {

    /**
     * Formats the given element into a string representation.
     * @param element the element to be formatted
     * @return the formatted string representation of the element
     */
    String format(Element element);

    /**
     * Formats the list of elements into a single string representation.
     * @param elements the list of elements to be formatted
     * @return the formatted string representation of the elements
     */
    default String format(List<Element> elements) {
        return elements.stream()
                .map(this::format)
                .collect(Collectors.joining());
    }
}