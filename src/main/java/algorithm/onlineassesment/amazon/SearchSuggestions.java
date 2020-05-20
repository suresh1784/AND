package algorithm.onlineassesment.amazon;
import java.util.*;
public class SearchSuggestions {

    public static class Trie {
        public static class TrieNode {
            Map<Character, TrieNode> children;
            boolean endOfWord;
            PriorityQueue<String> pq;

            public TrieNode() {
                children = new HashMap<>();
                endOfWord = false;
                pq = new PriorityQueue<>(3, (a, b) -> b.compareTo(a));
            }
        }

        static TrieNode root;
        public Trie(){
            root = new TrieNode();
        }

        public static void add(String s){
            TrieNode curr = root;
            add(curr, s.toCharArray(), 0);
        }

        private static void add(TrieNode  curr , char[] ch , int level){
            if (level>= ch.length){
                curr.endOfWord = true;
                return;
            }

            TrieNode node = curr.children.get(ch[level]);
            if (node == null){
                curr.children.put(ch[level], new TrieNode());
                node = curr.children.get(ch[level]);
            }
            node.pq.offer(new String(ch));
            if (node.pq.size() > 3){
                node.pq.poll();
            }
            add(node, ch, level+1);
        }

        public static List<List<String>> search(String s){
            TrieNode curr = root;
            List<List<String>> result = new ArrayList<>();
            List<String> list = new ArrayList<>();
            search(curr, s.toCharArray(), 0 , list, result);
            return result;
        }

       private static void search(TrieNode curr, char[] ch , int level , List<String> list, List<List<String>> result ){
            if (level== ch.length){
                if (curr == null) {
                    result.add(new ArrayList<>());
                }
                return;
            }

            if (curr == null){
                result.add(new ArrayList<>());
                search(null, ch, level+1, list, result);
            }else {
                TrieNode node = curr.children.get(ch[level]);
                if (node != null) {
                    List<String> list1 = new ArrayList<>();
                    list1.addAll(node.pq);
                   // Collections.reverse(list1);
                    list1.sort((a,b)-> a.compareTo(b));
                    result.add(new ArrayList(list1));
                }
                search(node, ch, level+1, list, result);
            }

        }

    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    List<List<String>>  result = new ArrayList<>();
    Trie trie = new Trie();
    for (String product : products){
        trie.add(product);
    }

    result = trie.search(searchWord);
    return result;
    }
}
