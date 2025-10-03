import java.util.ArrayList;
import java.util.List;

public class _1_array_arraylist {

    public static void printList(List<String> list){
        for(String item : list){
            System.out.println(item);
        }
    }
    public static void main(String[] args){
        final int size = 10;
        int arr[] = new int[size];
        String arr1[] = new String[size];

        List<String> list = new ArrayList<>();

        // List<String> list1 = new List<>(); // We cannot instantiate List directly because it's an interface, not a concrete class

        ArrayList<String> arrlist = new ArrayList<>();

        list.add("Hello");
        list.add("World");
        list.add("C++");
        list.add("Java8");

        list.set(2, "Java7");

        //list.remove("Java7");

        printList(list);

        System.out.println("List size: " + list.size());

        list.clear();

        System.out.println("Is the list empty: " + list.isEmpty());
    }
}

// Basic functions of ArrayList in Java:
//
// 1. Creating an ArrayList:
//    ArrayList<String> list = new ArrayList<>();
//
// 2. Adding elements:
//    list.add("Apple");
//    list.add("Banana");
//
// 3. Accessing elements:
//    String fruit = list.get(0); // Gets the first element
//
// 4. Modifying elements:
//    list.set(1, "Orange"); // Changes "Banana" to "Orange"
//
// 5. Removing elements:
//    list.remove("Apple"); // Removes "Apple" by value
//    list.remove(0);       // Removes element at index 0
//
// 6. Checking size:
//    int size = list.size();
//
// 7. Checking if empty:
//    boolean isEmpty = list.isEmpty();
//
// 8. Checking if contains an element:
//    boolean hasApple = list.contains("Apple");
//
// 9. Iterating through elements:
//    for(String item : list) {
//        System.out.println(item);
//    }
//
// 10. Clearing all elements:
//     list.clear();



