public class NextPermutation {

    public void nextPermutation(int[] nums) {

        Integer idx=null;

        for (int i = nums.length-1; i >0 ; i--) {
            if(nums[i-1]<nums[i]){
                idx=i-1;
                break;
            }
        }

        if(idx==null){
            rev(nums,0,nums.length-1);
            return;

        }

        int j=idx+1;
        while (j< nums.length){
            if(nums[idx]>=nums[j]){
                break;
            }
            j++;
        }

        int t=nums[j-1];
        nums[j-1]=nums[idx];
        nums[idx]=t;

        rev(nums,idx+1, nums.length-1);


    }


    private  void rev(int[] nums,int i, int j){
        int len= j-i +1;
        int m= i + (j-i)/2;

        if(len%2==0){
            m=m+1;
        }

        int k=i;
        while (k<m){
            int t=nums[j-(k-i)];
            nums[j-(k-i)]=nums[k];
            nums[k]=t;
            k++;
        }

    }
}
