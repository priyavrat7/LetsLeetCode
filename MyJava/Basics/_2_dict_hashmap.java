import java.util.HashMap;

public class _2_dict_hashmap {

    public static void printMap(HashMap<String, Integer> map){
        for(String key : map.keySet()){
            System.out.println(key + ": " + map.get(key));
        }
    }
    public static void main(String[] args){
        HashMap<String, Integer> map = new HashMap<>();


        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Orange", 30);

        printMap(map);


        map.remove("Apple");


    }

}
// Basic functions of HashMap in Java:
//
// 1. Creating a HashMap:
//    HashMap<KeyType, ValueType> map = new HashMap<>();
//
// 2. Adding key-value pairs:
//    map.put("Apple", 10);
//    map.put("Banana", 20);
//
// 3. Accessing a value by key:
//    int value = map.get("Apple"); // returns 10
//
// 4. Checking if a key exists:
//    boolean hasKey = map.containsKey("Banana");
//
// 5. Checking if a value exists:
//    boolean hasValue = map.containsValue(20);
//
// 6. Removing a key-value pair:
//    map.remove("Apple");
//
// 7. Iterating over keys:
//    for(String key : map.keySet()) {
//        System.out.println(key);
//    }
//
// 8. Iterating over values:
//    for(Integer val : map.values()) {
//        System.out.println(val);
//    }
//
// 9. Iterating over key-value pairs:
//    for(Map.Entry<String, Integer> entry : map.entrySet()) {
//        System.out.println(entry.getKey() + ": " + entry.getValue());
//    }
//
// 10. Getting the size of the map:
//     int size = map.size();
//
// 11. Clearing the map:
//     map.clear();
//
// 12. Checking if the map is empty:
//     boolean empty = map.isEmpty();
