# 17. Letter Combinations of a Phone Number

`Medium` `Hash Table` `String` `Backtracking`

Given a string containing digits from `2-9` inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

### Example 1:

- **Input**: `digits` = "23"
- **Output**: `["ad","ae","af","bd","be","bf","cd","ce","cf"]`
___
### Example 2:

- **Input**: `digits` = ""
- **Output**: `[]`

____
### Example 3:

- **Input**: `digits` = "2"
- **Output**: `["a","b","c"]`

**Constraints**:

- `0 <= digits.length <= 4`
- `digits[i]` is a digit in the range `['2', '9']`.


## 🔹 Разбор кода
### 1️⃣ Основная функция (letterCombinations)
```java
public List<String> letterCombinations(String digits) {
    String[] l = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res = new ArrayList<>();
    if(digits.length() == 0) return res;
    helper(l, digits, 0, new StringBuilder(), res);
    return res;
}
```

- Проверяем, если строка `digits` пуста — сразу возвращаем `res`.
- Вызываем рекурсивную функцию `helper`, передавая:
    
    - `l` — массив соответствий букв.
    - `digits` — введенные цифры.
    - `0` — начальная позиция в digits.
    - `new StringBuilder()` — пустой билдер для текущего слова.
    - `res` — список результатов.

### 2️⃣ Рекурсивная функция helper
```java
private void helper(String[] l, String digit, int i, StringBuilder str, List<String> res) {
    if (i == digit.length()) {
        res.add(str.toString());
        return;
    }
    int index = Character.getNumericValue(digit.charAt(i)); 
    for (int h = 0; h < l[index].length(); h++) {
        str.append(l[index].charAt(h));   // Добавляем букву
        helper(l, digit, i + 1, str, res); // Рекурсивный вызов
        str.deleteCharAt(str.length() - 1); // Удаляем последнюю букву перед возвратом
    }
}
```

- **Базовый случай**: если индекс `i` достиг конца строки `digits`, добавляем `str` в `res` и возвращаемся.
- Получаем текущий символ `digits.charAt(i)`, находим его числовое значение `index`.
- Проходим по всем буквам `l[index]` (например, "`abc`" для `2`).
- Добавляем букву, рекурсивно вызываем `helper(...)`, затем удаляем букву, возвращаясь к предыдущему состоянию.


## 🔹 Почему это быстрее и эффективнее?
### 1️⃣ Меньше затрат по памяти
- Итеративное решение каждый раз создает новый список `(O(N * 3^N))`.
- В этом коде используется `StringBuilder (O(N))`, который изменяется внутри рекурсивного вызова, а не копируется.
### 2️⃣ Отсутствие ненужных операций
- В предыдущем коде создавались новые массивы на каждом шаге `(combine(...))`.
- Здесь мы пошагово изменяем один объект, избегая дополнительных вычислений.
### 3️⃣ Более естественный Backtracking
- Использование удаления последнего символа `str.deleteCharAt(...)` помогает перебрать все комбинации, сохраняя предыдущее состояние.
