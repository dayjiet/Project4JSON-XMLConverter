package base;

import java.util.List;

public class AbstractConverter implements Converter {
    private final Parser parser;
    private final Formatter formatter;

    public AbstractConverter(Parser parser, Formatter formatter) {
        this.parser = parser;
        this.formatter = formatter;
    }

    @Override
    public String convert(String input) {
        List<Element> parsed = parser.parse(input);

        if (parsed == null) return null;

        return formatter.format(parsed);
    }
}