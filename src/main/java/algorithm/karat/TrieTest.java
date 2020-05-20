package algorithm.karat;

public class TrieTest {
    public static void main(String args[]){
        Trie trie = new Trie();
        trie.insert("Mouse");
        trie.insert("Moose");
        trie.insert("MouseHClick");
        trie.insert("MouseHandler");
        trie.insert("MouseClickHandler");
        trie.insert("MouseHandlerType");
        System.out.println(trie.search("MouseH"));
        System.out.println(trie.searchAbb("MouseH"));
    }
}
