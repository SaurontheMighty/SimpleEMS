
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joe
 */
public class ShowEmployees extends javax.swing.JFrame {

    // ATTRIBUTES
    private MyHashTable mainHT;
    private String data[][];
    /**
     * Creates new form RemoveEmployeeFrame
     */
    public ShowEmployees() {
        initComponents();
        
    }
    
    public MyHashTable getTheHT() {
        return mainHT;
    }
    
    //METHODS
    public void setMainHT(MyHashTable refvalForHT) {
        mainHT = refvalForHT;
    }
    
    public void showEmployees(){
        String[] columnNames = {"Employee Number","First Name","Last Name","Status"};
        if(mainHT.getNumInHashTable()>0){
            
            data = new String[mainHT.getNumInHashTable()][4];
            int n=0;
            
            for(int i=0; i<mainHT.buckets.length; i++) { //Go through every single bucket
                for(int j=0; j<mainHT.buckets[i].size(); j++) {
                    EmployeeInfo employee = mainHT.buckets[i].get(j);
                    System.out.println(employee);
                    String empNumber = Integer.toString(employee.getEmpNum());
                    String fName = employee.getFirstName();
                    String lName = employee.getLastName();
                    data[n][0]=empNumber;
                    data[n][1]=fName;
                    data[n][2]=lName;
                    if(employee instanceof FTE){
                        data[n][3]="FTE";
                    }
                    else if(employee instanceof PTE){
                        data[n][3]="PTE";
                    }
                    else{
                        data[n][3]="null";
                    }
                    n=n+1;
                }
            }
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setDataVector(data, columnNames);            
        }
        else{
            String[][] data1 = {{"No ","Employees ","in the ","table"}};
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setDataVector(data1, columnNames);   
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel1.setText("Show Employees");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }

        )
        {public boolean isCellEditable(int row, int column){return false;}}
    );
    table.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tableMouseClicked(evt);
        }
    });
    jScrollPane1.setViewportView(table);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(142, 142, 142)
            .addComponent(jLabel1)
            .addContainerGap(129, Short.MAX_VALUE))
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addContainerGap())
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(17, 17, 17))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // Gets the employee at the point that is clicked:
        int row = table.rowAtPoint(evt.getPoint());
        int col = table.columnAtPoint(evt.getPoint());
        EditEmployeeFrame theEditFrame = new EditEmployeeFrame();
        theEditFrame.setVisible(true);
        theEditFrame.setID(Integer.parseInt(data[row][0]));
        System.out.println(data[row][0]);
        theEditFrame.setMainHT(getTheHT());
    }//GEN-LAST:event_tableMouseClicked

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
            java.util.logging.Logger.getLogger(ShowEmployees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowEmployees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowEmployees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowEmployees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new ShowEmployees().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
