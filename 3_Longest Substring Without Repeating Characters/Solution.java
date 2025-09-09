import java.util.HashSet;
//import java.lang.Math;
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet<>();
        int left = 0;
        int maxLength = 0;

        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            while(hs.contains(c)){
                hs.remove(s.charAt(left));
                left++;
            }
            hs.add(c);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }

    public static void main(String[] args) {}
}
