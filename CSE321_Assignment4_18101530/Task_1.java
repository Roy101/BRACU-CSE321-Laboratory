package Cse321_lab4;

import java.util.Scanner;

public class Task_1 {
        public static void main(String args[]) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the number of process :");
            int process_num = sc.nextInt();
            int arrival_t[] = new int [process_num];
            int burst_t[] = new int [process_num];
            int waiting_t[] = new int [process_num];
            int com_t[] = new int [process_num];
            int turn_t[] = new int [process_num];
            int n[] = new int [process_num];
            int start_t = 0;
            int to_t = 0;
            double average_waiting_t = 0.0;
            double average_turn_t = 0.0;

            for (int i = 0; i < process_num; i++) {
                System.out.println("Arrival time of process " + i + ":");
                arrival_t[i] = sc.nextInt();
                System.out.println("Burst_time time of process " + i + ":");
                burst_t[i] = sc.nextInt();
            }

            while (true) {
                int c = process_num;
                int min = Integer.MAX_VALUE;
                if (to_t == process_num) {
                    break;
                }
                for (int i = 0; i < process_num; i++) {
                    if (arrival_t[i] <= start_t && n[i] == 0 && burst_t[i] < min) {
                        c = i;
                        min = burst_t[i];
                    }
                }

                if (c == process_num) {
                    start_t++;
                } else {
                    com_t[c] = start_t + burst_t[c];
                    start_t += burst_t[c];
                    turn_t[c] = com_t[c] - arrival_t[c];
                    waiting_t[c] = turn_t[c] - burst_t[c];
                    n[c] = 1;
                    to_t++;
                }
            }

            System.out.println("Process  Arrival   Burst   Completion   Turnaround   Waiting");
            for (int i = 0; i < process_num; i++) {
                average_waiting_t += waiting_t[i];
                average_turn_t += turn_t[i];
                System.out.println("     "+i + "      " + arrival_t[i] + "       " + burst_t[i] + "        " + com_t[i] + "            " + turn_t[i]+ "       " + waiting_t[i] );
            }
            System.out.println("Average waiting time: " + (double) average_waiting_t / process_num);
            System.out.println("Average turnaround time: " +(double) average_turn_t/process_num);
        }
    }

