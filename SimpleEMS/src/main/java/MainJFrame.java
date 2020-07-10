import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.lang.Object;

public class MainJFrame extends javax.swing.JFrame {
    
    // ATTRIBUTES
    private MyHashTable theHT;
    
    
    // CONSTRUCTORS
    /**
     * Creates new form MainJFrame
     */
    public MainJFrame() {
        initComponents();
        theHT = new MyHashTable(10);
        loadEmployeesToHashTable();
    }
    
    
    // METHODS   
    
    public MyHashTable getTheHT() {
        return theHT;
    }
    
    public void updateNumInTable(){
        if(theHT.getNumInHashTable()>0){
            numOfEmployees.setText(Integer.toString(theHT.getNumInHashTable()));
        }
        else{
            numOfEmployees.setText("0");
        }
    }
    
    public void loadEmployeesToHashTable(){
        File file = new File("employees.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                int flag=0;
                while (flag==0) {
                        String line = br.readLine();
                        line = line.replace("\n", "");
                        if(line.equals("END")){
                            flag=1;
                            break;
                        }
                        
                        if(line.charAt(0)=="F".charAt(0)){

                            String[] terms = line.split("&",-11); //At 0 we have F
                            int employeeNumber = Integer.parseInt(terms[1]);
                            int gender = Integer.parseInt(terms[4]);
                            int workloc = Integer.parseInt(terms[5]);
                            Double deductRate = Double.parseDouble(terms[6]);
                            Double salary = Double.parseDouble(terms[7]);
                            
                            FTE theFTE = new FTE(employeeNumber, terms[2], terms[3], gender, workloc, deductRate, salary);
                            theHT.addEmployee(theFTE);
                            System.out.println("Added "+theHT.getFromTable(employeeNumber).getFirstName()+" to the hash table!");
                        }
                        
                        else if(line.charAt(0)=="P".charAt(0)){
                            
                            String[] terms = line.split("&",-11); //At 0 we have F
                            
                            int employeeNumber = Integer.parseInt(terms[1]);
                            int gender = Integer.parseInt(terms[4]);
                            int workloc = Integer.parseInt(terms[5]);
                            Double deductRate = Double.parseDouble(terms[6]);
                            Double hourlyWage = Double.parseDouble(terms[7]);
                            Double hoursPerWeek = Double.parseDouble(terms[8]);
                            Double weeksPerYear = Double.parseDouble(terms[9]);
                            
                            PTE thePTE = new PTE(employeeNumber, terms[2], terms[3], gender, workloc, deductRate, hourlyWage, hoursPerWeek, weeksPerYear);
                            theHT.addEmployee(thePTE);
                            System.out.println("Added "+theHT.getFromTable(employeeNumber).getFirstName()+" to the hash table!");
                        }
                        else{
                            System.out.println("Invalid Employee type in file.");
                        }
                }
        } catch (IOException e) {
                e.printStackTrace();
        }
        updateNumInTable();
    }

    public void saveEmployeesToHashTable(){
        try {
            FileWriter myWriter = new FileWriter("employees.txt");
            
            int n= theHT.getNumInHashTable();
            if(n==0) {
                System.out.println("No Employees to save!");
            }
            else {
                for(int i=0; i<theHT.buckets.length; i++) { //Go through every single bucket

                        for(int j=0; j<theHT.buckets[i].size(); j++) { //Go through every single item in the arrayList

                            EmployeeInfo employee = theHT.buckets[i].get(j);
                            int eNumber = employee.getEmpNum();
                            String fName = employee.getFirstName();
                            String lName = employee.getLastName();
                            int gender = employee.getGender();
                            int workLoc = employee.getWorkLoc();
                            double deductRate = employee.getDeductRate();

                            //Check whether the employee is a part time employee or a full time employee
                            if(employee instanceof FTE){                                    
                                FTE theFTE = (FTE) employee;
                                double yearlySalary = theFTE.yearlySalary;

                                myWriter.write("F&"+eNumber+"&"+fName+"&"+lName+"&"+gender+"&"+workLoc+"&"+deductRate+"&"+yearlySalary+"\n");
                            }
                            if(employee instanceof PTE){                                    
                                PTE thePTE = (PTE) employee;
                                double hourlyWages = thePTE.hourlyWage;
                                double hoursPerWeek = thePTE.hoursPerWeek;
                                double weeksPerYear = thePTE.weeksPerYear;

                                myWriter.write("P&"+eNumber+"&"+fName+"&"+lName+"&"+gender+"&"+workLoc+"&"+deductRate+"&"+hourlyWages+"&"+hoursPerWeek+"&"+weeksPerYear+"\n");
                            }

                        }
                }
            }
            
            myWriter.write("END");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
          } catch (IOException e) {
            e.printStackTrace();
          }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        loadInfo = new javax.swing.JButton();
        saveInfo = new javax.swing.JButton();
        removeEmployee = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        showEmployees = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        numOfEmployees = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jButton1.setText("Tutorial");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Add an Employee");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jLabel1.setText("SimpleEMS");

        loadInfo.setText("Load Information");
        loadInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadInfoActionPerformed(evt);
            }
        });

        saveInfo.setText("Save Information");
        saveInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveInfoActionPerformed(evt);
            }
        });

        removeEmployee.setText("Remove an Employee");
        removeEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeEmployeeActionPerformed(evt);
            }
        });

        jButton4.setText("Edit Employee Information");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        showEmployees.setText("Show all Employees");
        showEmployees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showEmployeesActionPerformed(evt);
            }
        });

        jLabel2.setText("Welcome to SimpleEMS!");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel3.setText("Number of Employees:");

        numOfEmployees.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        numOfEmployees.setText("0");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loadInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveInfo))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(227, 227, 227)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(243, 243, 243)
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator2)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(removeEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(showEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(numOfEmployees)
                                .addGap(122, 122, 122))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(59, 59, 59)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4))
                    .addComponent(numOfEmployees))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeEmployee)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showEmployees)
                    .addComponent(jButton1))
                .addGap(33, 33, 33)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loadInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        AddEmployeeFrame theAddFrame = new AddEmployeeFrame();
        theAddFrame.setVisible(true);
        theAddFrame.setMainHT(getTheHT());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void loadInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadInfoActionPerformed
        // TODO add your handling code here:
        loadEmployeesToHashTable();
    }//GEN-LAST:event_loadInfoActionPerformed

    private void saveInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveInfoActionPerformed
        // TODO add your handling code here:
        saveEmployeesToHashTable();
    }//GEN-LAST:event_saveInfoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        saveEmployeesToHashTable();
    }//GEN-LAST:event_formWindowClosing

    private void removeEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeEmployeeActionPerformed
        // TODO add your handling code here:
        RemoveEmployeeFrame theRemoveFrame = new RemoveEmployeeFrame();
        theRemoveFrame.setVisible(true);
        theRemoveFrame.setMainHT(getTheHT());
    }//GEN-LAST:event_removeEmployeeActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        EditEmployeeFrame theEditFrame = new EditEmployeeFrame();
        theEditFrame.setVisible(true);
        theEditFrame.setMainHT(getTheHT());
    }//GEN-LAST:event_jButton4ActionPerformed

    private void showEmployeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showEmployeesActionPerformed
        // TODO add your handling code here:
        ShowEmployees theShowFrame = new ShowEmployees();
        theShowFrame.setVisible(true);
        theShowFrame.setMainHT(getTheHT());
        theShowFrame.showEmployees();
    }//GEN-LAST:event_showEmployeesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        TutorialFrame theTutorialFrame = new TutorialFrame();
        theTutorialFrame.setVisible(true);
        theTutorialFrame.setMainHT(getTheHT());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_formFocusGained

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
        updateNumInTable(); //Update the table when the user closes a inner jframe and returns to the main jframe.
    }//GEN-LAST:event_formWindowGainedFocus

    
    
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton loadInfo;
    private javax.swing.JLabel numOfEmployees;
    private javax.swing.JButton removeEmployee;
    private javax.swing.JButton saveInfo;
    private javax.swing.JButton showEmployees;
    // End of variables declaration//GEN-END:variables
}