import java.util.Arrays;

public class HeapSort {
    private int comparisonCount;
    private int movementCount;

    public void sort(int[] array) {
        comparisonCount = 0;
        movementCount = 0;
        
        int n = array.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            movementCount += 3;

            // Call max heapify on the reduced heap
            heapify(array, i, 0);
        }
    }

    void heapify(int[] array, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left = 2*i + 1
        int right = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (left < n && array[left] > array[largest]) {
            largest = left;
        }
        comparisonCount++;

        // If right child is larger than largest so far
        if (right < n && array[right] > array[largest]) {
            largest = right;
        }
        comparisonCount++;

        // If largest is not root
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;
            movementCount += 3;

            // Recursively heapify the affected sub-tree
            heapify(array, n, largest);
        }
    }

    public void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public int getComparisonCount() {
        return comparisonCount;
    }

    public int getMovementCount() {
        return movementCount;
    }
}
