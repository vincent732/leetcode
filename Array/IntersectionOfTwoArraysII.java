import java.util.Arrays;
import java.util.List;

/**
 * Given two arrays, write a function to compute their intersection.

    Example:
    Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

    Note:
    Each element in the result should appear as many times as it shows in both arrays.
    The result can be in any order.
    Follow up:
    What if the given array is already sorted? How would you optimize your algorithm?
    What if nums1's size is small compared to nums2's size? Which algorithm is better?
    What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */
import java.util.*;
class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        List<Integer> result = new ArrayList<Integer>();
        while (i <= nums1.length - 1 && j <= nums2.length - 1) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
                continue;
            }
            if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }

        int[] output = new int[result.size()];
        for (i = 0 ; i < output.length ; i++) {
            output[i] = result.get(i);
        }
        return output;
    }

    public static void main(String[] args) {
        IntersectionOfTwoArraysII i = new IntersectionOfTwoArraysII();
        System.out.println(i.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
    }
}