import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Given two arrays, write a function to compute their intersection.

    Example:
    Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

    Note:
    Each element in the result must be unique.
    The result can be in any order.

 */
class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<Integer>();
        int[] arr =  nums1.length > nums2.length ? nums2 : nums1;
        int[] store_array = nums1.length > nums2.length ? nums1 : nums2;
        List<Integer> store = new ArrayList<Integer>();
        for (int i = 0; i < store_array.length; i++) {
            store.add(store_array[i]);
        }
        
        for (int i = 0 ; i < arr.length; i++) {
            if (store.contains(arr[i]) && !result.contains(arr[i])) {
                result.add(arr[i]);
            }
        }
        int[] output = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            output[i] = result.get(i);
            System.out.print(output[i]);
        }
        return output;
    }

    public static void main(String[] args) {
        IntersectionOfTwoArrays iota = new IntersectionOfTwoArrays();
        iota.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2});
    }
}