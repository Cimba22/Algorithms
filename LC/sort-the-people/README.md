# 2418. Sort the People
`Easy`
     
_You are given an array of strings names, and an array heights that consists of distinct positive integers. Both arrays are of length n.
For each index i, names[i] and heights[i] denote the name and height of the ith person.
Return names sorted in descending order by the people's heights._



### Example 1:

**Input**: names = ["Mary","John","Emma"], heights = [180,165,170]

**Output**: ["Mary","Emma","John"]

**Explanation:** Mary is the tallest, followed by Emma and John.
____
### Example 2:

**Input**: names = ["Alice","Bob","Bob"], heights = [155,185,150]

**Output**: ["Bob","Alice","Bob"]

**Explanation**: The first Bob is the tallest, followed by Alice and the second Bob.

____
Constraints:

n == names.length == heights.length
1 <= n <= 103
1 <= names[i].length <= 20
1 <= heights[i] <= 105
names[i] consists of lower and upper case English letters.
All the values of heights are distinct.


## Solution
```java
public String[] sortPeople(String[] names, int[] heights) {

        int n = heights.length;
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }
        Arrays.sort(heights);

        //Реверсия отсортированного массива высот
        for (int i = 0; i < n / 2; ++i) {
            int temp = heights[i];
            heights[i] = heights[n - 1 - i];
            heights[n - 1 - i] = temp;
        }

        for (int i = 0; i < n; ++i) {
            names[i] = map.get(heights[i]);
        }

        return names;
    }
```
- At first, we add heights and names into Map<Integer, String>
- Then sort integers with Arrays.sort(heights). It will be ascending;
- We need to reverse it with:
```java
//Реверсия отсортированного массива высот
        for (int i = 0; i < n / 2; ++i) {
            int temp = heights[i];
            heights[i] = heights[n - 1 - i];
            heights[n - 1 - i] = temp;
        }
```
- Then get names with values `map.get(heights[i])`
