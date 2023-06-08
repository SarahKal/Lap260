
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class Main {
        
 static String []dd = {""};
 static String []cc ={""};
    
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
        
        
        
         String chart ="";
       chart += "                  gantt chart of FCFS\n";
     
       
          currentTime = 0;
        
        String labels = "";
        chart+= "+";
        labels+="";
        String width ="";
       int kk =0;
       labels+=kk;
        for (int j=0 ; j< list.size() ;j++) {
             kk+= list.get(j).burstTime;
            for(int k=0 ; k< list.get(j).burstTime *4;k++){
         
            chart+="-";
            labels+=" "  ;
            
        }
            chart+="+";
             labels+= "    "+kk ;
        }
         
        chart+="\n";
        labels+="\n";
        chart+="|";
        for (int j=0 ; j< list.size() ;j++) {
            for(int k=0 ; k< list.get(j).burstTime *4;k++){
            chart+=" ";
        }
           
             for(int k=0 ; k< list.get(j).burstTime /2;k++){
            chart+=" ";
        }
              chart+=list.get(j).burstTime;
                  for(int k=0 ; k< list.get(j).burstTime/2+1 ;k++){
            chart+=" ";
        }
                  chart+="|";
        }
         
        chart+="\n+";
         for (int j=0 ; j< list.size() ;j++) {
              for(int k=0 ; k< list.get(j).burstTime*4 ;k++){
            chart+="-";
              }
              chart+="+";
        }
        chart+="\n";
        labels+="\n";
        chart+= labels;
        
        resultfcfs +="\n"+ chart;
         
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
       
   
        
         String chart ="";
        chart += "                  gantt chart of SJF\n";
     
        
          currentTime = 0;
        
        String labels = "";
        chart+= "+";
        labels+="";
       int kk =0;
       labels+=kk;
         for (int j=0 ; j< list.size() ;j++) {
             kk+= list.get(j).burstTime;
            for(int k=0 ; k< list.get(j).burstTime *4;k++){
         
            chart+="-";
            labels+=" "  ;
            
        }
            chart+="+";
            labels+= "   "+kk ;
        }
         
        chart+="\n";
        labels+="\n";
        chart+="|";
        for (int j=0 ; j< list.size() ;j++) {
            for(int k=0 ; k< list.get(j).burstTime *4;k++){
            chart+=" ";
        }
           
             for(int k=0 ; k< list.get(j).burstTime /2;k++){
            chart+=" ";
        }
              chart+=list.get(j).burstTime;
                  for(int k=0 ; k< list.get(j).burstTime/2+1 ;k++){
            chart+=" ";
        }
                  chart+="|";
        }
         
        chart+="\n+";
         for (int j=0 ; j< list.size() ;j++) {
              for(int k=0 ; k< list.get(j).burstTime*4 ;k++){
            chart+="-";
              }
              chart+="+";
        }
        chart+="\n";
        labels+="\n";
        chart+= labels;
        
          
       
        resultsjf+= "\n"+chart;
         System.out.println(resultsjf);
   cc[0]= resultsjf;
        String result =  printsjf(cc);  
          
    }

     public static String printsjf(String [] cc) {
         return cc[0];
         
     }
    
  
}
