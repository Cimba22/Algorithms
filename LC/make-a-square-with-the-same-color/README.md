# 3127. Make a Square with the Same Color

`Array` `Matrix` `Enumeration`

## Problem Description

You are given a 2D matrix `grid` of size 3 x 3 consisting only of characters 'B' and 'W'. Character 'W' represents the white color, and character 'B' represents the black color.

Your task is to change the color of at most one cell so that the matrix has a 2 x 2 square where all cells are of the same color.

Return `true` if it is possible to create a 2 x 2 square of the same color, otherwise, return `false`.

### Examples

#### Example 1:

Input: grid = `[["B","W","B"],["B","W","W"],["B","W","B"]]`

Output: true



#### Explanation:
It can be done by changing the color of the `grid[0][2]`.



----
#### Example 2:
Input: grid = `[["B","W","B"],["W","B","W"],["B","W","B"]]`

Output: false

Explanation:

It cannot be done by changing at most one cell.

----


#### Example 3:
Input: grid = [["B","W","B"],["B","W","W"],["B","W","W"]]

Output: true

Explanation:

The grid already contains a 2 x 2 square of the same color.


### Constraints
- `grid.length == 3`
- `grid[i].length == 3`
- `grid[i][j]` is either 'W' or 'B'.

## Solution

The solution involves checking all possible 2x2 sub-grids within the 3x3 grid. For each sub-grid, count the number of 'B' and 'W' characters. If a sub-grid has at least 3 cells of the same color, it is possible to make all cells in that sub-grid the same color by changing at most one cell.

## Implementation

### Java Code

```java
public class MakeSquareWithSameColor {
    public boolean isPossibleToMakeSquare(char[][] grid) {
        // Check all 2x2 sub-grids
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                // Count the number of 'B' and 'W' in the current 2x2 sub-grid
                int bCount = 0;
                int wCount = 0;
                for (int x = i; x < i + 2; x++) {
                    for (int y = j; j < j + 2; y++) {
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

    public static void main(String[] args) {
        MakeSquareWithSameColor solution = new MakeSquareWithSameColor();

        char[][] grid1 = {
            {'B', 'W', 'B'},
            {'B', 'W', 'W'},
            {'B', 'W', 'B'}
        };
        System.out.println(solution.isPossibleToMakeSquare(grid1)); // true

        char[][] grid2 = {
            {'B', 'W', 'B'},
            {'W', 'B', 'W'},
            {'B', 'W', 'B'}
        };
        System.out.println(solution.isPossibleToMakeSquare(grid2)); // false

        char[][] grid3 = {
            {'B', 'W', 'B'},
            {'B', 'W', 'W'},
            {'B', 'W', 'W'}
        };
        System.out.println(solution.isPossibleToMakeSquare(grid3)); // true
    }
}
```
