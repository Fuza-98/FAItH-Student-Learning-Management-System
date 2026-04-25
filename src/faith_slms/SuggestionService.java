package faith_slms;

import java.util.*;

/**
 * SuggestionService
 * 
 * This class acts as a middleware API to:
 * - Cache student IDs and course codes
 * - Provide auto-suggestions based on prefix input
 * 
 * Used for Lab 7 & Lab 8 (API + caching requirement)
 */
public class SuggestionService {
    
    private CacheService cacheService;
    private ArrayList<String> studentCache = new ArrayList<>();
    private ArrayList<String> courseCache = new ArrayList<>();

    /**
     * Constructor
     * Initialize empty cache lists
     */
    public SuggestionService(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    /**
     * Add student ID into cache
     * Prevent duplicate values
     */
    public void addStudentID(String id) {
        if (!studentCache.contains(id)) {
            studentCache.add(id);
        }
    }

    /**
     * Add course code into cache
     * Prevent duplicate values
     */
    public void addCourseCode(String code) {
        if (!courseCache.contains(code)) {
            courseCache.add(code);
        }
    }

    /**
     * Suggest from BOTH caches (student IDs + course codes)
     * Based on prefix input
     */
    public String[] suggestFromCache(String prefix) {
    ArrayList<String> results = new ArrayList<>();

    // Fetch data from the actual CacheService
    String[] searchHistory = cacheService.getCachedSearches();
    String[] inputHistory = cacheService.getCachedInputs();

    // Search through searchHistory
    for (String item : searchHistory) {
        if (item != null && item.toLowerCase().startsWith(prefix.toLowerCase())) {
            results.add(item);
        }
    }

    // Search through inputHistory
    for (String item : inputHistory) {
        if (item != null && item.toLowerCase().startsWith(prefix.toLowerCase())) {
            // Avoid adding same thing twice if it's in both caches
            if (!results.contains(item)) {
                results.add(item);
            }
        }
    }

    return results.toArray(new String[0]);
}

    /**
     * Suggest course codes ONLY
     */
    public String[] suggestCourseCodes(String prefix, Course[] courses) {
    ArrayList<String> results = new ArrayList<>();

    for (int i = 0; i < courses.length; i++) {
        if (courses[i] != null) {
            String code = courses[i].getCode();

            cacheService.cacheInputValue(code);

            if (code.toLowerCase().startsWith(prefix.toLowerCase())) {
                results.add(code);
            }
        }
    }
    return results.toArray(new String[0]);
}

    /**
     * Suggest student IDs ONLY
     */
    public String[] suggestStudentIDs(String prefix, Student[] students) {
        ArrayList<String> results = new ArrayList<>();

        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                String id = students[i].getID();

                cacheService.cacheInputValue(id);

           if (id.toLowerCase().startsWith(prefix.toLowerCase())) {
                results.add(id);
                }
            }
        }

        return results.toArray(new String[0]);
    }
}
