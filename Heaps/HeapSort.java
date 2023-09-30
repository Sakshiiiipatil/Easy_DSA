/*
 *            Heap Sort
 */

public class HeapSort {

    public static void heapSort(int arr[]) {
        // step1: build maxHeap
        int n = arr.length;
        for (int i = n / 2; i >= 0; i--) {
            heapify(arr, i, n);
        }

        // step2: push largest at end
        for (int i = n - 1; i > 0; i--) {
            // swap (largest-first with last)
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, 0, i);
        }
    }

    public static void heapify(int arr[], int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIdx = i;

        if (left < size && arr[left] > arr[maxIdx]) {
            maxIdx = left;
        }

        if (right < size && arr[right] > arr[maxIdx]) {
            maxIdx = right;
        }

        if (maxIdx != i) {
            // swap
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;
            heapify(arr, maxIdx, size);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 8, 7, 65, 5, 4, 3, 2 };
        heapSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

/*
 * Output:
 * 2 3 4 5 7 8 65
 */

/*heapSort method:

The heapSort method takes an integer array arr as input and sorts it in ascending order using the Heap Sort algorithm.
The algorithm consists of two main steps:
Step 1: Build a max heap from the given array.
Step 2: Repeatedly extract the maximum element (located at the root of the heap) and place it at the end of the array, reducing the heap size, and then heapify the remaining elements.
heapify method:

The heapify method is used to maintain the max heap property.
It takes as input the array arr, the current index i, and the size of the heap size.
The method compares the element at index i with its left and right children (if they exist), and if any child is greater than the current element, it swaps them.
This process continues recursively to ensure that the largest element "bubbles up" to the root of the subtree rooted at index i.
main method:

In the main method, an example integer array arr is defined with unsorted values.
The heapSort method is called to sort the array.
After sorting, the program prints the sorted array, resulting in the elements being displayed in ascending order.
Output:

The sorted array is printed as the final output, demonstrating the sorted result using the Heap Sort algorithm.*/
