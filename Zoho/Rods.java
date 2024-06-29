package Questions;
import java.util.*;

public class Rods {
    public static void main(String a[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the expression: ");
        String input = sc.next();

        System.out.println(countRodsWithAllColors(input));
    }

    public static int countRodsWithAllColors(String rings) {
        Map<Integer, Set<Character>> data = new HashMap<>();

        for(int i = 0; i < rings.length(); i += 2) {
            char color = rings.charAt(i);
            int rod = rings.charAt(i+1) - '0';

            data.putIfAbsent(rod, new HashSet<>());

            data.get(rod).add(color);
        }

        int count = 0;
        for(Map.Entry<Integer, Set<Character>> x : data.entrySet()) {
            boolean flag = false;
            if(x.getValue().size() == 3) {
                if(x.getValue().contains('R') && x.getValue().contains('B') && x.getValue().contains('G')) flag = true;
                if(flag) count++; flag = false;
            }
        }

        return count != 0 ? count : -1;
    }
    
}

