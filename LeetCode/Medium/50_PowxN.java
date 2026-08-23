/**
 * Problem Link : https://leetcode.com/problems/powx-n/
 * Platform     : LeetCode
 * Difficulty   : Medium
 */

class Solution {
    public double myPow(double x, int n) {
        long N = n; // avoid overflow when n = Integer.MIN_VALUE
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return fastPow(x, N);
    }
    
    private double fastPow(double x, long n) {
        double result = 1.0;
        while (n > 0) {
            if (n % 2 == 1) {   // odd exponent, take one factor out
                result *= x;
            }
            x *= x;  // square the base
            n /= 2;  // halve the exponent
        }
        return result;
    }
}
