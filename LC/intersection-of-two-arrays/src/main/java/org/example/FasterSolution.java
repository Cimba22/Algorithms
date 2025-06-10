package org.example;

import java.util.Arrays;

public class FasterSolution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] arr = new int[1001];
        for (int i : nums1) {
            arr[i] = 1;
        }
        int j = 0;
        for (int i : nums2) {
            if (arr[i] == 1) {
                arr[i] = 2;
                nums1[j++] = i;
            }
        }
        return Arrays.copyOfRange(nums1, 0, j);
    }
}
