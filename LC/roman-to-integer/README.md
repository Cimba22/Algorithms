# 13. Roman to Integer
- Roman numerals are represented by seven different symbols: `I`, `V`, `X`, `L`, `C`, `D` and `M`.

```
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
```

For example, `2` is written as `II` in Roman numeral, just two ones added together. `12` is written as `XII`, which is simply `X + II`. The number `27` is written as `XXVII`, which is `XX + V + II`.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not `IIII`. Instead, the number four is written as `IV`. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as `IX`. There are six instances where subtraction is used:

- `I` can be placed before `V (5)` and `X (10)` to make `4` and `9`.
- `X` can be placed before `L (50)` and `C (100)` to make `40` and `90`.
- `C` can be placed before `D (500)` and `M (1000)` to make `400` and `900`.
- Given a roman numeral, convert it to an integer.

### Example 1:

- **Input**: s = "`III`"
- **Output**: 3
- **Explanation**: `III` = 3.
_____
### Example 2:

- **Input**: s = "`LVIII`"
- **Output**: 58
- **Explanation**: `L` = 50, `V`= 5, `III` = 3.
_____
### Example 3:

- **Input**: s = "`MCMXCIV`"
- **Output**: 1994
- **Explanation**: `M` = 1000, `CM` = 900, `XC` = 90 and `IV` = 4.


### Constraints:

`1 <= s.length <= 15`
`s` contains only the characters `('I', 'V', 'X', 'L', 'C', 'D', 'M')`.
It is **guaranteed** that s is a valid roman numeral in the range `[1, 3999]`.


### **Разбор решения для преобразования римского числа в целое (`romanToInt`)**

#### **Идея решения**
Метод принимает строку `s`, представляющую римское число, и конвертирует его в целое число. Алгоритм идет **справа налево**, складывая значения символов, но вычитая их, если встречается правило вычитания (например, `IX = 9`, потому что `I` перед `X` уменьшает его значение).

---

### **Подробное объяснение кода**
```java
public int romanToInt(String s) {
    int ans = 0, num = 0;
```
- `ans` — итоговый результат.
- `num` — значение текущего римского символа.

---

### **Обход строки справа налево**
```java
for (int i = s.length() - 1; i >= 0; i--) {
```
- Мы идем **с конца строки в начало** (в отличие от стандартного подхода, где обрабатывают слева направо).
- Это позволяет корректно учитывать вычитание (`IV = 4`, `IX = 9`), так как при встрече меньшего числа перед большим мы его **вычитаем**.

---

### **Определение числового значения римского символа**
```java
num = switch (s.charAt(i)) {
    case 'I' -> 1;
    case 'V' -> 5;
    case 'X' -> 10;
    case 'L' -> 50;
    case 'C' -> 100;
    case 'D' -> 500;
    case 'M' -> 1000;
    default -> num;
};
```
- `switch` находит числовое значение текущего символа.
- `default -> num;` — оставляет `num` без изменений в случае ошибки (хотя по условиям задачи этого не должно быть).

---

### **Правило вычитания**
```java
if (4 * num < ans) ans -= num;
else ans += num;
```
Здесь ключевой момент алгоритма:
- Если `4 * num < ans`, то это означает, что `num` — часть **вычитательной пары** (например, `IV`, `IX`, `XC`).
- Например, если мы уже добавили `10` (`X`), а сейчас встречаем `I`, то `I` должно быть **вычтено**.
- В противном случае число просто прибавляется.

Пример:
- `XIV` (14):
    - `V = 5`, `ans = 5`
    - `I = 1`, `4 * 1 < 5`, значит, **вычитаем** → `ans = 4`
    - `X = 10`, прибавляем → `ans = 14`

---

### **Возвращаем итог**
```java
return ans;
```
В `ans` хранится итоговый результат.

---

### **Преимущества решения**
1. **Проход только один раз** (`O(n)`) — нет необходимости использовать дополнительные структуры данных.
2. **Простая логика с обработкой вычитаний** — не нужны вспомогательные проверки, все учитывается через `if (4 * num < ans)`.
3. **Использует `switch` в стиле Java 14+** — он более компактный и читабельный.

---

### **Примеры работы**
#### **Пример 1**
```java
Input: "MCMXCIV"
Output: 1994
```
Разбор:
- `'V' = 5`, `ans = 5`
- `'I' = 1`, `4 * 1 < 5` → вычитаем → `ans = 4`
- `'C' = 100`, `ans = 104`
- `'X' = 10`, `4 * 10 < 104` → вычитаем → `ans = 94`
- `'M' = 1000`, `ans = 1094`
- `'C' = 100`, `4 * 100 < 1094` → вычитаем → `ans = 994`
- `'M' = 1000`, `ans = 1994`

#### **Пример 2**
```java
Input: "LVIII"
Output: 58
```
Разбор:
- `'I' = 1`, `ans = 1`
- `'I' = 1`, `ans = 2`
- `'I' = 1`, `ans = 3`
- `'V' = 5`, `ans = 8`
- `'L' = 50`, `ans = 58`

---

### **Почему умножаем на 4?**
Мы проверяем условие:

\[
4 x num < ans
\]

Что оно означает?
- `num` — текущее число (значение римской цифры).
- `ans` — текущая сумма римского числа, собранная справа налево.

Если `num` **меньше четверти уже набранного значения**, значит, это **вычитаемый символ**, и мы его вычитаем.

---

### **Как это связано с правилом повторения символов?**
- В римской системе **нельзя писать одну и ту же букву 4 раза подряд**.
- Вместо `IIII` пишут `IV`, вместо `XXXX` — `XL`, вместо `CCCC` — `CD` и так далее.
- Это значит, что **минимальный множитель для вычитания — это 1/4 от следующего числа**.
- Например, если в числе `MCMXCIV` встречается `C` перед `M`, мы понимаем, что `C = 100`, а `M = 1000`, и `100 < 1000 / 4`, значит, `C` вычитаем.

---

### **Примеры в числах**
1️⃣ `IX = 9`:
- `X = 10`, `I = 1`,
- `1 < 10 / 4` → значит, `I` вычитаем.

2️⃣ `CM = 900`:
- `M = 1000`, `C = 100`,
- `100 < 1000 / 4` → `C` вычитаем.

3️⃣ `IV = 4`:
- `V = 5`, `I = 1`,
- `1 < 5 / 4` → `I` вычитаем.

---

### **Вывод**
✔ **Умножаем на 4, потому что в римской системе числа перед большим числом — это "обход" запрета на повторение 4 раз подряд.**  
✔ **Это универсальное условие, которое работает для всех римских чисел.**

