public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int total=0;
        int tnk=0;
        int s=0;

        for (int i = 0; i <gas.length ; i++) {

            int diff=gas[i] - cost[i];
            total +=diff;
            tnk+=diff;

            if(tnk<0){
                s=i+1;
                tnk=0;
            }

        }

        return total>=0 ?s:-1;

    }
}
