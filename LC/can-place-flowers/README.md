# 605. Can Place Flowers
`Array` `Greedy`
## Problem Statement

You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

Given an integer array `flowerbed` containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer `n`, return `true` if `n` new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and `false` otherwise.

### Example 1:

- **Input:** flowerbed = [1,0,0,0,1], n = 1
- **Output:** true

### Example 2:

- **Input:** flowerbed = [1,0,0,0,1], n = 2
- **Output:** false

### Constraints:

- 1 <= flowerbed.length <= 2 * 10^4
- flowerbed[i] is 0 or 1.
- There are no two adjacent flowers in flowerbed.
- 0 <= n <= flowerbed.length

## Solution

To solve the problem of determining whether you can plant `n` new flowers in a flowerbed without violating the no-adjacent-flowers rule, we can iterate through the `flowerbed` array and check for available spots where flowers can be planted.

### Approach:

1. Iterate through each position in the `flowerbed` array.
2. Check if the current position and its neighboring positions (left and right) are empty (i.e., contain 0).
3. If an empty spot is found where a flower can be planted, plant the flower by setting the current position to 1 and decrement `n` by 1.
4. If at any point `n` becomes 0, return `true` since all flowers have been successfully planted.
5. After the iteration, if `n` is still greater than 0, return `false`.

### Code:

```java
public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int length = flowerbed.length;
        for (int i = 0; i < length; i++) {
            // Check if the current plot is empty and the left and right plots are empty or out of bounds
            if (flowerbed[i] == 0 && 
                (i == 0 || flowerbed[i - 1] == 0) && 
                (i == length - 1 || flowerbed[i + 1] == 0)) {
                // Plant a flower here
                flowerbed[i] = 1;
                n--;
                // If no more flowers need to be planted, return true
                if (n == 0) {
                    return true;
                }
            }
        }
        // If there are still flowers left to be planted, return false
        return n <= 0;
    }

    
}
```

## Better solution
```java
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int i = 0;
        while (i < flowerbed.length && n > 0) {
            if (flowerbed[i] == 1) {
                i += 2;
            } else if ((i == 0 || flowerbed[i - 1] == 0)
                    && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                n--;
                i += 2;
            } else {
                i++;
            }
        }

        return n == 0;

    }
```


---

### **Что делает этот код?**
Он проходит по массиву `flowerbed` и проверяет, можно ли посадить цветок в текущую позицию `i`, соблюдая правила (без соседних цветков).

---

### **Почему этот код лучше?**
1. **Оптимизированный шаг `i += 2`**
    - Если `flowerbed[i] == 1`, то следующий возможный пустой участок для посадки находится не в `i + 1`, а в `i + 2`, потому что цветы должны быть разнесены.
    - Таким образом, мы **пропускаем лишние проверки** на `i + 1`, если текущий элемент уже `1`.

2. **Проверка условий посадки в одной строке**
   ```java
   (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)
   ```
    - Учитывает случай, если `i` находится в начале (`i == 0`) или в конце массива (`i == flowerbed.length - 1`), без риска выхода за границы массива.
    - Проверяет, что **левый и правый соседи пустые**, что делает код **более читаемым и логичным**.

3. **Минимальное количество проверок**
    - В первой версии кода были избыточные проверки (`while (str.indexOf(ans) != 0)` в другом коде, аналогично).
    - Здесь, если `flowerbed[i] == 1`, мы **мгновенно пропускаем ненужные проверки** (`i += 2`).
    - Если цветок можно посадить, мы **сразу переходим на `i + 2`**, так как следующий `i + 1` уже занят.

4. **`n > 0` в `while`**
    - Этот дополнительный контроль позволяет **остановить цикл раньше**, как только посадили все `n` цветов. Это **ускоряет работу** на больших входных данных.

5. **Правильное сравнение `return n == 0;`**
    - Вместо `return n <= 0;`, здесь проверяется точное равенство `0`.
    - Хотя `<= 0` тоже работало бы, `n == 0` более точно выражает логику задачи.

---

### **Вывод**
✅ **Этот код лучше, чем предыдущий, потому что он эффективнее**:
- Он делает меньше итераций (`i += 2` вместо `i++` в некоторых случаях).
- Он использует **простую, но мощную проверку** условий посадки.
- Он **останавливается раньше**, если `n == 0`.

Это **оптимальное** решение с **O(n)** по времени и **O(1)** по памяти.