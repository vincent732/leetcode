/**
 * We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.

    Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
    Example:
    Input: 28
    Output: True
    Explanation: 28 = 1 + 2 + 4 + 7 + 14
    Note: The input number n will not exceed 100,000,000. (1e8)
 */
import java.util.*;
class PerfectNumber {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) {
            return false;
        }
        int sum = 0;
        int i = 2;
        while (i < num / i) {
            if (num % i == 0) {
                sum += i + num/i;
            }
            i++;
        }
        if (sum + 1 == num) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        PerfectNumber p = new PerfectNumber();
        System.out.println(p.checkPerfectNumber(28));
    }
}