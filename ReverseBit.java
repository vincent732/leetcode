/*
Reverse bits of a given 32 bits unsigned integer.

Example:

Input: 43261596
Output: 964176192
Explanation: 43261596 represented in binary as 00000010100101000001111010011100, 
     return 964176192 represented in bi        00111001011110000010100101000000.
Follow up:
If this function is called many times, how would you optimize it?
*/
class ReverseBit {

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        System.out.println("process :" + n);
        while (n >= 0) {
            int r = n % 2;
            n = n/2;
            System.out.print(r);
        }
        return 0;
    }

    public static void main(String[] args) {
        ReverseBit rb = new ReverseBit();
        rb.reverseBits(8);
    }
}