package org.example;

class FastestSolution {
    public int convertTime(String current, String correct) {
        int present = 0, fixed = 0;
        present += (current.charAt(0) - '0') * 10 * 60;
        present += (current.charAt(1) - '0') * 60;
        present += (current.charAt(3) - '0') * 10;
        present += (current.charAt(4) - '0');

        fixed += (correct.charAt(0) - '0') * 10 * 60;
        fixed += (correct.charAt(1) - '0') * 60;
        fixed += (correct.charAt(3) - '0') * 10;
        fixed += (correct.charAt(4) - '0');

        int rem = fixed - present;

        int res = 0;

        res += rem / 60;
        rem = rem % 60;

        res += rem / 15;
        rem = rem % 15;

        res += rem / 5;
        rem = rem % 5;

        res += rem / 1;
        rem = rem % 1;

        return res;
    }
}

