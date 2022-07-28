

table = {'a': 1, 'b': 2, 'c': 3, 'd': 4, 'e': 5, 'f': 6, 'g': 7, 'h': 8, 'i': 9, 'j': 10, 
         'k': 11, 'l': 12, 'm': 13, 'n': 14, 'o': 15, 'p': 16, 'q': 17, 'r': 18, 's': 19, 
         't': 20, 'u': 21, 'v': 22, 'w': 23, 'x': 24, 'y': 25, 'z': 26}
character_set_size = 26
mod = 10**9+7
power = 7


##### BRUTE ALGORITHM --------------------------------------------------
# Time Complexity = O(N*M) ||| Memory Complexity = O(1)
# Steps: 
# 1. Iterate in the main string. 
# 2. For each index we check weather that substring matches pattern.

def brute_string_matching(string: str, pattern: str) -> int:
    s_len, p_len = len(string), len(pattern)
    for i in range(s_len-p_len+1):
        j = 0
        while j < p_len and string[i+j] == pattern[j]:
            j += 1 
        if j == p_len: return i
    return -1

##### RABIN KARP ALGORITHM --------------------------------------------------
# Time Complexity = O(N+M) ||| Memory Complexity = O(1)
# Note -> However the time complexity if the Hash Function used is bad is still O(N*M).
# Spurious Hits -> When the hash value matches but the string does'nt.
# Steps: 
# 1. We require a hash function and a rolling hash function.
# 2. We intiaially calculate the hash value for the pattern.
# 3. We iterate in teh main string.
# 4. For each iteration we maintain the hash value of that substring via Rolling Hash Technique. 
# 5. If string_hash == pattern_hash, then match is found and return.

def hash_function(string: str) -> int:
    hash = 0
    for c in string[::-1]:
        hash = (hash * power + table[c]) % mod
    return hash

def rolling_hash(char_add, char_remove, hash, pk):
    return (((hash*power) % mod + table[char_add]) % mod - (table[char_remove]*pk) % mod) % mod

def rabin_karp_string_matching(string: str, pattern: str) -> int:
    s_len, p_len = len(string), len(pattern)

    if p_len > s_len: return -1
    
    pk = pow(power, p_len, mod)
    pattern_hash = hash_function(pattern)
    string_hash = hash_function(string[s_len-p_len:s_len])

    if pattern_hash == string_hash: return s_len-p_len

    for i in range(s_len-1, p_len-2, -1):
        string_hash = rolling_hash(string[i-p_len], string[i], string_hash, pk)
        if pattern_hash == string_hash and string[i-p_len : i] == pattern:
            return i-p_len
    
    return -1

##### KNUTH MORRIS PRATT ALGORITHM --------------------------------------------------
# Time Complexity = O(N*M) ||| Memory Complexity = O(1)
# Steps: 
# 1. Iterate in the main string. 
# 2. For each index we check weather that substring matches pattern.

print("Brute:", brute_string_matching("anuragapple", "app"))
print("RKS:", rabin_karp_string_matching("anuragapple", "app"))
print("Brute:", brute_string_matching("pbloczeqldpqyuvuvaql", "pqyuvuva"))
print("RKS:", rabin_karp_string_matching("pbloczeqldpqyuvuvaql", "pqyuvuva"))
print("Brute:", brute_string_matching("nekojivehbdhnksguzvi", "neko"))
print("RKS:", rabin_karp_string_matching("nekojivehbdhnksguzvi", "neko"))
print("Brute:", brute_string_matching("suydixmxcnafnpdsaave", "suydixmxcnafnpdsaave"))
print("RKS:", rabin_karp_string_matching("suydixmxcnafnpdsaave", "suydixmxcnafnpdsaave"))
print("Brute:", brute_string_matching("fjuopqsiieydlypusper", "ypusper"))
print("RKS:", rabin_karp_string_matching("fjuopqsiieydlypusper", "ypusper"))
print("Brute:", brute_string_matching("hezyxkyufkhcidlidxvp", "kyufkhcidli"))
print("RKS:", rabin_karp_string_matching("hezyxkyufkhcidlidxvp", "kyufkhcidli"))
print("Brute:", brute_string_matching("tumwqxxzowgrgsyutrbh", "wqx"))
print("RKS:", rabin_karp_string_matching("tumwqxxzowgrgsyutrbh", "wqx"))
print("Brute:", brute_string_matching("pyqqwmvhamqoazleabsg", "mq"))
print("RKS:", rabin_karp_string_matching("pyqqwmvhamqoazleabsg", "mq"))
print("Brute:", brute_string_matching("owufmoiktjswtqpwdwgh", "wufm"))
print("RKS:", rabin_karp_string_matching("owufmoiktjswtqpwdwgh", "wufm"))
print("Brute:", brute_string_matching("xlbrwchynbmjniklkxuj", "klkx"))
print("RKS:", rabin_karp_string_matching("xlbrwchynbmjniklkxuj", "klkx"))
print("Brute:", brute_string_matching("xwsjklkgkwbrznlulfmq", "sjklkgkwbrznlulfm"))
print("RKS:", rabin_karp_string_matching("xwsjklkgkwbrznlulfmq", "sjklkgkwbrznlulfm"))
print("Brute:", brute_string_matching("aaaaaaaaaa"*1000 + "b", "aaaaaaaaaaa"*100 + "b"))
print("RKS:", rabin_karp_string_matching("aaaaaaaaaa"*1000 + "b", "aaaaaaaaaaa"*100 + "b"))
print("Brute:", brute_string_matching("aaaaaaaaaa"*10000 + "b", "aaaaaaaaaaaaa"*100 + "b"))
print("RKS:", rabin_karp_string_matching("aaaaaaaaaa"*10000 + "b", "aaaaaaaaaaaaa"*100 + "b"))
