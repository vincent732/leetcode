
public class ReverseInteger {

    public int reverse(int x) {
        boolean reverseSign = false;
        if (x < 0) {
            reverseSign = true;
        }
        x = Math.abs(x);
        int numOfDigit = (int)(Math.log10(x)+1);
        int multiplyer = 10;
        int output = 0;
        while(x > 0) {
            int reminder = x % multiplyer;
            x = x / multiplyer;
            output += reminder * Math.pow(10, numOfDigit - 1);
            numOfDigit--;
            if (output == Integer.MAX_VALUE || output == Integer.MIN_VALUE) {
                output = 0;
                break;
            }
        }
        output = reverseSign ? 0 - output : output;
        return output;
    }

    public static void main(String[] args) {
        ReverseInteger a = new ReverseInteger();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.print(a.reverse(1534236469));
    }
}