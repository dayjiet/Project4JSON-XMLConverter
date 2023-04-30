package util;

import java.util.ArrayDeque;
import java.util.Queue;

public class CharQueue {
    private final Queue<Character> queue = new ArrayDeque<>();

    public void initialize(String input) {
        queue.clear();

        for (char character : input.toCharArray()) {

            if (!Character.isSpaceChar(character)) {
                queue.offer(character);
            }

        }
    }

    public char peek() {
        return queue.element();
    }

    public char poll() {
        return queue.remove();
    }

    public void poll(char character) {
        if (peek() != character) throw new IllegalStateException();

        poll();
    }

    public void poll(String word) {
        for (char character : word.toCharArray()) poll(character);
    }
}