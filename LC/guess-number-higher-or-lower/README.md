## 374. Guess Number Higher or Lower
`Binary Search` `Interactive`

We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.

You call a pre-defined API int guess(int num), which returns three possible results:

- -1: Your guess is higher than the number I picked (i.e. num > pick).
- 1: Your guess is lower than the number I picked (i.e. num < pick).
- 0: your guess is equal to the number I picked (i.e. num == pick).

Return the number that I picked.

**Example 1:**
```
Input: n = 10, pick = 6
Output: 6
```
**Example 2:**
~~~
Input: n = 1, pick = 1
Output: 1
~~~

**Example 3:**
~~~
Input: n = 2, pick = 1
Output: 1
~~~

**Constraints:**

-` 1 <= n <= 231 - 1`
-` 1 <= pick <= n`


### **🔍 Разбор решения задачи "Guess Number Higher or Lower"**

---

### **📌 Условие задачи**
Существует загаданный номер `pick` в диапазоне `[1, n]`. Ваша задача — угадать его, используя функцию `guess(int num)`, которая:
- Возвращает `-1`, если `num` больше `pick`
- Возвращает `1`, если `num` меньше `pick`
- Возвращает `0`, если `num` **совпадает** с `pick`

---

### **🛠 Разбор кода**
```java
public class Solution extends GuessGame { 
    public int guessNumber(int n) { // Метод принимает верхнюю границу числа
        
        int l = 1, r = n, mid; // Устанавливаем границы: 1 (минимум) и n (максимум)

        while (l <= r) { // Пока диапазон не сузился до одного числа

            mid = l + (r - l) / 2; // Находим середину диапазона, избегая переполнения

            if (guess(mid) == 0) return mid; // Угадали число — возвращаем его
            else if (guess(mid) == 1) l = mid + 1; // Загаданное число больше — сдвигаем левую границу
            else r = mid - 1; // Загаданное число меньше — сдвигаем правую границу
        }

        return -1; // Не найдено (теоретически, в условии всегда есть загаданное число)
    }
}
```

---

### **🔢 Как работает алгоритм?**
Алгоритм использует **бинарный (двоичный) поиск**, который быстро сокращает диапазон поиска.

#### **Пример 1**
Загадано число `pick = 6`, диапазон `[1, 10]`:  

| Итерация | l | r  | mid | guess(mid) | Действие   |
|----------|---|----|-----|------------|------------|
| 1        | 1 | 10 | 5   | 1          | `l = 6`    |
| 2        | 6 | 10 | 8   | -1         | `r = 7`    |
| 3        | 6 | 7  | 6   | 0          | `return 6` |

Число найдено за **3 шага**!

---

### **🚀 Почему это решение эффективное?**
✔ **Использует бинарный поиск**, который имеет сложность **O(log n)** (намного быстрее, чем линейный перебор O(n)).  
✔ **Избегает переполнения** `int`, используя формулу `mid = l + (r - l) / 2` вместо `(l + r) / 2`.  
✔ **Простая реализация**, легко читаемая и понятная.

---

### **⏳ Сложность алгоритма**
- **Лучший случай**: O(1) (если `mid` сразу совпал с `pick`).
- **Худший случай**: O(log n) (если нужно много итераций).

Бинарный поиск — один из **наиболее эффективных алгоритмов** для таких задач! 🚀


