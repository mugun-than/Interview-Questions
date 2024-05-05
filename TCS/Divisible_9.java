/* Question: To check whether the given number is divisible by 9 or not infinite times
 * The program should stop executing once the user types 0
 * The program should get executed only if the user input is in the range 100 <= input <= 999
 * The program should also handle exceptions when the user types in input other than integer (eg: String and combination of String and integer etc.)
 */

import java.util.*;

class TCS {
    public static void main(String args[]) {
        int number = -1;
        Scanner sc = new Scanner(System.in);
        do {
            // Prompting user if they pass inputs other than integers
            try {
                System.out.print("Enter a three-digit product code (0 to stop): ");
                number = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Enter only integers :(");
                sc.next();
                continue;
            }
            
            // Checking the range of the input
            if (number >= 100 && number <= 999) {
                // Checking divisibilty by 9
                if (number%9 == 0) System.out.println("Product with code "+ number +" is divisible by 9");
                else if (number%9 != 0) System.out.println("Product with code "+ number +" is not divisible by 9");
            }
            // Prompting user is they pass input out of range
            else if (number != 0) System.out.println("Product code should be in the range - 100 <= code <= 999");
        }while (number != 0); // Code exits once the user passes 0 as input
        sc.close();
    } 
}