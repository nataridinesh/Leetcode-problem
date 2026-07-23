import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // Sort the array to allow early pruning in the recursion loop
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Prune: if candidate exceeds the remaining target, stop the loop
            if (candidates[i] > target) {
                break;
            }

            current.add(candidates[i]);
            // Reuse the same element 'i' for unlimited picks
            backtrack(candidates, target - candidates[i], i, current, result);
            current.remove(current.size() - 1); // Backtrack
        }
    }
}
