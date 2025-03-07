# 2582. Pass the Pillow

`Math` `Simulation`

This repository contains a solution to the problem of finding the index of the person holding the pillow after a given number of seconds, given `n` people standing in a line.

## Problem Description

There are `n` people standing in a line labeled from `1` to `n`. The first person in the line is holding a pillow initially. Every second, the person holding the pillow passes it to the next person standing in the line. Once the pillow reaches the end of the line, the direction changes, and people continue passing the pillow in the opposite direction.

For example, once the pillow reaches the `n`th person they pass it to the `n - 1`th person, then to the `n - 2`th person, and so on.

Given the two positive integers `n` and `time`, the task is to return the index of the person holding the pillow after `time` seconds.

## Examples

### Example 1

- **Input**: `n = 4, time = 5`
- **Output**: `2`
- **Explanation**: People pass the pillow in the following way: `1 -> 2 -> 3 -> 4 -> 3 -> 2`.
  After five seconds, the pillow is given to the 2nd person.

### Example 2

- **Input**: `n = 3, time = 2`
- **Output**: `3`
- **Explanation**: People pass the pillow in the following way: `1 -> 2 -> 3`.
  After two seconds, the pillow is given to the 3rd person.

## Solution

To solve this problem, we need to simulate the passing of the pillow for the given number of seconds. The steps to implement the solution are as follows:

1. Initialize the current position of the pillow holder to `1`.
2. Initialize the direction of passing (forward or backward).
3. Loop through each second, updating the position of the pillow holder and changing direction if necessary.
4. Return the final position of the pillow holder after the given time.

## Usage

To use this solution, you can call the function `find_pillow_holder(n, time)` with the appropriate values of `n` and `time`. The function will return the index of the person holding the pillow after the specified time.

```java
public class PillowPassingGame {

    public static int findPillowHolder(int n, int time) {
        int currentPosition = 1;
        int direction = 1; // 1 for forward, -1 for backward

        for (int i = 0; i < time; i++) {
            currentPosition += direction;

            if (currentPosition == n || currentPosition == 1) {
                direction *= -1;
            }
        }

        return currentPosition;
    }

    public static void main(String[] args) {
        // Example usage
        int n = 4;
        int time = 5;
        System.out.println(findPillowHolder(n, time)); // Output: 2

        n = 3;
        time = 2;
        System.out.println(findPillowHolder(n, time)); // Output: 3
    }
}
```


1. **Инициализация**:
  - `currentPosition = 1`: Начальная позиция подушки — это первый игрок (позиция 1).
  - `direction = 1`: Направление движения подушки. Значение 1 означает движение вперёд (к следующему игроку), а -1 — назад (к предыдущему игроку).

2. **Цикл по времени**:
  - Цикл `for` выполняется `time` раз, где на каждом шаге происходит передача подушки.
  - На каждой итерации `currentPosition += direction` изменяет текущую позицию подушки в зависимости от направления.

3. **Поворот направления**:
  - После каждого шага проверяется, не достигла ли подушка одной из крайних позиций (первого или последнего игрока). Это условие проверяется с помощью:
    - `if (currentPosition == n || currentPosition == 1)`.
  - Если подушка достигает одной из крайних позиций (первой или последней), направление меняется на противоположное: `direction *= -1`.

4. **Возврат результата**:
  - После завершения цикла возвращается текущая позиция подушки, которая будет равна `currentPosition`.

### Пример:
Если есть 5 игроков и подушка передаётся 7 раз:
- Начальная позиция — игрок 1.
- После 1-го шага — игрок 2.
- После 2-го шага — игрок 3.
- После 3-го шага — игрок 4.
- После 4-го шага — игрок 5 (подушка доходит до конца, и направление меняется).
- После 5-го шага — игрок 4 (подушка идёт назад).
- После 6-го шага — игрок 3.
- После 7-го шага — игрок 2 (передача завершена).

Таким образом, решение работает за время O(time), где `time` — количество шагов передачи подушки.