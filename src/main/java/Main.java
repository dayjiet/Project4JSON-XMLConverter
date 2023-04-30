import base.Converter;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main implements Runnable {
    public static void main(String[] args) {
        new Main().run();
    }

    @Override
    public void run() {
        Converter[] converters = {new JsonToXmlConverter(), new XmlToJsonConverter()};

        try (Scanner scanner = new Scanner(new File("src/test/java/test.txt"))) {
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
