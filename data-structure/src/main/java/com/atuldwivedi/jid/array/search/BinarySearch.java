package com.atuldwivedi.jid.array.search;


public class BinarySearch implements Searcher {

    @Override
    public int search(int[] arr, int element) {
        int left = 0;
        int right = arr.length - 1;
        return binarySearch(arr, left, right, element);
    }

    private int binarySearch(int[] arr, int left, int right, int element) {
        if (right >= left) {
            int mid = left + (right - 1) / 2;

            if (arr[mid] == element) {
                return arr[mid];
            }

            if (arr[mid] > element) {
                return binarySearch(arr, left, mid - 1, element);
            }

            return binarySearch(arr, mid + 1, right, element);
        }
        return -1;
    }
}
