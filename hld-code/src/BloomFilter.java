import java.util.BitSet;

public class BloomFilter {

    private static final int DEFAULT_SIZE = 1 << 24; // ~16 million bits
    private static final int[] SEEDS = {7, 11, 13, 31, 37, 61};

    private final BitSet bits = new BitSet(DEFAULT_SIZE);

    public void add(String value) {
        for (int seed : SEEDS) {
            int hash = hash(value, seed);
            bits.set(hash);
        }
    }

    public boolean mightContain(String value) {
        for (int seed : SEEDS) {
            int hash = hash(value, seed);
            if (!bits.get(hash)) {
                return false; // definitely not present
            }
        }
        return true; // might be present
    }

    private int hash(String value, int seed) {
        int result = 0;
        for (char c : value.toCharArray()) {
            result = seed * result + c;
        }
        return (DEFAULT_SIZE - 1) & result;
    }
}
