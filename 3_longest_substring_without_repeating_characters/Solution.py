#
# @lc app=leetcode id=3 lang=python3
#
# [3] Longest Substring Without Repeating Characters
#
# https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
#
# algorithms
# Medium (40.01%)
# Likes:    46028
# Dislikes: 2254
# Total Accepted:    10.5M
# Total Submissions: 26.2M
# Testcase Example:  '"abcabcbb"'
#
# Given a string s, find the length of the longest substring without duplicate
# characters.
# 
# 
# Example 1:
# 
# 
# Input: s = "abcabcbb"
# Output: 3
# Explanation: The answer is "abc", with the length of 3. Note that "bca" and
# "cab" are also correct answers.
# 
# 
# Example 2:
# 
# 
# Input: s = "bbbbb"
# Output: 1
# Explanation: The answer is "b", with the length of 1.
# 
# 
# Example 3:
# 
# 
# Input: s = "pwwkew"
# Output: 3
# Explanation: The answer is "wke", with the length of 3.
# Notice that the answer must be a substring, "pwke" is a subsequence and not a
# substring.
# 
# 
# 
# Constraints:
# 
# 
# 0 <= s.length <= 10^5
# s consists of English letters, digits, symbols and spaces.
# 
# 
#

# @lc code=start
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        myset = set()
        max_count = 0
        left = 0

        for right in range(len(s)):
            # Shrink from left untill the duplicate is gone
            while s[right] in myset:
                myset.remove(s[left])
                left += 1

            # Add into the set
            myset.add(s[right])

            # The current window size will be (right - left + 1)
            max_count = max(max_count, right - left + 1)

        return max_count

        
# @lc code=end
# It is a classic sliding window problem
# Hint: Keep adding to right side and remove from left
# till we remove all the duplicates
solution = Solution()
s = "abcabcbb"
result = solution.lengthOfLongestSubstring(s)
print(f"Result is: {result}")
