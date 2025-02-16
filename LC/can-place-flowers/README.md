# Can Place Flowers

## Problem Statement

You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

Given an integer array `flowerbed` containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer `n`, return `true` if `n` new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and `false` otherwise.

### Example 1:

- **Input:** flowerbed = [1,0,0,0,1], n = 1
- **Output:** true

### Example 2:

- **Input:** flowerbed = [1,0,0,0,1], n = 2
- **Output:** false

### Constraints:

- 1 <= flowerbed.length <= 2 * 10^4
- flowerbed[i] is 0 or 1.
- There are no two adjacent flowers in flowerbed.
- 0 <= n <= flowerbed.length

## Solution

To solve the problem of determining whether you can plant `n` new flowers in a flowerbed without violating the no-adjacent-flowers rule, we can iterate through the `flowerbed` array and check for available spots where flowers can be planted.

### Approach:

1. Iterate through each position in the `flowerbed` array.
2. Check if the current position and its neighboring positions (left and right) are empty (i.e., contain 0).
3. If an empty spot is found where a flower can be planted, plant the flower by setting the current position to 1 and decrement `n` by 1.
4. If at any point `n` becomes 0, return `true` since all flowers have been successfully planted.
5. After the iteration, if `n` is still greater than 0, return `false`.

### Code:

```java
public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int length = flowerbed.length;
        for (int i = 0; i < length; i++) {
            // Check if the current plot is empty and the left and right plots are empty or out of bounds
            if (flowerbed[i] == 0 && 
                (i == 0 || flowerbed[i - 1] == 0) && 
                (i == length - 1 || flowerbed[i + 1] == 0)) {
                // Plant a flower here
                flowerbed[i] = 1;
                n--;
                // If no more flowers need to be planted, return true
                if (n == 0) {
                    return true;
                }
            }
        }
        // If there are still flowers left to be planted, return false
        return n <= 0;
    }

    
}
