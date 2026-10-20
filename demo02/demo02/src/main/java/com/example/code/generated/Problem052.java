package com.example.code.generated;

public class Problem052 {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if (nums1.length > nums2.length) {
                return findMedianSortedArrays(nums2, nums1);
            }

            int shorterLength = nums1.length;
            int longerLength = nums2.length;
            int left = 0;
            int right = shorterLength;

            while (left <= right) {
                int partition1 = left + (right - left) / 2;
                int partition2 = (shorterLength + longerLength + 1) / 2 - partition1;

                int left1 = partition1 == 0
                        ? Integer.MIN_VALUE : nums1[partition1 - 1];
                int right1 = partition1 == shorterLength
                        ? Integer.MAX_VALUE : nums1[partition1];
                int left2 = partition2 == 0
                        ? Integer.MIN_VALUE : nums2[partition2 - 1];
                int right2 = partition2 == longerLength
                        ? Integer.MAX_VALUE : nums2[partition2];

                if (left1 <= right2 && left2 <= right1) {
                    if ((shorterLength + longerLength) % 2 == 1) {
                        return Math.max(left1, left2);
                    }
                        int leftMax = Math.max(left1, left2);
                        int rightMin = Math.min(right1, right2);
                        return leftMax / 2.0 + rightMin / 2.0;
                }

                if (left1 > right2) {
                    right = partition1 - 1;
                } else {
                    left = partition1 + 1;
                }
            }

            throw new IllegalArgumentException("Input arrays must be sorted");
        }
    public static void main(String[] args) {
        System.out.println("MedianOfTwoSortedArrays");
        System.out.println("Solution method is ready.");
    }}
