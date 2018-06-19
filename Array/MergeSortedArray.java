import java.util.Arrays;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

    Note:

    The number of elements initialized in nums1 and nums2 are m and n respectively.
    You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
    Example:

    Input:
    nums1 = [1,2,3,0,0,0], m = 3
    nums2 = [2,5,6],       n = 3

    Output: [1,2,2,3,5,6]

 */
class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length == 0 && nums2.length == 0) {
            return;
        }
        if (nums2.length > 0) {
            int idx = nums2.length - 1;
            for (int i = nums1.length - 1 ; i >= 0 ; i--) {
                if (nums1[i] == 0) {
                    nums1[i] = nums2[idx];
                    idx--;
                    if (idx < 0) {
                        break;
                    }
                }
            }
        }
        if (nums1.length == 0) {
            nums1 = nums2;
        }

        for (int i = 1 ; i < nums1.length ; i++) {
            int j = i;
            while (j > 0) {
                if (nums1[j] < nums1[j-1]) {
                    int temp = nums1[j];
                    nums1[j] = nums1[j-1];
                    nums1[j-1] = temp;
                }
                j--;
            }
        }
    }

    public static void main(String[] args) {
        MergeSortedArray m = new MergeSortedArray();
        int[] num1 = new int[]{-1,0,0,3,3,3,0,0,0};
        int[] num2 = new int[]{1,2,2};
        m.merge(num1, 6, num2, 3);
        for (int i : num1) {
            System.out.print(i+" ");
        }
    }
}