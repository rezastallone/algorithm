public class javazalgo {
    public static void main(String[] args) {
        String text = "aaabcxyzaaaabczaaczabbaaaaaabcxyzaaaabczaaaabcxyza";
        String pattern = "aaabc";
        int[] zArray = findMatchingPattern(pattern + "$" + text);
        for ( int i = pattern.length(); i < zArray.length; i++){
            if ( zArray[i] == pattern.length() ){
                System.out.println("Found at " + ( i - pattern.length() - 1 ));
            }
        }
    }

    private static int[] findMatchingPattern(String text) {
        int[] zArray = new int[text.length()];
        int left = 0;
        int right = 0;
        for (int zValueItr = 1; zValueItr < text.length(); zValueItr++) {
            if (zValueItr > right) {
                left = zValueItr;
                right = zValueItr;
                while (right < text.length() && text.charAt(right) == text.charAt(right - left)){
                    right++;
                }
                zArray[zValueItr] = right - left;
                right--;
            } else {
                if ( zArray[zValueItr - left] + zValueItr > right ){
                    left = zValueItr;
                    while (right < text.length() && text.charAt(right) == text.charAt(right - left)){
                        right++;
                    }
                    zArray[zValueItr] = right - left;
                    right--;
                } else {
                    zArray[zValueItr] = zArray[zValueItr - left];
                }
            }
        }
        return zArray;
    }
}
