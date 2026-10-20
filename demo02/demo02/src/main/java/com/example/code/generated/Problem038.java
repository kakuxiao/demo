package com.example.code.generated;

public class Problem038 {
    public boolean searchMatrix(int[][] matrix, int target) {
        //从矩阵的左下角或者右上角开始遍历,时间复杂度O(m + n)
        int m = matrix.length;
        int n = matrix[0].length;
        int i = m - 1;
        int j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] == target) {
                return true;
            } else if(matrix[i][j] > target) {
                i--;
            } else {
                j++;
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        System.out.println("240. 搜索二维矩阵 II");
        System.out.println("Solution method is ready.");
    }}
