#include <iostream>

using namespace std;

void selectionSort(int arr[], int n){
    for(int i = 0; i < n; ++i){
        int min_idx = i;
        for(int j = i + 1; j < n; ++j){
            if(arr[j] < arr[min_idx]){
                min_idx = j;
            }
        }
        //swap element at min_idx with element at i
        swap(arr[i], arr[min_idx]);
    }
}

void print(int arr[], int n){
    for(int i = 0; i < n; i++){
        cout << arr[i] << " ";
    }
    cout << endl;
}

int main(){

    array<int, 7> arr = {3, 7, 1, 34, 12, 82, 2};
    selectionSort(arr.data(), arr.size());
    print(arr.data(), arr.size());
    return 0;
}

/*
3. Selection Sort
Intuition: Scan the entire list for the smallest item and swap it with the first
position. Then find the next smallest and swap it with the second position, and
so on.
Approach: Divides the input list into two parts: a sorted sublist and an unsorted
sublist. It repeatedly finds the minimum element from the unsorted part and
moves it to the end of the sorted part.

Complexity
 Time: Best/Worst/Avg: O(n^2)
 Space: O(1)

*/