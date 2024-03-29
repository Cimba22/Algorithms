package arraySort;

import java.util.Arrays;

/**
 * Находим максимальное число в заданном массиве.
 * Потом создаем новый временный массив длинной найденного макс. значения (max + 1) и заполняем его нулями.
 * Потом проходя изначальный массив вписываем с помощью итерации количество вхождений каждого элемента в изначальном массиве.
 * Последняя петля фор отвечает за подсчет. Счетчик увиличивается по ходу прохождения по временному массиву,
 *  как только наткнется на место записанного числа, то вписывает счетчик в изначальный массив.
 *
 *  Применение сортировки подсчётом целесообразно лишь тогда, когда сортируемые числа имеют (или их можно отобразить в) диапазон возможных значений,
 *  который достаточно мал по сравнению с сортируемым множеством, например, миллион натуральных чисел меньших 1000
 *
 *  Временная сложность сортировки подсчетом O(n + max), куда n размер ввода и max является входным диапазоном.
 *  Поскольку он использует массивы длины max+1 а также n, общее пространство, используемое алгоритмом, также равно O(n + max).
 *  Сортировка подсчетом может быть очень эффективной, когда диапазон ключей max значительно меньше, чем общее количество элементов n,
 *  но когда вариация ключей значительно превышает общее количество элементов max >> n, сортировка подсчетом занимает много места.
 */

public class Counting {
    private static void sort(int[] array) {

        //Найдём максимальное число в массиве
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        //Создадим новый массив длины max, по умолчанию наполненный нулями
        int[] tempArray = new int[max + 1];

        //Запишем в него количество вхождений каждого элемента поиндексно
        for (int value : array) {
            ++tempArray[value];
        }

        //Вставим элементы в исходный массив
        int b = 0;
        for (int i = 0; i < max + 1; ++i){
            for (int j = 0; j < tempArray[i]; ++j) {
                array[b++] = i;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {12,34,66,8,32,7,1,7,2};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
