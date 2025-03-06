
# 898. Bitwise ORs of Subarrays
`Medium` `Array`
`Dynamic Programming`
`Bit Manipulation`

Given an integer array arr, return the number of distinct bitwise ORs of all the non-empty subarrays of arr.

The bitwise OR of a subarray is the bitwise OR of each integer in the subarray. The bitwise OR of a subarray of one integer is that integer.

A subarray is a contiguous non-empty sequence of elements within an array.



### Example 1:

**Input**: `arr = [0]`

**Output**: `1`

**Explanation**: There is only one possible result: `0`.
____

### Example 2:

**Input**: `arr = [1,1,2]`

**Output**: `3`

**Explanation**: The possible subarrays are `[1], [1], [2], [1, 1], [1, 2], [1, 1, 2]`.

These yield the results `1, 1, 2, 1, 3, 3`.

There are 3 unique values, so the answer is 3.
____

### Example 3:

**Input**: `arr = [1,2,4]`

**Output**: `6`

**Explanation**: The possible results are `1, 2, 3, 4, 6, and 7.`


### Constraints:

`1 <= arr.length <= 5 * 104`

`0 <= arr[i] <= 10^9`
____

Этот метод `subarrayBitwiseORs(int[] arr)` решает задачу нахождения количества различных значений, которые можно получить при выполнении побитовой операции `OR (|)` на всех возможных подмассивах массива arr.

```java
public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> uniqueResults = new HashSet<>();
        Set<Integer> currentResults = new HashSet<>();

        for (int num : arr) {
            Set<Integer> newResults = new HashSet<>();
            newResults.add(num);

            for (int current : currentResults) {
                newResults.add(num | current);
            }
            uniqueResults.addAll(currentResults = newResults);
        }
        return uniqueResults.size();
    }
```

### Better solution:
```java
class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> curr = null;
        Set<Integer> prev = new HashSet<>();
        Set<Integer> uniqs = new HashSet<>();
        for(int x : arr){
            curr = new HashSet<>();
            prev.add(0);
            for(int y : prev){
                curr.add(y | x);
                uniqs.add(y | x);
            }
            prev = curr;
        }
        return uniqs.size();
    }
}
```

## Разбор кода
### 1️⃣ Переменные
- `uniqueResults`: `Set<Integer>` — множество для хранения всех уникальных значений, полученных при OR операций.
- `currentResults`: `Set<Integer>` — множество значений, полученных на текущей итерации (из возможных подмассивов, заканчивающихся на num).
### 2️⃣ Основной цикл
Цикл проходит по каждому числу `num` в массиве `arr`:

- Создается newResults, куда сразу добавляется num, т.к. он сам по себе является подмассивом длины 1.

- Обновляется newResults: для всех значений в currentResults (которые представляют подмассивы, заканчивающиеся на предыдущем элементе), выполняется операция OR с num.

    - Это означает, что OR выполняется не только между отдельными элементами, но и между последовательными группами элементов.
- Обновляются множества:

    - `currentResults` = `newResults`, то есть теперь currentResults хранит возможные OR результаты для всех подмассивов, заканчивающихся на num.
    - `uniqueResults.addAll(currentResults)`, чтобы сохранить все уникальные значения.
### 3️⃣ Возвращается размер uniqueResults
Этот размер указывает, сколько различных значений получилось.




## 🔹 Сложность
- В худшем случае количество уникальных `OR` значений ≈ `O(n log M)`, где `M` — максимальный элемент в `arr` (числа в arr могут давать максимум log M уникальных значений).
- Память `O(n log M)` из-за хранения множества уникальных значений.
### Ключевые моменты
- ✔ Используется `Set` для хранения уникальных значений.
- ✔ Каждый новый элемент `OR`-ится со всеми значениями из предыдущих шагов.
- ✔ Это эффективно отслеживает все возможные подмассивы.

## 🔹 Почему OR полезен в этой задаче?
- Он накапливает установленные (1) биты.
- Каждый раз, когда добавляется новый элемент num, он OR-ится со всеми ранее полученными значениями, создавая новые уникальные результаты.
- В отличие от сложения или умножения, операция OR не уменьшает число битов, а только добавляет 1, если возможно.