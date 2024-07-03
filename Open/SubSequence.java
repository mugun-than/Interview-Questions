import java.util.*;

public class SubSequence {
    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the sequence: ");
        String sequence = sc.next();
        System.out.println("Enter the sub sequence: ");
        String subSequence = sc.next();
        sc.close();

        for(char c : sequence.toCharArray()) {
            int i = sequence.indexOf(c);
            if(subSequence.length() > sequence.length()) break;
            else if(c == subSequence.charAt(0) && sequence.length() - i == subSequence.length()) {
                boolean flag = true;
                for(char j : subSequence.toCharArray()) {
                    if(j != sequence.charAt(i++)) {
                        flag = false;
                        break;
                    }
                }

                if(flag) {
                    System.out.println("VALID");
                    System.exit(0);
                }
            }
        }
        System.out.println("INVALID");
    }
}
