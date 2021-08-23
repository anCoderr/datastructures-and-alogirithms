package DataStructures.Trie;

public class TrieNode {
    // int size is size of input set(eg, 26 for all small english letters).
    int size;
    // EOW sequence that defines if the current node is the end of a word or not.
    boolean isEndOfWord;
    // children array keeps track of which character is current node connected to.
    TrieNode[] children;
    public TrieNode(int size, boolean end) {
        this.size = size;
        // EOW is false as we just created the current node.
        isEndOfWord = end;
        // This initialization just keeps all indexes of children as null values.
        children = new TrieNode[size];
    }
}