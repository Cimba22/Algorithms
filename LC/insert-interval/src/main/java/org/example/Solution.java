package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // Добавляем все интервалы, которые идут до newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Объединяем newInterval со всеми пересекающимися интервалами
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        // Добавляем оставшиеся интервалы
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        // Преобразуем список в массив и возвращаем
        return result.toArray(new int[result.size()][]);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4, 8};
        System.out.println(Arrays.deepToString(solution.insert(intervals, newInterval)));
    }
}