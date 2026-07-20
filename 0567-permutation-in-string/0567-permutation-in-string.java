class Solution {
    public boolean checkInclusion(String s1, String s2) {
      int[] count = new int[26];
        for (char c : s1.toCharArray()) {
            count[c - 'a']++;
        }
        
        int left = 0, right = 0, required = s1.length();
        
        while (right < s2.length()) {
            char c = s2.charAt(right);
            if (count[c - 'a'] > 0) {
                required--;
            }
            count[c - 'a']--;
            right++;
            
            if (required == 0) {
                return true;
            }
            
            if (right - left == s1.length()) {
                char leftChar = s2.charAt(left);
                if (count[leftChar - 'a'] >= 0) {
                    required++;
                }
                count[leftChar - 'a']++;
                left++;
            }
        }
        
        return false;  
    }
}