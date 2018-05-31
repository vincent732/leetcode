import java.util.HashMap;
public class JudgeRouteCircle {

    /**
     * Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.
        The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.

        Example 1:
        Input: "UD"
        Output: true
        Example 2:
        Input: "LL"
        Output: false
     */
    public boolean judgeCircle(String moves) {
        HashMap<Character, Integer> counts = new HashMap<Character, Integer>();
        for (int i = 0;i < moves.length(); i++) {
            Character c = moves.charAt(i);
            if (counts.containsKey(c)) {
                int count = counts.get(c) + 1;
                counts.put(c, count);
            } else {
                counts.put(c, 1);
            }
        }
        int countL = counts.containsKey('L') ? (int)counts.get('L') : 0;
        int countR = counts.containsKey('R') ? (int)counts.get('R') : 0;
        int countU = counts.containsKey('U') ? (int)counts.get('U') : 0;
        int countD = counts.containsKey('D') ? (int)counts.get('D') : 0;
        if (countL == countR && countU == countD) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        JudgeRouteCircle jrc = new JudgeRouteCircle();
        System.out.println(jrc.judgeCircle("UD"));
    }
}