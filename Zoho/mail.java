/* Question: 
*  Every email comprises a local name and a domain name, seperated by '@' sign.
 * Besides lowercase letters, the email may contain one or more '.' 0r '+'.
 * 
 * In "john@zohoaccounts.in", "john" is the local name and "zohoaccounts.in" is the domain name.
 * 
 * If period characters '.' are added in between characters in local name, mail will be 
 * forwarded to the same address without '.' in the local name. This rule does not apply to 
 * domain name. For example "john.t@zohoaccounts.in" and "johnt@zohoaccounts.in" forward to the same 
 * email address.
 * 
 * If plus character '+' is added in the local name, everything after first '+' sign will be ingored.
 * This allows certain emails to be filtered. Note that this rule do not apply to domain names. For example,
 * "john.t+user@zohoaccounts.in" will be forwarded to "johnt@zohoaccounts.in".
 * 
 * It is possible to use both of these rules simultaneously.
 * Given an array of strings emails where we send one email to each emails[i], return different addresses that
 * actually recieve mails. 
 */
import java.util.*;

public class mail {
    public static void main(String[] args) {
        String[] emails = {"mugunthan.s@zohoaccounts.in", "mugunthans@zohoaccounts.in", "mugunthan.s+sakthivel+@zohoaccounts.in", "mugunthans+velliyan.giri++@zohoaccounts.in"};
        HashSet<String> answer = new HashSet<String>();
        
        // Looping for each emailid in emails
        for (String s : emails) {
            String domainname = "";
            String localname = "";
            String ans = "";
            boolean flag = true;

            // Splitting the emailid into localname and domainname
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '@') {
                    domainname += c;
                    flag = false;
                }
                else if (flag) {
                    localname += c;
                }
                else {
                    domainname += c;
                }
            }
            
            // Modifiying the localname according to the constraints given in question
            for (int i = 0; i < localname.length(); i++) {
                char c = localname.charAt(i);
                if (c == '.') continue;
                else if (c == '+') break;
                else ans += c;
            }

            // Adding the emailid to the hashset (in order to remove duplication of elements)
            answer.add(ans+domainname);
        }
        
        // Printing the unique email ids
        System.out.println(answer);
    }

}
