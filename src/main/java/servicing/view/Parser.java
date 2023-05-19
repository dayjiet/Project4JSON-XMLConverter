package servicing.view;

import servicing.service.Element;

import java.util.List;

/**
 * Represents a parser that parses text input into a list of elements.
 */
public interface Parser {

    /**
     * Parses the input string and returns a list of elements.
     * @param input the text input to be parsed
     * @return a list of elements parsed from the input
     */
    List<Element> parse(String input);
}