import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
1268. Search Suggestions System
* */
public class SearchSuggestionsSystem {
    TrieNode root;
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        root=new TrieNode();
        Arrays.sort(products);
        for (String product:products){
            add(product);
        }
        return search(searchWord);
    }

    public List<List<String>> search(String searchWord){
        List<List<String>> rs=new ArrayList<>();
        TrieNode cur=root;
        for (char c: searchWord.toCharArray()){
            int idx=c-'a';
            if(cur==null || cur.kv[idx]==null){
                rs.add(new ArrayList<>());
                cur=null;
            }else {
                cur=cur.kv[idx];
                rs.add(cur.child);
            }
        }
        return rs;
    }

    public void add(String word){
        TrieNode cur=root;
        for (char c:word.toCharArray()){
            int idx=c-'a';
            if( cur.kv[idx]==null){
                cur.kv[idx]=new TrieNode();

            }

            cur=cur.kv[idx];
            if(cur.child.size()<3){
                cur.child.add(word);
            }
        }
    }

    class TrieNode{
        TrieNode[] kv;
        List<String> child;
        TrieNode(){
            kv=new TrieNode[26];
            child=new ArrayList<>();
        }
    }
}
