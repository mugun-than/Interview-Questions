/* Question:
 * Given an array as input containing both negative and positive integers
 * Find the pair of integers who's difference is maximum and the first integer is behind the second integer in array
 * 
 * eg: input_array = [7,2,3,-2,1]
 * difference between (7,-2) = 9 
 * difference between (-2,1) = 3
 * 
 * Here the answer is (-2,1) even though (7,2) has maximum difference, because the second condition of being first integer 
 * less than the second integer is only satisfied by (2,3) and (-2,1). Among these (-2,1) has maximum difference.
 * 
 * Hence output: (-2,1)
 */
import java.util.*;

public class max_diff {
    public static void main(String[] args) {
        ArrayList<Integer> input_array = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);

        // Getting the input from the user and converting it into an array of integers
        /* Approach:
         * Step 1. Get the input string from the user
         * Step 2. Split the string into array of strings containing individual numbers
         * Step 3. For each string value in the string array, convert it to integer and add to arraylist
         * Step 4. Convert the arraylist to array
         */
        String input = sc.nextLine();
        String[] tokens = input.split("\\s");
        for (String n : tokens) {
            int number;
            try {
                number = Integer.parseInt(n);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, enter only integers seperated by spaces");
                break;
            }
            input_array.add(number);
        }
        int[] array = new int[input_array.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = input_array.get(i);
        }

        // Finding the order pair with max difference and array[firstindex]< array[secondindex]
        /*  Hint: Since the array[firstindex] < array[secondindex], the max difference would be
            always negative. So the actual output is the pair with smallest difference when difference 
            is calculated as firstindex value - secondindex value or the pair with largest difference when 
            difference is calculated as second index value - firstindex value.

            In this code, the latter condition is implemented.

            Approach:
            Step 1. Marking two pointers i and j such that j is initialised always 1 index ahead of i.
            Step 2. By the above hint, the difference should be calculated only if the second integer is larger 
                    than the first index.
            Step 3. Calculating the difference as second integer - first integer.
            Step 4. Comparing it with the overall calculated maximum difference.
            Step 5. If the difference is greater than the previous maximum difference then the maximum difference is 
                    assigned to currently calculated difference and the ordered pair is also updated.
        */
        int max = 0;
        int firstindex = 0, secondindex = 0;
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[j] > array[i]) {
                    int difference = array[j] - array[i];
                    if (difference > max ) {
                        max = difference;
                        firstindex = i;
                        secondindex = j;
                    }
                }
            }
        }

        System.out.println("Ordered pair: ("+firstindex+", "+secondindex+") with difference "+max);
        sc.close();
    }
}
