import java.util.ArrayList;
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int c1 = 0;
        int c2 = 0;
        double median;

        //int final [] = new int[len(c1) + len(c2)];

        ArrayList<Integer> combined = new ArrayList<>();

        while(c1 < nums1.length && c2 < nums2.length){
            if(nums1[c1] < nums2[c2]){
                combined.add(nums1[c1]);
                c1++;
            }
            else{
                combined.add(nums2[c2]);
                c2++;
            }
        }

        // Now, drain the remaining elements
        while(c1 < nums1.length){
            combined.add(nums1[c1]);
            c1++;
        }

        while(c2 < nums2.length){
            combined.add(nums2[c2]);
            c2++;
        }

        int mid = combined.size() / 2;


        if (combined.size() % 2 == 0){
            median = (combined.get(mid) + combined.get(mid - 1)) / 2.0;
        }
        else{
            median = combined.get(mid);
        }
        return median;
        
    }
}
/*
    Commonly used functions of ArrayList in Java:

    1. add(E e)
       - Appends the specified element to the end of the list.
         Example: arrayList.add(10);

    2. get(int index)
       - Returns the element at the specified position in the list.
         Example: int value = arrayList.get(0);

    3. set(int index, E element)
       - Replaces the element at the specified position with the specified element.
         Example: arrayList.set(0, 20);

    4. remove(int index)
       - Removes the element at the specified position in the list.
         Example: arrayList.remove(0);

    5. size()
       - Returns the number of elements in the list.
         Example: int count = arrayList.size();

    6. isEmpty()
       - Returns true if the list contains no elements.
         Example: boolean empty = arrayList.isEmpty();

    7. clear()
       - Removes all of the elements from the list.
         Example: arrayList.clear();

    8. contains(Object o)
       - Returns true if the list contains the specified element.
         Example: boolean exists = arrayList.contains(10);
*/
