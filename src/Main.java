import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Main
 {
	
	
	float Twt,Awt,w;
	  // intiailize to zero 
	float[] Wt= new float[10];
        
	
 
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
  	//Calculating Average Weighting Time
  	for(i=0;i<4;i++)
        	Twt=Twt+Wt[i];
  	Awt=Twt/4;
  	System.out.println("Total Weighting Time=" + Twt);
  	System.out.println("Average Weighting Time=" + Awt +" ");
	}
	//Shortest job First Algorithm
	public  void Sjf(Process[] arr)
	{
      	int i,j;
        Process temp;
      	int [] B= new int [10];
 	Twt=(float) 0.0;
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
	//calculating Average Weighting Time
	for(i=0;i<4;i++)
    	Twt=Twt+Wt[i];
	Awt=Twt/4;
   System.out.println("Total Weighting Time=" + Twt);
  	System.out.println("Average Weighting Time=" + Awt +" ");
	}


	public static void main(String[] args) throws FileNotFoundException {
 
    	int ch,cho;
        
        File input = new File("process.txt");
        Scanner sc = new Scanner(input);
        Process [] arr = new Process [4];
        for(int i=0 ; i< arr.length ; i++){
            int id = sc.nextInt();
            int arriv = sc.nextInt();
            int brust = sc.nextInt();
            
            arr[i]= new Process (id , arriv , brust);
            
        }
  	Main c = new  Main();
          c.Fcfs(arr);
          c.Sjf(arr);
 
 }
   
}
