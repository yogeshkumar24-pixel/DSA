/**
 * Problem Link : https://leetcode.com/problems/divide-two-integers/
 * Platform     : LeetCode
 * Difficulty   : Medium
 */

class Solution {
    public int divide(int dividend, int divisor) {
        // Overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        // Determine sign of result
        boolean negative = (dividend < 0) ^ (divisor < 0);
        
        // Work with negative numbers to avoid overflow (|INT_MIN| > INT_MAX)
        long dvd = dividend < 0 ? dividend : -dividend;
        long dvs = divisor < 0 ? divisor : -divisor;
        
        int result = 0;
        // dvd and dvs are both <= 0, so dvd <= dvs means |dvd| >= |dvs|
        while (dvd <= dvs) {
            long tempDvs = dvs;
            int multiple = 1;
            // Double dvs (moving toward 0, i.e., magnitude grows) while it still fits
            while (tempDvs >= (Long.MIN_VALUE >> 1) && dvd <= (tempDvs << 1)) {
                tempDvs <<= 1;
                multiple <<= 1;
            }
            dvd -= tempDvs;
            result += multiple;
        }
        
        return negative ? -result : result;
    }
}
