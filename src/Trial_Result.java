import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.text.MessageFormat;
import javax.swing.*;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
public class Trial_Result extends javax.swing.JInternalFrame {

      Connection conn=null;
ResultSet rs = null;
PreparedStatement pst=null;
String sql=null;
    public Trial_Result() throws SQLException {
        initComponents();
        Show_Users_In_JTable();
    }
         public ArrayList<user8> getUserList() throws SQLException
    {
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/biotechinfo?autoReconnect=true&useSSL=false","root","root"); 
        ArrayList<user8> usersList = new ArrayList<user8>();
        String searchQuery = "SELECT * FROM clinical_trial_result"; 
        Statement st;
        ResultSet rs;
        
        try{
            st = conn.createStatement();
           
            rs=st.executeQuery(searchQuery);
            
            user8 User;
             while(rs.next())
            {
                User = new user8(
                                 rs.getInt("Clinical_Trial_Id"),
                        rs.getInt("Drug_Id"),
                        rs.getString("Test_Result")
                                );
                usersList.add(User);
            }
            
        }catch(Exception ex){
            //System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        
        return usersList;
    }
 
      
   public void Show_Users_In_JTable() throws SQLException
    {
        ArrayList<user8> users = getUserList();
        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel)jtable9.getModel();
        //model.setColumnIdentifiers(new Object[]{"Dept_Id","Hospital_Id","Dept_Name","Contact","Email"});
        Object[] row = new Object[3];
        
        for(int i = 0; i < users.size(); i++)
        {
            
            row[0] = users.get(i).getId();
            row[1] = users.get(i).getId2();
            row[2] = users.get(i).getresult();
            
            model.addRow(row);
        }
       jtable9.setModel(model);
       
    }
   public void executeSQlQuery(String query, String message) throws SQLException
   {
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/biotechinfo?autoReconnect=true&useSSL=false","root","root");
       Statement st;
       try{
           st = conn.createStatement();
           if((st.executeUpdate(query)) == 1)
           {
               // refresh jtable data
               DefaultTableModel model = (DefaultTableModel)jtable9.getModel();
               model.setRowCount(0);
               Show_Users_In_JTable();
               
               JOptionPane.showMessageDialog(null, "Data "+message+" Succefully");
           }else{
               JOptionPane.showMessageDialog(null, "Data Not "+message);
           }
       }catch(Exception ex){
           ex.printStackTrace();
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

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        search = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        id1 = new javax.swing.JTextField();
        id2 = new javax.swing.JTextField();
        result = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtable9 = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Clinical Trial Result");

        jPanel1.setBackground(new java.awt.Color(0, 51, 204));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton1.setForeground(new java.awt.Color(153, 0, 0));
        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton2.setForeground(new java.awt.Color(153, 0, 0));
        jButton2.setText("Exit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jButton3.setIcon(new javax.swing.ImageIcon("F:\\DBMS\\1-11-18\\2_GUI development Tutorial_FrontEnd_BackEnd\\must_have_icons_icons_pack_120704\\Search\\Search_16x16.png")); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("Details Information");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 0, 0));
        jLabel2.setText("Clinical Trial Id");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 0));
        jLabel3.setText("Drug Id");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 0, 0));
        jLabel4.setText("Trial Result");

        result.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton4.setForeground(new java.awt.Color(153, 0, 0));
        jButton4.setIcon(new javax.swing.ImageIcon("F:\\DBMS\\1-11-18\\2_GUI development Tutorial_FrontEnd_BackEnd\\must_have_icons_icons_pack_120704\\Add\\Add_16x16.png")); // NOI18N
        jButton4.setText("Insert");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton5.setForeground(new java.awt.Color(153, 0, 0));
        jButton5.setIcon(new javax.swing.ImageIcon("F:\\DBMS\\1-11-18\\2_GUI development Tutorial_FrontEnd_BackEnd\\must_have_icons_icons_pack_120704\\Edit\\Edit_16x16.png")); // NOI18N
        jButton5.setText("Update");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton6.setForeground(new java.awt.Color(153, 0, 0));
        jButton6.setIcon(new javax.swing.ImageIcon("F:\\DBMS\\1-11-18\\2_GUI development Tutorial_FrontEnd_BackEnd\\must_have_icons_icons_pack_120704\\Delete\\Delete_16x16.png")); // NOI18N
        jButton6.setText("Delete");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(70, 70, 70)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(id2, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                                    .addComponent(id1)
                                    .addComponent(result)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 100, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6)
                        .addGap(18, 18, 18))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(id1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(id2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(result, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jtable9.setBackground(new java.awt.Color(0, 0, 0));
        jtable9.setForeground(new java.awt.Color(255, 255, 255));
        jtable9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Clinical_Trial_Id", "Drug_Id", "Testl_Result"
            }
        ));
        jtable9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtable9MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtable9);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(186, 186, 186))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void resultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resultActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       try{
           int i=-1;
           i = jtable9.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel)jtable9.getModel();
        if(i >= 0 )
        {
            
            model.setValueAt(id1.getText(), i, 0);
            model.setValueAt(id2.getText(), i, 1);
            model.setValueAt(result.getText(), i, 2);
           
            
            String value0=id1.getText();
           String value1=id2.getText();
            String value2=result.getText();
           
           String sql="update clinical_trial_result set Clinical_Trial_Id='"+value0+"',Drug_Id='"+value1+"',Test_Result='"+value2+"'where Clinical_Trial_Id ="+value0+""; 
            pst =conn.prepareStatement(sql);
           pst.execute();
            JOptionPane.showMessageDialog(null, "Updated");
        }else{
            
       String value0=id1.getText();
       String value1=id2.getText();
       String value2=result.getText();
       
      String sql="update clinical_trial_result set Clinical_Trial_Id='"+value0+"',Drug_Id='"+value1+"',Test_Result='"+value2+"'where Clinical_Trial_Id ="+value0+"";
       pst =conn.prepareStatement(sql);
       pst.execute();
       JOptionPane.showMessageDialog(null, "Updated"); 
        }
      
       }
           catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);
    } 
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      try{
                 
    String sql="select * from clinical_trial_result where Clinical_Trial_Id=? ";
    pst =conn.prepareStatement(sql);
   pst.setString(1,search.getText());
  

    rs=pst.executeQuery();
   // pst.execute();
   if(rs.next()){
     
    String add5=rs.getString("Clinical_Trial_Id");
    id1.setText(add5);
    String add1=rs.getString("Drug_Id");
    id2.setText(add1);
    String add2=rs.getString("Test_Result");
   result.setText(add2);
  
      }  

   }
   
           catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
            try{
                 
  String sql="select * from clinical_trial_result where Drug_Id=? ";
    pst =conn.prepareStatement(sql);
   pst.setString(1,search.getText());
  

    rs=pst.executeQuery();
   // pst.execute();
   if(rs.next()){
     String add5=rs.getString("Clinical_Trial_Id");
    id1.setText(add5);
    String add1=rs.getString("Drug_Id");
    id2.setText(add1);
    String add2=rs.getString("Test_Result");
   result.setText(add2);
      }  

   }
   
           catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      conn= Mysqlconnection.ConnectDB();
      String sql="Insert into clinical_trial_result(Clinical_Trial_Id,Drug_Id,Test_Result) value (?,?,?)";
       try
       {
         
            pst=conn.prepareStatement(sql);
           
             pst.setString(1,id1.getText());
              pst.setString(2,id2.getText());
              pst.setString(3,result.getText());
              
              
               
                 
                pst.execute();
                 
                 JOptionPane.showMessageDialog(null, "Data Inserted");
       
       }
       catch(Exception e)
       {
         
            JOptionPane.showMessageDialog(null, "Failed");
           
       }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
          String sql="delete from clinical_trial_result where Clinical_Trial_Id=?";
        try{
            int i=-1;
        i = jtable9.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel)jtable9.getModel();
        if (i>=0){
            pst =conn.prepareStatement(sql);
            pst.setString(1, id1.getText());
    
    //rs=pst.executeQuery();
        executeSQlQuery(sql, "Deleted");
        pst.execute();
    
       JOptionPane.showMessageDialog(null, "Deleted");
        }
        else{
              pst =conn.prepareStatement(sql);
        pst.setString(1, id1.getText());
    
    //rs=pst.executeQuery();
        executeSQlQuery(sql, "Deleted");
        pst.execute();
    
       JOptionPane.showMessageDialog(null, "Deleted");
        }
      
    //QueryJFrame s = new QueryJFrame();
    //s.setVisible(true);
    
    
    
    
            
    }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        search.setText("");
     
       id1.setText("");
       
        id2.setText("");
        result.setText("");
        
        DefaultTableModel model = (DefaultTableModel)jtable9.getModel();
        model.setRowCount(0);
         try {
             Show_Users_In_JTable();
         } catch (SQLException ex) {
             Logger.getLogger(Department.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtable9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtable9MouseClicked
       int i = jtable9.getSelectedRow();
        
         // get the model from the jtable
       DefaultTableModel model = (DefaultTableModel)jtable9.getModel();
       
      //  Show_Users_In_JTable();

      
        model = (DefaultTableModel) jtable9.getModel();
        
         //Display Slected Row In JTexteFields
       id1.setText(model.getValueAt(i,0).toString());


        id2.setText(model.getValueAt(i,1).toString());

        result.setText(model.getValueAt(i,2).toString());  
  
    }//GEN-LAST:event_jtable9MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField id1;
    private javax.swing.JTextField id2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtable9;
    private javax.swing.JTextField result;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
