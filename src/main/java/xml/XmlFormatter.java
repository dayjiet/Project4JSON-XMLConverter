package xml;

import base.Element;
import base.Formatter;

import java.util.List;
import java.util.stream.Collectors;

import static util.Strings.encloseInQuotes;

public class XmlFormatter implements Formatter {

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