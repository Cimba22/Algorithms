//package org.example;
//
//import java.util.Arrays;
//
//public class Solution {
//    public int longestBeautifulSubstring(String word) {
//        char[] chars = word.toCharArray();
//
//        int maxLength = 0;
//        int currentLength = 1;
//        int uniqueVowels = 1;
//
//        if (word.isEmpty())
//            return 0;
//        if(!word.contains("a")){
//            return 0;
//        }
//
//        for (int i = 1; i < chars.length; i++) {
//            if (chars[i] >= chars[i - 1]) { // Проверяем, идет ли буква в порядке или повторяется
//                currentLength++;
//                if (chars[i] > chars[i - 1]) { // Новая уникальная гласная
//                    uniqueVowels++;
//                }
//            } else { // Если порядок нарушен, сбрасываем
//                currentLength = 1;
//                uniqueVowels = 1;
//            }
//
//            if (uniqueVowels == 5) { // Если собрали все гласные в правильном порядке
//                maxLength = Math.max(maxLength, currentLength);
//            }
//        }
//
//        return maxLength;
//    }
//
//
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        String word = "aeiaaioaaaaeiiiiouuuooaauuaeiu";
//        System.out.println(solution.longestBeautifulSubstring(word));
//    }
//}