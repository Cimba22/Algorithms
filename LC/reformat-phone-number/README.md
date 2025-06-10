# 1694. Reformat Phone Number

`Easy`
## 📜 Task Description

You are given a phone number as a string `number`. The string consists of digits, spaces `' '`, and/or dashes `'-'`.

You would like to reformat the phone number in a certain manner:

1. First, remove all spaces and dashes.
2. Then, group the digits from left to right into blocks of length 3 until there are 4 or fewer digits remaining.
3. The final digits are then grouped as follows:
    - 2 digits: A single block of length 2.
    - 3 digits: A single block of length 3.
    - 4 digits: Two blocks of length 2 each.

The blocks are joined by dashes. The reformatting process should never produce any blocks of length 1 and should produce at most two blocks of length 2.

### Constraints:
- 2 <= number.length <= 100
- number consists of digits and the characters `'-'` and `' '`.
- There are at least two digits in `number`.

## 🧠 Problem Understanding

The main goal is to clean up and normalize a phone number string. We must:
- Remove all formatting (spaces, dashes).
- Then split the digits into chunks following strict rules:
    - Use groups of 3 while possible.
    - Carefully handle the last 2–4 digits to avoid blocks of size 1.

This ensures readability and consistency across formatted numbers.

## 🔍 Step-by-step Solution

1. **Remove non-digit characters**:
   Use a regular expression to remove all non-digit characters:
   ```java
   String digits = number.replaceAll("\\D", "");


2. **Initialize a StringBuilder to construct the result**.

3. **Iterate through the digits**:

    * While more than 4 digits remain, take the next 3 and append them with a dash.
    * Once 4 or fewer digits remain:

        * If exactly 4 digits: split into two blocks of 2.
        * If 3 or 2 digits: make one block with them.

4. **Remove any trailing dash if necessary**.

### 💡 Key Points:

* Never allow blocks of size 1.
* Only the **last** grouping can consist of two blocks of 2.
* Use `StringBuilder` for efficient string concatenation.

## 🧪 Examples

### Example 1:

**Input:** `"1-23-45 6"`
**Output:** `"123-456"`
**Explanation:** Cleaned to `"123456"`, then split into `123` and `456`.

---

### Example 2:

**Input:** `"123 4-567"`
**Output:** `"123-45-67"`
**Explanation:** Cleaned to `"1234567"`. First group: `123`, remaining 4 digits are split into `45` and `67`.

---

### Example 3:

**Input:** `"123 4-5678"`
**Output:** `"123-456-78"`
**Explanation:** Cleaned to `"12345678"`. Groups: `123`, `456`, and `78`.

---


