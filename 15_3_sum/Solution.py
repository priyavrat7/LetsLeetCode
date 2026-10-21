#
# @lc app=leetcode id=15 lang=python3
#
# [15] 3Sum
#
# https://leetcode.com/problems/3sum/description/
#
# algorithms
# Medium (40.07%)
# Likes:    36586
# Dislikes: 3343
# Total Accepted:    6.6M
# Total Submissions: 16.5M
# Testcase Example:  '[-1,0,1,2,-1,-4]'
#
# Given an integer array nums, return all the triplets [nums[i], nums[j],
# nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] +
# nums[k] == 0.
# 
# Notice that the solution set must not contain duplicate triplets.
# 
# 
# Example 1:
# 
# 
# Input: nums = [-1,0,1,2,-1,-4]
# Output: [[-1,-1,2],[-1,0,1]]
# Explanation: 
# nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
# nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
# nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
# The distinct triplets are [-1,0,1] and [-1,-1,2].
# Notice that the order of the output and the order of the triplets does not
# matter.
# 
# 
# Example 2:
# 
# 
# Input: nums = [0,1,1]
# Output: []
# Explanation: The only possible triplet does not sum up to 0.
# 
# 
# Example 3:
# 
# 
# Input: nums = [0,0,0]
# Output: [[0,0,0]]
# Explanation: The only possible triplet sums up to 0.
# 
# 
# 
# Constraints:
# 
# 
# 3 <= nums.length <= 3000
# -10^5 <= nums[i] <= 10^5
# 
# 
#

# @lc code=start
class Solution:
    def threeSum(self, nums: list[int]) -> list[list[int]]:

        nums.sort()
        n = len(nums)
        print(f"[DEBUG]: Sorted nums = {nums}")
        answer = []

        for i in range(n - 2):

            # Skip duplicate
            if i > 0 and nums[i] == nums[i - 1]:
                continue

            left = i + 1
            right = n - 1
            target = -nums[i]

            while left < right:
                left_right_sum = nums[left] + nums[right]

                if left_right_sum == target:
                    answer.append([nums[i], nums[left], nums[right]])
                    left += 1
                    right -= 1

                    # Skip duplicates for left
                    while left < right and nums[left] == nums[left - 1]:
                        left += 1

                    # Skip duplicates for right
                    while left < right and nums[right] == nums[right + 1]:
                        right -= 1


                elif left_right_sum < target:
                    left += 1

                else:
                    right -= 1

        return answer


        
# @lc code=end

solution = Solution()
nums = [-1,0,1,2,-1,-4]
result = solution.threeSum(nums)
print(f"Output is: {result}")