/*
211. Design Add and Search Words Data Structure
* */
public class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root=new TrieNode();
    }
    public void addWord(String word) {
        TrieNode curr=root;
        for (char c: word.toCharArray()){
            int idx=c-'a';
            if(curr.kv[idx]==null){
                curr.kv[idx]=new TrieNode();
            }
            curr=curr.kv[idx];
        }
        curr.isEnd=true;
    }

    public boolean search(String word) {
        TrieNode cur=root;
        Boolean val= find(cur,0,word.toCharArray());
        return val;
    }

    public boolean find(TrieNode node,int i, char[] arr){
        if(i>=arr.length){
            return true && node.isEnd;
        }else {
            char c=arr[i];
            if(c=='.'){
                for (int j = 0; j < 26 ; j++) {
                    if(node.kv[j]!=null){
                        if(find(node.kv[j],i+1,arr)) return true;
                    }
                }
                return false;
            }else {

                int idx=c-'a';
                if(node.kv[idx]==null){
                    return false;
                }else {
                    return find(node.kv[idx],i+1,arr);
                }

            }

        }
    }
}

class TrieNode{
    TrieNode[] kv;
    boolean isEnd;
    TrieNode(){
        kv=new TrieNode[26];
    }
}
