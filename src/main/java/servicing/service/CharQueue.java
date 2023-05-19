package servicing.service;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * CharQueue class represents a queue of characters, providing methods for initializing and manipulating the queue.
 */
public class CharQueue {
    private final Queue<Character> queue = new ArrayDeque<>();

    /**
     * Initializes the CharQueue with the characters from the input string.
     * Spaces are ignored and not added to the queue.
     * @param input the input string to initialize the queue
     */
    public void initialize(String input) {
        queue.clear();

        for (char character : input.toCharArray()) {

            if (!Character.isSpaceChar(character)) {
                queue.offer(character);
            }

        }
    }

    /**
     * Retrieves the first character in the queue without removing it.
     * @return the first character in the queue
     */
    public char peek() {
        return queue.element();
    }

    /**
     * Retrieves and removes the first character from the queue.
     * @return the first character from the queue
     */
    public char poll() {
        return queue.remove();
    }

    /**
     * Removes the specified character from the queue.
     * @param character the character to remove
     * @throws IllegalStateException if the first character in the queue is not equal to the specified character
     */
    public void poll(char character) {
        if (peek() != character) throw new IllegalStateException();

        poll();
    }

    /**
     * Removes a sequence of characters represented by the specified word from the queue.
     * @param word the word to remove from the queue
     */
    public void poll(String word) {
        for (char character : word.toCharArray()) poll(character);
    }
}