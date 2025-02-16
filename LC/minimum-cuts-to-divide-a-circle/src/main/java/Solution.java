/**
 * Для парных всегда будет в половину меньше
 * Для непарных столько же сколько и само n
 */
public class Solution {
    public int numberOfCuts(int n) {
        return (n % 2 == 0) ? (n / 2) : (n == 1 ? 0 : n);
    }
}
