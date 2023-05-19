package servicing.dao;

import servicing.service.Element;
import servicing.view.Formatter;

import java.util.stream.Collectors;

import static servicing.service.Strings.encloseInQuotes;

/**
 * Represents a formatter that formats elements into JSON format.
 */
public class JSONFormatter implements Formatter {

    /**
     * Formats the given element into a JSON string representation.
     * @param element the element to be formatted
     * @return the formatted JSON string representation of the element
     */
    @Override
    public String format(Element element) {
        return format(element, true, true);
    }

    private String format(Element element, boolean inBraces, boolean includeName) {
        StringBuilder result = new StringBuilder();

        if (inBraces) result.append('{');

        if (includeName) result.append(encloseInQuotes(element.name()))
                .append(':');

        if (element.isArray()) {
            result.append(formatArray(element));
        } else if (element.getAttributes().isEmpty()) {
            result.append(formatValue(element));
        } else {
            String attributes = element.getAttributes()
                    .stream()
                    .map(attribute -> encloseInQuotes("@" + attribute.getName()) + ":" + encloseInQuotes(attribute.getValue()) + ",")
                    .collect(Collectors.joining());

            attributes += encloseInQuotes("#" + element.name()) + ":" + formatValue(element);
            result.append('{').append(attributes).append('}');
        }

        if (inBraces) result.append('}');

        return result.toString();
    }

    private String formatArray(Element element) {
        return element.getChildren()
                .stream()
                .map(e -> format(e, false, false))
                .collect(Collectors.joining(",", "[", "]"));
    }

    private String formatValue(Element element) {

        if (element.getChildren() == null) {
            return encloseInQuotes(element.getSingleValue());
        }

        if (element.isContentArray()) {
            return formatArray(element);
        }

        return element.getChildren()
                .stream()
                .map(e -> format(e, false, true))
                .collect(Collectors.joining(",", "{", "}"));
    }
}