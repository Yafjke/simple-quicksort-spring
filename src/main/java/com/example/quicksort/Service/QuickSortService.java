package com.example.quicksort.Service;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class QuickSortService<T extends Comparable> {

/*    private int partition(T[] array, int startIndex, int endIndex) {
        int pivotIndex = (startIndex + endIndex) / 2;
        T pivotValue = array[pivotIndex];
        startIndex--;
        endIndex++;

        while (true) {
            do startIndex++; while (array[startIndex].compareTo(pivotValue) < 0);
            do endIndex--; while (array[endIndex].compareTo(pivotValue) > 0);

            if (startIndex >= endIndex) return endIndex;
            T temp = array[startIndex];
            array[startIndex] = array[endIndex];
            array[endIndex] = temp;
        }
    }


    public T[] quicksort(T[] array, int startIndex, int endIndex) {
        if (startIndex < endIndex)
        {
            int pivotIndex = partition(array, startIndex, endIndex);
            quicksort(array, startIndex, pivotIndex);
            quicksort(array, pivotIndex + 1, endIndex);
        }
        return array;
    }*/
public int[] sort(int[] array) {
    return Arrays.stream(sort(Arrays.stream(array).boxed().toArray(Integer[]::new)))
            .mapToInt(Integer::intValue)
            .toArray();
}

    public long[] sort(long[] array) {
        return Arrays.stream(sort(Arrays.stream(array).boxed().toArray(Long[]::new)))
                .mapToLong(Long::longValue)
                .toArray();
    }

    public double[] sort(double[] array) {
        return Arrays.stream(sort(Arrays.stream(array).boxed().toArray(Double[]::new)))
                .mapToDouble(Double::doubleValue)
                .toArray();
    }

    public <T extends Comparable<T>> T[] sort(T[] array) {
        doSort(array, 0, array.length - 1);
        return array;
    }

    private <T extends Comparable<T>> void doSort(T[] array, int left, int right) {
        if (left < right) {
            int pivot = partition(array, left, right);
            doSort(array, left, pivot - 1);
            doSort(array, pivot, right);
        }
    }

    private <T extends Comparable<T>> int partition(T[] array, int left, int right) {
        int mid = (left + right) / 2;
        T pivot = array[mid];
        while (right >= left) {
            while (array[left].compareTo(pivot) < 0) {
                left++;
            }
            while (pivot.compareTo(array[right]) < 0) {
                right--;
            }
            if (right >= left) {
                T swap = array[left];
                array[left] = array[right];
                array[right] = swap;
                ++left;
                --right;
            }
        }
        return left;
    }
}
