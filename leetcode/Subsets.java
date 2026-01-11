import java.util.ArrayList;
import java.util.List;

/*
78. Subsets
* */
public class Subsets {
    List<List<Integer>> rs;

    public List<List<Integer>> subsets(int[] nums) {
        rs = new ArrayList<>();
        rs.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            List<Integer> l = new ArrayList<>();
            l.add(nums[i]);
            rs.add(new ArrayList<>(l));
            dp(i, l, nums);
        }
        return rs;
    }

    public void dp(int i, List<Integer> l, int[] nums) {

        for (int j = i + 1; j < nums.length; j++) {
            List<Integer> temp = new ArrayList<>(l);
            temp.add(nums[j]);
            rs.add(new ArrayList<>(temp));
            dp(j, temp, nums);
        }
    }
}
