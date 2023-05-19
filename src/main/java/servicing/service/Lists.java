package servicing.service;

import java.util.List;

/**
 * Lists class provides utility methods for working with lists.
 */
public class Lists {

    /**
     * Returns the last element in the list.
     * @param list the list
     * @param <T> the type of elements in the list
     * @return the last element in the list
     */
    public static <T> T last(List<T> list) {
        return list.get(list.size() - 1);
    }
}