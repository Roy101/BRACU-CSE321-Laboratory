package Lab06;

import java.io.*;
import java.util.*;

class Banker_algo{
    static int k, l;
    static int safe_state[] = new int[k+10];

    public static boolean safe_checker(int need_mat[][],int avail[], int alloc[][], int n, int m,
                                 int change_In_Available[][]) {

        boolean check_safe_state[] = new boolean[n];

        for (int i = 0; i < n; i++)
            check_safe_state[i] = false;

        int checking1 = 0;
        int checking2 = 0;
        do {
            for (int i = 0; i < n; i++) {
                boolean p = true;
                if (check_safe_state[i] == false) {
                    for (int j = 0; j < m; j++) {
                        if (avail[j] < need_mat[i][j])
                            p = false;
                    }
                    if (p == true) {
                        for (int j = 0; j < m; j++) {
                            avail[j] = avail[j] + alloc[i][j];
                            change_In_Available[checking1][j] = avail[j];
                        }
                        safe_state[checking1] = i;
                        checking1++;
                        check_safe_state[i] = true;
                    }
                }
            }
            checking2++;
        }
        while (checking1 < n && checking2 < n);

        if (checking1 > n)
            return false;
        else
            return true;

    }

    public static void main(String[] args) throws IOException {
        String path ="E:\\CSE220_SPRING2020\\src\\Lab06\\input.txt";
        File file = new File(path);
        Scanner sc = new Scanner(file);
        k = sc.nextInt();
        l= sc.nextInt();

        int maximum[][] = new int[k][l];

        for (int i = 0; i < k; i++)
            for (int j = 0; j < l; j++) {
                maximum[i][j] = sc.nextInt();
            }

        int alloc[][] = new int[k][l];

        for (int i = 0; i < k; i++)
            for (int j = 0; j < l; j++) {

                alloc[i][j] = sc.nextInt();

            }
        int avail[] = new int[l];

        for (int i = 0; i < l; i++) {
            avail[i] = sc.nextInt();
        }

        int need[][] = new int[k][l];

        for (int i = 0; i < k; i++)
            for (int j = 0; j < l; j++) {
                need[i][j] = maximum[i][j] - alloc[i][j];
            }

        int[][] change_In_Available = new int[k][l];
        System.out.println("Need matrix is: ");
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < l; j++) {
                System.out.print(need[i][j] + "  ");
            }
            System.out.println();
        }

        if (safe_checker(need,avail, alloc, k, l, change_In_Available)) {
            System.out.println("Safe sequence is:");
            for (int i = 0; i < k; i++) {
                System.out.print((char) ('A' + safe_state[i]) + " ");
            }
            System.out.println();
            System.out.println("Change In Available Resource Matrix : ");
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < l; j++) {
                    System.out.print(change_In_Available[i][j] + "  ");
                }
                System.out.println();
            }

        }
        else
            System.out.println("System is not in safe state");

    }
}