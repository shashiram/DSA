public class kthSmallestInSOrtedMatrix {
    public int kthSmallest(int[][] m, int k) {

        int n = m.length;
        int l = m[0][0];
        int h = m[n - 1][n - 1];

        while (l < h) {
            int mid = l + (h - l) / 2;
            int c = 0;
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m.length; j++) {
                    if (m[i][j] <= mid) {
                        c++;
                    }
                }

            }

            if (c < k) {
                l = mid + 1;
            } else {
                h = mid;
            }

        }

        return l;
    }
}
