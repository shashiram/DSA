public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] arr=new boolean[n]; // composite number
        arr[0]=true;
        arr[1]=true;
        int d=(int) Math.sqrt(n-1);
        for (int i = 2; i <=d ; i++) {
            if(!arr[i]){
                for (int j = i*i; j <n; j+=i) {
                    arr[j]=true;
                }
            }
        }
        int c=0;
        for (int i = 0; i < arr.length; i++) {
            if(!arr[i])c++;
        }
        return c;
    }
}
