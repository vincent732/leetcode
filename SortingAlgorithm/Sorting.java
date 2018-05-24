import java.util.Arrays;
import java.util.ArrayList;
public class Sorting {

    public int[] BubbleSort(int[] nums) {
        // in ASC order
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = 0; j < i;j++) {
                if (nums[j] > nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] =temp;
                }
            }
        }
        return nums;
    }

    public int[] SelectionSort(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int min = Integer.MAX_VALUE;
            int idx = -1;
            // find minimum value
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    idx = j;
                }
            }

            // swap with leftmost element
            int temp = nums[i];
            nums[i] = nums[idx];
            nums[idx] = temp;
        }
        return nums;
    }

    public int[] InsertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i;
            while (j > 0) {
                if (nums[j] < nums[j-1]) {
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                } else {
                    break;
                }
                j--;
            }
        }
        return nums;
    }

    public int[] MergeSort(int[] nums) {
        int N = nums.length;
        if (N <= 1) {
            return nums;
        }
        int[] a = Arrays.copyOfRange(nums, 0, N/2);
        int[] b = Arrays.copyOfRange(nums, N/2, N);
        nums = Merge(MergeSort(a), MergeSort(b));
        return nums;
    }

    private int[] Merge(int[] a, int[] b) {
        int[] output = new int[a.length + b.length];
        int i = 0, j = 0;
        for (int k = 0; k < output.length; k++) {
            if (i >= a.length) {
                output[k] = b[j++];
            } else if (j >= b.length) {
                output[k] = a[i++];
            } else if (a[i] <= b[j]) {
                output[k] = a[i++];
            } else {
                output[k] = b[j++];
            }
        }
        return output;
    }

    public int[] QuickSort(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        int pivot = nums[0];
        int[] unsorted = Arrays.copyOfRange(nums, 1, nums.length);
        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();
        for (int i : unsorted) {
            if (i < pivot) {
                left.add(i);
            } else {
                right.add(i);
            }
        }
        int[] leftArray = QuickSort(ArrayListToArray(left));
        int[] rightArray = QuickSort(ArrayListToArray(right));
        return mergeArray(leftArray, pivot, rightArray);
    }

    private int[] mergeArray(int[] left, int pivot, int[] right) {
        int[] arr = new int[left.length + 1 + right.length];
        for (int i = 0; i < arr.length; i++) {
            if (i < left.length) {
                arr[i] = left[i];
            } else if (i == left.length) {
                arr[i] = pivot;
            } else {
                arr[i] = right[i - left.length - 1];
            }
        }
        return arr;
    }

    private static int[] ArrayListToArray(ArrayList nums) {
        int[] arr = new int[nums.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)nums.get(i);
        }
        return arr;
    }

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i+" ");
        }
    }

    public static void main(String[] args) {
        Sorting s = new Sorting();
        int[] result = s.QuickSort(new int[]{9,10, 13, 3,1,32,5,8,2,3,6,5});
        printArray(result);
    }
}