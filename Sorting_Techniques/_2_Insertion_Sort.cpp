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