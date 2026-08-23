/**
 * Problem Link : https://leetcode.com/problems/water-and-jug-problem/
 * Platform     : LeetCode
 * Difficulty   : Medium
 */

class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0) return true;
        if ((long) x + y < z) return false;  // avoid overflow, use long
        return z % gcd(x, y) == 0;
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
