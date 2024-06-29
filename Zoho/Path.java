package Questions;
import java.util.*;

public class Path {
    public static void main(String a[]) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        if(checkPath(input)) System.out.println("TRUE");
        else System.out.println("FALSE"); 
        sc.close();
    }    

    public static boolean checkPath(String s) {
        char[] path = s.toCharArray();

        Set<String> visitedPoints = new HashSet<>();
        int x = 0, y = 0;
        visitedPoints.add(x + "," + y);

        for(char c : path) {
            switch(c) {
                case 'N':
                    y+= 1;
                    break;
                case 'S': y -= 1; break;
                case 'E': x += 1; break;
                case 'W': x -= 1; break;
            }

            String currentPosition = x + "," + y;
            if(visitedPoints.contains(currentPosition)) return true;
            visitedPoints.add(currentPosition);
        }
        return false;
    }
}
