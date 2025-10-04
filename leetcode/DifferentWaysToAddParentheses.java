import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DifferentWaysToAddParentheses {
    List<Integer>[][] m;

    public List<Integer> diffWaysToCompute(String e) {
        m = new List[e.length()][e.length()];
        return dp(0, e.length() - 1, e);
    }

    public List<Integer> dp(int i, int j, String e) {

        if (m[i][j] != null) return m[i][j];
        if (i == j) {
            return Arrays.asList(getInt(e.charAt(i)));
        }
        if (i + 1 == j) {
            return Arrays.asList(Integer.valueOf(e.substring(i, j + 1)));
        } else {
            List<Integer> l = new ArrayList<>();
            for (int k = i + 1; k < j; k++) {
                if (isOp(k, e)) {
                    List<Integer> l1 = dp(i, k - 1, e);
                    List<Integer> l2 = dp(k + 1, j, e);
                    if (e.charAt(k) == '+') {
                        List<Integer> rt = merge(l1, l2, '+');
                        l.addAll(rt);
                    } else if (e.charAt(k) == '-') {
                        List<Integer> rt = merge(l1, l2, '-');
                        ;
                        l.addAll(rt);
                    } else {
                        List<Integer> rt = merge(l1, l2, '*');
                        ;
                        l.addAll(rt);
                    }
                }
            }
            m[i][j] = l;
            return l;
        }

    }

    public boolean isOp(int k, String e) {
        return e.charAt(k) == '+' || e.charAt(k) == '-' || e.charAt(k) == '*';
    }

    public int getInt(char c) {
        return Character.getNumericValue(c);
    }

    public List<Integer> merge(List<Integer> l1, List<Integer> l2, char op) {
        List<Integer> rt = new ArrayList<>();
        for (int m = 0; m < l1.size(); m++) {
            for (int n = 0; n < l2.size(); n++) {
                if (op == '+')
                    rt.add(l1.get(m) + l2.get(n));
                else if (op == '-') {
                    rt.add(l1.get(m) - l2.get(n));
                } else
                    rt.add(l1.get(m) * l2.get(n));
            }
        }
        return rt;
    }
}

