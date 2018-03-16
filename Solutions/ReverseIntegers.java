/*
 Author: Himanshu Gupta, himgupt2@gmail.com
----

Given a 32-bit signed integer, reverse digits of an integer.

*/

class Solution {
    public int reverse(int x) {
        int rev = 0, temp;
        if (x==0)
            return 0;
        int i = x;
        
        if (x<0)
            i = -x;
        
        while (i>0){
            temp = rev*10 + i%10;
            if (temp/10 != rev)
                return 0;
            i /= 10;
            rev = temp;
        }
    if (x<0) {
        return -rev;
    } else {
        return rev;
    }
    }
}
