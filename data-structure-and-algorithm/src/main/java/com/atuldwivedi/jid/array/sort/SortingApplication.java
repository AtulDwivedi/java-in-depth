package com.atuldwivedi.jid.array.sort;

import org.assertj.core.util.Arrays;

public class SortingApplication {
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        System.out.print("Unsorted array: ");
        Arrays.asList(arr).forEach(element -> System.out.print(element + " "));
        System.out.println();

        //Sorter sorter = new BubbleSort();
        Sorter sorter = new QuickSort();




        sorter.sort(arr);
        System.out.print("Sorted array: ");
        Arrays.asList(arr).forEach(element -> System.out.print(element + " "));
    }
}
