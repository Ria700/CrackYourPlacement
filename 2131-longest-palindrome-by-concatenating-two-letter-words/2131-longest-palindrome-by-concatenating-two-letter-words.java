class Solution {
    //conditions on non-palindrome
        // count = count of reverse (even count)
    // conditions on palindrome / centrals
        // if it is central: can occure ODD/even
        // if it is non-central: even only
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> count = new HashMap<String, Integer>();
        // setting up HashMap
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        int answer = 0;
        boolean central = false; // odd frequency of any palindrmic pair
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            String word = entry.getKey();
            int countOfTheWord = entry.getValue();
            // if the word is a palindrome
            if (word.charAt(0) == word.charAt(1)) {
                if (countOfTheWord % 2 == 0) {
                    answer += countOfTheWord;
                } else {
                    answer += countOfTheWord - 1;
                    central = true; // we ann only have one central
                }
            // consider a pair of non-palindrome words such that one is the reverse of another
            } else if (word.charAt(0) < word.charAt(1)) { // wew want to consider ab and ba only once
                String reversedWord = "" + word.charAt(1) + word.charAt(0);
                if (count.containsKey(reversedWord)) {
                    answer += 2 * Math.min(countOfTheWord, count.get(reversedWord));
                }
            }
        }
        if (central) {
            answer++;
        }
        return 2 * answer;
    }
};