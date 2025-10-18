//package org.example;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class Solution {
//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//
//
//        public void merge(int[] nums1, int m, int[] nums2, int n) {
//            int i = m - 1, j = n - 1, k = m + n - 1;
//
//            // Основной цикл: идем с конца и вставляем наибольшие элементы
//            while (i >= 0 && j >= 0) {
//                if (nums1[i] > nums2[j]) {
//                    nums1[k] = nums1[i];
//                    i--;
//                } else {
//                    nums1[k] = nums2[j];
//                    j--;
//                }
//                k--;
//            }
//
//            // Если в nums2 остались элементы, копируем их в nums1
//            while (j >= 0) {
//                nums1[k] = nums2[j];
//                j--;
//                k--;
//            }
//
//            // Если остались элементы в nums1, они уже на месте
//        }
//
//    }
//
//
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int[] nums1 = {1, 2, 3, 0, 0, 0};
//        int[] nums2 = {2, 5, 6};
//        solution.merge(nums1, 3, nums2, 3);
//        System.out.println(Arrays.toString(nums1));
//    }
//}