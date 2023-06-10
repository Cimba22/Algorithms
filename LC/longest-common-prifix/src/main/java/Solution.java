//runtime is 0ms, memory is 40,6 mb
public class Solution {
    public static String longestCommonPrefix(String[] strs) {
        String ans = strs[0];
        for (int i = 0; i < strs.length; i++) {
            while (strs[i].indexOf(ans) != 0)
                    ans = ans.substring(0, ans.length() - 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
