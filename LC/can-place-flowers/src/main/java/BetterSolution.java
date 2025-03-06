public class BetterSolution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int i = 0;
        while (i < flowerbed.length && n > 0) {
            if (flowerbed[i] == 1) {
                i += 2;
            } else if ((i == 0 || flowerbed[i - 1] == 0)
                    && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                n--;
                i += 2;
            } else {
                i++;
            }
        }

        return n == 0;

    }
}
