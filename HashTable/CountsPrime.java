
/**
 * Count the number of prime numbers less than a non-negative number, n.

Example:

Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

 */
class CountPrime {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int cnt = 0;
        for (int i = 2 ; i < n ; i++) {
            if (!notPrime[i]) {
                cnt++;
                for (int j = 2 ; i * j < n ; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        return cnt;
    }
}