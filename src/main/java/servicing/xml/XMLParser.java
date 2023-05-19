package servicing.xml;

import servicing.base.Attribute;
import servicing.base.Element;
import servicing.base.Parser;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class XMLParser implements Parser {
    private static final Pattern ATTRIBUTE_PATTERN =
            Pattern.compile("(?<name>\\w+)\\s*=\\s*([\"'])(?<value>.*?)\\2");

    private static final Pattern TAG_PATTERN =
            Pattern.compile("<\\s*(?<name>\\w+)\\s*(?<attributes>(\\s*\\w+\\s*=\\s*([\"']).*?\\4\\s*)*?)\\s*(/>|>)");
    private Queue<String> tokens;

    @Override
    public List<Element> parse(String input) {
        tokens = new ArrayDeque<>(split(input));

        if (!tokens.isEmpty() && tokens.element().startsWith("<?")) tokens.remove();

        if (tokens.isEmpty() || !TAG_PATTERN.matcher(tokens.element()).matches()) return null;

        return List.of(parse(new ArrayList<>()));
    }

    private static List<String> split(String input) {
        Pattern pattern = Pattern.compile("<.*?>");
        Matcher matcher = pattern.matcher(input);

        int lastEnd = 0;
        List<String> result = new ArrayList<>();

        while (matcher.find()) {
            result.add(input.substring(lastEnd, matcher.start()));
            result.add(input.substring(matcher.start(), matcher.end()));
            lastEnd = matcher.end();
        }

        return result.stream()
                .map(String::trim)
                .filter(token -> !token.isEmpty())
                .collect(Collectors.toList());
    }

    private Element parse(List<String> path) {
        String rootTag = tokens.remove();
        boolean isSelfClosing = rootTag.endsWith("/>");
        Matcher matcher = TAG_PATTERN.matcher(rootTag);

        if (!matcher.find()) {
            return new Element(Collections.emptyList(), null, null, null);
        }

        String name = matcher.group("name");
        path.add(name);

        List<Attribute> attributes = parseAttributes(matcher.group("attributes"));

        if (isSelfClosing) {
            return new Element(attributes, null, null, path);
        }

        List<Element> children = new ArrayList<>();
        String value = null;

        while (!tokens.element().equals("</" + name + ">")) {
            String literal = parseLiteral();

            if (literal != null) {
                value = literal;
            } else {
                children.add(parse(new ArrayList<>(path)));
            }
        }

        tokens.poll();

        if (children.isEmpty()) {
            children = null;

            if (value == null) {
                value = "";
            }

        } else if (value != null) {
            throw new IllegalStateException("Found both children and a literal value");
        }

        return new Element(attributes, children, value, path);
    }

    private static List<Attribute> parseAttributes(String input) {
        return ATTRIBUTE_PATTERN.matcher(input)
                .results()
                .map(result -> new Attribute(result.group(1), result.group(3)))
                .collect(Collectors.toList());
    }

    private String parseLiteral() {

        if (!TAG_PATTERN.matcher(tokens.element()).find()) {
            return tokens.remove().trim();
        }

        return null;
    }
}