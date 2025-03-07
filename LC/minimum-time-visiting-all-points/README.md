# 1266. Minimum Time Visiting All Points
`Array` `Math` `Geometry`

On a 2D plane, there are `n` points with integer coordinates `points[i] = [xi, yi].` 
Return the minimum time in seconds to visit all the points in the order given by `points`.

You can move according to these rules:

- In 1 second, you can either:
    - move vertically by one unit,
    - move horizontally by one unit, or
    - move diagonally sqrt(2) units (in other words, move one unit vertically then one unit horizontally in 1 second).
- You have to visit the points in the same order as they appear in the array.
- You are allowed to pass through points that appear later in the order, but these do not count as visits.
____
- **Input**: points = `[[1,1],[3,4],[-1,0]]`
- **Output**: 7
- **Explanation**: One optimal path is `[1,1] -> [2,2] -> [3,3] -> [3,4] -> [2,3] -> [1,2] -> [0,1] -> [-1,0]   `
Time from `[1,1]` to` [3,4]` = 3 seconds
Time from `[3,4]` to `[-1,0]` = 4 seconds
Total time = 7 seconds
____
### Example 2:

- **Input**: points = `[[3,2],[-2,2]]`
- **Output**: 5

## Решение
```java
    for (int i = 1; i < points.length; i++) {
    int dx = Math.abs(points[i][0] - points[i - 1][0]); // Разница по X
    int dy = Math.abs(points[i][1] - points[i - 1][1]); // Разница по Y
    totalTime += Math.max(dx, dy); // Формула Чебышева
    }

```

### Объяснение решения
- **Плюсы**:
    Это простой, понятный и компактный код, который сразу вычисляет Math.max(dx, dy), не вызывая дополнительных функций.
    Использует O(n) времени, так как проходит по массиву всего один раз.
- **Минусы**:
  Нет выделенной функции distance(), что может затруднить читаемость при желании использовать логику повторно в других местах.


---

## Оптимальное решение
```java
class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int n = points.length;
        int sum  = 0;

        if (n <= 1) {
            return 0;
        }

        for (int i = 1; i < n; i++) {
            sum += distance(points[i - 1], points[i]); 
        }

        return sum;
    }

    private int distance(int[] start, int[] destination) {
        int xDiff = Math.abs(start[0] - destination[0]);
        int yDiff = Math.abs(start[1] - destination[1]);
        return Math.max(xDiff, yDiff);
    }
}
```

### В чем разница и почему это решение быстрее?
#### Возможные причины разницы в скорости:
1. **Inlining (встраивание функций)**

- JIT (Just-In-Time) компилятор Java может автоматически встроить метод distance() в основную функцию, убирая накладные расходы на вызов метода.
- Это приводит к тому, что второй код выполняется почти так же, как первый, но без лишних временных затрат.
2. **Разные структуры цикла**

- В первом коде используется `Math.max(dx, dy)` внутри цикла.
- Во втором коде аналогичная операция выполняется внутри `distance()`, но JVM может эффективнее оптимизировать этот вызов за счет предсказания ветвлений (branch prediction).
3. **Кэширование данных**

- Возможно, во втором коде данные кэшируются лучше из-за разделения вычислений на две функции.
- Процессор может загружать их в регистры и быстрее обрабатывать.
4. **JVM оптимизирует `if` внутри метода `distance()`**

- В методе `distance()` используется `xDiff < yDiff ? yDiff : xDiff`, что эквивалентно Math.max(), но может быть оптимизировано JVM более эффективно.
#### Вывод:
✅ Разница в скорости незначительна, но второй код потенциально получает больше оптимизаций от JVM, особенно за счет inlining.