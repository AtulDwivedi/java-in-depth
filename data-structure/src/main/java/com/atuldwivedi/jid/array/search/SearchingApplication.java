package com.atuldwivedi.jid.array.search;

import org.assertj.core.util.Arrays;

public class SearchingApplication {
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        int elementToBeSearched = 11;

        System.out.print("Array: ");
        Arrays.asList(arr).forEach(element -> System.out.print(element + " "));
        System.out.println("\nElement to be searched: " + elementToBeSearched);

        Searcher searcher = new BinarySearch();

        System.out.println("Element found at index: " + searcher.search(arr, elementToBeSearched));
    }
}
