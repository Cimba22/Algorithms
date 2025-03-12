# 57. Insert Interval

`Array`

You are given an array of non-overlapping intervals `intervals` where `intervals[i] = [starti, endi]` represent the start and the end of the `ith` interval and intervals is sorted in ascending order by `starti`. You are also given an interval `newInterval = [start, end]` that represents the start and end of another interval.

Insert `newInterval` into `intervals` such that `intervals` is still sorted in ascending order by `starti` and `intervals` still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return `intervals` after the insertion.

Note that you don't need to modify `intervals` in-place. You can make a new array and return it.


---

### 🔹 **Алгоритм**:
1️⃣ **Пройти по всем интервалам**, добавляя те, что идут перед `newInterval`.  
2️⃣ **Объединить пересекающиеся интервалы** с `newInterval`.  
3️⃣ **Добавить оставшиеся интервалы**, которые идут после `newInterval`.  
4️⃣ **Вернуть итоговый список в виде массива**.

---

### ✅ **Код на Java**:
```java
import java.util.*;

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
}
```

---

### 🔍 **Как работает код?**
#### **Пример 1**
```plaintext
Вход: intervals = [[1,3],[6,9]], newInterval = [2,5]
1. Пропускаем [1,3], т.к. [1,3] и [2,5] пересекаются
2. Объединяем [1,3] и [2,5] → [1,5]
3. Добавляем оставшиеся интервалы
Выход: [[1,5],[6,9]]
```

#### **Пример 2**
```plaintext
Вход: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
1. Пропускаем [1,2] (не пересекается)
2. Объединяем [3,5], [6,7], [8,10] → [3,10]
3. Добавляем оставшиеся интервалы
Выход: [[1,2],[3,10],[12,16]]
```

---

### 🚀 **Сложность**
- **O(n)** – один проход по массиву.
- **O(n)** – используется список, но в худшем случае копируем все элементы.

Решение эффективное и простое! 😊