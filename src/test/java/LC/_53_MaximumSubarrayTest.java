package LC;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _53_MaximumSubarrayTest extends _53_MaximumSubarray {

    @Test
    @DisplayName("6_PASS")
    void testMaxSubArray_MaxSum6() {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        assertEquals(6, maxSubArray(nums));
    }
    @Test
    @DisplayName("1_PASS")
    void testMaxSubArray_SingleElement() {
        int[] nums = { 1 };
        assertEquals(1, maxSubArray(nums));
    }
    @Test
    @DisplayName("-1_PASS")
    void testMaxSubArray_SingleNegativeElement() {
        int[] nums = { -1 };
        assertEquals(-1, maxSubArray(nums));
    }
    @Test
    @DisplayName("-1_PASS")
    void testMaxSubArray_AllNegativeElements() {
        int[] nums = { -2, -1 };
        assertEquals(-1, maxSubArray(nums));
    }
    @Test
    @DisplayName("23_PASS")
    void testMaxSubArray_MaxSum23() {
        int[] nums = { 5, 4, -1, 7, 8 };
        assertEquals(23, maxSubArray(nums));
    }
    @Test
    @DisplayName("2_PASS")
    void testMaxSubArray_MaxSum2() {
        int[] nums = { -11, 2, -10, 1, -12 };
        assertEquals(2, maxSubArray(nums));
    }
    @Test
    @DisplayName("1_PASS")
    void testMaxSubArray_MaxSum1() {
        int[] nums = { -11, 0, -10, 1, -12 };
        assertEquals(1, maxSubArray(nums));
    }
    @Test
    @DisplayName("6_PASS")
    void testMaxSubArray_StartEndNegative() {
        int[] nums = { -10, 1, 2, 3, -10, 5, -10 };
        assertEquals(6, maxSubArray(nums));
    }
    @Test
    @DisplayName("10_PASS")
    void testMaxSubArray_AllPositive() {
        int[] nums = { 1, 2, 3, 4 };
        assertEquals(10, maxSubArray(nums));
    }
    @Test
    @DisplayName("1_PASS")
    void testMaxSubArray_AllNegExceptLast() {
        int[] nums = { -1, -2, -3, -4, 1 };
        assertEquals(1, maxSubArray(nums));
    }



}