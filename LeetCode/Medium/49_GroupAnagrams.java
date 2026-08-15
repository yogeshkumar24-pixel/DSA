/**
 * Problem Link : https://leetcode.com/problems/group-anagrams/
 * Platform     : LeetCode
 * Difficulty   : Medium
 */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        List<List<String>> ls=new ArrayList<List<String>>();
        for(String str:strs){
            char[] ch=str.toCharArray();
            Arrays.sort(ch);
            String key=new String(ch);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<String>());
            }
            map.get(key).add(str);
        }
        for(Map.Entry<String,List<String>> e:map.entrySet()){
            ls.add(e.getValue());
        }
        return ls;

    }
}
