
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class Main {

    /*
	
	float Waitingtime,Awt,w;
	  // intiailize to zero 
	float[] Wt= new float[4];
        Process [] arr = new Process [4];
	float[] Turn= new float[4];
 
   //First come First served Algorithm
   public   void Fcfs(Process[] arr)
	{
        
       	int i;
     	int [] B= new int [10];
 	Twt=(float) 0.0;
 	for(i=0;i<4;i++)
	{
     	
     	System.out.println("Burst time for process p"+ i +"= ");
     	System.out.println(arr[i].burstTime);
 	}
 	Wt[0]=0;
 	for(i=1;i<4;i++)
	{
       	Wt[i]=arr[i-1].burstTime+Wt[i-1];
 	}
        
        for(i=0;i<4;i++)
	{
       	Turn[i]=arr[i].burstTime+Wt[i];
 	}
  	//Calculating Average Weighting Time
  	for(i=0;i<4;i++){
        	Twt=Twt+Wt[i];
                Awt = Awt+Turn[i];
        }
  	 printFCFS(arr,Wt,Twt,Turn);
  	System.out.println("Total Weighting Time=" + Twt);
  	         System.out.println("Total Turnaround Time=" + Awt);
        
       
	}
   
   
   
	//Shortest job First Algorithm
	public  void Sjf(Process[] arr)
	{
      	int i,j;
        Process temp;
      	int [] B= new int [10];
 	Twt=(float) 0.0;
        Awt=(float) 0.0;
 	for(i=0;i<4;i++)
	{
     	
     	System.out.println("Burst time for process p"+ i +"= ");
     	System.out.println(arr[i].burstTime);
	}
	for(i=4;i>0;i--)
   {
    	for(j=1;j<4;j++)
   	{
       	if(arr[j-1].burstTime > arr[j].burstTime)
      	{
            	temp=arr[j-1];
            	arr[j-1]=arr[j];
            	arr[j]=temp;
      	}
   	}
	}
 	Wt[0]=0;
 	for(i=1;i<4;i++)
	{
      	Wt[i]=arr[i-1].burstTime+Wt[i-1];
	}
	for(i=0;i<4;i++)
	{
       	Turn[i]=arr[i].burstTime+Wt[i];
 	}
  	//Calculating Average Weighting Time
  	for(i=0;i<4;i++){
        	Twt=Twt+Wt[i];
                Awt = Awt+Turn[i];
        }
	 printSjf( arr ,Wt ,  Twt,Turn);
   System.out.println("Total Weighting Time=" + Twt);
  	 System.out.println("Total Turnaround Time=" + Awt);
        
       
	}

	public static void main(String[] args) throws FileNotFoundException {
  Process [] arr = new Process [4];
    	int ch,cho;
        
        File input = new File("process.txt");
        Scanner sc = new Scanner(input);
        
        for(int i=0 ; i< arr.length ; i++){
            int pid = sc.nextInt();
            int arrival = sc.nextInt();
            int brust = sc.nextInt();
            
            arr[i]= new Process (pid , arrival , brust);
            
        }
  	Main c = new  Main();
          c.Fcfs(arr);
          c.Sjf(arr);
 
 }
     */
    public static ArrayList<Process> processList;

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Process> list = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("process.txt"));
            while (scanner.hasNext()) {
               int arrivalTime = scanner.nextInt();
                int id = scanner.nextInt();
                
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
                resultfcfs+=" finishes at time " + currentTime;
                resultfcfs+=". Response time = " + waitingTime;
                resultfcfs+=", Waiting time = " + waitingTime;
                resultfcfs+=", Turnaround time = " + turnaroundTime;
                resultfcfs+="\n";
                i++;
        
           

    }
        System.out.println(resultfcfs);
        String result =  printfcfs(resultfcfs);
    }

     public static String printfcfs(String resultfcfs) {
         return resultfcfs;
         
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
                resultsjf+=" finishes at time " + currentTime;
                resultsjf+=". Response time = " + waitingTime;
                resultsjf+=", Waiting time = " + waitingTime;
                resultsjf+=", Turnaround time = " + turnaroundTime;
                resultsjf+="\n";
             i++;
    
        }
   System.out.println(resultsjf);
        String result =  printfcfs(resultsjf);
    }

     public static String printsjf(String printsjf) {
         return printsjf;
         
     }
    

}
