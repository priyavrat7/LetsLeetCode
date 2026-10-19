#
# @lc app=leetcode id=125 lang=python3
#
# [125] Valid Palindrome
#
# https://leetcode.com/problems/valid-palindrome/description/
#
# algorithms
# Easy (54.52%)
# Likes:    12182
# Dislikes: 8672
# Total Accepted:    6.1M
# Total Submissions: 11.2M
# Testcase Example:  '"A man, a plan, a canal: Panama"'
#
# A phrase is a palindrome if, after converting all uppercase letters into
# lowercase letters and removing all non-alphanumeric characters, it reads the
# same forward and backward. Alphanumeric characters include letters and
# numbers.
# 
# Given a string s, return true if it is a palindrome, or false otherwise.
# 
# 
# Example 1:
# 
# 
# Input: s = "A man, a plan, a canal: Panama"
# Output: true
# Explanation: "amanaplanacanalpanama" is a palindrome.
# 
# 
# Example 2:
# 
# 
# Input: s = "race a car"
# Output: false
# Explanation: "raceacar" is not a palindrome.
# 
# 
# Example 3:
# 
# 
# Input: s = " "
# Output: true
# Explanation: s is an empty string "" after removing non-alphanumeric
# characters.
# Since an empty string reads the same forward and backward, it is a
# palindrome.
# 
# 
# 
# Constraints:
# 
# 
# 1 <= s.length <= 2 * 10^5
# s consists only of printable ASCII characters.
# 
# 
#

# @lc code=start
class Solution:
    def isPalindrome(self, s: str) -> bool:

        string = ""

        for i in range(len(s)):
            if s[i].isalnum():
                string = string + s[i].lower()

        print(f"Sanatized string is: {string}\n")

        left = 0
        right = len(string) - 1

        while left < right:
            if string[left] != string[right]:
                return False

            left += 1
            right -= 1

        return True

solution = Solution()
s = "A man, a plan, a canal: Panama"
result = solution.isPalindrome(s)
print(result)
        
# @lc code=end

