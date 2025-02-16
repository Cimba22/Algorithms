public class Solution {
    public int findKthPositive(int[] arr, int k) {
        int missingCount = 0;
        int current = 1;
        int index = 0;

        while (missingCount < k) {
            if (index < arr.length && arr[index] == current) {
                // Если текущее число содержится в массиве, переходим к следующему элементу массива
                index++;
            } else {
                // Если текущее число пропущено, увеличиваем счетчик пропущенных чисел
                missingCount++;
                if (missingCount == k) {
                    return current;
                }
            }
            current++;
        }

        return current;
    }
}
