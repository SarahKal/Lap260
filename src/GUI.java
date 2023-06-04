import java.awt.BorderLayout;
import java.awt.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class GUI extends javax.swing.JFrame {

    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
        
    }
   
int n;
        boolean flag;
        DefaultListModel<String> listModel ;
	int[] Bu = new int[20];
	float Twt,Awt,w;
	float[] A= new float[10];   // intiailize to zero 
	float[] Wt= new float[10];
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simulation of process scheduling algorithms");

        jButton1.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jButton1.setText("First Come First Serve");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jButton2.setText("Shortest Job First");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(112, 150, 176));
        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel1.setText("Please Select one of the two scheduling algorithms ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(jButton1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jButton2)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(111, 111, 111))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    
    FCFS a = null;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      if(flag){
        BufferedReader br = null;
        try {
             br = new BufferedReader (new FileReader("FCFS.txt"));
             
             Process []arr = new Process [4];
             for(int i =0; i< arr.length ; i++){
                 int processId = br.read();
                 int arrivalTime = br.read();
                 int burstTime = br.read();
                 arr[i]= new Process(processId,arrivalTime,burstTime);
                 listModel.
             }
             flag =false; 
        } catch (Exception ex) {
            System.out.println(""+ ex);
       
        }
        finally {
            try{
                br.close();
            }
            catch (Exception ex) {
                System.out.println(""+ ex);
            }
        }
      }
        
        if (a==null){
            a=new FCFS();
        }       
        a.setVisible(true);
       loadFile();
       /*
        int currentTime = 0;
        for (Process process : processes) {
            int responseTime = currentTime - process.getArrivalTime();
            int waitingTime = currentTime - process.getArrivalTime();
            int turnaroundTime = waitingTime + process.getBurstTime();
            int terminationTime = currentTime + process.getBurstTime();
            currentTime = terminationTime;
            tblModel.addRow(new Object[] { process.getProcessId(), process.getArrivalTime(), process.getBurstTime(), 
                terminationTime, responseTime, waitingTime, turnaroundTime });
        }
        */
       
    }//GEN-LAST:event_jButton1ActionPerformed
    SJF b=null;
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (b==null){
            b=new SJF();
        }       
        b.setVisible(true);
       loadFile();
        
        /*
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
        */
    }//GEN-LAST:event_jButton2ActionPerformed

        private void loadFile() {
        String fileName = "process.txt";
        ArrayList<Process> processes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                int processId = Integer.parseInt(tokens[0]);
                int arrivalTime = Integer.parseInt(tokens[1]);
                int burstTime = Integer.parseInt(tokens[2]);
                processes.add(new Process(processId, arrivalTime, burstTime));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
