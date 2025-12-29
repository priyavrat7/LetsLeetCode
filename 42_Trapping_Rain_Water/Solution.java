class Solution {
    public int trap(int[] height) {

        int left = 0;
        int right = height.length - 1; // 11

        int water = 0;

        int left_max = height[left];
        int right_max = height[right];

        // System.out.println(left + ", " + right);

        while(left < right){
            if(height[left] <= height[right]){
                left_max = Math.max(left_max, height[left]);
                water += left_max - height[left];
                left ++;
            }
            else{
                right_max = Math.max(right_max, height[right]);
                water += right_max - height[right];
                right --;
            }
        }

        return water;
    }
}