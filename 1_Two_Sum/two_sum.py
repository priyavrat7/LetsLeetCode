# LeetCode 1. Two Sum
class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        # This creates a hash table where key = index, value = element
        # For example: {0:2, 1:7, 2:11, 3:15}
        my_hash_table = {} # class 'dist'
        print(type(my_hash_table))
        for i in range(len(nums)):
            my_hash_table[i] = nums[i]

        # This uses a double loop to check every possible pair of indices
        # For each index i, it checks all other indices k (where i != k)
        # and sees if their corresponding numbers add up to the target.
        for i in range(len(nums)):
            for k, v in my_hash_table.items():
                print(f"Key: {k}, Value: {v}")
                if i != k and nums[i] + v == target:
                    return [i, k]
        # If no pair is found, None is returned (not required for LeetCode, but good practice to handle)


class OptimalSolution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        my_hash_table = {}
        
        for i in range(len(nums)):
            finder = target - nums[i]

            if finder in my_hash_table:
                return [i, my_hash_table[finder]]
            my_hash_table[nums[i]] = i

if __name__ == "__main__":
    # Example 1
    nums = [2, 7, 11, 15]
    target = 9
    sol = Solution()
    result = sol.twoSum(nums, target)
    print(result)  # Output: [0, 1]
    # The output should be the indices of the two numbers that add up to the target.
    # In this case, nums[0] + nums[1] = 2 + 7 = 9, so the output is [0, 1].
    # Note: sequence of indices does not matter, as long as they are correct, so [1, 0] would also be valid.

    # Example 2
    nums2 = [3, 2, 4]
    target2 = 6
    result2 = sol.twoSum(nums2, target2)
    print(result2)  # Output: [1, 2]        

    # Example 3
    nums3 = [3, 3]
    target3 = 6
    result3 = sol.twoSum(nums3, target3)
    print(result3) # Output: [0, 1]

# -------------------------------------------------------------------------
# Why is this not the optimal solution?
# -------------------------------------------------------------------------

# 1. Inefficient Time Complexity:
#    This code checks every possible pair of indices (i, k), resulting in O(n^2) time complexity.
#    For each index i, it loops through all indices again, which is slow for large lists.
#
# 2. Hash Table Not Used Effectively:
#    The hash table here is just a copy of the array (index as key, value as value).
#    The main benefit of a hash table in the two-sum problem is fast value look-up (O(1)),
#    but this code still brute-forces all pairs, so the hash table provides no real speedup.
#
# 3. Not Taking Advantage of Hash Map for Complements:
#    The optimal solution uses the hash table to directly check
#    "Have I already seen the complement (target - current number)?" as it loops through nums.
#    That allows it to solve the problem in a single pass with O(n) time complexity.

# -------------------------------------------------------------------------
# What is the optimal solution? (for reference)
# -------------------------------------------------------------------------

# class Solution(object):
#     def twoSum(self, nums, target):
#         my_hash_table = {}
#         for i, num in enumerate(nums):
#             complement = target - num
#             if complement in my_hash_table:
#                 return [my_hash_table[complement], i]
#             my_hash_table[num] = i

# - Here, the hash table maps {value: index} for instant look-up of complements.
# - Only one loop is needed, and each lookup/insertion is O(1).

sol_optimal = OptimalSolution()
result_optimal = sol_optimal.twoSum(nums, target)
print(result_optimal)  # Output: [0, 1] or [1, 0] depending on the order of indices
# This is the optimal solution with O(n) time complexity and O(n) space complexity.
# It efficiently finds the two indices whose values sum to the target using a single pass through the list and a hash table for quick lookups.
# The output should be the same as the previous solution, but it runs much faster for larger inputs.
# The optimal solution is more efficient and handles larger inputs effectively.
# The output should be the indices of the two numbers that add up to the target.
# In this case, nums[0] + nums[1] = 2 + 7 = 9, so the output is [0, 1].
