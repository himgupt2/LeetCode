/*
Author: Himanshu Gupta, himgupt2@gmail.com
Given a string s, find the longest palindromic substring in s.
Example:
Input: "cbbd"
Output: "bb"
*/

class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len==0) return "";
        
        String Max = s.substring(0,1);
        for(int i =0; i<len-1;i++){
            String s1 = expand(s,i,i);
            if (s1.length()>Max.length()){
                Max = s1;
            }
        
            if (s.charAt(i) == s.charAt(i+1)){
                String s2 = expand(s,i,i+1);
                if(s2.length()>Max.length()) {
                    Max = s2;
                }
            }
           //System.out.println("Max ff="+Max);
        }
        return Max;
    }
    private String expand(String s, int i, int j){
        int l = i, r=j;
        
        int len = s.length();
        if (l == 0 || r == len-1) {
            return s.substring(l,r+1);
        } 
        while(l>=0 && r < len && s.charAt(l)==s.charAt(r)){
            //System.out.println(s.substring(l,r+1));
            l--;
            r++;
        }
        //System.out.println("l = " + l + "r="+r);
        return s.substring(l+1, r);
    }
}
