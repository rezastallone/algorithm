package string;

import java.util.Scanner;

public class CompatibleString {


    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String b;
        String a;

        a = s.nextLine();                 // Reading input from STDIN
        b = s.nextLine();                 // Reading input from STDIN

        if ( a.length() != b.length() ){
            System.out.println("NO");
            return;
        }

        int maxValue = 0;
        boolean foundZBefore = false;
        for ( int i = 0; i < a.length(); i++){
            int diff = b.charAt(i) - a.charAt(i);
            System.out.println(diff);
            if ( i == 0 ) maxValue = diff;
            if ( diff < 0 || diff > maxValue || ( foundZBefore && diff != 0 ) ){
                System.out.println("NO");
                return;
            }
            if ( a.charAt(i) == 'z' ){
                foundZBefore = true;
            }
        }
        System.out.println("YES");
    }

}
