package Cse321_lab4;
import java.util.Scanner;
public class Task_2{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of process : ");
        int process_num = sc.nextInt();
        int process [] = new int[process_num];
        int arrival_t[] = new int [process_num];
        int burst_t[] = new int [process_num];
        int waiting_t[] = new int [process_num];
        int com_t[] = new int [process_num];
        int turn_t[] = new int [process_num];
        int process_priority [] = new int[process_num];
        int i = 0;
        int x = 0;
        int average_tur_time=0;
        int average_waiting_time=0;

        System.out.println("Enter the burst time  and priorities respectively: ");

        for(i=0;i<process_num;i++)
        {
            System.out.println("Process["+(i+1)+"]:");
            burst_t[i] = sc.nextInt();
            process_priority[i] = sc.nextInt();
            process[i]=i+1;
        }

        for(i=0;i<process_num-1;i++)
        {
            for(int j=i+1;j<process_num;j++)
            {
                if(process_priority[i]>process_priority[j])
                {
                    x=process_priority[i];
                    process_priority[i]=process_priority[j];
                    process_priority[j]=x;
                    x=burst_t[i];
                    burst_t[i]=burst_t[j];
                    burst_t[j]=x;
                    x=process[i];
                    process[i]=process[j];
                    process[j]=x;
                }
            }
        }
        waiting_t[0]=0;
        average_waiting_time=0;
        turn_t[0]=burst_t[0];
        average_tur_time=turn_t[0];
        for(i=1;i<process_num;i++)
        {
            waiting_t[i]=turn_t[i-1];
            average_waiting_time+=waiting_t[i];
            turn_t[i]=waiting_t[i]+burst_t[i];
            average_tur_time+=turn_t[i];
        }
        System.out.println("Process  Burst  Waiting  Turn Around  Priority");
        for(i=0;i<process_num;i++) {
            System.out.println("   " +process[i] + "     " + burst_t[i] + "      " + waiting_t[i] + "          " + turn_t[i] + "      " + process_priority[i]);
        }
        System.out.println("Average waiting Time : "+(double) average_waiting_time/process_num);
        System.out.println("Average turnround Time : "+(double) average_tur_time/process_num);
    }
}
