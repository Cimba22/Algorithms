# 1365. How Many Numbers Are Smaller Than the Current Number

## Problem Description
Given the array `nums`, for each `nums[i]` find out how many numbers in the array are smaller than it. That is, for each `nums[i]` you have to count the number of valid `j`'s such that `j != i` and `nums[j] < nums[i]`.

Return the answer in an array.

### Example 1:
**Input:** nums = [8,1,2,2,3]  
**Output:** [4,0,1,1,3]  
**Explanation:**  
For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).  
For nums[1]=1 does not exist any smaller number than it.  
For nums[2]=2 there exists one smaller number than it (1).  
For nums[3]=2 there exists one smaller number than it (1).  
For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).

### Example 2:
**Input:** nums = [6,5,4,8]  
**Output:** [2,1,0,3]

### Example 3:
**Input:** nums = [7,7,7,7]  
**Output:** [0,0,0,0]

### Constraints:
- 2 <= nums.length <= 500
- 0 <= nums[i] <= 100

## Solution 1: Brute Force Approach
```java
public int[] smallerNumbersThanCurrent(int[] nums) {
    int[] res = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
        int count = 0;
        for (int num : nums) {
            if (nums[i] > num) {
                count++;
            }
        }
        res[i] = count;
    }
    return res;
}
```

### Explanation:
- Create an array res to store the results.
- For each element in nums, initialize a counter to zero.
- Compare the current element with every other element in the array.
- If the current element is greater than another element, increment the counter.
- Assign the counter value to the corresponding position in the res array.
- Return the res array.


## Solution 2: Optimized Approach using Counting Sort
```java
public int[] smallerNumbersThanCurrent(int[] nums) {
    int[] buckets = new int[101];

    for (int num : nums) {
        buckets[num]++;
    }

    for(int i = 1; i < buckets.length; i++) {
        buckets[i] += buckets[i - 1];
    }

    int[] result = new int[nums.length];
    for(int i = 0; i < result.length; i++) {
        if(nums[i] == 0) {
            result[i] = 0;
        } else {
            result[i] = buckets[nums[i] - 1];
        }
    }
    return result;
}
```

### Explanation:
- Create a buckets array of size 101 (since 0 <= nums[i] <= 100) to store the count of each number in nums.
- Traverse the nums array and increment the count of each number in the buckets array.
- Update the buckets array such that each element at index i contains the cumulative count of numbers up to i.
- Create a result array to store the results.
- For each element in nums, if the element is 0, the result is 0 (since no number is smaller than 0).
- Otherwise, the result for each element is the value in the buckets array at the index nums[i] - 1 (which gives the count of numbers smaller than the current number).
- Return the result array.