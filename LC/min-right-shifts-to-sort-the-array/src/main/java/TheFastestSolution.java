import java.util.List;

/**
 * Проходим по циклу проверяя больше ли предыдущее число.
 * Если порядок нарушен, увеличиваем breakPoints и сохраняем текущий индекс i в переменной index.
 * Если breakPoints == 1 и последний элемент массива nums.get(len - 1) меньше или равен первому элементу nums.get(0),
 * это означает, что массив можно отсортировать одним циклическим сдвигом. В этом случае возвращаем количество сдвигов len - index.
 */
public class TheFastestSolution {
    public int minimumRightShifts(List<Integer> nums) {

        int len = nums.size();

        if (len == 1) {
            return 0;
        }

        int breakPoints = 0;
        int index = 0;

        for (int i = 1; i < len; i++) {
            if (nums.get(i - 1) > nums.get(i)) {
                breakPoints++;
                index = i;
            }
        }

        if (breakPoints == 1 && nums.get(len - 1) <= nums.getFirst()) {
            return len - index;
        } else if (breakPoints == 0) {
            return 0;
        } else {
            return -1;
        }
    }
}
