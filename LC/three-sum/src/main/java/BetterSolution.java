import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class BetterSolution {
    public List<List<Integer>> threeSum(int[] arr) {
        return new AbstractList<>() {
            List<List<Integer>> ans;

            @Override
            public int size() {
                if (ans == null)
                    ans = createList(arr);
                return ans.size();
            }

            @Override
            public List<Integer> get(int index) {
                if (ans == null)
                    ans = createList(arr);
                return ans.get(index);
            }
        };
    }

    private List<List<Integer>> createList(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = arr.length;
        Arrays.sort(arr);
        for (int i = 0; i < len - 2 && arr[i] <= 0; ++i) {
            if (i > 0 && arr[i] == arr[i - 1])
                continue;
            twoSum(ans, arr, i + 1, len - 1, -arr[i]);
        }
        return ans;
    }

    private void twoSum(List<List<Integer>> ans, int[] arr, int left, int right, int target) {
        while (left < right) {
            if (arr[left] + arr[right] > target) {
                --right;
                continue;
            }
            if (arr[left] + arr[right] < target) {
                ++left;
                continue;
            }

            ans.add(Arrays.asList(-target, arr[left++], arr[right--]));

            while (left <= right && arr[left] == arr[left - 1])
                ++left;
        }
    }

    public static void main(String[] args) {
        BetterSolution solution = new BetterSolution();
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(solution.threeSum(nums));
    }
}
