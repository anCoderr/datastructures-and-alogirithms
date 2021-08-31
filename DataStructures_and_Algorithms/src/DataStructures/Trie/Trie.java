package DataStructures.Trie;// Basic Implementation of a DataStructures.Trie.Trie.

/*
    This is basically what a tree(...!oops I meant TRIE) looks like.
                             --------------------------
                          This right here is important..!!
                          ==> Trie and Tree are different
                          (Trie is a special form of Tree)

                                        root
                                      /  |  \
                                     A   M   N
                                    / \  \    \
                                   D   P  O    A
                                  / \  |   \    \
                               ->D  I  P   N    M
                                   /  / \   \   |
                                  O  L  A   E   E<-
                                 /   |  |   |    \
                              ->S  ->E  R ->Y     L-E-S-S<-
                                        |
                                        E
                                       /
                                    ->L

    NOTE => The multiple arrow heads (-> , <-) are essentially Word End specifiers.
            Eg, NAME in itself is a word but NAMELESS can be made by extending nodes
            below the NAME string. Thus a single branch can have multiple EOW's(end of word sequence).

    Insert => O(n)
    Search => O(n)
    n ------> Size of word/String

    One thing that you might have noticed right of the bat is that this seems like a very optimal way to
    store words(or Strings), and you are right for the most part. This sort of tree can be very helpful to
    store lots of words. However if we ever need to search the entire trie for any suffix that would be
    really problematic. This is because searching for something whose starting points are not known could
    be quite literally could be "ANYWHERE" in the Trie. Searching for prefix would be easy. That is why we
    try to avoid situations where we need to check for suffix. Notice I said Graph and at some point I also
    called it a Tree. This is because Tree is a specific sort of Graph. Trie is a special sort of Tree hence
    it is also a Graph.

    NOTE => Graph is a really important DS as a lot of DS are just special cases of Graph
            For Eg, Linked List, Tree, BST, Trie are all Graphs with some strict rules and boundations.

    By now you might have realized why this DS is very good for storing strings/words, if not dont worry
    read the following :

    Essentially the problem was that with any normal Data Structure that we could have used for this problem
    Eg, arrays, tree, lists, etc we had to store a lot of redundant data as each word/string was a different
    entity in itself. Our goal is to look for common links between these different values so as to use these
    common links as some sort of optimizations for this problem. One can easily realize that a Word
    is just a arrangement of some characters(just 26 of em..!!).

    Lets take an example, just look at NAME and NAMELESS, these 2 words have a common part i.e "NAME"
    but storing them as different entities we are storing "NAME" redundantly. Just Consider NAME and LESS
    as 2 different nodes and connect the two. To check if a specific sequence of such nodes is an inserted
    word or not, we can assign each node with a boolean property i.e EOW(end of word) sequence. To take
    this scenario a bit further consider 3 numbers NAME, NAMELESS, NAMEPLATE, NAMELESSNESS. Here NAME can
    be common node for all 4 words and NAMELESS can be common node for 2 words. We realized that since the
    character set is limited, taking this common node approach a bit further and apply this principle to each
    and every single character. Rather than storing common substrings we store all character as different
    nodes, each with its own EOW sequence and subsequent character array to keep record of which character
    is the current character attached to.

 */

import Exceptions.ExceptionsGenerator;

public class Trie {

    static class Runner {
        public static void main(String[] args) throws Exception {
            Trie trie = new Trie(26);
            trie.addWord("apple");
            trie.addWord("apollo");
            trie.addWord("apparel");
            trie.addWord("base");
            trie.addWord("basement");
            trie.addWord("zomba");
            System.out.println(trie.search("apple"));
            System.out.println(trie.search("apollo"));
            System.out.println(trie.search("apparel"));
            System.out.println(trie.search("base"));
            System.out.println(trie.search("basement"));
            System.out.println(trie.search("zomba"));
            trie.deleteWord("apollo");
            trie.deleteWord("zomba");
            System.out.println(trie.search("zomba"));
            System.out.println(trie.search("apollo"));
        }
    }

    // setSize is size of input set(eg, 26 for all small english letters)
    int setSize;
    // root is the root node
    TrieNode root;
    public Trie(int setSize) {
        this.setSize = setSize;
        root = new TrieNode(this.setSize, false);
    }
    public void addWord(String word) throws Exception{
        if(search(word))
            throw new ExceptionsGenerator("Illegal Argument Exception.\nError Message : The given word is already exists");
        TrieNode current = root;
        int index;
        for(int i = 0; i<word.length(); i++) {
            index = word.charAt(i) - 'a';
            if(current.children[index] == null)
                current.children[index] = new TrieNode(26, false);
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }
    public boolean search(String word) {
        TrieNode current = root;
        int index;
        for(int i = 0; i<word.length(); i++) {
            index = word.charAt(i) - 'a';
            if(current.children[index] == null)
                return false;
            current = current.children[index];

        }
        return current.isEndOfWord;
    }
    public void deleteWord(String word) throws Exception {
        TrieNode current = root;
        int index;
        for(int i = 0; i<word.length(); i++) {
            index = word.charAt(i) - 'a';
            if(current.children[index] == null)
                throw new ExceptionsGenerator("Illegal Argument Exception.\nError Message : The given word is doesn't exist exists");
            current = current.children[index];
        }
        current.isEndOfWord = false;
    }
}



