package com.company.SortingMethods;

import com.company.Sorting;

import java.util.ArrayList;

public class BubbleSort implements Sorting {

    private long timeStart = 0;
    private long timeFinish = 0;

    @Override
    public ArrayList sort(ArrayList<Integer> array) {
        timeStart = System.currentTimeMillis();
        if (array.size() > 1) {
            bubbleSort(array);
        }
        timeFinish = System.currentTimeMillis();
        return array;
    }

    private void bubbleSort(ArrayList<Integer> array) {
        int tmp;
        for (int i = 0; i < array.size(); i++) {
            for (int j = 0; j < array.size() - i - 1; j++) {
                if (array.get(j).compareTo(array.get(j + 1)) > 0) {
                    tmp = array.get(j);
                    array.set(j, array.get(j + 1));
                    array.set(j + 1, tmp);
                }
            }
        }
    }

    @Override
    public String getSortName() {
        return "Пузырьковая сортировка: ";
    }

    @Override
    public String getWorkTime() {
        return String.valueOf(timeFinish - timeStart);
    }
}
