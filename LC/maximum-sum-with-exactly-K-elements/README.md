# 2656. Maximum Sum With Exactly K Elements

`Array` `Greedy`

You are given a `0-indexed` integer array nums and an integer `k`. Your task is to perform the following operation exactly `k` times in order to maximize your score:

Select an element `m` from `nums`.
Remove the selected element `m` from the array.
Add a new element with a value of ``m` + 1 `to the array.
Increase your score by `m`.
Return the maximum score you can achieve after performing the operation exactly `k` times.



### Example 1:

- **Input**: nums = [1,2,3,4,5], k = 3
- **Output**: 18
- **Explanation**: We need to choose exactly 3 elements from nums to maximize the sum.

      - For the first iteration, we choose 5. Then sum is 5 and nums = [1,2,3,4,6]
      - For the second iteration, we choose 6. Then sum is 5 + 6 and nums = [1,2,3,4,7]
      - For the third iteration, we choose 7. Then sum is 5 + 6 + 7 = 18 and nums = [1,2,3,4,8]
      - So, we will return 18.
It can be proven, that 18 is the maximum answer that we can achieve.
___
### Example 2:

- **Input**: nums = `[5,5,5]`, k = `2`
- **Output**: `11`
- **Explanation**: We need to choose exactly 2 elements from nums to maximize the sum.

For the first iteration, we choose 5. Then sum is 5 and nums = `[5,5,6]`

For the second iteration, we choose 6. Then sum is 5 + 6 = 11 and nums = `[5,5,7]`

So, we will return `11`.

It can be proven, that `11` is the maximum answer that we can achieve.


### Constraints:

`1 <= nums.length <= 100`

`1 <= nums[i] <= 100`

`1 <= k <= 100`

### **Разбор решения задачи "Максимизация суммы"**

#### **Задача в двух словах**
Нужно выбрать **наибольшее число** в массиве `nums` и **увеличивать его `k` раз**, каждый раз прибавляя его текущее значение к сумме.

---

### **Разбор кода**
```java
public int maximizeSum(int[] nums, int k) {
    int max = Integer.MIN_VALUE;

    // Находим максимальное число в массиве
    for (int num : nums) {
        if (max < num) {
            max = num;
        }
    }

    int sum = 0;
    // Увеличиваем max k раз, суммируя его значения
    for (int i = 0; i < k; i++) {
        sum += max++;
    }
    return sum;
}
```

---

### **Как работает алгоритм?**
1. **Находим максимум в `nums`**
      - Переменная `max` инициализируется минимально возможным значением `Integer.MIN_VALUE`.
      - Проходим по массиву и обновляем `max`, если находим число больше.

2. **Максимизируем сумму**
      - В цикле `k` раз добавляем `max` к `sum`, **увеличивая `max` на 1** после каждой итерации.

---

### **Пример работы**
```java
nums = [1, 3, 5, 2]
k = 3
```
- Максимальный элемент: **`5`**
- Считаем сумму:

  - **1-й шаг:** `sum = 5`, `max = 6`
  - **2-й шаг:** `sum = 5 + 6 = 11`, `max = 7`
  - **3-й шаг:** `sum = 11 + 7 = 18`, `max = 8`
- **Ответ:** `18`

---

### **Сложность алгоритма**
- **Временная сложность**: `O(n + k)`, где `n` — длина массива, `k` — количество увеличений.
  - `O(n)` — поиск максимального элемента.
  - `O(k)` — суммирование `k` раз.
- **Доп. память**: `O(1)`, так как используем **только несколько переменных**.

---

