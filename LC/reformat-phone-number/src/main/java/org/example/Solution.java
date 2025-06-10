package org.example;

class Solution {
    public String reformatNumber(String number) {

        String digits = number.replaceAll("\\D", "");

        StringBuilder result = new StringBuilder();
        int i = 0;
        int n = digits.length();

        while (n - i > 4) {
            result.append(digits, i, i + 3).append("-");
            i += 3;
        }

        if (n - i == 4) {
            result.append(digits, i, i + 2).append("-");
            result.append(digits, i + 2, i + 4);
        } else {
            result.append(digits.substring(i));
        }

        if (result.charAt(result.length() - 1) == '-') {
            result.deleteCharAt(result.length() - 1);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reformatNumber("123 456 789"));
        System.out.println(solution.reformatNumber("12 45"));
        System.out.println(solution.reformatNumber("123-456-789 123"));
        System.out.println(solution.reformatNumber("123-456-789 13"));
    }
}