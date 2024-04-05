import java.util.ArrayList;
import java.util.Scanner;

public class BRGC {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int m;
        System.out.println("What order of binary reflective Gray Codes would wou like to compute:");
        m = scan.nextInt();

        // print the binary reflective gray code of order m
        ArrayList<String> brgcM = brgcRecursive(m);
        System.out.println("The binary reflected Gray code of order " + m + " generated recursively is given by:");
        for (String n : brgcM) {
            System.out.println(n);
        }

        System.out.println("\nThe binary reflected Gray code of order " + m + " generated non-recursively is given by:");
        brgcNonRecur(m);

    }

    /**
     * Generates recursively the binary reflected Gray code of order n
     * @param n, a positive integer for which the binary reflected gray code will be generated
     * @return a list of all bit strings of length n composing the Gray code
     */
    public static ArrayList<String> brgcRecursive(int n) {
        // base case
        if (n == 1) {
            ArrayList<String> base = new ArrayList<>();
            base.add("0");
            base.add("1");
            return base;
        }

        // recursively call the function for the n-1 case
        ArrayList<String> l1 = brgcRecursive(n - 1);
        // declare l1 and set it equal to the reversed order of l1
        ArrayList<String> l2 = new ArrayList<>();
        for (int i = l1.size() - 1; i >= 0; i--) {
            l2.add(l1.get(i));
        }
        // for each bit string in l1 add a 0 in front, and in l2 add a 1 in front
        for (int j = 0; j < l1.size(); j++) {
            l1.set(j, "0" + l1.get(j));
            l2.set(j, "1" + l2.get(j));
        }
        // append l2 to l1
        l1.addAll(l2);
        // return the list of bit strings to the final output or the previous recursive call
        return l1;
    }

    /**
     * Generate the binary reflective Gray Code of order n non-recursively
     * @param n the order of binary reflective Gray code to compute
     */
    public static void brgcNonRecur(int n) {
        // find the number of bit strings to compute
        int max = ((int) Math.pow(2, n));

        int[] brgc = new int[n];

        // find the binary representation for the ith bit string
        String binary;
        for (int i = 0; i < max; i++) {
            binary = Integer.toBinaryString(i);
            int lengthDiff = n - binary.length();
            while (lengthDiff > 0) {
                binary = "0" + binary;
                lengthDiff--;
            }
            // determine the least significant 1 in the binary string and flip the same bit in the brgc representation
            int j;
            for (j = binary.length() - 1; j >= 0; j--) {
                if (binary.charAt(j) == '1') {
                    brgc[j] = (brgc[j] + 1) % 2;
                    break;
                }
            }
            // print the bit string before computing the next
            for (int bit : brgc) {
                System.out.print(bit);
            }
            System.out.println();
        }
    }

}
