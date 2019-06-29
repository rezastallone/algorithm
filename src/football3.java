import java.util.Arrays;

public class football3 {

    public static void main(String[] args) {
        int[] counts = counts(new int[]{2
                ,10
                ,5
                ,4
                ,8}, new int[]{
                3,
                1,
                7,
                8
        });
        for ( int i = 0; i < counts.length; i++){
            System.out.println(counts[i]);
        }
    }

    static int[] counts(int[] nums, int[] maxes) {
        Arrays.sort(nums);
        int[] counts = new int[maxes.length];
        int total = 0;
        int j = 0;
        for (int i = 0; i < nums.length && j < maxes.length; i++) {
            System.out.println(nums[i] + " " + maxes[j] + " " + total);
            if (nums[i] <= maxes[j]) {
                total++;
            } else {
                counts[j] = total;
                j++;
            }
        }
        if (nums[nums.length - 1] <= maxes[j-1]) {
            total++;
        }
        counts[j-1] = total;
        return counts;
    }


}
