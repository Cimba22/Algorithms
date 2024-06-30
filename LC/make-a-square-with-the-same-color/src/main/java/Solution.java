public class Solution {
    public boolean canMakeSquare(char[][] grid) {
        // Check all 2x2 sub-grids
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                // Count the number of 'B' and 'W' in the current 2x2 sub-grid
                int bCount = 0;
                int wCount = 0;
                for (int x = i; x < i + 2; x++) {
                    for (int y = j; y < j + 2; y++) {
                        if (grid[x][y] == 'B') {
                            bCount++;
                        } else {
                            wCount++;
                        }
                    }
                }
                // If there are at least 3 cells of the same color, it can be converted
                // into a 2x2 square of that color by changing at most one cell
                if (bCount >= 3 || wCount >= 3) {
                    return true;
                }
            }
        }
        // If no such 2x2 sub-grid is found, return false
        return false;
    }
}
