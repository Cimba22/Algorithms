import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    void testMinimumCuts() {
        Solution s = new Solution();

        assertEquals(0, s.numberOfCuts(1), "n = 1 should return 0");
        assertEquals(1, s.numberOfCuts(2), "n = 2 should return 1");
        assertEquals(3, s.numberOfCuts(3), "n = 3 should return 3");
        assertEquals(2, s.numberOfCuts(4), "n = 4 should return 2");
        assertEquals(5, s.numberOfCuts(5), "n = 5 should return 5");
        assertEquals(3, s.numberOfCuts(6), "n = 6 should return 3");
        assertEquals(7, s.numberOfCuts(7), "n = 7 should return 7");
        assertEquals(4, s.numberOfCuts(8), "n = 8 should return 4");

    }
}
