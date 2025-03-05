package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {

        int n = heights.length;
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }
        Arrays.sort(heights);

        //Реверсия отсортированного массива высот
        for (int i = 0; i < n / 2; ++i) {
            int temp = heights[i];
            heights[i] = heights[n - 1 - i];
            heights[n - 1 - i] = temp;
        }

        for (int i = 0; i < n; ++i) {
            names[i] = map.get(heights[i]);
        }

        return names;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] names = new String[] {"Mary","John","Emma"};
        int[] heights = new int[] {180,165,170};

        System.out.println(Arrays.toString(solution.sortPeople(names, heights)));
    }
}