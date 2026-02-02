import java.util.HashSet;
//import java.lang.Math;
public class LongestSubstringWithoutRepeatingCharsSolution {
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
/*
    Commonly used functions of HashSet in Java:

    1. add(E e)
       - Adds the specified element to the set if it is not already present.
         Example: hashSet.add("apple");

    2. contains(Object o)
       - Returns true if the set contains the specified element.
         Example: boolean exists = hashSet.contains("apple");

    3. remove(Object o)
       - Removes the specified element from the set if it is present.
         Example: hashSet.remove("apple");

    4. size()
       - Returns the number of elements in the set.
         Example: int count = hashSet.size();

    5. isEmpty()
       - Returns true if the set contains no elements.
         Example: boolean empty = hashSet.isEmpty();

    6. clear()
       - Removes all of the elements from the set.
         Example: hashSet.clear();

    7. iterator()
       - Returns an iterator over the elements in the set.
         Example: Iterator<String> it = hashSet.iterator();
*/
