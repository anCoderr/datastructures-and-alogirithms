class TrieNode():
    def __init__(self):
        self.edges = [None]*26
        self.is_end_of_word = False