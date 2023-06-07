
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class Main {
        
 static String []dd = {"Process 0   finishes at time 5.   Response time = 0,   Waiting time = 0,   Turnaround time = 5\n" +
"Process 1   finishes at time 8.   Response time = 5,   Waiting time = 5,   Turnaround time = 8\n" +
"Process 2   finishes at time 9.   Response time = 8,   Waiting time = 8,   Turnaround time = 9\n" +
"Process 3   finishes at time 11.   Response time = 9,   Waiting time = 9,   Turnaround time = 11"};
 
 static String []cc ={"Process 0`   finishes at time 1.    Response time = 0,   Waiting time = 0,   Turnaround time = 1\n" +
"Process 1`   finishes at time 3.    Response time = 1,   Waiting time = 1,   Turnaround time = 3\n" +
"Process 2`   finishes at time 6.    Response time = 3,   Waiting time = 3,   Turnaround time = 6\n" +
"Process 3`   finishes at time 11.    Response time = 6,   Waiting time = 6,   Turnaround time = 11"};
    
    public static ArrayList<Process> processList;

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Process> list = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("process.txt"));
            while (scanner.hasNext()) {
               int arrivalTime = scanner.nextInt();
                String id = scanner.next();
                
                int burstTime = scanner.nextInt();
                list.add(new Process(id, arrivalTime, burstTime));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        printProcessList(list);
       FCFS(list) ;
       SJF(list);

        GUI gui = new GUI();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.pack();
        gui.setVisible(true);
    }

   

    private static void printProcessList(ArrayList<Process> list) {
        System.out.println("Processes:");
        for (Process p : list) {
            System.out.println(p.burstTime);
        }
        System.out.println();
    }

    public static void FCFS(ArrayList<Process> list) {
     
        list.sort((p1, p2) -> Integer.compare(p1.getArrivalTime(), p2.getArrivalTime()));

        int currentTime = 0;
        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
         String resultfcfs = "";
        //textArea.append("Schedule Result:\n");
      int i=0 ;
        for (Process p : list) {
            int waitingTime = currentTime - p.getArrivalTime();
            
            if (waitingTime < 0) {
                waitingTime = 0;
            }
            totalWaitingTime += waitingTime;

            int turnaroundTime = waitingTime + p.getBurstTime();
            totalTurnaroundTime += turnaroundTime;

            currentTime += p.getBurstTime();

            
            
                resultfcfs+="Process " + i;
                resultfcfs+="   finishes at time " + currentTime;
                resultfcfs+=".   Response time = " + waitingTime;
                resultfcfs+=",   Waiting time = " + waitingTime;
                resultfcfs+=",   Turnaround time = " + turnaroundTime;
                resultfcfs+="\n";
                i++;
        
           

    }
        System.out.println(resultfcfs);
        dd[0] = resultfcfs;
        String result =  printfcfs(dd);
    }
    
     

     public static String printfcfs(String []dd) {
         return dd[0];
         
     }
    public static void SJF(ArrayList<Process> list) {
       
        list.sort((p1, p2) -> Integer.compare(p1.getBurstTime(), p2.getBurstTime()));

        int currentTime = 0;
        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        String resultsjf = "";
        int i=0;
        for (Process p : list) {
            int waitingTime = currentTime - p.getArrivalTime();
            if (waitingTime < 0) {
                waitingTime = 0;
            }
            totalWaitingTime += waitingTime;

            int turnaroundTime = waitingTime + p.getBurstTime();
            totalTurnaroundTime += turnaroundTime;

            currentTime += p.getBurstTime();

           
            
                resultsjf+="Process " + i;
                resultsjf+="`   finishes at time " + currentTime;
                resultsjf+=".    Response time = " + waitingTime;
                resultsjf+=",   Waiting time = " + waitingTime;
                resultsjf+=",   Turnaround time = " + turnaroundTime;
                resultsjf+="\n";
             i++;
    
        }
   System.out.println(resultsjf);
   cc[0]= resultsjf;
        String result =  printsjf(cc);
    }

     public static String printsjf(String [] cc) {
         return cc[0];
         
     }
    

}
