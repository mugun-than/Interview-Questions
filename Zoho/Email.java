package Questions;
import java.util.*;

public class Email {
    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);

        String[] emails = {"mugunthans@fyndus.com", "mugunthan.s@fyndus.com", "mugunthan.s+abc@fyndus.com", "mugunthan+.as++@fyndus.com", "bhuvana.s+absadkjfh@fyndus.com"};

        Set<String> answer = new HashSet<>();

        for(String email : emails) {
            String domainName = "", localName = "", actualName = "";
            boolean flag = false;
            for(char c : email.toCharArray()) {
                if(c == '@') {
                    domainName += c;
                    flag = true;
                }
                else if(flag) domainName += c;
                else localName += c;
            }

            for(char c : localName.toCharArray()) {
                if(c == '.') continue;
                else if(c == '+') break;
                actualName += c;
            }

            answer.add(actualName+domainName);
        }

        System.out.println(answer);
    }
}
