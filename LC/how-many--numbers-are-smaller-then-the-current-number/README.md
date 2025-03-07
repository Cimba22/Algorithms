# 1365. How Many Numbers Are Smaller Than the Current Number

`Array` `Hash Table` `Sorting` `Counting Sort`

## Problem Description
Given the array `nums`, for each `nums[i]` find out how many numbers in the array are smaller than it. That is, for each `nums[i]` you have to count the number of valid `j`'s such that `j != i` and `nums[j] < nums[i]`.

Return the answer in an array.

### Example 1:
**Input:** nums = [8,1,2,2,3]  
**Output:** [4,0,1,1,3]  
**Explanation:**  
For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).  
For nums[1]=1 does not exist any smaller number than it.  
For nums[2]=2 there exists one smaller number than it (1).  
For nums[3]=2 there exists one smaller number than it (1).  
For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).

### Example 2:
**Input:** nums = [6,5,4,8]  
**Output:** [2,1,0,3]

### Example 3:
**Input:** nums = [7,7,7,7]  
**Output:** [0,0,0,0]

### Constraints:
- 2 <= nums.length <= 500
- 0 <= nums[i] <= 100

## Solution 1: Brute Force Approach
```java
public int[] smallerNumbersThanCurrent(int[] nums) {
    int[] res = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
        int count = 0;
        for (int num : nums) {
            if (nums[i] > num) {
                count++;
            }
        }
        res[i] = count;
    }
    return res;
}
```

### Explanation:
- Create an array res to store the results.
- For each element in nums, initialize a counter to zero.
- Compare the current element with every other element in the array.
- If the current element is greater than another element, increment the counter.
- Assign the counter value to the corresponding position in the res array.
- Return the res array.


## Solution 2: Optimized Approach using Counting Sort
```java
public int[] smallerNumbersThanCurrent(int[] nums) {
    int[] buckets = new int[101];

    for (int num : nums) {
        buckets[num]++;
    }

    for(int i = 1; i < buckets.length; i++) {
        buckets[i] += buckets[i - 1];
    }

    int[] result = new int[nums.length];
    for(int i = 0; i < result.length; i++) {
        if(nums[i] == 0) {
            result[i] = 0;
        } else {
            result[i] = buckets[nums[i] - 1];
        }
    }
    return result;
}
```

### **Разбор решения "Smaller Numbers Than Current"**

**Задача:**  
Для каждого элемента массива `nums[i]` определить, сколько чисел в массиве меньше него.

---

### **1. Используем частотный массив (`buckets`)**
```java
int[] buckets = new int[101];
```
- Создаём массив `buckets` размером `101`, так как числа в `nums` находятся в диапазоне `[0, 100]`.
- В `buckets[i]` будет храниться количество вхождений числа `i` в `nums`.

---

### **2. Заполняем частотный массив**
```java
for (int num : nums) {
    buckets[num]++;
}
```
- Для каждого числа `num` в `nums` увеличиваем соответствующий индекс в `buckets`.
- В результате `buckets[i]` содержит количество раз, сколько число `i` встречается в `nums`.

---

### **3. Преобразуем `buckets` в массив кумулятивных сумм**
```java
for (int i = 1; i < buckets.length; i++) {
    buckets[i] += buckets[i - 1];
}
```
- Теперь `buckets[i]` хранит **количество чисел ≤ `i`**.
- Это достигается за счёт сложения предыдущих значений:
    - `buckets[2] = buckets[2] + buckets[1]`
    - `buckets[3] = buckets[3] + buckets[2]`
    - … и так далее.

---

### **4. Заполняем результат**
```java
int[] result = new int[nums.length];
for (int i = 0; i < result.length; i++) {
    if (nums[i] == 0) {
        result[i] = 0;
    } else {
        result[i] = buckets[nums[i] - 1];
    }
}
```
- Если `nums[i] == 0`, то **меньших чисел нет**, записываем `0`.
- В противном случае, `buckets[nums[i] - 1]` содержит количество чисел **меньше** `nums[i]`.

---

### **Пример работы**
**Вход:** `nums = [8, 1, 2, 2, 3]`
1. **Шаг 1: Частотный массив (`buckets`) после первого прохода**
   ```
   buckets = [0,1,2,1,0,0,0,0,1,...] // (Пропущены нули)
   ```
2. **Шаг 2: Кумулятивная сумма**
   ```
   buckets = [0,1,3,4,4,4,4,4,5,...]
   ```
3. **Шаг 3: Определяем результат**
   ```
   result = [4,0,1,1,3] // (Сколько чисел меньше каждого из nums[i])
   ```

---

### **Сложность алгоритма**
- **Подсчёт частот:** `O(N)`
- **Вычисление кумулятивной суммы:** `O(101) ≈ O(1)`
- **Формирование ответа:** `O(N)`

**Общая сложность:** `O(N)`, что быстрее, чем `O(N²)` наивного решения с двумя циклами.

---

### **Почему это решение лучше?**
- **Не требует сортировки** (`O(N log N)`), вместо этого использует **частотный массив** (`O(N)`).
- **Эффективно для больших `nums`**, так как диапазон значений ограничен `[0, 100]`.
- **Простая реализация**, легко читается и понимается.

🔹 **Вывод:** Решение оптимальное и эффективно использует частотный массив! 🚀