package com.company.SortingMethods;

import com.company.Sorting;

import java.util.ArrayList;

public class MergeSort implements Sorting {

    private long timeStart = 0;
    private long timeFinish = 0;

    @Override
    public ArrayList sort(ArrayList<Integer> array) {
        timeStart = System.currentTimeMillis();
        mergeSort(array);
        timeFinish = System.currentTimeMillis();
        return array;
    }

    public ArrayList<Integer> mergeSort(ArrayList<Integer> whole) {
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        int center;

        if (whole.size() == 1) {
            return whole;
        } else {
            center = whole.size() / 2;
            for (int i = 0; i < center; i++) {
                left.add(whole.get(i));
            }
            for (int i = center; i < whole.size(); i++) {
                right.add(whole.get(i));
            }
            left = mergeSort(left);
            right = mergeSort(right);
            merge(left, right, whole);
        }
        return whole;
    }

    private void merge(ArrayList<Integer> left, ArrayList<Integer> right, ArrayList<Integer> whole) {
        int leftIndex = 0;
        int rightIndex = 0;
        int wholeIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if ((left.get(leftIndex).compareTo(right.get(rightIndex))) < 0) {
                whole.set(wholeIndex, left.get(leftIndex));
                leftIndex++;
            } else {
                whole.set(wholeIndex, right.get(rightIndex));
                rightIndex++;
            }
            wholeIndex++;
        }

        ArrayList<Integer> rest;
        int restIndex;
        if (leftIndex >= left.size()) {
            rest = right;
            restIndex = rightIndex;
        } else {
            rest = left;
            restIndex = leftIndex;
        }
        for (int i = restIndex; i < rest.size(); i++) {
            whole.set(wholeIndex, rest.get(i));
            wholeIndex++;
        }
    }

    @Override
    public String getSortName() {
        return "Сортировка Слиянием: ";
    }

    @Override
    public String getWorkTime() {
        return String.valueOf(timeFinish - timeStart);
    }
}
