import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ThanosSortTests {
    @Test
    public void ThanosSortEvenLengthArray() {
        int[] arr = {4888, -1, -2147483648, 0, 123, 4, 2147483647, 2147483646};
        int[] arrExpected = {-2147483648, -1, 0, 4, 123, 4888, 2147483646, 2147483647};
        ThanosSort.thanosSort(arr);
        Assertions.assertArrayEquals(arrExpected, arr);
    }

    @Test
    public void ThanosSortOddLengthArray() {
        int[] arr = {4888, -1, -2147483648, 0, 0, 4, 2147483647};
        int[] arrExpected = {-2147483648, -1, 0, 0, 4, 4888, 2147483647};
        ThanosSort.thanosSort(arr);
        Assertions.assertArrayEquals(arrExpected, arr);
    }

    @Test
    public void BucketSortFirstHalfOfArray() {
        int[] arr = {4888, -1, -2147483648, 0, 123, 4, 2147483647, 2147483646};
        int[] arrExpected = {-2147483648, -1, 0, 4888, 123, 4, 2147483647, 2147483646};
        ThanosSort.BucketSort(arr, 0, arr.length / 2);
        Assertions.assertArrayEquals(arrExpected, arr);
    }

    @Test
    public void BucketSortSecondHalfOfArray() {
        int[] arr = {4888, -1, -2147483648, 0, 123, 4, 2147483647, 2147483646};
        int[] arrExpected = {4888, -1, -2147483648, 0, 4, 123, 2147483646, 2147483647};
        ThanosSort.BucketSort(arr, arr.length / 2, arr.length);
        Assertions.assertArrayEquals(arrExpected, arr);
    }

    @Test
    public void IsSortedTrue() {
        int[] arr = {-2, -1, 0, 1, 2, 3};
        boolean result = ThanosSort.IsSorted(arr, 0, arr.length);
        Assertions.assertTrue(result);
    }

    @Test
    public void IsSortedFalse() {
        int[] arr = {123, -1, 56, 0, 1, 9876};
        boolean result = ThanosSort.IsSorted(arr, 0, arr.length);
        Assertions.assertFalse(result);
    }
}