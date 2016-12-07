package com.company.SortingMethods;

import com.company.Sorting;

import java.util.ArrayList;
import java.util.Collections;

public class QuickSort implements Sorting {

    private long timeStart = 0;
    private long timeFinish = 0;

    @Override
    public ArrayList sort(ArrayList<Integer> array) {
        timeStart = System.currentTimeMillis();
        if (array.size() > 1) {
            quickSort(array, 0, array.size() - 1);
        }
        timeFinish = System.currentTimeMillis();
        return array;
    }

    public void quickSort(ArrayList<Integer> array, int from, int to) {
        if (from < to) {
            int pivot = from;
            int left = from + 1;
            int right = to;
            int pivotValue = array.get(pivot);
            while (left <= right) {
                while (left <= to && pivotValue >= array.get(left)) {
                    left++;
                }
                while (right > from && pivotValue < array.get(right)) {
                    right--;
                }
                if (left < right) {
                    Collections.swap(array, left, right);
                }
            }
            Collections.swap(array, pivot, left - 1);
            quickSort(array, from, right - 1);
            quickSort(array, right + 1, to);
        }
    }

    @Override
    public String getSortName() {
        return "Быстрая сортировка: ";
    }

    @Override
    public String getWorkTime() {
        return String.valueOf(timeFinish - timeStart);
    }
}
