package org.example;

import java.util.Map;

public class Solution {
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

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.convertTime("02:30", "04:35"));
    }

}