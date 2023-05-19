package servicing.view;

/**
 * Represents a converter that converts text input into another format.
 */
public interface Converter {

    /**
     * Converts the input string into another format.
     * @param input the text input to be converted
     * @return the converted string in the desired format
     */
    String convert(String input);
}