import java.util.Arrays;

public class ThanosSort {
    public static void main(String[] args) {
        int[] arr = {4888, -1, -2147483648, 0, 123, 4, 2147483647, 2147483646};
        thanosSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void thanosSort(int[] arr) {
        BucketSort(arr, 0, arr.length);
    }

    public static boolean IsSorted(int[] arr, int start, int end) {
        for (int i = start; i < end - 1; i++)
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        return true;
    }

    public static void BucketSort(int[] arr, int start, int end) {
        double sum = 0;
        for (int i = start; i < end; i++) {
            sum += arr[i];
        }
        double mean = sum / (end - start);

        int[] copy = new int[end - start];
        int left = 0;
        int right = (end - start) - 1;

        for (int i = 0; i < copy.length; i++) {
            if (arr[start + i] <= mean) {
                copy[left] = arr[start + i];
                left++;
            } else {
                copy[right] = arr[start + i];
                right--;
            }
        }
        if (copy.length >= 0) System.arraycopy(copy, 0, arr, start, copy.length);
        if (left > 1 && !IsSorted(arr, start, start + left)) {
            BucketSort(arr, start, start + left);
        }
        if (left < end - 1 && !IsSorted(arr, start + left, end)) {
            BucketSort(arr, start + left, end);
        }
    }
}