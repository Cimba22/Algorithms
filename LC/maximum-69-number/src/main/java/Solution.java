public class Solution {
    public int maximum69Number (int num) {
        String numStr = Integer.toString(num);
        char[] numChars = numStr.toCharArray();
        for (int i = 0; i < numChars.length; i++) {
            if (numChars[i] == '6') {
                numChars[i] = '9';
                break;
            }
        }
        return Integer.parseInt(new String(numChars));

    }
}
