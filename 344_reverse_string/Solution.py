#
# @lc app=leetcode id=344 lang=python3
#
# [344] Reverse String
#
# https://leetcode.com/problems/reverse-string/description/
#
# algorithms
# Easy (81.46%)
# Likes:    9849
# Dislikes: 1230
# Total Accepted:    4.2M
# Total Submissions: 5.2M
# Testcase Example:  '["h","e","l","l","o"]'
#
# Write a function that reverses a string. The input string is given as an
# array of characters s.
# 
# You must do this by modifying the input array in-place with O(1) extra
# memory.
# 
# 
# Example 1:
# Input: s = ["h","e","l","l","o"]
# Output: ["o","l","l","e","h"]
# Example 2:
# Input: s = ["H","a","n","n","a","h"]
# Output: ["h","a","n","n","a","H"]
# 
# 
# Constraints:
# 
# 
# 1 <= s.length <= 10^5
# s[i] is a printable ascii character.
# 
# 
#

# @lc code=start
class Solution:
    def reverseString(self, s: list[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """

        start = 0
        end = len(s) - 1

        while end > start:
            s[start], s[end] = s[end], s[start]
            start += 1
            end -= 1

        return s
        
# @lc code=end
solution = Solution()
s = ["H","a","n","n","a","h"]
result = solution.reverseString(s)
print(result)