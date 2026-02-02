#include <iostream>

using namespace std;

void insertionSort(int arr[], int n){
    for(int i = 0; i < n; ++i){
        int key = arr[i];
        int j = i - 1;

        while(j>=0 && arr[j] > key){
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = key;

    }
}

void print(int arr[], int n){
    for(int i = 0; i < n; ++i){
        cout << arr[i] << " ";
    }
    cout << endl;
}

int main(){

    array<int, 7> arr = {3, 7, 1, 34, 12, 82, 2};
    insertionSort(arr.data(), arr.size());
    print(arr.data(), arr.size());

    return 0;
}
// Time: Best: O(n) | Worst/Avg: O(n^2)
// Space: O(1)
/*
2. Insertion Sort
Intuition: Like sorting a deck of cards in your hand. You pick one card at a time
and "insert" it into its correct position relative to the cards already in your hand.
Approach: Builds the final sorted array one item at a time. It is much less
efficient on large lists than more advanced algorithms.
*/