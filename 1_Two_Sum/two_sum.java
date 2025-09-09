import java.util.HashMap;
class two_sum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < nums.length; ++i){
            int finder = target - nums[i];
            
            if(hm.containsKey(finder)){
                int[] vals = {i, hm.get(finder)};
                return vals;
            }
            hm.put(nums[i], i);
        }
        return null;
    }
    public static void main(String[] args){
        //dummy test case
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        two_sum ts = new two_sum();
        int[] result = ts.twoSum(nums, target);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }
    
}


/*
    Commonly used functions of HashMap in Java:

    1. put(K key, V value)
       - Adds a key-value pair to the map.
         Example: hashMap.put(1, 100);

    2. get(Object key)
       - Returns the value to which the specified key is mapped, or null if the map contains no mapping for the key.
         Example: Integer value = hashMap.get(1);

    3. containsKey(Object key)
       - Returns true if the map contains a mapping for the specified key.
         Example: boolean exists = hashMap.containsKey(1);

    4. containsValue(Object value)
       - Returns true if the map maps one or more keys to the specified value.
         Example: boolean hasValue = hashMap.containsValue(100);

    5. remove(Object key)
       - Removes the mapping for the specified key if present.
         Example: hashMap.remove(1);

    6. size()
       - Returns the number of key-value mappings in the map.
         Example: int size = hashMap.size();

    7. isEmpty()
       - Returns true if the map contains no key-value mappings.
         Example: boolean empty = hashMap.isEmpty();

    8. clear()
       - Removes all of the mappings from the map.
         Example: hashMap.clear();

    9. keySet()
       - Returns a Set view of the keys contained in the map.
         Example: Set<Integer> keys = hashMap.keySet();

    10. values()
        - Returns a Collection view of the values contained in the map.
          Example: Collection<Integer> values = hashMap.values();

    11. entrySet()
        - Returns a Set view of the mappings contained in the map.
          Example: Set<Map.Entry<Integer, Integer>> entries = hashMap.entrySet();
*/


