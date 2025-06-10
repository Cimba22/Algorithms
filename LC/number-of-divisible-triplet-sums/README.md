
---

# 📊 2964. Number of Divisible Triplet Sums

**Difficulty:** Medium
**Topics:** Combinatorics, Hash Map, Modulo Arithmetic
**Problem Type:** Triplet Search with Condition

---

## 📝 Problem Statement

Given a 0-indexed integer array `nums` and an integer `d`, return the number of triplets **(i, j, k)** such that:

* `i < j < k`
* `(nums[i] + nums[j] + nums[k]) % d == 0`

---

### ✅ Constraints:

* `1 <= nums.length <= 1000`
* `1 <= nums[i] <= 10⁹`
* `1 <= d <= 10⁹`

---

## 📌 Examples

### Example 1:

```text
Input: nums = [3, 3, 4, 7, 8], d = 5
Output: 3
Explanation: Valid triplets are (0,1,2), (0,2,4), (1,2,4)
```

### Example 2:

```text
Input: nums = [3, 3, 3, 3], d = 3
Output: 4
Explanation: Any triplet sums to 9, which is divisible by 3. 4 such triplets exist.
```

### Example 3:

```text
Input: nums = [3, 3, 3, 3], d = 6
Output: 0
Explanation: No triplet sum is divisible by 6.
```

---

## 🔍 Approach 1: Hash Map of Duplet Sums

### 🔧 Java Code

```java
class Solution {
    public int divisibleTripletCount(int[] nums, int d) {
        Map<Integer, List<int[]>> dupletSums = new HashMap<>();
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int temp = (nums[i] + nums[j]) % d;
                dupletSums.putIfAbsent(temp, new ArrayList<>());
                dupletSums.get(temp).add(new int[]{i, j});
            }
        }

        for (int k = 0; k < nums.length; k++) {
            int val = nums[k];
            int targetKey = (d - val % d) % d;
            final int kFinal = k;

            ans += (int) dupletSums.getOrDefault(targetKey, Collections.emptyList())
                    .stream()
                    .filter(ijPair -> ijPair[1] < kFinal)
                    .count();
        }
        return ans;
    }
}
```

### 🧠 How it works:

* First, build a map of all duplet sums `(i, j)` modulo `d`.
* Then, for each index `k`, find how many duplets `(i, j)` exist such that `i < j < k` and the sum with `nums[k]` is divisible by `d`.

### ⏱ Time Complexity:

* O(n²) for duplet generation
* O(n) for checking each `k`
* **Total: O(n²)**

---

## ⚡ Approach 2: Optimized Modulo Counting

### 🔧 Java Code

```java
public class FasterSolution {
    public int divisibleTripletCount(int[] nums, int d) {
        int[] map = new int[d];
        int len = nums.length;
        int res = 0;

        for (int i = 0; i < len - 2; i++) {
            int t = (d - nums[i] % d) % d;
            map[t] += 1;
            int j = i + 1;
            for (int k = j + 1; k < len; k++) {
                res += map[(nums[k] + nums[j]) % d];
            }
        }
        return res;
    }
}
```

### 🧠 How it works:

* This solution avoids storing duplets explicitly.
* For each number `nums[i]`, it calculates the required modulo sum `t` and stores its frequency.
* Then for each pair `(j, k)`, it checks how many `i`s before them would complete the triplet.

### ⏱ Time Complexity:

* O(n²) but with **less overhead** than the previous solution
* No nested map or list structure; uses a simple array

---

## ⚖️ Comparison

| Aspect                 | Approach 1 (`Solution`) | Approach 2 (`FasterSolution`)   |
| ---------------------- | ----------------------- | ------------------------------- |
| Time Complexity        | O(n²)                   | O(n²)                           |
| Space Complexity       | O(n²) in worst case     | O(d)                            |
| Clarity / Readability  | Higher                  | Slightly more complex           |
| Performance            | Slower for large inputs | Faster, more efficient          |
| Suitable for large `d` | Yes                     | Only if `d` is reasonably small |

---

## 💡 Conclusion

Both solutions solve the problem correctly, but:

* Use **Approach 1** for clarity or when `d` is very large.
* Use **Approach 2** for better performance when `d` is reasonably small (e.g. ≤ 10⁵).
