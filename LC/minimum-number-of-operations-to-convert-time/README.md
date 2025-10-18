# 2224. Minimum Number of Operations to Convert Time

**Difficulty:** Easy

This Java solution solves [LeetCode Problem 2224](https://leetcode.com/problems/minimum-number-of-operations-to-convert-time/), which asks to calculate the minimum number of operations needed to convert one 24-hour time to another.

## Problem Description

You are given two strings `current` and `correct` representing times in 24-hour format `"HH:MM"`.

* `HH` is between `00` and `23`.
* `MM` is between `00` and `59`.
* The earliest time is `00:00`, and the latest is `23:59`.

In **one operation**, you can increase `current` by **1, 5, 15, or 60 minutes**. You can perform any number of operations.

**Goal:** Return the **minimum number of operations** needed to convert `current` to `correct`.

## Examples

**Example 1**

```
Input: current = "02:30", correct = "04:35"
Output: 3
```

**Explanation:**

1. Add 60 minutes → "03:30"
2. Add 60 minutes → "04:30"
3. Add 5 minutes → "04:35"

**Example 2**

```
Input: current = "11:00", correct = "11:01"
Output: 1
```

**Explanation:**
Only 1 minute needs to be added.

## Constraints

* `current` and `correct` are in the format `"HH:MM"`.
* `current <= correct`.

## Solution Overview

The solution works by:

1. Converting both `current` and `correct` times into **total minutes**.
2. Calculating the **difference in minutes**.
3. Using **greedy operations** (60, 15, 5, 1) to minimize the number of steps.

This approach ensures we always take the largest possible increment first, reducing the total number of operations.

## Java Implementation

```java
public int convertTime(String current, String correct) {
    String[] curArgs = current.split(":");
    String[] corrArgs = correct.split(":");

    int diffMinutesAmount = Math.abs(
            Integer.parseInt(curArgs[0]) * 60 + Integer.parseInt(curArgs[1]) -
                    (Integer.parseInt(corrArgs[0]) * 60 + Integer.parseInt(corrArgs[1]))
    );

    int count = 0;
    int[] options = {60, 15, 5, 1};

    for(int i = 0; i < options.length && diffMinutesAmount > 0; diffMinutesAmount = diffMinutesAmount % options[i++]) {
        count += diffMinutesAmount / options[i];
    }

    return count;
}
```

## Complexity

* **Time complexity:** `O(1)` — fixed number of operations.
* **Space complexity:** `O(1)` — only a few variables are used.


