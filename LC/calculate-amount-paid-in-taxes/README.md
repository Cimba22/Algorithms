# 2303. Calculate Amount Paid in Taxes

`Array` `Simulation`

This project provides a solution to calculate the amount of tax paid based on different tax brackets and an individual's income. The solution is implemented in Java, and includes a main class `TaxCalculator` and a corresponding test class `TaxCalculatorTest` using JUnit.

## Problem Description

You are given a 2D integer array `brackets` where `brackets[i] = [upperi, percenti]` means that the `i`-th tax bracket has an upper bound of `upperi` and is taxed at a rate of `percenti`. The brackets are sorted by upper bound (`upperi-1 < upperi` for `0 < i < brackets.length`).

Tax is calculated as follows:
- The first `upper0` dollars earned are taxed at a rate of `percent0`.
- The next `upper1 - upper0` dollars earned are taxed at a rate of `percent1`.
- The next `upper2 - upper1` dollars earned are taxed at a rate of `percent2`.
- And so on.

Given an integer `income` representing the amount of money earned, the objective is to return the amount of money that has to be paid in taxes.

### Examples

1. **Example 1:**
    - Input: `brackets = [[3, 50], [7, 10], [12, 25]], income = 10`
    - Output: `2.65000`
    - Explanation:
        - Based on the income, you have 3 dollars in the 1st tax bracket (50%), 4 dollars in the 2nd tax bracket (10%), and 3 dollars in the 3rd tax bracket (25%).
        - Total tax paid = `3 * 50% + 4 * 10% + 3 * 25% = $2.65`.

2. **Example 2:**
    - Input: `brackets = [[1, 0], [4, 25], [5, 50]], income = 2`
    - Output: `0.25000`
    - Explanation:
        - Based on the income, you have 1 dollar in the 1st tax bracket (0%) and 1 dollar in the 2nd tax bracket (25%).
        - Total tax paid = `1 * 0% + 1 * 25% = $0.25`.

3. **Example 3:**
    - Input: `brackets = [[2, 50]], income = 0`
    - Output: `0.00000`
    - Explanation:
        - No income to tax, so total tax paid is $0.

## Solution


#### **Задача в двух словах**
Дан **прогрессивный налог** в виде границ дохода и соответствующих процентных ставок. Нужно вычислить **общую сумму налога** для заданного `income`.

---

### **Разбор кода**
```java
public double calculateTax(int[][] brackets, int income) {
    double totalTax = 0.0; // Общая сумма налога
    int previousUpper = 0; // Граница предыдущего налогового диапазона

    for (int[] bracket : brackets) {
        int upper = bracket[0];  // Верхняя граница текущего налогового диапазона
        int percent = bracket[1]; // Ставка налога для этого диапазона

        if (income > upper) {
            // Если доход превышает текущую верхнюю границу, считаем налог для полного диапазона
            int taxableIncome = upper - previousUpper;
            totalTax += (double) (taxableIncome * percent) / 100;
        } else {
            // Если доход меньше текущей верхней границы, считаем налог только для доступного дохода
            int taxableIncome = income - previousUpper;
            totalTax += (double) (taxableIncome * percent) / 100;
            break; // Все доход обработан, можно выйти из цикла
        }
        previousUpper = upper; // Обновляем границу для следующего диапазона
    }
    return totalTax;
}
```

---

### **Как работает алгоритм?**
1. **Проходим по налоговым диапазонам (`brackets`)**
   - `upper` — верхняя граница текущего диапазона.
   - `percent` — ставка налога для данного диапазона.

2. **Рассчитываем налог для каждого диапазона:**
   - Если **доход больше** верхней границы `upper`, то облагается налогом весь диапазон `upper - previousUpper`.
   - Если **доход меньше** текущей границы, налог вычисляется только для оставшегося дохода `income - previousUpper`, после чего вычисление заканчивается (`break`).

3. **Обновляем `previousUpper`, чтобы отслеживать начало следующего диапазона.**

---

### **Пример работы**
#### **Входные данные**
```java
brackets = [[10, 10], [20, 20], [30, 30]]
income = 25
```
- Налоговая шкала:
   - **До 10** → 10%
   - **От 10 до 20** → 20%
   - **От 20 до 30** → 30%

#### **Шаги вычисления**
1. **Первый диапазон** `(0 - 10)`:
   - `10 * 10% = 1.0`
2. **Второй диапазон** `(10 - 20)`:
   - `10 * 20% = 2.0`
3. **Третий диапазон** `(20 - 25)` (неполный, так как доход 25):
   - `5 * 30% = 1.5`
4. **Итого налог**:
   - `1.0 + 2.0 + 1.5 = 4.5`

**Ответ:** `4.5`

---

### **Сложность алгоритма**
- **Временная сложность**: `O(n)`, так как проходим по `brackets` **максимум один раз**.
- **Доп. память**: `O(1)`, так как используем **только переменные**.

---

### **Вывод**
Этот алгоритм **эффективно рассчитывает налог** по прогрессивной шкале, используя **последовательное суммирование** налога для каждого диапазона.
