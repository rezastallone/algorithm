import java.util.*;

public class MinumumDiff {

    public static void main(String[] args) {
        List<String> a = new ArrayList<String>();
        a.add("a");
        a.add("jk");
        a.add("abb");
        a.add("mn");
        a.add("abc");
        List<String> b = new ArrayList<String>();
        b.add("bb");
        b.add("kj");
        b.add("bbc");
        b.add("op");
        b.add("def");


        List<Integer> sol = getMinimumDifference(a,b);
        for ( int i = 0; i < sol.size(); i++){
            System.out.println(sol.get(i));
        }
    }

    public static List<Integer> getMinimumDifference(List<String> a, List<String> b) {
        // Write your code here
        List<Integer> sol = new ArrayList<Integer>();
        for ( int i = 0; i < a.size(); i++){
            sol.add(countDiff(a.get(i), b.get(i)));
        }
        return sol;
    }

    private static int checkMinumumDiff(String a, String b){
        if ( a.length() != b.length() ){
            return -1;
        }

        HashMap<Character, Integer> charMapA = new HashMap<>();
        HashMap<Character, Integer> charMapB = new HashMap<>();

        for ( int i = 0; i < a.length(); i++){
            Integer numberOfChar = charMapA.get(a.charAt(i));
            if ( numberOfChar == null ) {
                numberOfChar = 0;
            }
            numberOfChar++;
            charMapA.put(a.charAt(i), numberOfChar);
        }

        for ( int i = 0; i < b.length(); i++){
            Integer numberOfChar = charMapB.get(b.charAt(i));
            if ( numberOfChar == null ) {
                numberOfChar = 0;
            }
            numberOfChar++;
            charMapB.put(b.charAt(i), numberOfChar);
        }

        int numberOfCharToChange = 0;

        Iterator it = charMapB.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            Integer aContainNumber = (Integer) pair.getValue();
            Integer bContainNumber = charMapA.get(pair.getKey());
            if ( bContainNumber == null ){
                numberOfCharToChange += aContainNumber;
            } else {
                numberOfCharToChange += Math.abs(  aContainNumber - bContainNumber );
            }
            it.remove();
        }

        return numberOfCharToChange;
    }

    static int countDiff(String a, String b){
        if ( a.length() != b.length() ){
            return -1;
        }

        int diff = 0;
        int charCount[] = new int[26];
        for (int i = 0;i < a.length(); i++){
            charCount[a.charAt(i) - 'a']++;
        }

        for ( int i =0; i < b.length(); i++){
            if ( charCount[b.charAt(i) - 'a']-- <= 0){
                diff++;
            }
        }
        return diff;
    }
}
