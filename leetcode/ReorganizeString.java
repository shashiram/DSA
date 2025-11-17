import java.util.HashMap;
import java.util.Map;

/*
767. Reorganize String
* */
public class ReorganizeString {

    Map<Character,Integer> m;
    int s;
    public String reorganizeString(String str) {
        m=new HashMap<>();

        for (int i = 0; i <str.length() ; i++) {
            m.put(str.charAt(i),m.getOrDefault(str.charAt(i),0)+1);
        }
        Map.Entry<Character,Integer>[] arr=new Map.Entry[m.size()];
        int i=0;
        for (Map.Entry<Character, Integer> e : m.entrySet()) {
            arr[i]=e;
            i++;
        }
        s=arr.length;
        if(s==1){
            if(arr[0].getValue()==1){
                return arr[0].getKey()+"";
            }else {
                return "";
            }
        }
        i=arr.length/2;
        while (i>=0){
            hd(i,arr);
            i--;
        }
        StringBuilder sb=new StringBuilder();
        while (s>0){
            Map.Entry<Character,Integer> e1=arr[0];
            arr[0]=arr[s-1];
            s=s-1;
            if(s==0){
                if(e1.getValue()==1){
                    sb.append(e1.getKey());
                    break;
                }else {
                    return "";
                }
            }
            hd(0,arr);
            Map.Entry<Character,Integer> e2=arr[0];
            arr[0]=arr[s-1];
            s=s-1;
            hd(0,arr);

            if(s==0){
                if(e1.getValue()==e2.getValue() || (e2.getValue()+1==e1.getValue())){
                    int j=1;
                    for ( j = 1; j <=e2.getValue() ; j++) {
                        sb.append(e1.getKey());
                        sb.append(e2.getKey());
                    }
                    if(j==e1.getValue()){
                        sb.append(e1.getKey());
                    }
                    break;
                }else {
                    return "";
                }
            }

            sb.append(e1.getKey());
            sb.append(e2.getKey());
            e1.setValue(e1.getValue()-1);
            e2.setValue(e2.getValue()-1);
            if(e1.getValue()>0){
                arr[s]=e1;
                s=s+1;
                hup(s-1,arr);
            }
            if(e2.getValue()>0){
                arr[s]=e2;
                s=s+1;
                hup(s-1,arr);
            }
        }

        // System.out.println(sb);
        return sb.toString();
    }

    public void hup(int i, Map.Entry<Character,Integer>[] arr){
        while ((i-1)/2 >=0 && i>0){
            int pid=(i-1)/2;
            if(arr[pid].getValue()<arr[i].getValue()){
                Map.Entry<Character,Integer> t=arr[pid];
                arr[pid]=arr[i];
                arr[i]=t;
            }else
                break;
            i=pid;
        }
    }

    public void hd(int i,  Map.Entry<Character,Integer>[] arr){
        int l=2*i+1;
        int r=2*i+2;
        if(!(l>=s && r>=s)){
            int idx=i;
            if(l<s && arr[l].getValue()>=arr[idx].getValue()){

                if(arr[l].getValue()>arr[idx].getValue()){
                    idx=l;
                }
                if(arr[l].getValue()==arr[idx].getValue() && (arr[l].getKey().compareTo(arr[idx].getKey()) < 0)) {
                    idx = l;
                }
            }
            if(r<s && arr[r].getValue()>=arr[idx].getValue()){
                if(arr[r].getValue()>arr[idx].getValue()){
                    idx=r;
                }
                if(arr[r].getValue()==arr[idx].getValue() && (arr[r].getKey().compareTo(arr[idx].getKey()) < 0)) {
                    idx = r;
                }
            }
            if(idx!=i){
                Map.Entry<Character,Integer> e=arr[i];
                arr[i]=arr[idx];
                arr[idx]=e;
                hd(idx,arr);
            }
        }
    }
}
