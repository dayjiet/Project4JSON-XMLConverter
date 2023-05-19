package servicing.util;

public class Strings {
    public static String emptyIfNull(String input) {
        return input == null ? "" : input;
    }

    public static String encloseInQuotes(String input) {
        return input == null ? null : '"' + input + '"';
    }
}