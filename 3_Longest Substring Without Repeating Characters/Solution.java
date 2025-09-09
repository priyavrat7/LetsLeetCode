import java.util.HashMap;
//import java.lang.Math; // imported implicitly by java
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int left = 0;
        int maxLength = 0;

        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            while(hm.containsKey(c)){
                hm.remove(s.charAt(left));
                left++;
            }
            hm.put(c, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }

    public static void main(String[] args) {}
}
