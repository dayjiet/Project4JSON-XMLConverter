package servicing;

import servicing.view.Converter;
import servicing.view.ToJSONConverter;
import servicing.view.ToXMLConverter;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * A program that converts text input to XML or JSON format using different converters.
 */
public class JSONXMLConverter implements Runnable {
    /**
     * The main entry point of the program.
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        new JSONXMLConverter().run();
    }

    /**
     * Runs the program.
     */
    @Override
    public void run() {
        Converter[] converters = {new ToXMLConverter(), new ToJSONConverter()};

        try (Scanner scanner = new Scanner(new File("test.txt"))) {
            // try (Scanner scanner = new Scanner(new File("test.txt"))) {
            String input = scanner.tokens()
                    .collect(Collectors.joining(" "));

            for (Converter converter : converters) {

                String result = converter.convert(input);
                if (result != null) {

                    System.out.println(result);
                    return;

                }
            }

            System.err.println("Converter not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
