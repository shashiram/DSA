import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
692. Top K Frequent Words
* */
public class TopKFrequentWords {
    Map<String, Integer> m;
    int s = 0;

    public List<String> topKFrequent(String[] strs, int k) {
        m = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            m.put(strs[i], m.getOrDefault(strs[i], 0) + 1);
        }


        Map.Entry<String, Integer>[] arr = new Map.Entry[m.size()];
        int i = 0;
        for (Map.Entry<String, Integer> e : m.entrySet()) {
            arr[i] = e;
            i++;
        }
        s = arr.length;
        i = arr.length / 2;
        while (i >= 0) {
            hp(i, arr);
            i--;
        }

        List<String> l = new ArrayList<>();
        while (k > 0) {

            String str = arr[0].getKey();
            arr[0] = arr[s - 1];
            s = s - 1;
            hp(0, arr);
            k--;
            l.add(str);
        }

        return l;

    }

    public void hp(int i, Map.Entry<String, Integer>[] arr) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (!(l >= s && r >= s)) {
            int idx = i;
            if (l < s && arr[l].getValue() >= arr[idx].getValue()) {

                if (arr[l].getValue() > arr[idx].getValue()) {
                    idx = l;
                }
                if (arr[l].getValue() == arr[idx].getValue() && (arr[l].getKey().compareTo(arr[idx].getKey()) < 0)) {
                    idx = l;
                }
            }
            if (r < s && arr[r].getValue() >= arr[idx].getValue()) {
                if (arr[r].getValue() > arr[idx].getValue()) {
                    idx = r;
                }
                if (arr[r].getValue() == arr[idx].getValue() && (arr[r].getKey().compareTo(arr[idx].getKey()) < 0)) {
                    idx = r;
                }
            }
            if (idx != i) {
                Map.Entry<String, Integer> e = arr[i];
                arr[i] = arr[idx];
                arr[idx] = e;
                hp(idx, arr);
            }
        }
    }
}


