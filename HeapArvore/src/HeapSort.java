import java.util.Arrays;

public class HeapSort {
    private int comparisonCount;
    private int movementCount;

    public void sort(int[] array) {
        comparisonCount = 0;
        movementCount = 0;
        
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            movementCount += 3;
            
            heapify(array, i, 0);
        }
    }

    void heapify(int[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1; 
        int right = 2 * i + 2; 

        if (left < n && array[left] > array[largest]) {
            largest = left;
        }
        comparisonCount++;

        if (right < n && array[right] > array[largest]) {
            largest = right;
        }
        comparisonCount++;

        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;
            movementCount += 3;

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
