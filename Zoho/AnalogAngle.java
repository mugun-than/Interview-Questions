package Questions;
import java.util.*;

public class AnalogAngle {
    public static void main(String a[]) {
        Scanner sc = new Scanner(System.in);
        String time = sc.next();
        
        String[] tokens = time.split(":");
        int hour = Integer.parseInt(tokens[0]);
        System.out.println("Hour: "+ hour);
        int minute = Integer.parseInt(tokens[1]);
        System.out.println("Minute: "+minute);

        double minuteAngle = minute * (360.0/60);
        System.out.println("Minute angle: " + minuteAngle);
        double hourAngle = ((hour%12) * (180.0/6)) + (minute * (30.0/60));
        System.out.println("Hour angle: " + hourAngle);
        double difference = Math.abs(hourAngle - minuteAngle);
        double answer = Math.min(difference, 360 - difference);

        System.out.println("Shorter angle : "+ answer);
    }
}
