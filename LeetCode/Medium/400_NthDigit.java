/**
 * Problem Link : https://leetcode.com/problems/nth-digit/
 * Platform     : LeetCode
 * Difficulty   : Medium
 */

class Solution {
    public int findNthDigit(int n) {
        long digitLength = 1;
        long count = 9;
        long start = 1;

        while (n > digitLength * count) {
            n -= digitLength * count;
            digitLength++;
            count *= 10;
            start *= 10;
        }

        long num = start + (n - 1) / digitLength;
        int index = (int)((n - 1) % digitLength);

        return String.valueOf(num).charAt(index) - '0';
    }
}
