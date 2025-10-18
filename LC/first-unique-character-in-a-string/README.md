
## №387: First Unique Character in a String

**Description:**
Given a string `s`, find the **first non-repeating character** in it and return its **index**. If no such character exists, return `-1`.

**Example:**

```
Input: s = "leetcode"
Output: 0
Explanation: 'l' is the first character that does not repeat.
```

```
Input: s = "loveleetcode"
Output: 2
Explanation: 'v' is the first non-repeating character.
```

**Constraints:**

* `1 <= s.length <= 10^5`
* `s` consists of lowercase English letters.

---

### Solution Explanation

1. **Count character frequencies:**
   Use a `HashMap<Character, Integer>` to count how many times each character appears in the string.

2. **Find the first unique character:**
   Iterate over the string from left to right. For each character, check its frequency in the map.

    * If the frequency is `1`, return the current index — this is the first non-repeating character.

3. **Return `-1` if none found:**
   If the loop finishes without finding a unique character, return `-1`.

**Time Complexity:** `O(n)` — two passes through the string.
**Space Complexity:** `O(1)` — at most 26 characters for lowercase English letters.

