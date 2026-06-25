class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int count = 0;
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            int majorityCount = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] == target) {
                    majorityCount++;
                }
                if (majorityCount > (j - i + 1) / 2) {
                    count++;
                }
            }
        }
        
        return count;
    }
}