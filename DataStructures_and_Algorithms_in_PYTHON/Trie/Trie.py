from DataStructures_and_Algorithms_in_PYTHON.Trie.trie_node import TrieNode


class Trie():
    def __init__(self):
        self.root = TrieNode()

    def add_word(self, word):
        current = self.root
        for i in word:
            index = ord(i) - ord('a')
            if current.edges[index] is None:
                current.edges[index] = TrieNode()
            current = current.edges[index]
        current.is_end_of_word = True

    def search_word(self, word):
        current = self.root
        for i in word:
            index = ord(i) - ord('a')
            if current.edges[index] is None:
                return False
            current = current.edges[index]
        return current.is_end_of_word
    """
    The reason why we can't physically delete the TrieNodes is as  
    other words might depends on the character of the word that we delete. 
    Eg: 'apple', 'applications'
    If we remove 'apple' then 'a', 'p', 'p', 'l', 'e' will be removed
    But 'applications' shared 'a' 'p' 'p' 'l' with 'apple'. Hence it 
    would also be affected.
    """
    def delete_word(self, word):
        current = self.root
        for i in word:
            index = ord(i) - ord('a')
            if current.edges[index] is None:
                return
            current = current.edges[index]
        current.is_end_of_word = False