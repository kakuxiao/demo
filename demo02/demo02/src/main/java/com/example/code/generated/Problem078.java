package com.example.code.generated;

import java.util.*;

public class Problem078 {
    public int majorityElement(int[] nums) {
        //hashmap 使用HashMap,若其中存在，则value + 1,不存在则将相应的key添加进去
        Map<Integer,Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num,map.getOrDefault(num,0)+1);
            if(map.get(num) > nums.length /2){
                return num;
            }
        }
        return  -1;
    }
    public static void main(String[] args) {
        System.out.println("169. 多数元素");
        System.out.println("Solution method is ready.");
    }}
