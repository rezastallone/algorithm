package sampletest;

import java.util.ArrayList;

public class QuickSort {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(10);
        arr.add(80);
        arr.add(30);
        arr.add(90);
        arr.add(40);
        arr.add(70);

        sort(arr, 0, arr.size() - 1);
        System.out.println(arr);
    }

    static void sort(ArrayList<Integer> arr, Integer low, Integer high) {
        if ( low < high ){
            int partitionInsertionIndex = partition(arr, low, high);
            sort(arr, low, partitionInsertionIndex - 1);
            sort(arr, partitionInsertionIndex + 1, high);
        }
    }

    static Integer partition(ArrayList<Integer> arr, Integer low, Integer high) {
        int pivotInsertionIndex = low - 1;
        for (int i = low; i < high; i++) {
            if ( arr.get(i) < arr.get(high) ){
                pivotInsertionIndex++;
                swap(arr, i, pivotInsertionIndex);
            }
        }
        pivotInsertionIndex++;
        swap(arr, pivotInsertionIndex, high);
        return pivotInsertionIndex;
    }

    static void swap(ArrayList<Integer> arr, int i, int j) {
        Integer temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
}
