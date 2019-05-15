package com.atuldwivedi.jid.algo.sorting;

public class QuickSort {

    private void sort(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);
            sort(arr, low, partitionIndex - 1);
            sort(arr, partitionIndex + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int lowestElementIndex = (low - 1);
        for (int i = low; i < high; i++) {
            if (arr[i] <= pivot) {
                lowestElementIndex++;

                int temp = arr[lowestElementIndex];
                arr[lowestElementIndex] = arr[i];
                arr[i] = temp;
            }
        }

        int temp = arr[lowestElementIndex + 1];
        arr[lowestElementIndex + 1] = arr[high];
        arr[high] = temp;

        return lowestElementIndex + 1;
    }

    public static void main(String[] args) {
        int[] elements = {10, 7, 8, 9, 1, 5};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(elements, 0, elements.length - 1);

        for (int element : elements) {
            System.out.print(element + " ");
        }
    }
}
