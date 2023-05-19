package servicing.service;

/**
 * Strings class provides utility methods for working with strings.
 */
public class Strings {

    /**
     * Returns an empty string if the input is null.
     * @param input the input string
     * @return an empty string if the input is null, otherwise the input string
     */
    public static String emptyIfNull(String input) {
        return input == null ? "" : input;
    }

    /**
     * Encloses the input string in double quotes.
     * @param input the input string
     * @return the input string enclosed in double quotes, or null if the input is null
     */
    public static String encloseInQuotes(String input) {
        return input == null ? null : '"' + input + '"';
    }
}