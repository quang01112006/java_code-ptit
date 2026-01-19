import java.util.Scanner;

public class SapXepNoiBot {
    static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }

            }
            if (swapped) {
                System.out.print("Buoc " + (i + 1) + ": ");
                for (int a = 0; a < arr.length; a++) {
                    System.out.print(arr[a]);
                    if (a < arr.length - 1) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }

        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] input = sc.nextLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        bubbleSort(arr);
    }
}
