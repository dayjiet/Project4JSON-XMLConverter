package base;

import java.util.List;

public interface Parser {
    List<Element> parse(String input);
}