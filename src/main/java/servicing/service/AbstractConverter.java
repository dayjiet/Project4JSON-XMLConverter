package servicing.service;

import servicing.view.Converter;
import servicing.view.Formatter;
import servicing.view.Parser;

import java.util.List;

/**
 * AbstractConverter class is an abstract implementation of the Converter interface.
 * It provides the basic functionality for converting input strings using a Parser and a Formatter.
 */
public class AbstractConverter implements Converter {
    private final Parser parser;
    private final Formatter formatter;

    /**
     * Constructs an AbstractConverter with the specified Parser and Formatter.
     * @param parser the Parser implementation to use for parsing
     * @param formatter the Formatter implementation to use for formatting
     */
    public AbstractConverter(Parser parser, Formatter formatter) {
        this.parser = parser;
        this.formatter = formatter;
    }

    /**
     * Converts the given input string using the configured Parser and Formatter.
     * @param input the input string to convert
     * @return the converted string
     */
    @Override
    public String convert(String input) {
        List<Element> parsed = parser.parse(input);

        if (parsed == null) return null;

        return formatter.format(parsed);
    }
}