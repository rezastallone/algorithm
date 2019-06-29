import java.util.ArrayList;
import java.util.List;

public class isbst {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList();
        arr.add(1);
        arr.add(3);
        arr.add(2);
        System.out.println(isValid(arr));
    }

    public static String isValid(List<Integer> a) {
        // Write your code here
        for (int i = 0; i < a.size(); i++) {
            int left = i * 2 + 1;
            int right = i * 2 + 2;
            int valRoot = a.get(i);
            if ( left < a.size() ){
                if ( a.get(left) >= valRoot ){
                    System.out.println(a.get(left) + " >= " + valRoot);
                    return "NO";
                }
            }

            if ( right < a.size() ){
                if ( a.get(right) < valRoot ){
                    System.out.println(a.get(left) + " >= " + valRoot);
                    return "NO";
                }
            }
        }
        return "YES";
    }

}
