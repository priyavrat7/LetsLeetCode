#include <iostream>

using namespace std;

void bubbleSort(int arr[], int n){
    bool swap = false;
    for(int i = 0; i < n - 1; ++i){
        for(int j = 0; j < n - i - 1; ++j){
            if(arr[j] > arr[j+1]){
                arr[j] = arr[j] ^ arr[j+1];
                arr[j+1] = arr[j] ^ arr[j+1];
                arr[j] = arr[j] ^ arr[j+1];
                swap = true;
            }
        }
        if(!swap){break;}
    }
}

void print(int arr[], int size){
    for(int i = 0; i < size; ++i){
        cout << arr[i] << " ";
    }
    cout << endl;
}

int main(){
    int arr[] = {64, 34, 25, 12, 22, 11, 90};

    int size = sizeof(arr) / sizeof(arr[0]);

    cout << "Size of arr = " << size << endl;

    array<int, 7> arr1 = {1, 2, 3, 4, 5, 6, 7};

    cout << "Size of arr1 = " << arr1.size() << endl;

    bubbleSort(arr, size);
    print(arr, size);
    
    return 0;
}
// Time complexity: O(n^2) in worst and average case, O(n) in best case
// Space complexity: O(1)

/*
1. Bubble Sort
Intuition: Imagine bubbles rising to the surface. In each "pass," the largest
element "bubbles up" to its correct position at the end of the array by comparing
adjacent pairs.
Approach: Repeatedly steps through the list, compares adjacent elements, and
swaps them if they are in the wrong order.
*/
