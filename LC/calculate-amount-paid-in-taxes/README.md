# Tax Calculator

This project provides a solution to calculate the amount of tax paid based on different tax brackets and an individual's income. The solution is implemented in Java, and includes a main class `TaxCalculator` and a corresponding test class `TaxCalculatorTest` using JUnit.

## Problem Description

You are given a 2D integer array `brackets` where `brackets[i] = [upperi, percenti]` means that the `i`-th tax bracket has an upper bound of `upperi` and is taxed at a rate of `percenti`. The brackets are sorted by upper bound (`upperi-1 < upperi` for `0 < i < brackets.length`).

Tax is calculated as follows:
- The first `upper0` dollars earned are taxed at a rate of `percent0`.
- The next `upper1 - upper0` dollars earned are taxed at a rate of `percent1`.
- The next `upper2 - upper1` dollars earned are taxed at a rate of `percent2`.
- And so on.

Given an integer `income` representing the amount of money earned, the objective is to return the amount of money that has to be paid in taxes.

### Examples

1. **Example 1:**
    - Input: `brackets = [[3, 50], [7, 10], [12, 25]], income = 10`
    - Output: `2.65000`
    - Explanation:
        - Based on the income, you have 3 dollars in the 1st tax bracket (50%), 4 dollars in the 2nd tax bracket (10%), and 3 dollars in the 3rd tax bracket (25%).
        - Total tax paid = `3 * 50% + 4 * 10% + 3 * 25% = $2.65`.

2. **Example 2:**
    - Input: `brackets = [[1, 0], [4, 25], [5, 50]], income = 2`
    - Output: `0.25000`
    - Explanation:
        - Based on the income, you have 1 dollar in the 1st tax bracket (0%) and 1 dollar in the 2nd tax bracket (25%).
        - Total tax paid = `1 * 0% + 1 * 25% = $0.25`.

3. **Example 3:**
    - Input: `brackets = [[2, 50]], income = 0`
    - Output: `0.00000`
    - Explanation:
        - No income to tax, so total tax paid is $0.

## Solution

### Class `TaxCalculator`

This class contains the main method `calculateTax` which computes the tax based on the given brackets and income.

```java
public class TaxCalculator {
    public static double calculateTax(int[][] brackets, int income) {
        double totalTax = 0.0;
        int previousUpper = 0;

        for (int[] bracket : brackets) {
            int upper = bracket[0];
            int percent = bracket[1];

            if (income > upper) {
                int taxableIncome = upper - previousUpper;
                totalTax += taxableIncome * percent / 100.0;
            } else {
                int taxableIncome = income - previousUpper;
                totalTax += taxableIncome * percent / 100.0;
                break;
            }

            previousUpper = upper;
        }

        return totalTax;
    }
}
