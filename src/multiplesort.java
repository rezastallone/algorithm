import java.util.*;

public class multiplesort {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        arr.add(3);
        arr.add(2);
        arr.add(2);
        arr.add(4);
        customSort(arr);
    }

    public static void customSort(List<Integer> arr) {
        // Write your code here
        HashMap<Integer, Integer> numberToFrequencyMap = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> frequencyToNumberListMap = new HashMap<>();

        numberToFrequencyMap = getNumberToFrequencyMap(arr, numberToFrequencyMap);

        frequencyToNumberListMap = mapNumberToFrequency(numberToFrequencyMap, frequencyToNumberListMap);

        printList(frequencyToNumberListMap);
    }

    private static void printList(HashMap<Integer, ArrayList<Integer>> frequencyToNumberListMap) {
        List<Integer> frequencyKeyList = new ArrayList(frequencyToNumberListMap.keySet());
        Collections.sort(frequencyKeyList);
        for (int i = 0; i < frequencyKeyList.size(); i++) {
            ArrayList<Integer> listToPrint = frequencyToNumberListMap.get(frequencyKeyList.get(i));
            Collections.sort(listToPrint);
            for (int j = 0; j < listToPrint.size(); j++) {
                System.out.println(listToPrint.get(j));
            }
        }
    }

    private static HashMap<Integer, ArrayList<Integer>> mapNumberToFrequency(HashMap<Integer, Integer> numberToFrequencyMap, HashMap<Integer, ArrayList<Integer>> frequencyToNumberListMap) {
        Iterator it = numberToFrequencyMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> pair = (Map.Entry) it.next();
            Integer value = pair.getValue();
            Integer key = pair.getKey();
            ArrayList sameFrequencyList = frequencyToNumberListMap.get(pair.getValue());
            if (sameFrequencyList == null) {
                sameFrequencyList = new ArrayList();
            }
            for (int i = 0; i < pair.getValue(); i++) {
                sameFrequencyList.add(key);
            }

            frequencyToNumberListMap.put(value, sameFrequencyList);
            it.remove();
        }
        return frequencyToNumberListMap;
    }

    private static HashMap<Integer, Integer> getNumberToFrequencyMap(List<Integer> arr, HashMap<Integer, Integer> numberToFrequencyMap) {
        for (int i = 0; i < arr.size(); i++) {
            Integer freq = numberToFrequencyMap.get(arr.get(i));
            if (freq == null) {
                freq = 0;
            }
            freq++;
            numberToFrequencyMap.put(arr.get(i), freq);
        }
        return numberToFrequencyMap;
    }

}
