# 15. 3Sum
`Array` `Two Pointers` `Sorting`

Given an integer array nums, return all the triplets `[nums[i], nums[j], nums[k]]` such that `i != j`, `i != k`, and `j != k`, and `nums[i] + nums[j] + nums[k] == 0`.

_Notice that the solution set must not contain duplicate triplets._

### Example 1:

- **Input**: nums = `[-1,0,1,2,-1,-4]`
- **Output**: `[[-1,-1,2],[-1,0,1]]`
- **Explanation**:

`nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.`

`nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.`

`nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.`

The distinct triplets are `[-1,0,1]` and `[-1,-1,2]`.
Notice that the order of the output and the order of the triplets does not matter.

____

### Example 2:

- **Input**: nums = `[0,1,1]`
- **Output**: `[]`
- **Explanation**: The only possible triplet does not sum up to 0.
___

### Example 3:

- **Input**: nums = `[0,0,0]`
- **Output**: `[[0,0,0]]`
- **Explanation**: The only possible triplet sums up to 0.


## Solution
```java
public static List<List<Integer>> threeSum(int[] nums) {
    int target = 0;
    Arrays.sort(nums); // O(n log n) - сортируем массив
    Set<List<Integer>> s = new HashSet<>(); // Set нужен, чтобы избежать дубликатов

    for (int i = 0; i < nums.length; i++) {  // O(n)
        int j = i + 1;       // Левый указатель
        int k = nums.length - 1; // Правый указатель

        while (j < k) {  // O(n) -> итерации идут пока указатели не встретятся
            int sum = nums[i] + nums[j] + nums[k];

            if (sum == target) {  // Если сумма равна 0 — нашли тройку
                s.add(Arrays.asList(nums[i], nums[j], nums[k]));
                j++;  // Двигаем оба указателя, чтобы избежать дубликатов
                k--;
            } else if (sum < target) {
                j++; // Если сумма меньше 0, увеличиваем `j`
            } else {
                k--; // Если сумма больше 0, уменьшаем `k`
            }
        }
    }

    return new ArrayList<>(s); // Переводим Set в List
}
```

## Разбор кода по шагам
### Шаг 1: Сортировка
```java
Arrays.sort(nums);
```
- Это важно, чтобы можно было использовать два указателя и исключить дубликаты.
  - **Пример:**
    - Вход: `[ -1, 0, 1, 2, -1, -4 ]`
    - После сортировки: `[ -4, -1, -1, 0, 1, 2 ]`

### Шаг 2: Фиксация первого числа и два указателя
```java
for (int i = 0; i < nums.length; i++) {
    int j = i + 1;  // Левый указатель (следующий элемент)
    int k = nums.length - 1;  // Правый указатель (последний элемент)
```
- `nums[i]` — фиксируем первый элемент.
- `j` — левый указатель (начинается сразу после i).
- `k` — правый указатель (начинается с конца массива).

### Шаг 3: Движение указателей
```java
while (j < k) {
    int sum = nums[i] + nums[j] + nums[k];
```

- Пока левый указатель `j` меньше правого `k`, проверяем сумму.

### Шаг 4: Найдена сумма 0
```java
if (sum == target) { 
    s.add(Arrays.asList(nums[i], nums[j], nums[k]));
    j++;
    k--;
}
```

- Если `nums[i] + nums[j] + nums[k] == 0`, добавляем тройку в `Set`.
- Сдвигаем оба указателя, чтобы избежать дубликатов.

### Шаг 5: Если сумма < 0 → двигаем `j` вправо
```java
else if (sum < target) {
    j++; 
}
```
- Если сумма меньше 0, увеличиваем `j`, чтобы увеличить сумму.

### Шаг 6: Если сумма > 0 → двигаем k влево
```java
else {
    k--; 
}
```
- Если сумма больше 0, уменьшаем `k`, чтобы уменьшить сумму.

## Better solution
```java
public List<List<Integer>> threeSum(int[] arr) {
        return new AbstractList<>() {
            List<List<Integer>> ans;

            @Override
            public int size() {
                if (ans == null)
                    ans = createList(arr);
                return ans.size();
            }

            @Override
            public List<Integer> get(int index) {
                if (ans == null)
                    ans = createList(arr);
                return ans.get(index);
            }
        };
    }

    private List<List<Integer>> createList(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = arr.length;
        Arrays.sort(arr);
        for (int i = 0; i < len - 2 && arr[i] <= 0; ++i) {
            if (i > 0 && arr[i] == arr[i - 1])
                continue;
            twoSum(ans, arr, i + 1, len - 1, -arr[i]);
        }
        return ans;
    }

    private void twoSum(List<List<Integer>> ans, int[] arr, int left, int right, int target) {
        while (left < right) {
            if (arr[left] + arr[right] > target) {
                --right;
                continue;
            }
            if (arr[left] + arr[right] < target) {
                ++left;
                continue;
            }

            ans.add(Arrays.asList(-target, arr[left++], arr[right--]));

            while (left <= right && arr[left] == arr[left - 1])
                ++left;
        }
    }
```

## 1. Основное улучшение — "ленивый" (lazy) вычислительный подход
### Что это значит?
Вместо того чтобы сразу вычислять все тройки `(threeSum())`, оно создаёт "отложенный" список с помощью `AbstractList<>`, **который реально вычисляется только тогда**, когда вызываются методы:

- `size()` → запрашивает количество троек
- `get(index)` → запрашивает конкретную тройку

Это значит, что если кто-то вызовет метод `threeSum()`, но не будет использовать результат, вычисления вообще не произойдут.

### Почему это лучше?
- **Экономия ресурсов:** если клиентский код не использует весь список, то ненужные вычисления не выполняются.
- **Уменьшение задержки:** код не блокируется на полный расчёт списка, пока это не потребуется.


## 2. Использование `twoSum()` с `target = -arr[i]`
### Как это работает?
Вместо поиска двух чисел `nums[j] + nums[k] == -nums[i]` внутри основного цикла, здесь выделена отдельная функция `twoSum()`, которая:

- Использует два указателя `(left, right)` для поиска пар, сумма которых равна `-arr[i]`.
- После нахождения пары пропускает дубликаты `(while (left <= right && arr[left] == arr[left - 1]))`.
### Почему это лучше?
- ✅ Читаемость кода выше → поиск пары вынесен в отдельную функцию.
- ✅ Уменьшает дублирование кода → теперь логика поиска двух чисел (twoSum()) отделена от основной части.


## 3. Уменьшение количества дубликатов через пропуск `arr[i] == arr[i - 1]`
### Как это помогает?
В основном цикле:
```java
if (i > 0 && arr[i] == arr[i - 1])
    continue;
```

- Пропускаем одинаковые `arr[i]`, чтобы не вычислять одни и те же комбинации заново.

В `twoSum()`:
```java
while (left <= right && arr[left] == arr[left - 1])
    ++left;
```

- После нахождения пары также пропускаем дубликаты.

### Почему это лучше?
- ✅ Меньше повторений → быстрее выполнение.
- ✅ Нет необходимости использовать `Set`, потому что дубликаты обрабатываются на месте.


## 4. Разделение логики для большей гибкости
### Чем хорош такой подход?
- Метод `threeSum()` только инициализирует процесс.
- Метод `createList()` создаёт тройки при первом доступе.
- Метод `twoSum()` обрабатывает поиск пар.

Это делает код легче для модификации и тестирования.