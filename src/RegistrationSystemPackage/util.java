package RegistrationSystemPackage;


class util {

    static void sort(int[] arr) {
        countingSort(arr);
    }

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