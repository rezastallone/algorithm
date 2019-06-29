package sampletest;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {



    // Complete the findNumber function below.
    static String findNumber(List<Integer> arr, int k) {
       Collections.sort(arr);
       return Arrays.binarySearch(arr.toArray(), k) +"";
    }

    static void quickSort(List<Integer> arr, Integer low, Integer high){
        Integer pivot = arr.get(high);
        Integer i = ( low - 1);
        for ( int lowItr = low; lowItr <= high - 1; lowItr++){

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < arrCount; i++) {
            int arrItem = Integer.parseInt(bufferedReader.readLine().trim());
            arr.add(arrItem);
        }

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String res = findNumber(arr, k);
        System.out.println(res);
//        bufferedWriter.write(res);
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }
}
