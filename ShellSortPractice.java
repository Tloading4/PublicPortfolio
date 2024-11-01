import java.util.Arrays;

public class Main {

    public void shellSort(int[] arr, int n) {
        // Start with a big gap, then reduce the gap
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Do a gapped insertion sort for this gap size.
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;
                // Shift earlier gap-sorted elements up until the correct location for arr[i] is found
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                
                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] data = {14, 238, 32, 74, 51, 64, 42, 153};

        Main ss = new Main();
        ss.shellSort(data, data.length);  // Call the shellSort method

        System.out.println("Sorted Array:");
        System.out.println(Arrays.toString(data));  // Use Arrays.toString to print array
    }
}
