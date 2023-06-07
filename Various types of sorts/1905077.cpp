#include <iostream>
#include <fstream>
#include <ctime>
#include <bits/stdc++.h>

using namespace std;

int n, k = 36, *R;
ofstream output;

void swap(int *a, int *b) {
  int t = *a;
  *a = *b;
  *b = t;
}

void printArray(int array[], int size) {
  int i;
  for (i = 0; i < size; i++)
    cout << array[i] << " ";
  cout << endl;
}


int partition(int array[], int low, int high) {

  int pivot = array[high];

  int i = (low - 1);

  for (int j = low; j < high; j++) {
    if (array[j] <= pivot) {

      i++;

      swap(&array[i], &array[j]);
    }
  }

  swap(&array[i + 1], &array[high]);

  return (i + 1);
}


void quickSort(int array[], int low, int high) {
  if (low < high) {
    int pi = partition(array, low, high);
    quickSort(array, low, pi - 1);
    quickSort(array, pi + 1, high);
  }
}
void randomizedQuickSort(int array[], int low, int high) {
  if (low < high) {
    //srand(time(NULL));
    int random = low + abs(rand()) % (high - low);

    swap(array[random], array[high]);

    int pi = partition(array, low, high);

    randomizedQuickSort(array, low, pi - 1);

    randomizedQuickSort(array, pi + 1, high);
  }
}
void merge(int arr[], int p, int q, int r) {

    int n1 = q - p + 1;
    int n2 = r - q;

    int L[n1], M[n2];

    for (int i = 0; i < n1; i++)
        L[i] = arr[p + i];
    for (int j = 0; j < n2; j++)
        M[j] = arr[q + 1 + j];

    int i, j, k;
    i = 0;
    j = 0;
    k = p;

    while (i < n1 && j < n2) {
        if (L[i] <= M[j]) {
            arr[k] = L[i];
            i++;
        } else {
            arr[k] = M[j];
            j++;
        }
        k++;
    }

    while (i < n1) {
        arr[k] = L[i];
        i++;
        k++;
    }

    while (j < n2) {
        arr[k] = M[j];
        j++;
        k++;
    }
}
void mergeSort(int arr[], int l, int r) {
  if (l < r) {
    int m = l + (r - l) / 2;

    mergeSort(arr, l, m);
    mergeSort(arr, m + 1, r);

    merge(arr, l, m, r);
  }
}

void insertionSort (int* A, int p, int r) {
    int i, j;
    for (i = p+1; i <= r; i++) {
        for (j=i; A[j-1] > A[j] && j>0; j--) {
            swap (A[j], A[j-1]);
        };
    };
};



void showTime (void (*alg)(int*, int, int), bool reshuffle = true) {
    clock_t start;
    float time = 0;
    for (int i=0; i<20; i++) {
        if (reshuffle) {
            srand (k);
            for (int j=0; j<n; j++) R[j] = abs(rand());
        };
        start = clock();
        alg (R, 0, n-1);
        time += float (clock() - start);
    };
    time /= (20.0 * CLOCKS_PER_SEC * 0.001);
    cout << time << ",";
    //for (int i=0; i<n; i++) cout << R[i] << " ";
    //cout << endl;
};



void stlSort (int* A, int p, int r) {
    sort (A+p, A+r+1);
};

int main() {

    output.open("output.csv");
    //redirects cout to file i/o
    cout.rdbuf(output.rdbuf());

    int S[6] = {5, 10, 100, 1000, 10000, 100000};
    cout << ",,,,Time required in ms,,,," << endl << "n,"
         << "Merge Sort,Quicksort,Randomized Quicksort,Insertion Sort,Quicksort with Sorted Input,Randomized Quicksort with Sorted Input,STL sort() function," << endl;

    for (int i=0; i<6; i++) {
        n = S[i], R = new int[n];
        cout << n << ",";
        showTime (&mergeSort);
        showTime (&quickSort);
        showTime (&randomizedQuickSort);
        showTime (&insertionSort);
        showTime (&quickSort, false);
        showTime (&randomizedQuickSort, false);
        showTime (&stlSort);
        cout << endl;
    };

    output.close();
    return 0;

};
