package org.example;

import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder current = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // Считываем число (может быть многозначным)
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                // Начало новой вложенной строки
                countStack.push(k);
                stringStack.push(current);
                current = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                // Закрытие вложенности — повторяем строку
                StringBuilder decoded = stringStack.pop();
                int count = countStack.pop();
                decoded.append(String.valueOf(current).repeat(Math.max(0, count)));
                current = decoded;
            } else {
                // Просто буква — добавляем к текущей строке
                current.append(ch);
            }
        }

        return current.toString();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.decodeString("3[a]2[bc]"));
    }
}