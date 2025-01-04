public class MurmurHash3 {
	
	
	
    private static final int C1 = 0xcc9e2d51; //3432918353
    private static final int C2 = 0x1b873593; //461845907
    private static final int R1 = 15;
    private static final int R2 = 13;
    private static final int M = 5;
    private static final int N = 0xe6546b64; //3864292196

    
    
    
    /**
     * Computes the MurmurHash3 hash of a byte array.
     *
     * @param data The input byte array to hash
     * @param seed The seed value for the hash
     * @return The 32-bit hash value
     */
    
    
    public static int hash32(byte[] data, int seed) {
        int length = data.length;
        int hash = seed;
        int nblocks = length / 4;

        
        for (int i = 0; i < nblocks; i++) {
            int i4 = i * 4;
            int k1 = getBlock32(data, i4);

            k1 = mixK1(k1);
            hash = mixH1(hash, k1);
        }

       
        int tail = nblocks * 4;
        int k1 = 0;
        switch (length & 3) {
            case 3:
                k1 ^= (data[tail + 2] & 0xff) << 16;  //255
                
            case 2:
                k1 ^= (data[tail + 1] & 0xff) << 8;
                
            case 1:
                k1 ^= (data[tail] & 0xff);
                k1 = mixK1(k1);
                hash ^= k1;
        }
        
        

        
        hash ^= length;
        hash = fmix32(hash);

        return hash;
    }

    /**
     * Converts four bytes of the input array into a 32-bit integer.
     */
    
    
    private static int getBlock32(byte[] data, int index) {
        return ((data[index] & 0xff)) |           //255
               ((data[index + 1] & 0xff) << 8) |
               ((data[index + 2] & 0xff) << 16) |
               ((data[index + 3] & 0xff) << 24);
    }

    
    
    /**
     * Performs the initial mixing of key.
     */
    
    
    private static int mixK1(int k1) {
        k1 *= C1;
        k1 = Integer.rotateLeft(k1, R1);
        k1 *= C2;
        return k1;
    }

    
    
    /**
     * Performs the mixing of the hash value.
     */
    
    
    private static int mixH1(int h1, int k1) {
        h1 ^= k1;
        h1 = Integer.rotateLeft(h1, R2);
        h1 = h1 * M + N;
        return h1;
    }

    
    
    /**
     * Final mixing of bits.
     */
    
    private static int fmix32(int h1) {
        h1 ^= h1 >>> 16;
        h1 *= 0x85ebca6b;   //2246822507
        h1 ^= h1 >>> 13;
        h1 *= 0xc2b2ae35;   //3266489909
        h1 ^= h1 >>> 16;
        return h1;
    }

    /**
     * Utility method to convert a string to its hash value.
     */
    public static int hashString(String text, int seed) {
        return hash32(text.getBytes(), seed);
    }

    
    public static void main(String[] args) {
        
    	String testString = "Hello, World!";
        int seed = 42;
        byte[] data = testString.getBytes();
        int hash = hash32(data, seed);
        
        System.out.println(hash);
    }
}




//int hash = hashString(testString, seed);
//System.out.println("Hash of '" + testString + "': " + hash);

// Test consistency
//int hash2 = hashString(testString, seed);
//System.out.println("Second hash of same input: " + hash2);

// Test different input
//String testString2 = "Hello, World"; // Missing !
//int hash3 = hashString(testString2, seed);
//System.out.println("Hash of slightly different input: " + hash3);
