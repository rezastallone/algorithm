import java.util.ArrayList;

public class commonprefix {
    public static void main(String[] args) {
        String text = "ababaa";

        int total = 0;
        for (int textItr = 1; textItr < text.length(); textItr++) {
            total += findMatchIndexes(text.substring(0, textItr - 1), text.substring(textItr, textItr + ( text.length() - textItr )));
        }
    }

    static int findMatchIndexes(String pattern, String text) {
        if ( pattern.isEmpty() ){
            return text.length();
        }

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
                break;
            }
        }

        if ( foundIndexes.size() > 0 ){
            return pattern.length();
        } else {
            return 0;
        }
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
