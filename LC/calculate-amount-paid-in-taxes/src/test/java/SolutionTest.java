import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void testCalculateTax() {
        Solution s = new Solution();
        // Test case 1
        int[][] brackets1 = {{3, 50}, {7, 10}, {12, 25}};
        int income1 = 10;
        double expected1 = 2.65000;
        assertEquals(expected1, s.calculateTax(brackets1, income1), 1e-5);

        // Test case 2
        int[][] brackets2 = {{1, 0}, {4, 25}, {5, 50}};
        int income2 = 2;
        double expected2 = 0.25000;
        assertEquals(expected2, s.calculateTax(brackets2, income2), 1e-5);

        // Test case 3
        int[][] brackets3 = {{2, 50}};
        int income3 = 0;
        double expected3 = 0.00000;
        assertEquals(expected3, s.calculateTax(brackets3, income3), 1e-5);

        // Additional test cases
        // Test case 4
        int[][] brackets4 = {{2, 10}, {5, 20}, {10, 30}};
        int income4 = 5;
        double expected4 = 0.8;
        assertEquals(expected4, s.calculateTax(brackets4, income4), 1e-5);

        // Test case 5
        int[][] brackets5 = {{2, 10}, {5, 20}, {10, 30}};
        int income5 = 12;
        double expected5 = 2.3;
        assertEquals(expected5, s.calculateTax(brackets5, income5), 1e-5);

        // Test case 6
        int[][] brackets6 = {{2, 10}, {5, 20}, {10, 30}};
        int income6 = 0;
        double expected6 = 0.0;
        assertEquals(expected6, s.calculateTax(brackets6, income6), 1e-5);
    }
}
