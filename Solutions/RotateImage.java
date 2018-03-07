/*
 Author: Himanshu Gupta, himgupt2@gmail.com
----

 You are given an n x n 2D matrix representing an image.

 Rotate the image by 90 degrees (clockwise and inplace).
*/

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length ;
        for (int i =0;i<n/2;i++){
           for (int j=i; j<n-i-1; j++) {
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[n-j-1][i];
                matrix[n-j-1][i]=matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1]=matrix[j][n-i-1];
                matrix[j][n-i-1]=tmp;
            }
        }
    }
}
