package org.example;

class Solution {
    public int bitwiseComplement(int n) {

        if (n == 0) return 1;

        int mask = 1;
        while (mask <= n) {
            mask = mask << 1;
        }
        mask -= 1;

        return n ^ mask;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.bitwiseComplement(5));
    }
}