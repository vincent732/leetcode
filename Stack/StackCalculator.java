import java.util.Stack;

public class StackCalculator {

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        try{
            for (int i = 0 ; i < s.length() ; i++) {
                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    stack.push(c - '0');
                    continue;
                }
                if (c == '+') {
                    int output = stack.pop() + stack.pop();
                    if (output < 0) {
                        return -1;
                    }
                    stack.push(output);
                    continue;
                }

                if (c == '*') {
                    int output = stack.pop() * stack.pop();
                    if (output < 0) {
                        return -1;
                    }
                    stack.push(output);
                    continue;
                }
            
            }
        } catch (Exception e) {
            return -1;
        }
        
        if (!stack.isEmpty()) {
            return stack.pop();
        }
        return -1;
    }

    public static void main(String[] args) {
        StackCalculator s = new StackCalculator();
        System.out.println(s.calculate("13+62*7+*"));
        System.out.println(s.calculate("11+"));
        System.out.println(s.calculate("11+2*2*3*4"));
    }
}