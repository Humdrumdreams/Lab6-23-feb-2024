//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package mainSim;

public class MergeSort {
    public MergeSort() {
    }

    void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];

        int i;
        for(i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
        }

        for(i = 0; i < n2; ++i) {
            R[i] = arr[m + 1 + i];
        }

        i = 0;
        int j = 0;

        int k;
        for(k = l; i < n1 && j < n2; ++k) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                ++i;
            } else {
                arr[k] = R[j];
                ++j;
            }
        }

        while(i < n1) {
            arr[k] = L[i];
            ++i;
            ++k;
        }

        while(j < n2) {
            arr[k] = R[j];
            ++j;
            ++k;
        }

    }

    void sort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            this.sort(arr, l, m);
            this.sort(arr, m + 1, r);
            this.merge(arr, l, m, r);
        }

    }

    static void printArray(int[] arr) {
        int n = arr.length;

        for(int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{12, 11, 13, 5, 6, 7};
        System.out.println("Given Array");
        printArray(arr);
        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);
        System.out.println("\nSorted array");
        printArray(arr);
    }
}