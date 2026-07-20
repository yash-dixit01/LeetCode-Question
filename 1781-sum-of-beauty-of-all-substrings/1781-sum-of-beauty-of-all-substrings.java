class Solution {
    public int beautySum(String s) {
      int sum = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String substring = s.substring(i, j);
                int[] freq = new int[26];
                for (char c : substring.toCharArray()) {
                    freq[c - 'a']++;
                }
                int maxFreq = 0;
                int minFreq = Integer.MAX_VALUE;
                for (int f : freq) {
                    if (f > 0) {
                        maxFreq = Math.max(maxFreq, f);
                        minFreq = Math.min(minFreq, f);
                    }
                }
                sum += (maxFreq - minFreq);
            }
        }
        return sum;  
    }
}