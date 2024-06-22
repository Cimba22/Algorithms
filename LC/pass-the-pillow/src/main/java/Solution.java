public class Solution {
    public int passThePillow(int n, int time) {

        int currentPosition = 1;
        int direction = 1; // 1 for forward, -1 for backward

        for (int i = 0; i < time; i++) {
            currentPosition += direction;

            if (currentPosition == n || currentPosition == 1) {
                direction *= -1;
            }
        }

        return currentPosition;
    }
}
