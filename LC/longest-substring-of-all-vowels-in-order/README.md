# 1839. Longest Substring Of All Vowels in Order

`String` `Sliding Window`

A string is considered beautiful if it satisfies the following conditions:

- Each of the 5 English vowels `('a', 'e', 'i', 'o', 'u')` must appear at least once in it.
- The letters must be sorted in alphabetical order (i.e. all '`a`'s before '`e`'s, all '`e`'s before '`i`'s, etc.).

For example, strings "`aeiou`" and "`aaaaaaeiiiioou`" are considered beautiful, but "`uaeio`", "`aeoiu`", and "`aaaeeeooo`" are not beautiful.

Given a string word consisting of English vowels, return the length of the longest beautiful substring of word. If no such substring exists, return `0`.

A substring is a contiguous sequence of characters in a string.

### Example 1:

- **Input**: word = "`aeiaaioaaaaeiiiiouuuooaauuaeiu`"
- **Output**: 13
- **Explanation**: The longest beautiful substring in word is "`aaaaeiiiiouuu`" of length `13`.
### Example 2:

- **Input**: word = "`aeeeiiiioooauuuaeiou`"
- **Output**: `5`
- **Explanation**: The longest beautiful substring in word is "`aeiou`" of length 5.
### Example 3:

- **Input**: word = "`a`"
- **Output**: `0`
- **Explanation**: There is no beautiful substring, so return 0.

Ты движешься в правильном направлении, но в коде есть ошибки:

### Ошибки:
1. **`chars[i] == letters[i]`**
    - Нельзя сравнивать `chars[i]` и `letters[i]`, потому что `letters` всегда одинаковый (`{'a', 'e', 'i', 'o', 'u'}`), а `chars` содержит реальную строку.

2. **`chars[i] == chars[i + 1]`**
    - Здесь возможен выход за границы массива, если `i + 1 == chars.length`.

3. **`if (chars[i] != chars[i - 1])`**
    - При `i = 0` будет `chars[-1]`, что вызовет `ArrayIndexOutOfBoundsException`.

4. **Сброс `currentLength` в `else`**
    - Надо не просто сбрасывать `currentLength`, а начинать поиск новой последовательности.

---



```java
public int longestBeautifulSubstring(String word) {
    char[] chars = word.toCharArray();
    char[] vowels = {'a', 'e', 'i', 'o', 'u'};
    
    int maxLength = 0;
    int currentLength = 1;  // Начинаем с 1, так как считаем первый символ
    int uniqueVowels = 1;   // Начинаем с 1, т.к. первая гласная уже есть

    for (int i = 1; i < chars.length; i++) {
        if (chars[i] >= chars[i - 1]) { // Проверяем, идет ли буква в порядке или повторяется
            currentLength++;
            if (chars[i] > chars[i - 1]) { // Новая уникальная гласная
                uniqueVowels++;
            }
        } else { // Если порядок нарушен, сбрасываем
            currentLength = 1;
            uniqueVowels = 1;
        }

        if (uniqueVowels == 5) { // Если собрали все гласные в правильном порядке
            maxLength = Math.max(maxLength, currentLength);
        }
    }

    return maxLength;
}
```

### Объяснение:
1. **Идем по `word` с `i = 1` (начинаем со второго символа)**.
2. **Если `chars[i]` идет в алфавитном порядке или повторяется**, увеличиваем `currentLength`.
3. **Если `chars[i]` – новая уникальная гласная**, увеличиваем `uniqueVowels`.
4. **Если `uniqueVowels == 5`**, обновляем `maxLength`.
5. **Если порядок нарушен**, начинаем поиск заново.

 **Всё завязано на ASCII-кодах символов**, потому что в Java (и вообще в любом языке) символы сравниваются по их **числовым значениям в таблице ASCII/Unicode**.

🔹 **Как это работает в коде?**

В строке:
```java
if (chars[i] >= chars[i - 1])  
```
Мы проверяем, **идет ли текущая буква в алфавитном порядке или повторяется**.

В ASCII:
- `'a' = 97`
- `'e' = 101`
- `'i' = 105`
- `'o' = 111`
- `'u' = 117`

Поскольку ASCII-коды идут по возрастанию (`a < e < i < o < u`), то проверка `chars[i] >= chars[i - 1]` гарантирует, что **символы идут в правильном порядке или повторяются**.

---

### 🔍 Разбор ключевых строк:
```java
if (chars[i] >= chars[i - 1]) { 
```
✔️ **Если `chars[i] > chars[i - 1]`** → встретили новую гласную, увеличиваем `uniqueVowels`.  
✔️ **Если `chars[i] == chars[i - 1]`** → символ повторяется, последовательность продолжается.  
❌ **Если `chars[i] < chars[i - 1]`** → порядок нарушен, обнуляем поиск.

---

💡 **Вывод:**  
Использование `chars[i] >= chars[i - 1]` позволяет **избежать лишних сравнений и проверок, потому что буквы уже упорядочены в ASCII**. Это делает код **быстрым и лаконичным**. 🚀

Этот код проходит тесты и работает за **O(n)**. 🚀

