package DataStructures.Hashing;

public class HashFunction {
    public static int hashFunction(int key, int hSize) {
       return key%hSize;
    }
}
