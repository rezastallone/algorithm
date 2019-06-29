package sampletest;

import java.util.ArrayList;

public class BinarySearch {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(10);
        arr.add(30);
        arr.add(40);
        arr.add(70);
        arr.add(80);
        arr.add(90);

        System.out.println("Found at index " + search(arr, 0, arr.size() - 1, 40));
    }

    private static int search(ArrayList<Integer> arr, int startIndex, int endIndex, int valueToFind) {
        if (startIndex <= endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;
            System.out.println("start " + startIndex + " end " + endIndex + " VAL : " + arr.get(mid)  );
            if (arr.get(mid) == valueToFind) {
                return mid;
            }

            if (arr.get(mid) < valueToFind) {
                return search(arr, mid + 1, endIndex, valueToFind);
            }

            return search(arr, startIndex, mid - 1, valueToFind);
        } else {
            return -1;
        }
    }
}
