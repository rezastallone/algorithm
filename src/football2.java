import java.util.*;

public class football2 {

    public static void main(String[] args) {
        int[] counts = counts(new int[]{1, 4, 2, 4}, new int[]{100, 3, 5});
    }

    static int[] counts(int[] nums, int[] maxes) {
        HashMap<Integer, Integer> numberToFrequencyMap = new HashMap<>();
        HashMap<Integer, Integer> solutionTable = new HashMap<>();

        numberToFrequencyMap = getNumberToFrequencyMap(nums, numberToFrequencyMap);


        List<Integer> frequencyKeyList = new ArrayList(numberToFrequencyMap .keySet());
        Collections.sort(frequencyKeyList);

        int total = 0;
        for (int i = 0; i < frequencyKeyList.size(); i++) {
            int freq = numberToFrequencyMap.get(frequencyKeyList.get(i));
            total += freq;
            solutionTable.put(frequencyKeyList.get(i), total);
        }

        int[] counts = new int[maxes.length];
        int j;
        for (int i = 0; i < maxes.length; i++){
            j = maxes[i];
            while ( j > 0 && solutionTable.get(j) == null ){
                j--;
            }
            if ( solutionTable.get(j) != null){
                counts[i] = solutionTable.get(j);
            } else {
                counts[i] = 0;
            }
        }
        return counts;
    }

    private static HashMap<Integer, Integer> getNumberToFrequencyMap(int[] arr, HashMap<Integer, Integer> numberToFrequencyMap) {
        for (int i = 0; i < arr.length; i++) {
            Integer freq = numberToFrequencyMap.get(arr[i]);
            if (freq == null) {
                freq = 0;
            }
            freq++;
            numberToFrequencyMap.put(arr[i], freq);
        }
        return numberToFrequencyMap;
    }

}
