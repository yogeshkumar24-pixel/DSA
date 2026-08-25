/**
 * Problem Link : https://leetcode.com/problems/can-i-win/
 * Platform     : LeetCode
 * Difficulty   : Medium
 */

class Solution {
    HashMap<Integer, Boolean> memo = new HashMap<>();
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = maxChoosableInteger * (maxChoosableInteger + 1) / 2;

        if (sum < desiredTotal) return false;
        if (desiredTotal <= 0) return true;

        return dfs(maxChoosableInteger, desiredTotal, 0);
    }
    private boolean dfs(int max, int remaining, int mask) {
        if (memo.containsKey(mask)) {
            return memo.get(mask);
        }
        for (int i = 1; i <= max; i++) {
            int bit = 1 << (i - 1);
            if ((mask & bit) == 0) {
                if (i >= remaining || !dfs(max, remaining - i, mask | bit)) {
                    memo.put(mask, true);
                    return true;
                }
            }
        }
        memo.put(mask, false);
        return false;
    }
}
