package faith_slms;

public class CacheService {
    
    private String[] searchCache;
    private String[] inputCache;
    private int searchCacheCount;
    private int inputCacheCount;
    private final int MAX_SIZE = 100;

    public CacheService() {
        this.searchCache = new String[MAX_SIZE];
        this.inputCache = new String[MAX_SIZE];
        this.searchCacheCount = 0;
        this.inputCacheCount = 0;
    }

    // Adds a searched term (like a Course Code) to the cache
    public void cacheSearchTerm(String term) {
        if (!contains(term) && searchCacheCount < MAX_SIZE) {
            searchCache[searchCacheCount++] = term;
        }
    }

    // Adds a value (like a Student Name) to the cache
    public void cacheInputValue(String value) {
        if (!contains(value) && inputCacheCount < MAX_SIZE) {
            inputCache[inputCacheCount++] = value;
        }
    }

    // Returns all cached searches
    public String[] getCachedSearches() {
        return java.util.Arrays.copyOf(searchCache, searchCacheCount);
    }

    // Returns all cached inputs
    public String[] getCachedInputs() {
        return java.util.Arrays.copyOf(inputCache, inputCacheCount);
    }

    // Helper method to check for duplicates so the cache stays clean
    public boolean contains(String value) {
        for (int i = 0; i < searchCacheCount; i++) {
            if (searchCache[i].equalsIgnoreCase(value)) return true;
        }
        for (int i = 0; i < inputCacheCount; i++) {
            if (inputCache[i].equalsIgnoreCase(value)) return true;
        }
        return false;
    }
}
