import java.util.ArrayList;
import java.util.List;

class BetterSolution {
    public List<String> letterCombinations(String digits) {

        String[] l = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();

        if(digits.length() == 0) return res;

        helper(l, digits, 0, new StringBuilder(), res);
        return res;
    }

    private void helper(String[] l, String digit, int i, StringBuilder str, List<String> res){
        if(i == digit.length()){
            res.add(str.toString());
            return;
        }

        int index = Character.getNumericValue(digit.charAt(i));
        for(int h = 0; h < l[index].length(); h++){
            str.append(l[index].charAt(h));
            helper(l, digit, i+1, str, res);
            str.deleteCharAt(str.length()-1);
        }

    }

    public static void main(String[] args) {
        BetterSolution sol = new BetterSolution();
        System.out.println(sol.letterCombinations("78"));
    }
}
