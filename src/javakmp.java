import java.util.ArrayList;

public class javakmp {
    public static void main(String[] args) {
        String text = "ababcabcabababd";
        String pattern = "ababd";
        ArrayList<Integer> foundIndexes = findMatchIndexes(pattern, text);
        foundIndexes.forEach(integer -> System.out.println("found at " + integer + "  " + text.substring(integer, integer + pattern.length())));

    }

    static ArrayList<Integer> findMatchIndexes(String pattern, String text) {
        ArrayList<Integer> foundIndexes = new ArrayList();
        int[] patternArray = buildPattern(pattern);
        int patternFallbackItr = -1;
        for (int textItr = 1; textItr < text.length(); textItr++) {
            if (text.charAt(textItr) == pattern.charAt(patternFallbackItr + 1)) {
                patternFallbackItr++;
            } else {
                while (patternFallbackItr > -1) {
                    patternFallbackItr = patternArray[patternFallbackItr];
                    if (text.charAt(textItr) == pattern.charAt(patternFallbackItr + 1)) {
                        patternFallbackItr++;
                    }
                    break;
                }
            }

            if (patternFallbackItr >= pattern.length() - 1) {
                int foundAt = textItr - (pattern.length() - 1);
                foundIndexes.add(foundAt);
            }
        }
        return foundIndexes;
    }

    static int[] buildPattern(String pattern) {
        int[] patternArray = new int[pattern.length()];
        int patternItr = 0;
        for (int i = 1; i < pattern.length(); i++) {
            if (pattern.charAt(i) == pattern.charAt(patternItr)) {
                patternItr++;
            } else {
                patternItr = 0;
            }
            patternArray[i] = patternItr;
        }
        return patternArray;
    }
}
