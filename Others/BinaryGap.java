
public class BinaryGap {
    public int solution(int num) {

        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int reminder = num % 2;
            sb.append(reminder);
            num = num/2;
        }
        int max = 0;
        int cnt = 0;
        boolean flag = false;
        String binary = sb.reverse().toString();
        System.out.println("b:"+binary);
        for (int i = 0 ; i < binary.length() ; i++) {
            char c = sb.charAt(i);
            if (c == '1') {
                if (flag) {
                   if (cnt > max) {
                       max = cnt;
                    }
                    cnt = 0; 
                } else {
                    flag = true;
                }
                
            }
            if (c == '0') {
                cnt++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        BinaryGap b = new BinaryGap();
        System.out.println(b.solution(1));
        System.out.println(b.solution(2));
        System.out.println(b.solution(9));
        System.out.println(b.solution(529)); 
        System.out.println(b.solution(15));
        System.out.println(b.solution(32));
        System.out.println(b.solution(647));
        System.out.println(b.solution(483));
    }
}