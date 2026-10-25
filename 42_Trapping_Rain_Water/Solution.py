#
# @lc app=leetcode id=42 lang=python3
#
# [42] Trapping Rain Water
#
# https://leetcode.com/problems/trapping-rain-water/description/
#
# algorithms
# Hard (68.41%)
# Likes:    37311
# Dislikes: 737
# Total Accepted:    4M
# Total Submissions: 5.8M
# Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
#
# Given n non-negative integers representing an elevation map where the width
# of each bar is 1, compute how much water it can trap after raining.
# 
# 
# Example 1:
# 
# 
# Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
# Output: 6
# Explanation: The above elevation map (black section) is represented by array
# [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section)
# are being trapped.
# 
# 
# Example 2:
# 
# 
# Input: height = [4,2,0,3,2,5]
# Output: 9
# 
# 
# 
# Constraints:
# 
# 
# n == height.length
# 1 <= n <= 2 * 10^4
# 0 <= height[i] <= 10^5
# 
# 
#

# @lc code=start
class Solution:
    def trap(self, height: list[int]) -> int:
        water = 0
        left = 0
        right = len(height) - 1

        left_max = height[left]
        right_max = height[right]

        while left < right:
            if height[left] < height[right]:
                left_max = max(left_max, height[left])
                water += left_max - height[left]
                left += 1

            else:
                right_max = max(right_max, height[right])
                water += right_max - height[right]
                right -= 1

        return water


solution = Solution()
height = [0,1,0,2,1,0,1,3,2,1,2,1]
result = solution.trap(height)

print(f"Result is: {result}")
        
        
# @lc code=end

