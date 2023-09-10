
#include <iostream>
#include <cmath>
#include <algorithm>
using namespace std;

class Heap
{

    int *heap;
    int heapsize;
    int maxsize;

    void buildHeap()
    {
        for (int i = floor(heapsize / 2) - 1; i >= 0; i--)
        {
            maxHeapify(i);
        }
    }

    void increaseKey(int i, int key)
    {
        if (key < heap[i])
        {
            cout << "New key is smaller than current key" << endl;
        }
        else
        {
            heap[i] = key;
            while (i > 0 && heap[parent(i)] < heap[i])
            {
                swap(heap[i], heap[parent(i)]);
                i = parent(i);
            }
        }
    }

    int parent(int i)
    {
        return floor((i - 1) / 2);
    }
    int leftChild(int i)
    {
        return 2 * i + 1;
    }
    int rightChild(int i)
    {
        return 2 * i + 2;
    }

public:
    Heap(vector<int> &vect)
    {
        heap = new int[vect.size()];
        for (int i = 0; i < vect.size(); i++)
        {
            heap[i] = vect[i];
        }
        heapsize = vect.size();
        maxsize = 2000000;
        buildHeap();
    }
    Heap(int size)
    {
        heap = new int[size];
        heapsize = 0;
        maxsize = size;
        buildHeap();
    }
    void maxHeapify(int i)
    {
        int l = leftChild(i);
        int r = rightChild(i);
        int largest;
        if (l < heapsize && heap[l] > heap[i])
        {
            largest = l;
        }
        else
            largest = i;
        if (r < heapsize && heap[r] > heap[largest])
        {
            largest = r;
        }
        if (largest != i)
        {
            swap(heap[i], heap[largest]);
            maxHeapify(largest);
        }
    }
    void insert(int key)
    {
        //        if (heapsize == maxsize - 1){
        //            maxsize *= 2;
        //            int* tempArr = new int[maxsize];
        //            for(int i=0; i<heapsize; i++) tempArr[i] = heap[i];
        //            delete [] heap;
        //            heap = new int[maxsize];
        //            for(int i=0; i<heapsize; i++) heap[i] = tempArr[i];
        //        }
        heapsize++;
        heap[heapsize - 1] = INT64_MIN;
        increaseKey(heapsize - 1, key);
    }
    void deleteKey()
    {
        if (heapsize < 1)
        {
            cout << "Heap underflow";
        }
        else
        {
            int max = heap[0];
            heap[0] = heap[heapsize - 1];
            heapsize--;
            maxHeapify(0);
        }
    }
    int getMax()
    {
        return heap[0];
    }
    int size()
    {
        return heapsize;
    }

    int getHeapsize()
    {
        return heapsize;
    }

    void setHeapsize(int heapsize)
    {
        Heap::heapsize = heapsize;
    }

    int &operator[](int index)
    {
        return heap[index];
    }
};

void heapsort(vector<int> &v)
{

    Heap h(v);
    int j = h.getHeapsize() - 1, k = v.size();
    int i = j;
    for (i; i >= 1; i--)
    {
        swap(h[i], h[0]);
        h.setHeapsize(h.getHeapsize() - 1);
        h.maxHeapify(0);
    }
    v.clear();
    for (i = k - 1; i >= 0; i--)
    {
        v.push_back(h[i]);
    }
    //    for( i=0;i<v.size();i++){
    //        cout<<v[i]<<" ";
    //    }
}
