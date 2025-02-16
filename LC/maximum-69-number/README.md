# Maximum 69 Number

This project contains a Java implementation for solving the "Maximum 69 Number" problem, where the goal is to maximize a given number by changing at most one digit from `6` to `9` or from `9` to `6`.

## Problem Description

You are given a positive integer `num` consisting only of digits `6` and `9`.

Return the maximum number you can get by changing at most one digit (`6` becomes `9`, and `9` becomes `6`).

### Example 1
- **Input:** `num = 9669`
- **Output:** `9969`
- **Explanation:**
    - Changing the first digit results in `6669`.
    - Changing the second digit results in `9969`.
    - Changing the third digit results in `9699`.
    - Changing the fourth digit results in `9666`.
    - The maximum number is `9969`.

### Example 2
- **Input:** `num = 9996`
- **Output:** `9999`
- **Explanation:** Changing the last digit `6` to `9` results in the maximum number.

### Example 3
- **Input:** `num = 9999`
- **Output:** `9999`
- **Explanation:** It is better not to apply any change.

### Constraints:
- `1 <= num <= 10^4`
- `num` consists of only digits `6` and `9`.

## Solution

The solution involves the following steps:
1. Convert the number to a string to easily manipulate individual digits.
2. Traverse the string and find the first occurrence of the digit `6`.
3. Change the first `6` to `9`.
4. Convert the string back to an integer and return it.

## Implementation


```java
public class Maximum69Number {
    public static int maximum69Number (int num) {
        // Convert the number to a string to easily access and modify digits
        String numStr = Integer.toString(num);
        
        // Convert the string to a character array
        char[] numChars = numStr.toCharArray();
        
        // Traverse the character array to find the first occurrence of '6'
        for (int i = 0; i < numChars.length; i++) {
            if (numChars[i] == '6') {
                // Change the first '6' to '9'
                numChars[i] = '9';
                break;
            }
        }
        
        // Convert the character array back to a string and then to an integer
        return Integer.parseInt(new String(numChars));
    }

}
