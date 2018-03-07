/*
 Author: Himanshu Gupta, himgupt2@gmail.com
---

Given a string, find the length of the longest substring without repeating characters.

*/


class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int l = 0;
        for (int i = 0, j =0; i<s.length();i++){
            if(map.containsKey(s.charAt(i)))
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            map.put(s.charAt(i), i);
            l = Math.max(l,i-j+1);
        }
        return l; 
    }
}
