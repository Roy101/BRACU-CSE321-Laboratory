package Cse321_lab4;

import java.util.Scanner;
public class Task3{
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter number of process:");
        int process_num = sc.nextInt();
        int arrival_t[]=new int[process_num];
        int burst_t[]=new int[process_num];
        int waiting_t[]=new int[process_num];
        int turn_t[]=new int[process_num];
        int a[]=new int[process_num];
        int i = 0;
        int j = 0;
        int x = 0;
        int y = 0;
        int s = 0;

        System.out.println("Enter arrival Time:"  );
        for(i=0;i<process_num;i++){
            System.out.println("Enter arrival Time for  "+(i+1));
            arrival_t[i] = sc.nextInt();
        }
        for(i=0;i<process_num;i++){
            System.out.println("Enter burst Time for  "+(i+1));
            burst_t[i] = sc.nextInt();
        }

        System.out.println("Enter Time quantum:");
        y=sc.nextInt();
        for(i=0;i<process_num;i++)
            a[i]=burst_t[i];
        for(i=0;i<process_num;i++)
            waiting_t[i]=0;
        do{
            for(i=0;i<process_num;i++){
                if(burst_t[i]>y){
                    burst_t[i]-=y;
                    for(j=0;j<process_num;j++){
                        if((j!=i)&&(burst_t[j]!=0))
                            waiting_t[j]+=y;
                    }
                }
                else{
                    for(j=0;j<process_num;j++){
                        if((j!=i)&&(burst_t[j]!=0))
                            waiting_t[j]+=burst_t[i];
                    }
                    burst_t[i]=0;
                }
            }
            s=0;
            for(x=0;x<process_num;x++){
                s=s+burst_t[x];
            }
        }
        while(s!=0);
        for(i=0;i<process_num;i++){
            turn_t[i]=waiting_t[i]+a[i];
        }
        System.out.println("Process  Burst  Waiting  Turn Around  Priority");
        for(i=0;i<process_num;i++) {
            System.out.println((i + 1) + "   " + arrival_t[i] + "   " + a[i] + "    " + waiting_t[i] + "     " + turn_t[i]);
        }
        float average_waiting_t=0;
        float average_turn_t=0;
        for(j=0;j<process_num;j++){
            average_waiting_t+=waiting_t[j];
        }
        for(j=0;j<process_num;j++){
            average_turn_t+=turn_t[j];
        }
        System.out.println("Average waiting time: "+(average_waiting_t/process_num));
        System.out.println("Average turn around time: "+(average_turn_t/process_num));
        }
    }
