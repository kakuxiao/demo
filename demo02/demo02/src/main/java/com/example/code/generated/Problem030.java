package com.example.code.generated;

import java.util.*;

public class Problem030 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backTracking(nums,0);
        return res;
    }
    public void backTracking(int[] nums,int startIndex){
        res.add(new ArrayList<>(path));
        if(startIndex >= nums.length){
            return;
        }
        for(int i = startIndex; i < nums.length ; i++){
                path.add(nums[i]);
                backTracking(nums,i+1); // 这里是i + 1
                path.remove(path.size() - 1);
        }
        
    }
    public static void main(String[] args) {
        System.out.println("78. 子集");
        System.out.println("Solution method is ready.");
    }}
