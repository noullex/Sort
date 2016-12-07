package com.company.SortingMethods;

import com.company.Sorting;

import java.util.ArrayList;

public class ShellSort implements Sorting {

    private long timeStart = 0;
    private long timeFinish = 0;

    @Override
    public ArrayList sort(ArrayList<Integer> array) {
        timeStart = System.nanoTime();
        if (array.size() > 1) {
            shellSort(array);
        }
        timeFinish = System.nanoTime();
        return array;
    }

    private void shellSort(ArrayList<Integer> array) {
        for (int gap = array.size() / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < array.size(); i++) {
                Integer tmp = array.get(i);
                int j;
                for (j = i; j >= gap && tmp.compareTo(array.get(j - gap)) < 0; j -= gap) {
                    array.set(j, array.get(j - gap));
                }
                array.set(j, tmp);
            }
        }
    }

    @Override
    public String getSortName() {
        return "Сортировка Шелла: ";
    }

    @Override
    public String getWorkTime() {
        return String.valueOf(timeFinish - timeStart);
    }
}
