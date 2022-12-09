/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframe;

import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
/**
 *
 * @author ahmad
 */
public class IssueBook extends javax.swing.JFrame {
 Color mouseEnterColor=new Color(0,0,0);
    Color mouseExistColor=new Color(102,102,255);
    Color mouseExistColor1=new Color(255,51,51);
    /**
     * Creates new form IssueBook
     */
    public IssueBook() {
        initComponents();
    }
    public void getBookDetails(){
    int bookId=Integer.parseInt(txt_bookId.getText());
        
    try { 
            Connection con =DBConnection.getConnection();
            PreparedStatement pst =con.prepareStatement("select * from book_details where book_id=?");
             pst.setInt(1, bookId);
            ResultSet rs =  pst.executeQuery();
            if(rs.next()){
            lbl_bookId.setText(rs.getString("book_id"));
            lbl_bookName.setText(rs.getString("book_name"));
            lbl_author.setText(rs.getString("author"));
            lbl_quantity.setText(rs.getString("quantity"));
            }
        else{ lbl_bookId.setText("");
            lbl_bookName.setText("");
            lbl_author.setText("");
            lbl_quantity.setText("");
            JOptionPane.showMessageDialog(this,"Incorrect Book Id");
                        
                        }
    
    }
       catch (Exception e) {
        e.printStackTrace();
    }}
 // to bet student datails to the issue page
     public void getStudentDetails(){
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
             else{ lbl_studentId.setText("");
            lbl_studentName.setText("");
            lbl_course.setText("");
            lbl_branch.setText(""); 
                JOptionPane.showMessageDialog(this,"Incorrect Student Id");
                        
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
           int initialcount=Integer.parseInt(lbl_quantity.getText());
           lbl_quantity.setText(Integer.toString(initialcount-1));
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_studentId = new javax.swing.JLabel();
        lbl_studentName = new javax.swing.JLabel();
        lbl_course = new javax.swing.JLabel();
        lbl_branch = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lbl_bookId = new javax.swing.JLabel();
        lbl_bookName = new javax.swing.JLabel();
        lbl_author = new javax.swing.JLabel();
        lbl_quantity = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        date_issueDate = new rojeru_san.componentes.RSDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        date_dueDate = new rojeru_san.componentes.RSDateChooser();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        txt_studentId = new app.bolivia.swing.JCTextField();
        txt_bookId = new app.bolivia.swing.JCTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Student_Registration_100px_2.png"))); // NOI18N
        jLabel2.setText(" Student Details");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 330, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 350, 5));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 0, 25)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Branch:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 740, -1, -1));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 0, 25)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Student  Id :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, -1, -1));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 0, 25)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Student Name :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 510, -1, -1));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 0, 25)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Course:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 630, -1, -1));

        lbl_studentId.setFont(new java.awt.Font("Yu Gothic UI", 0, 25)); // NOI18N
        lbl_studentId.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lbl_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 390, 250, 50));

        lbl_studentName.setFont(new java.awt.Font("Yu Gothic UI", 0, 25)); // NOI18N
        lbl_studentName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lbl_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 490, 310, 70));

        lbl_course.setFont(new java.awt.Font("Yu Gothic UI", 0, 25)); // NOI18N
        lbl_course.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lbl_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 600, 280, 90));

        lbl_branch.setFont(new java.awt.Font("Yu Gothic UI", 0, 25)); // NOI18N
        lbl_branch.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lbl_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 720, 270, 70));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 0, 600, 1030));

        jPanel5.setBackground(new java.awt.Color(255, 51, 51));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 60));

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
        jLabel14.setText("Book  Id :");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, -1, -1));

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI", 0, 25)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Book  Name :");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 510, -1, -1));

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI", 0, 25)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Author :");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 630, -1, -1));

        lbl_bookId.setFont(new java.awt.Font("Yu Gothic UI", 0, 25)); // NOI18N
        lbl_bookId.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(lbl_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, 260, 70));

        lbl_bookName.setFont(new java.awt.Font("Yu Gothic UI", 0, 25)); // NOI18N
        lbl_bookName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(lbl_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 500, 280, 60));

        lbl_author.setFont(new java.awt.Font("Yu Gothic UI", 0, 25)); // NOI18N
        lbl_author.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(lbl_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 610, 280, 70));

        lbl_quantity.setFont(new java.awt.Font("Yu Gothic UI", 0, 25)); // NOI18N
        lbl_quantity.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(lbl_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 730, 160, 50));

        jLabel17.setFont(new java.awt.Font("Yu Gothic UI", 0, 25)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Quantity:");
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 740, -1, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 1030));

        jPanel8.setBackground(new java.awt.Color(255, 51, 51));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1440, 260, 380, 5));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 51, 51));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel7.setText("Issue Book");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1500, 190, 240, -1));

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
        jLabel1.setFont(new java.awt.Font("Verdana", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Bookt Id:");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 400, 120, 30));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Verdana", 0, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 51, 51));
        jLabel8.setText("Issue Date:");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 630, 130, 30));

        date_issueDate.setColorBackground(new java.awt.Color(255, 51, 51));
        date_issueDate.setColorForeground(new java.awt.Color(255, 51, 51));
        date_issueDate.setFont(new java.awt.Font("Tahoma", 0, 117)); // NOI18N
        date_issueDate.setFuente(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        date_issueDate.setPlaceholder("Select Issue Date...");
        jPanel1.add(date_issueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1460, 620, 370, 50));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Verdana", 0, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 51, 51));
        jLabel9.setText("Student Id:");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 510, 130, 30));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Verdana", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 51, 51));
        jLabel10.setText("Due Date:");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 740, 110, 30));

        date_dueDate.setColorBackground(new java.awt.Color(255, 51, 51));
        date_dueDate.setColorForeground(new java.awt.Color(255, 51, 51));
        date_dueDate.setFont(new java.awt.Font("Tahoma", 0, 117)); // NOI18N
        date_dueDate.setFuente(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        date_dueDate.setPlaceholder("Select Due Date...");
        jPanel1.add(date_dueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1460, 730, 370, 50));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle1.setText("ISSUE BOOK");
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
        jPanel1.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 860, 400, 70));

        txt_studentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 0, 51)));
        txt_studentId.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
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
        jPanel1.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1460, 480, 330, 50));

        txt_bookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 0, 51)));
        txt_bookId.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
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
        jPanel1.add(txt_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1460, 380, 330, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1030));

        setSize(new java.awt.Dimension(1923, 1027));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked

    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
         HomePage page=new HomePage();
       page.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void txt_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdActionPerformed

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost
       if(!txt_studentId.getText().equals("")){
            getStudentDetails();
     }
                
                
    }//GEN-LAST:event_txt_studentIdFocusLost

    private void txt_studentIdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusGained
      
    }//GEN-LAST:event_txt_studentIdFocusGained

    private void txt_bookIdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIdFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookIdFocusGained

    private void txt_bookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIdFocusLost
       if(!txt_bookId.getText().equals("")){
            getBookDetails();
     }
    }//GEN-LAST:event_txt_bookIdFocusLost

    private void txt_bookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookIdActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
        if(lbl_quantity.getText().equals("0")){
        JOptionPane.showMessageDialog(this, "Book in not available");
        }else{
        if(isAlreadyissued()==false){
        if(issueBook()==true){
        JOptionPane.showMessageDialog(this, "Book issued succesfully");
         bookUpdate();
        }
        else{
        JOptionPane.showMessageDialog(this, "can't issue the book");
        }}
        else{JOptionPane.showMessageDialog(this, "The Student Already Has The Book");}}
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseEntered
       jPanel6.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel11MouseEntered

    private void jLabel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseExited
        jPanel6.setBackground(mouseExistColor); 
    }//GEN-LAST:event_jLabel11MouseExited

    private void jLabel19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseEntered
      jPanel10.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel19MouseEntered

    private void jLabel19MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseExited
       jPanel10.setBackground(mouseExistColor);
    }//GEN-LAST:event_jLabel19MouseExited

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel19MouseClicked

    private void rSMaterialButtonCircle1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1MouseEntered
     rSMaterialButtonCircle1.setBackground(mouseEnterColor);
    }//GEN-LAST:event_rSMaterialButtonCircle1MouseEntered

    private void rSMaterialButtonCircle1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1MouseExited
        rSMaterialButtonCircle1.setBackground(mouseExistColor1);
    }//GEN-LAST:event_rSMaterialButtonCircle1MouseExited

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
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.componentes.RSDateChooser date_dueDate;
    private rojeru_san.componentes.RSDateChooser date_issueDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lbl_author;
    private javax.swing.JLabel lbl_bookId;
    private javax.swing.JLabel lbl_bookName;
    private javax.swing.JLabel lbl_branch;
    private javax.swing.JLabel lbl_course;
    private javax.swing.JLabel lbl_quantity;
    private javax.swing.JLabel lbl_studentId;
    private javax.swing.JLabel lbl_studentName;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private app.bolivia.swing.JCTextField txt_bookId;
    private app.bolivia.swing.JCTextField txt_studentId;
    // End of variables declaration//GEN-END:variables

 
}
