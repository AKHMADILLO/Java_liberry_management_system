/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframe;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
/**
 *
 * @author ahmad
 */
public class ReturnBook extends javax.swing.JFrame {
Color mouseEnterColor=new Color(0,0,0);
    Color mouseExistColor=new Color(102,102,255);
    Color mouseExistColor1=new Color(255,51,51);
    /**
     * Creates new form IssueBook
     */
    public ReturnBook() {
        initComponents();
    }
    public void getIssueBookDetails(){
    boolean IssueBook=false;
        int bookId=Integer.parseInt(txt_bookId.getText());
      int studentId=Integer.parseInt(txt_studentId.getText());     
    try {         
            Connection con =DBConnection.getConnection();
            PreparedStatement pst =con.prepareStatement("select * from issue_book_details where book_id=? and student_id=? and status=?");
             pst.setInt(1, bookId);
             pst.setInt(2,studentId);
             pst.setString(3, "pending");
            ResultSet rs =  pst.executeQuery();
            if(rs.next()){
            lbl_issueId.setText(rs.getString("id"));
            lbl_bookName.setText(rs.getString("book_name"));
            lbl_studentName.setText(rs.getString("student_name"));
            lbl_issueDate.setText(rs.getString("issue_date"));
            lbl_dueDate.setText(rs.getString("due_date"));
            }
        else{ 
                 lbl_issueId.setText("_");
            lbl_bookName.setText("_");
            lbl_studentName.setText("_");
            lbl_issueDate.setText("_");
            lbl_dueDate.setText("_");       
             JOptionPane.showMessageDialog(this,"No Record Found");            }
    
    }
       catch (Exception e) {
        e.printStackTrace();
    } }
    
    
    // to insert data  into return book details table
     public boolean returnBook(){
         boolean returned=false;
       int bookId=Integer.parseInt(txt_bookId.getText());
        int studentId=Integer.parseInt(txt_studentId.getText());
     
        
        try{
            Connection con = DBConnection.getConnection();
            String sql="update issue_book_details set status=? where student_id=? and book_id=? and status=?";
            PreparedStatement pst=con.prepareStatement(sql);
              pst.setString(1, "returned"); 
            pst.setInt(2, studentId);
             pst.setInt(3,bookId);
             pst.setString(4, "pending");

          
            int updatedRowCount = pst.executeUpdate();
            
            if (updatedRowCount > 0) {
                returned=true;
            }else{
               returned=false; 
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }return returned;
    }
     // update quantity after issuing book     
public void bookUpdate(){
  int bookId=Integer.parseInt(txt_bookId.getText());
    try {  Connection con = DBConnection.getConnection();
            String sql="update book_details set quantity=quantity+1 where book_id=?";
            PreparedStatement pst=con.prepareStatement(sql);
             pst.setInt(1,bookId );
               int updatedRowCount = pst.executeUpdate();
         if (updatedRowCount > 0) {
                JOptionPane.showMessageDialog(this,"Book Count Updated");
       
          }else{
                JOptionPane.showMessageDialog(this," Can't UpdateBook Count ");
            }
    } catch (Exception e) {
    }}
    
    
    
    
    
    
    
    
    
    
    
    
    
 // to bet student datails to the issue page
    /* public void getStudentDetails(){
    int studentId=Integer.parseInt(txt_studentId.getText());
        
    try { 
            Connection con =DBConnection.getConnection();
            PreparedStatement pst =con.prepareStatement("select * from student_details where student_id=?");
             pst.setInt(1, studentId);
            ResultSet rs =  pst.executeQuery();
            if(rs.next()){
            lbl_studentId.setText(rs.getString("student_id"));
            lbl_studentName.setText(rs.getString("name"));
            lbl_course.setText(rs.getString("course"));
            lbl_branch.setText(rs.getString("branch"));
            }
             else{  JOptionPane.showMessageDialog(this,"Incorrect Student Id");
                        
                        }
        }
       catch (Exception e) {
        e.printStackTrace();
    }}
     // to insert datas to issued book details table
     public boolean issueBook(){
         boolean issued=false;
       int bookId=Integer.parseInt(txt_bookId.getText());
        int studentId=Integer.parseInt(txt_studentId.getText());
        String bookName=lbl_bookName.getText();
        String studentName=lbl_studentName.getText();
         java.util.Date uIssueDate= date_issueDate.getDatoFecha();
        
         java.util.Date uDueDate= date_dueDate.getDatoFecha();
         Date  sIssueDate=new Date( uIssueDate.getTime());
         Date sDuedate=new Date(uDueDate.getTime());
        
        try{
            Connection con = DBConnection.getConnection();
            String sql="insert into issue_book_details(book_id,book_name,student_id,student_name,issue_date,due_date,status) values(?,?,?,?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(sql);
            
            pst.setInt(1,bookId );
            pst.setString(2,bookName);
            pst.setInt(3,studentId);
            pst.setString(4,studentName);
            pst.setDate(5, sIssueDate);
            pst.setDate(6, sDuedate);
            pst.setString(7, "pending");
            int updatedRowCount = pst.executeUpdate();
            
            if (updatedRowCount > 0) {
                issued=true;
            }else{
               issued=false; 
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }return issued;
    }
  // update quantity after issuing book     
public void bookUpdate(){
  int bookId=Integer.parseInt(txt_bookId.getText());
    try {  Connection con = DBConnection.getConnection();
            String sql="update book_details set quantity=quantity-1 where book_id=?";
            PreparedStatement pst=con.prepareStatement(sql);
             pst.setInt(1,bookId );
               int updatedRowCount = pst.executeUpdate();
         if (updatedRowCount > 0) {
                JOptionPane.showMessageDialog(this,"Book Count Updated");
           int initialcount=Integer.parseInt(lbl_issueDate.getText());
           lbl_issueDate.setText(Integer.toString(initialcount-1));
          }else{
                JOptionPane.showMessageDialog(this," Can't UpdateBook Count ");
            }
    } catch (Exception e) {
    }}
//to check that book alredy issued
     public boolean isAlreadyissued(){
     boolean isalreadyIssud=false;
         int bookId=Integer.parseInt(txt_bookId.getText());
        int studentId=Integer.parseInt(txt_studentId.getText());
         try { Connection con = DBConnection.getConnection();
            String sql="select * from  issue_book_details  where book_id=? and student_id=? and status=?";
            PreparedStatement pst=con.prepareStatement(sql);
             pst.setInt(1,bookId );
             pst.setInt(2,studentId );
             pst.setString(3, "pending");   
             ResultSet rs = pst.executeQuery();        
          if (rs.next()) {
                isalreadyIssud=true;
            }else{
               isalreadyIssud=false; 
            }
         }catch (Exception e) {e.printStackTrace();
         }return isalreadyIssud;
}*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lbl_issueId = new javax.swing.JLabel();
        lbl_bookName = new javax.swing.JLabel();
        lbl_studentName = new javax.swing.JLabel();
        lbl_issueDate = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbl_dueDate = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        txt_studentId = new app.bolivia.swing.JCTextField();
        txt_bookId = new app.bolivia.swing.JCTextField();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 51, 51));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 30)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel12.setText(" Book Details");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 290, -1));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 310, 5));

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI", 0, 25)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Issue  Id :");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, -1, -1));

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI", 0, 25)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Book  Name :");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 510, -1, -1));

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI", 0, 25)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Student Name:");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 630, -1, -1));

        lbl_issueId.setFont(new java.awt.Font("Yu Gothic UI", 0, 25)); // NOI18N
        lbl_issueId.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(lbl_issueId, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 400, 130, 40));

        lbl_bookName.setFont(new java.awt.Font("Yu Gothic UI", 0, 25)); // NOI18N
        lbl_bookName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(lbl_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 510, 160, 40));

        lbl_studentName.setFont(new java.awt.Font("Yu Gothic UI", 0, 25)); // NOI18N
        lbl_studentName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(lbl_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 630, 240, 40));

        lbl_issueDate.setFont(new java.awt.Font("Yu Gothic UI", 0, 25)); // NOI18N
        lbl_issueDate.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(lbl_issueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 740, 140, 40));

        jLabel17.setFont(new java.awt.Font("Yu Gothic UI", 0, 25)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Due Date:");
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 840, -1, -1));

        jLabel18.setFont(new java.awt.Font("Yu Gothic UI", 0, 25)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Issue Date:");
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 740, -1, -1));

        lbl_dueDate.setFont(new java.awt.Font("Yu Gothic UI", 0, 25)); // NOI18N
        lbl_dueDate.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(lbl_dueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 840, 130, 40));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 0, 630, 1030));

        jPanel8.setBackground(new java.awt.Color(255, 51, 51));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1450, 260, 310, 5));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 51, 51));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel7.setText("Return Book");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1480, 190, 280, -1));

        jPanel10.setBackground(new java.awt.Color(102, 102, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Verdana", 1, 35)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("x");
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel19MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel19MouseExited(evt);
            }
        });
        jPanel10.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 30, 30));

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1770, 0, 150, 60));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Verdana", 0, 25)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Bookt Id:");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 410, 140, 30));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Verdana", 0, 25)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 51, 51));
        jLabel9.setText("Student Id:");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 580, 160, 30));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle1.setText("FIND");
        rSMaterialButtonCircle1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rSMaterialButtonCircle1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rSMaterialButtonCircle1MouseExited(evt);
            }
        });
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1420, 760, 400, 60));

        txt_studentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 0, 51)));
        txt_studentId.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        txt_studentId.setPlaceholder("Enter  Student  Id..");
        txt_studentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_studentIdFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentIdFocusLost(evt);
            }
        });
        txt_studentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentIdActionPerformed(evt);
            }
        });
        jPanel1.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1510, 580, 310, -1));

        txt_bookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 0, 51)));
        txt_bookId.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        txt_bookId.setPlaceholder("Enter  Book Id..");
        txt_bookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_bookIdFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookIdFocusLost(evt);
            }
        });
        txt_bookId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookIdActionPerformed(evt);
            }
        });
        jPanel1.add(txt_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1510, 410, 310, -1));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle2.setText("RETURN BOOK");
        rSMaterialButtonCircle2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rSMaterialButtonCircle2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rSMaterialButtonCircle2MouseExited(evt);
            }
        });
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1420, 870, 400, 60));

        jPanel6.setBackground(new java.awt.Color(102, 102, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel11.setText("Back");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel11MouseExited(evt);
            }
        });
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 100, 40));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 60));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/library-2.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 670, 460));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1030));

        setSize(new java.awt.Dimension(1923, 1027));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_bookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookIdActionPerformed

    private void txt_bookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIdFocusLost
        /*if(!txt_bookId.getText().equals("")){
            getBookDetails();
        }*/
    }//GEN-LAST:event_txt_bookIdFocusLost

    private void txt_bookIdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIdFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookIdFocusGained

    private void txt_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdActionPerformed

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost
        /*if(!txt_studentId.getText().equals("")){
            getStudentDetails();
        }*/

    }//GEN-LAST:event_txt_studentIdFocusLost

    private void txt_studentIdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusGained

    }//GEN-LAST:event_txt_studentIdFocusGained

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
      if(txt_bookId.getText().equals("")||txt_studentId.getText().equals("")){
       JOptionPane.showMessageDialog(this,"fill the blanks first");}
      else{
        getIssueBookDetails();}
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked

    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        HomePage page=new HomePage();
        page.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
       if(returnBook()==true){
       JOptionPane.showMessageDialog(this,"Book Returned Succesfully");
       bookUpdate();
       }
       else{ JOptionPane.showMessageDialog(this,"Book Return Failed");
       
       }
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
       System.exit(0);
    }//GEN-LAST:event_jLabel19MouseClicked

    private void rSMaterialButtonCircle1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1MouseEntered
    rSMaterialButtonCircle1.setBackground(mouseEnterColor);        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle1MouseEntered

    private void rSMaterialButtonCircle1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1MouseExited
      rSMaterialButtonCircle1.setBackground(mouseExistColor1);
    }//GEN-LAST:event_rSMaterialButtonCircle1MouseExited

    private void rSMaterialButtonCircle2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2MouseEntered
rSMaterialButtonCircle2.setBackground(mouseEnterColor);         // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle2MouseEntered

    private void rSMaterialButtonCircle2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2MouseExited
     rSMaterialButtonCircle2.setBackground(mouseExistColor1);      // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle2MouseExited

    private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseEntered
jPanel6.setBackground(mouseEnterColor);         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseEntered

    private void jLabel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseExited
     jPanel6.setBackground(mouseExistColor);   // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseExited

    private void jLabel19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseEntered
jPanel10.setBackground(mouseEnterColor);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel19MouseEntered

    private void jLabel19MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseExited
   jPanel10.setBackground(mouseExistColor);      // TODO add your handling code here:
    }//GEN-LAST:event_jLabel19MouseExited

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
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lbl_bookName;
    private javax.swing.JLabel lbl_dueDate;
    private javax.swing.JLabel lbl_issueDate;
    private javax.swing.JLabel lbl_issueId;
    private javax.swing.JLabel lbl_studentName;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private app.bolivia.swing.JCTextField txt_bookId;
    private app.bolivia.swing.JCTextField txt_studentId;
    // End of variables declaration//GEN-END:variables

 
}
