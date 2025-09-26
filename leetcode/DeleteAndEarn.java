public class DeleteAndEarn {
    Integer[] m;
    public int deleteAndEarn(int[] nums) {
        int max=0;
        for (int n:nums){
            max=Math.max(max,n);
        }
        int[] p=new int[max+1];
        m=new Integer[max+1];
        for (int n: nums){
            p[n]+=n;
        }
        return dp(0,p);
    }

    public int dp(int i, int[] p){
        if(i>=p.length) return 0;
        if(m[i]!=null) return m[i];
        int v=Math.max(p[i] +dp(i+2,p), dp(i+1,p));
        m[i]=v;
        return v;
    }
}
