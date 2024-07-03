import java.util.LinkedList;
import java.util.List;

public class MiddleElementLL {
    public static void main(String[] a) {
        List<Integer> linkedList = new LinkedList<>();
        
        for(int i = 1; i < 10; i++) {
            linkedList.add(i);
        }

        int slowIndex = 0, fastIndex = 0;
        while(fastIndex < linkedList.size() && fastIndex+1 < linkedList.size()) {
            slowIndex++;
            fastIndex += 2;
        }
        System.out.println("Middle element: "+linkedList.get(slowIndex));
    }    
}
