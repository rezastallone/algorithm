import java.util.ArrayList;
import java.util.List;

public class knapsackproblem {

    public static void main(String[] args) {
        List<Long> bags = new ArrayList<Long>();
        bags.add(50l);
        bags.add(40l);
        bags.add(1l);
        System.out.println(maxCandies(bags, 48));
    }

    public static long maxCandies(List<Long> bags, long candiesLimit) {

        return findMaxCand(bags, candiesLimit, bags.size());
    }

    private static long solveDp(List<Long> bags, int i, long candiesLimit) {
        return 0l;
    }

    private static long findMaxCand(List<Long> bags, long candiesLimit, int n) {
        long sol[] = new long[bags.size()+1];
        long max = 0;
        for( int i = 0; i <= n; i++){
            if (i == 0 || candiesLimit == 0) {
                sol[n] = 0;
            } else if ( bags.get(i-1) <= candiesLimit ){
                sol[n] = Math.max(bags.get(i - 1) + sol[i - 1], sol[i-1]);
            } else {
                sol[n] = sol[-1];
            }
            max = Math.max(sol[n] , max);
        }
        return max;
    }
}
