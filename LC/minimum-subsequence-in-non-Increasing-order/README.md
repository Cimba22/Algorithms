# 1403. Minimum Subsequence in Non-Increasing Order
`Array` `Greedy` `Sorting`

Given the array nums, obtain a subsequence of the array whose sum of elements is strictly greater than the sum of the non-included elements in such subsequence.

If there are multiple solutions, return the subsequence with minimum size and if there still exist multiple solutions, return the subsequence with the maximum total sum of all its elements. A subsequence of an array can be obtained by erasing some (possibly zero) elements from the array.

Note that the solution with the given constraints is guaranteed to be unique. Also return the answer sorted in non-increasing order.



#### Example 1:
~~~
Input: nums = [4,3,10,9,8]
Output: [10,9]
Explanation: The subsequences [10,9] and [10,8] are minimal such that the sum of their elements is strictly greater than the sum of elements not included. However, the subsequence [10,9] has the maximum total sum of its elements.
~~~
#### Example 2:
~~~
Input: nums = [4,4,7,6,7]
Output: [7,7,6]
Explanation: The subsequence [7,7] has the sum of its elements equal to 14 which is not strictly greater than the sum of elements not included (14 = 4 + 4 + 6). Therefore, the subsequence [7,6,7] is the minimal satisfying the conditions. Note the subsequence has to be returned in non-decreasing order.
~~~


### Constraints:

`1 <= nums.length <= 500`

`1 <= nums[i] <= 100`

### Разбор решения `minSubsequence(int[] nums)`

#### **Задача**
Найти минимальную по размеру подпоследовательность массива `nums`, сумма элементов которой строго больше суммы оставшихся элементов.

---

### **Как работает код**
1. **Подсчет общей суммы массива**
   ```java
   int sum = 0, sumAns = 0;
   for (int num : nums) {
       sum += num;
   }
   ```
    - Переменная `sum` хранит сумму всех элементов массива.
    - Переменная `sumAns` будет накапливать сумму выбранной подпоследовательности.

2. **Сортировка массива в порядке возрастания**
   ```java
   Arrays.sort(nums);
   ```
    - Это позволит нам выбирать элементы с наибольшим значением в первую очередь (будем обходить массив с конца).

3. **Выбор элементов с конца массива (наибольших значений)**
   ```java
   for (int i = nums.length - 1; i >= 0; i--) {
       ans.add(nums[i]);
       sumAns += nums[i];
       if (sumAns > sum - sumAns) {
           return ans;
       }
   }
   ```
    - Начинаем добавлять числа с **конца массива** (то есть с самых больших значений).
    - `sumAns` увеличивается на добавленный элемент.
    - Если сумма `sumAns` **становится больше** оставшейся суммы `(sum - sumAns)`, мы нашли минимальную подпоследовательность и **возвращаем результат**.

---

### **Пример работы**
#### Входные данные:
```java
nums = [4,3,10,9,8]
```
#### Разбор работы алгоритма:
1. Подсчитаем сумму:
   ```
   sum = 4 + 3 + 10 + 9 + 8 = 34
   ```
2. Отсортируем массив:
   ```
   nums = [3, 4, 8, 9, 10]
   ```
3. Добавляем элементы с конца:
    - `ans = [10]`, `sumAns = 10`, `sum - sumAns = 24` (10 < 24) → продолжаем.
    - `ans = [10, 9]`, `sumAns = 19`, `sum - sumAns = 15` (19 > 15) → **готово!**

#### Итоговый результат:
```java
[10, 9]
```
---

### **Почему это решение эффективно?**
- **Сортировка** занимает `O(n log n)`.
- **Проход по массиву** — `O(n)`.
- **Общая сложность**: `O(n log n)`, что достаточно быстро для больших массивов.

👉 **Вывод:** Это жадный алгоритм, который быстро находит минимальную подпоследовательность, начиная с самых больших чисел.
