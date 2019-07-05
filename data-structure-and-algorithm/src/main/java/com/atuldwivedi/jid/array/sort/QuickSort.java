package com.atuldwivedi.jid.array.sort;

public class QuickSort implements Sorter {

    @Override
    public void sort(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        bubbleSort(arr, low, high);
    }

    private void bubbleSort(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);
            bubbleSort(arr, low, partitionIndex - 1);
            bubbleSort(arr, partitionIndex + 1, high);
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
}
