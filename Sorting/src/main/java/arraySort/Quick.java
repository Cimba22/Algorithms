package arraySort;

/**
 * Из массива выбирается опорный элемент, чаще всего посередине массива.
 * Другие элементы массива распределяются таким образом, чтобы меньшие размещались до него, а большие — после.
 * Далее первые шаги рекурсивно применяются к подмассивам,
 *  которые разделились опорным элементом на две части — слева и справа от него.
 *  Асимптотика: O(n log n) в среднем и лучшем случае, O(n2). Наихудшая
 *  * оценка достигается при неудачном выборе опорного элемента.
 */
public class Quick {
    public static void quickSort(int[] array, int low, int high) {
        //завершить,если массив пуст или уже нечего делить
        if (array.length == 0 || low >= high) return;

        //выбираем опорный элемент
        int middle = low + (high - low) / 2;
        int border = array[middle];

        //разделияем на подмассивы и меняем местами
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < border) i++;
            while (array[j] > border) j--;
            if (i <= j) {
                int swap = array[i];
                array[i] = array[j];
                array[j] = swap;
                i++;
                j--;
            }
        }

        //рекурсия для сортировки левой и правой части
        if (low < j) quickSort(array, low, j);
        if (high > i) quickSort(array, i, high);
    }

    public static void sort(int[] array){
        quickSort(array, 0, array.length - 1);
    }

}
