class Solution:
    def trap(self, height: List[int]) -> int:
        left = 0
        right = len(height) - 1
        water = 0

        left_max = height[left]
        right_max = height[right]

        while(left < right):
            if (height[left] <= height[right]):
                left_max = max(left_max, height[left])
                water += left_max - height[left]
                left += 1

            else:
                right_max = max(right_max, height[right])
                water += right_max - height[right]
                right -= 1
        
        return water
        