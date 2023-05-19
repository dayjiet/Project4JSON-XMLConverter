package servicing.dao;

import servicing.service.Element;
import servicing.view.Formatter;

import java.util.List;
import java.util.stream.Collectors;

import static servicing.service.Strings.encloseInQuotes;

/**
 * XMLFormatter class is responsible for formatting XML elements and lists of elements into XML string representation.
 */
public class XMLFormatter implements Formatter {

    /**
     * Formats a list of elements into an XML string representation.
     * @param elements the list of elements to format
     * @return the XML string representation of the elements
     */
    @Override
    public String format(List<Element> elements) {

        if (elements.size() == 1) {
            return format(elements.get(0));
        }

        String children = elements.stream()
                .map(this::format)
                .collect(Collectors.joining());
        return String.format("<root>%s</root>", children);
    }

    /**
     * Formats an element into an XML string representation.
     * @param element the element to format
     * @return the XML string representation of the element
     */
    @Override
    public String format(Element element) {
        StringBuilder result = new StringBuilder();
        result.append('<')
                .append(element.name());
        element.getAttributes().
                forEach(attribute -> result.append(' ')
                        .append(attribute.getName())
                        .append('=')
                        .append(encloseInQuotes(attribute.getValue()))
                );

        if (element.getChildren() == null && element.getSingleValue() == null) {
            result.append("/>");
            return result.toString();
        } else {
            result.append('>');
        }

        if (element.getSingleValue() != null) {
            result.append(element.getSingleValue());
        } else {
            element.getChildren()
                    .stream()
                    .map(this::format)
                    .forEach(result::append);
        }

        result.append("</")
                .append(element.name())
                .append('>');
        return result.toString();
    }
}