import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> uniqueResults = new HashSet<>();
        Set<Integer> currentResults = new HashSet<>();

        for (int num : arr) {
            Set<Integer> newResults = new HashSet<>();
            newResults.add(num);

            for (int current : currentResults) {
                newResults.add(num | current);
            }

            uniqueResults.addAll(currentResults = newResults);
        }

        return uniqueResults.size();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {1,1,2};


        System.out.println(solution.subarrayBitwiseORs(array));
    }
}
