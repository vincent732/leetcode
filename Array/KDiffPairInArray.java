import java.util.HashMap;
class KDiffPairInArray {
    /*
    Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.

    Example 1:
    Input: [3, 1, 4, 1, 5], k = 2
    Output: 2
    Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
    Although we have two 1s in the input, we should only return the number of unique pairs.
    Example 2:
    Input:[1, 2, 3, 4, 5], k = 1
    Output: 4
    Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
    Example 3:
    Input: [1, 3, 1, 5, 4], k = 0
    Output: 1
    Explanation: There is one 0-diff pair in the array, (1, 1).
    Note:
    The pairs (i, j) and (j, i) count as the same pair.
    The length of the array won't exceed 10,000.
    All the integers in the given input belong to the range: [-1e7, 1e7].
    */
    public int findPairs(int[] nums, int k) {
        HashMap<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    int key = Math.min(nums[i], nums[j]);
                    int value = Math.max(nums[i], nums[j]);
                    if (!cnt.containsKey(key)) {
                       cnt.put(key, value); 
                    }
                }
            }
        }
        return cnt.size();
    }

    public int findPairs2(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        int output = 0;
        HashMap<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (int i : nums) {
            if (cnt.containsKey(i)) {
                cnt.put(i, (int)cnt.get(i) + 1);
            } else {
                cnt.put(i, 1);
            }
        }
        for (int i: cnt.keySet()) {
            System.out.println(i+":"+cnt.get(i));
        }
        if (k == 0) {
            for (int i:cnt.keySet()) {
                if (cnt.get(i) >= 2) {
                    output++;
                }
            }
        } else {
            for (int i:cnt.keySet()) {
                if (cnt.containsKey(k + i)) {
                    output++;
                }
            }
        }
        return output;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        KDiffPairInArray kd = new KDiffPairInArray();
        System.out.println(kd.findPairs2(new int[]{3,1,4,1,5}, 2));
        long endTime = System.currentTimeMillis();
        System.out.println("That took " + (endTime - startTime) + " milliseconds");
    }
}