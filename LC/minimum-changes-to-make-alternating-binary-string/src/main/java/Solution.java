public class Solution {
    public int minOperations(String s) {
        int first = 0;
        int second = 0;
        for (int i = 0; i < s.length(); i++) {
            if(i % 2 == 0) {
                if(s.charAt(i) == '1') first++;
                else second++;
            } else {
                if(s.charAt(i) == '1') second++;
                else first++;
            }
        }
        return Math.min(first, second);
    }
}
