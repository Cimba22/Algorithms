# 2481. Minimum Cuts to Divide a Circle

## Problem Statement
A valid cut in a circle can be:

- A cut that is represented by a straight line that touches two points on the edge of the circle and passes through its center, or
- A cut that is represented by a straight line that touches one point on the edge of the circle and its center.

Given the integer `n`, return the minimum number of cuts needed to divide a circle into `n` equal slices.

## Examples

### Example 1
**Input:**  n = 4

**Output:** 2

**Explanation:**
The figure shows how cutting the circle twice through the middle divides it into 4 equal slices.

### Example 2
**Input:**  n = 3

**Output:** 3

**Explanation:**
At least 3 cuts are needed to divide the circle into 3 equal slices. It can be shown that less than 3 cuts cannot result in 3 slices of equal size and shape. Also note that the first cut will not divide the circle into distinct parts.

## Constraints
- 1 <= n <= 100

## Solution

To solve this problem, we need to consider how many cuts are required to divide a circle into `n` equal slices. The solution can be derived by observing the following patterns:

- If `n` is 1, no cuts are needed since the circle itself is a single slice.
- If `n` is greater than 1:
    - If `n` is even, the minimum number of cuts needed is `n / 2`.
    - If `n` is odd, the minimum number of cuts needed is `n`.

Here is the Python code to implement this logic:

```java
public class Solution {
    public int numberOfCuts(int n) {
        return (n % 2 == 0) ? (n / 2) : (n == 1 ? 0 : n);
    }
}





