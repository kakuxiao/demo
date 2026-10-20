package com.example.code.generated;

public class Problem068 {
    // 二进制
    // 将当前元素与1按位与，计算二进制中1的个数
    public int[] countBits(int n) {
        int[] res= new int[n + 1];
        for (int i = 0; i <=n; i++) {
            int count = 0;
            int tmp = i;
            while (tmp != 0) {
                if ((tmp & 1) == 1) {
                    count++;
                }
                tmp >>= 1;
            }
            res[i] = count;
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println("338. 比特位计数");
        System.out.println("Solution method is ready.");
    }}
