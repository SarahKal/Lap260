import java.util.*;


public class Main
 {
	int n;
	int[] Bu = new int[20];
	float Twt,Awt,w;
	float[] A= new float[10];   // intiailize to zero 
	float[] Wt= new float[10];
	//Getting the No of processes & burst time
   public  void Getdata()
	{
     	int i;
   	Scanner sc = new Scanner(System.in)  ;
 	System.out.println("Enter the no of processes:");
 	n=sc.nextInt();
 	for(i=1;i<=n;i++)
	{
     	System.out.println("Enter The BurstTime for Process p"+ i +"= ");
     	Bu[i]=sc.nextInt();
	}
	}
   //First come First served Algorithm
   public   void Fcfs()
	{
       	int i;
     	int [] B= new int [10];
 	Twt=(float) 0.0;
 	for(i=1;i<=n;i++)
	{
     	B[i]=Bu[i];
     	System.out.println("Burst time for process p"+ i +"= ");
     	System.out.println(B[i]);
 	}
 	Wt[1]=0;
 	for(i=2;i<=n;i++)
	{
       	Wt[i]=B[i-1]+Wt[i-1];
 	}
  	//Calculating Average Weighting Time
  	for(i=1;i<=n;i++)
        	Twt=Twt+Wt[i];
  	Awt=Twt/n;
  	System.out.println("Total Weighting Time=" + Twt);
  	System.out.println("Average Weighting Time=" + Awt +" ");
	}
	//Shortest job First Algorithm
	public  void Sjf()
	{
      	int i,j,temp;
      	int [] B= new int [10];
 	Twt=(float) 0.0;
 	for(i=1;i<=n;i++)
	{
     	B[i]=Bu[i];
     	System.out.println("Burst time for process p"+ i +"= ");
     	System.out.println(B[i]);
	}
	for(i=n;i>=1;i--)
   {
    	for(j=1;j<=n;j++)
   	{
       	if(B[j-1] > B[j])
      	{
            	temp=B[j-1];
            	B[j-1]=B[j];
            	B[j]=temp;
      	}
   	}
	}
 	Wt[1]=0;
 	for(i=2;i<=n;i++)
	{
      	Wt[i]=B[i-1]+Wt[i-1];
	}
	//calculating Average Weighting Time
	for(i=1;i<=n;i++)
    	Twt=Twt+Wt[i];
	Awt=Twt/n;
   System.out.println("Total Weighting Time=" + Twt);
  	System.out.println("Average Weighting Time=" + Awt +" ");
	}


	public static void main(String[] args) {
 
    	int ch,cho;
  	Main c = new  Main();
  	try{
          	Scanner sc = new Scanner(System.in)  ;
         	do
         	{
              	System.out.println("MENU");
              	System.out.println("1.Getting BurstTime");
              	System.out.println("2.FirstComeFirstServed");
              	System.out.println("3.ShortestJobFirst");
              	System.out.println("4.RoundRobin");
              	System.out.println("5.Priority");
              	System.out.println("6.EXIT");
              	System.out.println("Enter your choice");
              	ch=sc.nextInt();
              	switch(ch)
             	{
                 	case 1:
                          	c.Getdata();
                          	break;
                 	case 2:
                          	System.out.println("FIRST COME FIRST SERVED SCHEDULING");
                          	c.Fcfs();
                          	break;
                  	case 3:
                           	System.out.println("SHORTEST JOB FIRST SCHEDULING");
         	                  do
                           	{
                                 	System.out.println("1.SJF-Normel");
                                 	System.out.println("2.SJF-Preemptive");
                                 	System.out.println("3.SJF-NonPreemptive");
                                 	System.out.println("Enter your choice");
                                 	cho=sc.nextInt();
                                 	switch(cho)
                                	{
                                     	case 1:
                                              	c.Sjf();
                                              	break;
                                  	}
                             	}while(cho<=3);
                             	break;

                    	case 6:
                             	break;
                	}
          	}while(ch<=5);
 	}
  	catch (Exception e)
	{
    	System.out.println("Error Occur Some Where :)");
	}
 }
   
}
