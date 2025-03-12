# 56. Merge Intervals

`Array` `Sorting`

Given an array of `intervals` where `intervals[i] = [starti, endi]`, merge all overlapping intervals, and _return an array of the non-overlapping intervals that cover all the intervals in the input._

### Example 1:

- **Input**: intervals = `[[1,3],[2,6],[8,10],[15,18]]`
- **Output**: `[[1,6],[8,10],[15,18]]`
- **Explanation**: Since intervals `[1,3]` and `[2,6]` overlap, merge them into `[1,6]`.
____
### Example 2:

- **Input**: intervals = `[[1,4],[4,5]]`
- **Output**: `[[1,5]]`
- **Explanation**: Intervals `[1,4]` and `[4,5]` are considered overlapping.


Этот код решает задачу **"Merge Intervals"** (Слияние интервалов).

## 🔹 **Суть задачи**
Дан массив интервалов `intervals[][]`, где каждый подмассив `[start, end]` представляет **отрезок**.  
Нужно **объединить пересекающиеся интервалы** и вернуть список непересекающихся интервалов.

📌 **Пример:**  
**Вход:** `[[1,3],[2,6],[8,10],[15,18]]`  
**Выход:** `[[1,6],[8,10],[15,18]]`

---

```java
public int[][] merge(int[][] intervals) {

        if (intervals.length <= 1) {
            return intervals;
        }

        // Сортируем интервалы по начальному значению
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (nextStart <= currentEnd) { // Есть пересечение
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else { // Нет пересечения, добавляем новый интервал
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
```

## 🔍 **Разбор кода**

### 1️⃣ **Обработка краевых случаев**
```java
if (intervals.length <= 1) {
    return intervals;
}
```
✔ Если в `intervals` **0 или 1 интервал**, его не нужно сливать — **возвращаем как есть**.

---

### 2️⃣ **Сортировка интервалов**
```java
Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
```
✔ **Сортируем интервалы по начальному значению (`a[0]`)**, чтобы удобнее было находить пересечения.

---

### 3️⃣ **Обход всех интервалов и их слияние**
```java
List<int[]> merged = new ArrayList<>();
int[] currentInterval = intervals[0];
merged.add(currentInterval);
```
✔ Создаем **список объединенных интервалов**.  
✔ **Берем первый интервал** как начальный.

---

### 4️⃣ **Обход и объединение**
```java
for (int[] interval : intervals) {
    int currentEnd = currentInterval[1];
    int nextStart = interval[0];
    int nextEnd = interval[1];

    if (nextStart <= currentEnd) { // Есть пересечение
        currentInterval[1] = Math.max(currentEnd, nextEnd);
    } else { // Нет пересечения
        currentInterval = interval;
        merged.add(currentInterval);
    }
}
```
🔹 **Идея:**
- **Если начало следующего интервала (`nextStart`) меньше или равно концу текущего (`currentEnd`)**, значит, интервалы **пересекаются** → объединяем, обновляя `end`.
- **Если пересечения нет**, добавляем новый интервал в список `merged`.

---

### 5️⃣ **Преобразование списка в массив**
```java
return merged.toArray(new int[merged.size()][]);
```
✔ Преобразуем `ArrayList<int[]>` в `int[][]`, потому что **метод должен вернуть массив**.

---

## 🔥 **Алгоритм и сложность**
1. **Сортировка:** `O(n log n)`
2. **Одно проходное объединение:** `O(n)`  
   **Итоговая сложность:** **`O(n log n)`** (из-за сортировки).

### 🏆 **Вывод:**
Этот алгоритм эффективно решает задачу за **O(n log n)**, используя сортировку + один проход. 🚀

