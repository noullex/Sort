package com.company;

import com.company.SortingMethods.BubbleSort;
import com.company.SortingMethods.MergeSort;
import com.company.SortingMethods.QuickSort;
import com.company.SortingMethods.ShellSort;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    private static final int SIZE = 10000;
    private static ArrayList<Sorting> sortList = new ArrayList<>();

    public static void main(String[] args) {
        createSortArray();
        if (!sortList.isEmpty()) {
            Random rnd = new Random();
            ArrayList<Integer> arrayInteger = new ArrayList<>();
            for (int i = 0; i < SIZE; i++) {
                arrayInteger.add(rnd.nextInt(SIZE * 2));
            }
            System.out.print("Результаты для целочисленных массивов размерности " + SIZE + "\n");
            callSorts(arrayInteger);
            printResult();
        }
    }

    private static void createSortArray() {
        sortList.add(new BubbleSort());
        sortList.add(new QuickSort());
        sortList.add(new MergeSort());
        sortList.add(new ShellSort());
    }

    private static ArrayList<Integer> tmp = new ArrayList<>();

    private static void callSorts(ArrayList array) {
        for (int i = 0; i < sortList.size(); i++) {
            tmp = sortList.get(i).sort(array);
        }
    }

    private static void printResult() {
        for (int i = 0; i < sortList.size(); i++) {
            System.out.print(sortList.get(i).getSortName());
            System.out.print("время сортировки - " + sortList.get(i).getWorkTime() + " нс\n");
        }
    }
}
