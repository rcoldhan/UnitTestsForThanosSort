import java.util.Arrays;

public class ThanosSort {
    public static void main(String[] args) {
        int[] arr = {4888, -1, -2147483648, 0, 123, 4, 2147483647, 2147483646};
        thanosSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void thanosSort(int[] arr) {
        bucketSort(arr, 0, arr.length);
    }

    public static boolean isSorted(int[] arr, int start, int end) {
        for (int i = start; i < end - 1; i++)
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        return true;
    }

    public static void bucketSort(int[] arr, int start, int end) {
        double sum = 0;
        int len = end - start;
        for (int i = start; i < end; i++) {
            sum += arr[i];
        }
        double mean = sum / len;

        int[] copy = new int[len];
        int left = 0;
        int right = len - 1;

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
        if (left > 1 && !isSorted(arr, start, start + left)) {
            bucketSort(arr, start, start + left);
        }
        if (left < end - 1 && !isSorted(arr, start + left, end)) {
            bucketSort(arr, start + left, end);
        }
    }
}