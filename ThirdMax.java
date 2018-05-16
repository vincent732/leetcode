class ThirdMax {
    /*
    *Given a non-empty array of integers, return the third maximum number in this array. 
    If it does not exist, return the maximum number. The time complexity must be in O(n).
    Example 1:
    Input: [3, 2, 1]

    Output: 1

    Explanation: The third maximum is 1.
    Example 2:
    Input: [1, 2]

    Output: 2

    Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
    Example 3:
    Input: [2, 2, 3, 1]

    Output: 1

    Explanation: Note that the third maximum here means the third maximum distinct number.
    Both numbers with value 2 are both considered as second maximum.

    */
    public int thirdMax(int[] nums) {
        int[] record = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        int count = 0;
        for (int i:nums) {
            if (i == Integer.MIN_VALUE) {
                count++;
            }
            if (i == record[0] || i == record[1]) {
                continue;
            } else if (i > record[0]) {
                record[2] = record[1];
                record[1] = record[0];
                record[0] = i;
            } else if (i > record[1]) {
                record[2] = record[1];
                record[1] = i;
            } else if (i >= record[2]) {
                record[2] = i;
            }
        }
        if (record[2] == Integer.MIN_VALUE && count == 0) {
            return record[0];
        } else if (record[2] < record[1] && record[1] < record[0]) {
            return record[2];
        } else {
            return record[0];
        }
    }

    public static void main(String[] args) {
        ThirdMax tm = new ThirdMax();
        System.out.println(tm.thirdMax(new int[]{2, 2, 3, 1}));
    }
}