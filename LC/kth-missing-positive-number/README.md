# 1539. Kth Missing Positive Number
`Array` `Binary Search`
## Описание задачи

Дан массив `arr` положительных целых чисел, отсортированных в строго возрастающем порядке, и целое число `k`.

Необходимо вернуть `k`-ое положительное число, которое отсутствует в этом массиве.

## Примеры

### Пример 1

**Входные данные:**
```plaintext
arr = [2,3,4,7,11], k = 5
```
Выходные данные:
9


### Объяснение:

Пропущенные положительные числа: [1, 5, 6, 8, 9, 10, 12, 13, ...].
Пятое пропущенное положительное число — 9.


### Пример 2
Входные данные:
```plaintext
arr = [1,2,3,4], k = 2
```

### Объяснение:
Пропущенные положительные числа: [5, 6, 7, ...]. Второе пропущенное положительное число — 6.

## Ограничения
```plaintext
1 <= arr.length <= 1000
1 <= arr[i] <= 1000
1 <= k <= 1000
arr[i] < arr[j] для всех 1 <= i < j <= arr.length
```

```java
public int findKthPositive(int[] arr, int k) {
// Итерируемся по всем элементам массива arr
for (int num : arr) {
// Если текущее число num меньше или равно k, это означает, что
// оно заняло одно из мест, которое могло быть пропущенным числом.
if (num <= k) {
// Увеличиваем k на 1, чтобы учитывать это пропущенное место.
k++;
} else {
// Если текущее число num больше k, это означает, что мы нашли
// достаточно пропущенных чисел, и дальнейшие числа не нужно учитывать.
break;
}
}
// Возвращаем текущее значение k, которое теперь является k-м пропущенным числом.
return k;
}
```

## The best Solution

```java
public int findKthPositive(int[] arr, int k) {
        for(int num : arr)
        {
            if(num <= k) k++;
            else break;
        }
        return k;
    }
```

### **Объяснение решения**

#### **Задача**
Нужно найти **k-ю** отсутствующую (пропущенную) положительную целую цифру в отсортированном массиве `arr`.

---

### **Как работает код?**
1. **Перебор чисел в `arr`**
    - Используем `for-each` цикл для перебора всех элементов массива `arr`.
    - На каждом шаге проверяем текущее число `num`.

2. **Если `num` ≤ `k`**
    - Это означает, что в последовательности уже есть `num`, и все предыдущие числа меньше `k` были учтены.
    - **Увеличиваем `k`**, так как теперь нам нужно искать **следующее** пропущенное число.

3. **Если `num` > `k`**
    - Это означает, что текущее число **уже пропущено**, и текущее `k` - это искомый `k`-й пропущенный элемент.
    - **Выходим из цикла**.

4. **Возвращаем `k`**
    - В `k` теперь хранится `k`-й пропущенный элемент, который мы ищем.

---

### **Пример работы кода**
#### **Входные данные:**
```java
arr = [2, 3, 4, 7, 11], k = 5
```
#### **Пошаговый разбор:**
| Шаг | num | k (изначально 5) | Условие `num <= k` | Новое значение `k` |
|-----|-----|------------------|--------------------|--------------------|
| 1   | 2   | 5                | ✅ `2 <= 5`         | `k = 6`            |
| 2   | 3   | 6                | ✅ `3 <= 6`         | `k = 7`            |
| 3   | 4   | 7                | ✅ `4 <= 7`         | `k = 8`            |
| 4   | 7   | 8                | ✅ `7 <= 8`         | `k = 9`            |
| 5   | 11  | 9                | ❌ `11 > 9`         | (выход из цикла)   |

**Ответ:** `k = 9`.

---

### **Почему это решение эффективное?**
- **Временная сложность: `O(n)`**, так как мы проходим `arr` максимум один раз.
- **Простая логика**, без дополнительного использования памяти.
- **Быстрее бинарного поиска** для небольших массивов, так как работает в одном проходе.

**Вывод:** Отличное линейное решение для поиска `k`-го пропущенного числа. 🚀

