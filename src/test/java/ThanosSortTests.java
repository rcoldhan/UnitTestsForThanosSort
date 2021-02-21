import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ThanosSortTests {
    @Test
    public void EmptyArray() {
        int[] arr = {};
        int[] arrExpected = {};
        ThanosSort.thanosSort(arr);
        Assertions.assertArrayEquals(arrExpected, arr);
    }

    @Test
    public void OneElementArray() {
        int[] arr = {42};
        int[] arrExpected = {42};
        ThanosSort.thanosSort(arr);
        Assertions.assertArrayEquals(arrExpected, arr);
    }

    @Test
    public void ArrayWithZeroAndPositive() {
        int[] arr = {21, 0};
        int[] arrExpected = {0, 21};
        ThanosSort.thanosSort(arr);
        Assertions.assertArrayEquals(arrExpected, arr);
    }

    @Test
    public void ArrayWithZeroAndNegative() {
        int[] arr = {0, -234};
        int[] arrExpected = {-234, 0};
        ThanosSort.thanosSort(arr);
        Assertions.assertArrayEquals(arrExpected, arr);
    }

    @Test
    public void OnlyNegativeArray() {
        int[] arr = {-1, -346, -15, -4567890, -2147483648};
        int[] arrExpected = {-2147483648, -4567890, -346, -15, -1};
        ThanosSort.thanosSort(arr);
        Assertions.assertArrayEquals(arrExpected, arr);
    }

    @Test
    public void ArrayWithBigNumbers() {
        int[] arr = {2147483647, 2147483643, 2147483645, 2147483644, 2147483646};
        int[] arrExpected = {2147483643, 2147483644, 2147483645, 2147483646, 2147483647};
        ThanosSort.thanosSort(arr);
        Assertions.assertArrayEquals(arrExpected, arr);
    }

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
        int[] arr = {4888, -1, -2147483648, 12, 123, 4, 2147483647, 2147483646};
        int[] arrExpected = {4888, -1, -2147483648, 12, 4, 123, 2147483646, 2147483647};
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