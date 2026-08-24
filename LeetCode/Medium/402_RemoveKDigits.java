/**
 * Problem Link : https://leetcode.com/problems/remove-k-digits/
 * Platform     : LeetCode
 * Difficulty   : Medium
 */

class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder st = new StringBuilder();

        for(char ch : num.toCharArray()) {
            while(k > 0 && st.length() > 0 && st.charAt(st.length() - 1) > ch) {
                st.deleteCharAt(st.length() - 1);
                k--;
            }
            st.append(ch);
        }

        while(k > 0) {
            st.deleteCharAt(st.length() - 1);
            k--;
        }

        int i = 0;
        while(i < st.length() && st.charAt(i) == '0') {
            i++;
        }

        String ans = st.substring(i);
        return ans.length() == 0 ? "0" : ans;
    }
}
