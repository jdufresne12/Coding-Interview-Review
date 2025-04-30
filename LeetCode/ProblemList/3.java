class LongestSubWithoutRepeat {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        
        // Int array holding all ASCII Character, each initit to 
        int[] charPosition = new int[128];
        for (int i = 0; i < 128; i++) {
            charPosition[i] = -1;
        }
        
        int maxLength = 0;    
        int start = 0;      

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            System.out.println(currentChar);

            if (charPosition[currentChar] >= start) {
                start = charPosition[currentChar] + 1;
            } else {
                maxLength = Math.max(maxLength, end - start + 1);
            }
            
            charPosition[currentChar] = end;
        }
        
        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubWithoutRepeat solution = new LongestSubWithoutRepeat();
        
        // Test cases
        String[] testInputs = {
            "abcabcbb",    // Expected: 3 ("abc")
            // "bbbbb",       // Expected: 1 ("b")
            // "pwwkew",      // Expected: 3 ("wke")
            // "",           // Expected: 0
            // " ",          // Expected: 1
            // "au",         // Expected: 2
            // "dvdf",       // Expected: 3
            // "aab",        // Expected: 2
            // "abba"        // Expected: 2
        };
        
        // int[] expectedOutputs = {3, 1, 3, 0, 1, 2, 3, 2, 2};
        int[] expectedOutputs = {3};
        
        // Run tests
        for (int i = 0; i < testInputs.length; i++) {
            int result = solution.lengthOfLongestSubstring(testInputs[i]);
            System.out.printf("Input: \"%s\"%n", testInputs[i]);
            System.out.printf("Expected: %d, Got: %d%n", expectedOutputs[i], result);
            System.out.println("Test " + (result == expectedOutputs[i] ? "PASSED" : "FAILED"));
            System.out.println();
        }
    }
}