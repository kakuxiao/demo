package com.example.code.generated;

public class Problem069 {
    //检查x和y中的二进制不同的位数，可以先计算x异或y，x^y
    //再利用按位与判断尾数是否为1 xor&1
    public int hammingDistance(int x, int y) {
        int res = x^y, hammingDistance = 0;
        while (res != 0) {
            if ((res & 1) == 1) {
                hammingDistance++;
            }
            res >>= 1;
        }
        return hammingDistance; 
    }
    public static void main(String[] args) {
        System.out.println("461. 汉明距离");
        System.out.println("Solution method is ready.");
    }}
