/* Every valid email comprises a local name and a domain name seperated by the @ symbol. Besides lowercase letters, the email may contain one or more '.' or '+'

    In jhon@zohoaccounts.in", "jhon" is the local name and the "zohoaccounts.in" is the domain name/.

    If the period characters '.' are added in between characters in local name, mail will be forwarded to the same address without '.' in the local name. This rule does
    not apply for the domain name. For example, "jhont@zohoaccounts.in" and "jhon.t@zohoaccounts.in" forward to the same email id "jhont@zohoaccounts.in".

    If plus character '+' is added in the local name, everything after first '+' sign is ingored. This allows certain emails to be filtered. Note that this rule does not 
    apply to the domain name. For example, "jhon.t+user@zohoaccounts.in", will be forwarded to "jhont@zohoaccounts.in".

    It is possible to use both of these rules simultaneously. Given an array of strings emails where we send one email to each emails[i], return different addresses that
    actually will recieve emails. 
*/

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
