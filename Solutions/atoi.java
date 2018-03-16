/*
 Author: Himanshu Gupta, himgupt2@gmail.com
----

Implement atoi to convert a string to an integer.

Requirements for atoi:

The function first discards as many whitespace characters as necessary until the first non-whitespace character 
is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many 
numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have 
 effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence 
exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of 
representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.

*/

class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0)
            return 0;
        
        str = str.trim();
        int length = str.length();
        int n = 0;
        long ret = 0;
        int sign = 1;
        
        if (str.charAt(0) == '+') {
            n = 1;
            sign = 1;
        } else if (str.charAt(0) == '-'){
            n = 1;
            sign = -1;
        }
        while (n<length){
            if (!Character.isDigit(str.charAt(n)))
                return (int) ret*sign;
            ret = ret*10 + (str.charAt(n) - '0');
            n++;
            //System.out.println("Ret = "+ ret);
            
            if (sign == 1 && ret > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (sign == -1 && (-1)*ret < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }
    return (int) ret*sign;
    }
}