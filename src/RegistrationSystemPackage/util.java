package RegistrationSystemPackage;


class util {

    static void sort(int[] arr) {


        // Check which algorithm is more fast
        int n = arr.length;
        int k = arr[0];
        for (int num : arr) {
            if (num > k) {
                k = num;
            }
        }

        if (n+k <= n*n) {
            countingSort(arr); // O(n+k)
        } else {
            selectionSort(arr); // O(n^2)
        }
    }

    // O(n^2)
    private static void selectionSort(int[] arr) {
        int outer, inner, min;
        for (outer = 0; outer < arr.length - 1; outer++) {
            min = outer;
            for (inner = outer + 1; inner < arr.length; inner++) {
                if (arr[inner] < arr[min]) {
                    min = inner;
                }
            }
            int temp = arr[outer];
            arr[outer] = arr[min];
            arr[min] = temp;
        }
    }

    // O(n+k)
    private static void countingSort(int[] arr) {
        if (arr.length == 0) return;

        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }

        int[] count = new int[max + 1];

        for (int num : arr) {
            count[num]++;
        }

        int index = 0;
        for (int i = 0; i <= max; i++) {
            while (count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
        }
    }


}