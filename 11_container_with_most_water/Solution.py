#
# @lc app=leetcode id=11 lang=python3
#
# [11] Container With Most Water
#
# https://leetcode.com/problems/container-with-most-water/description/
#
# algorithms
# Medium (61.03%)
# Likes:    35234
# Dislikes: 2280
# Total Accepted:    6M
# Total Submissions: 9.9M
# Testcase Example:  '[1,8,6,2,5,4,8,3,7]'
#
# You are given an integer array height of length n. There are n vertical lines
# drawn such that the two endpoints of the i^th line are (i, 0) and (i,
# height[i]).
# 
# Find two lines that together with the x-axis form a container, such that the
# container contains the most water.
# 
# Return the maximum amount of water a container can store.
# 
# Notice that you may not slant the container.
# 
# 
# Example 1:
# 
# 
# Input: height = [1,8,6,2,5,4,8,3,7]
# Output: 49
# Explanation: The above vertical lines are represented by array
# [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the
# container can contain is 49.
# 
# 
# Example 2:
# 
# 
# Input: height = [1,1]
# Output: 1
# 
# 
# 
# Constraints:
# 
# 
# n == height.length
# 2 <= n <= 10^5
# 0 <= height[i] <= 10^4
# 
# 
#

# @lc code=start
class Solution:
    def maxArea(self, height: list[int]) -> int:

        left = 0
        right = len(height) - 1

        max_area = 0

        while left < right:

            current_area = (min(height[right], height[left])) * (right - left)
            print(f"[DUBUG]: Current area is: {current_area}")

            if height[left] < height[right]:
                left += 1

            else:
                right -= 1

            if max_area < current_area:
                max_area = current_area
                print(f"[DUBUG]: Updated max area is: {max_area}")

        return max_area
        
# @lc code=end
solution = Solution()
height = [1,3,2,5,25,24,5]
result = solution.maxArea(height)

print(f"Result = {result}")