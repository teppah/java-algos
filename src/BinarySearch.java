public class BinarySearch {
    public static int search(int[] sortedArray, int key) {
        int low = 0,
                high = sortedArray.length - 1,
                mid = (low + high) / 2;
        while (low <= high) {
            int current = sortedArray[mid];
            if (key == current) {
                return mid;
            } else if (key > current) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            mid = (low + high) / 2;
        }
        return -1;
    }
}
