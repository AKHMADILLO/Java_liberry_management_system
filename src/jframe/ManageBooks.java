 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframe;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import static jframe.DBConnection.con;

/**
 *
 * @author ahmad
 */
public class ManageBooks extends javax.swing.JFrame {

    /**
     * Creates new form ManageBooks
     */
    String bookName,author;
    int bookId,quantity;
    DefaultTableModel model;
    Color mouseEnterColor=new Color(0,0,0);
    Color mouseExistColor=new Color(255,51,51);
    
    public ManageBooks() {
        initComponents();
         setBookDetailsToTable();   
    }
public void setBookDetailsToTable(){
    try {  Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","");
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select * from book_details");
        while(rs.next()){
        String bookId=rs.getString("book_id");
        String bookName=rs.getString("book_name");
        String author=rs.getString("author");
        String quantity=rs.getString("quantity");
   Object[] obj={bookId,bookName,author,quantity};
   model=(DefaultTableModel)tbl_bookDetails.getModel();
   model.addRow(obj);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
 }
// add book datails into table 
    public boolean addBooks(){
    boolean isAdded=false;
    bookId=Integer.parseInt(txt_BookId.getText());
    bookName=txt_BookName.getText();
    author=txt_AuthorName.getText();
    quantity=Integer.parseInt(txt_Quantity.getText());
        try {
             Connection con = DBConnection.getConnection();
            String sql="insert into book_details values(?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1, bookId);
            pst.setString(2, bookName);
            pst.setString(3, author);
            pst.setInt(4,quantity);
           
             int RowCount = pst.executeUpdate();
            
            if (RowCount > 0) {
               isAdded=true;
            }else{
                isAdded=false;
            }
            
        } catch (Exception e) {e.printStackTrace();
        }
    return isAdded;
    }
    //Update book 
     public boolean updateBooks(){
    boolean isUpdated=false;
    bookId=Integer.parseInt(txt_BookId.getText());
    bookName=txt_BookName.getText();
    author=txt_AuthorName.getText();
    quantity=Integer.parseInt(txt_Quantity.getText());
        try {
             Connection con = DBConnection.getConnection();
            String sql="update  book_details set book_name=?,author=?,quantity=? where book_id=?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(4, bookId);
            pst.setString(1, bookName);
            pst.setString(2, author);
            pst.setInt(3,quantity);
           
             int RowCount = pst.executeUpdate();
            
            if (RowCount > 0) {
               isUpdated=true;
            }else{
                isUpdated=false;
            }
            
        } catch (Exception e) {e.printStackTrace();
        }
    return isUpdated;
    }
  //Delete Book 
      public boolean deleteBooks(){
    boolean isDeleted=false;
    bookId=Integer.parseInt(txt_BookId.getText());
    
        try {
             Connection con = DBConnection.getConnection();
            String sql="delete from  book_details where book_id=?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1, bookId);
           
           
             int RowCount = pst.executeUpdate();
            
            if (RowCount > 0) {
               isDeleted=true;
            }else{
                isDeleted=false;
            }
            
        } catch (Exception e) {e.printStackTrace();
        }
    return isDeleted;}

//to clear the table
public void clearTable(){
    DefaultTableModel model=(DefaultTableModel)tbl_bookDetails.getModel();
    model.setRowCount(0);


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
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txt_BookId = new app.bolivia.swing.JCTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_BookName = new app.bolivia.swing.JCTextField();
        txt_Quantity = new app.bolivia.swing.JCTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_AuthorName = new app.bolivia.swing.JCTextField();
        jLabel10 = new javax.swing.JLabel();
        rSMaterialButtonCircle1 = new necesario.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new necesario.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new necesario.RSMaterialButtonCircle();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_bookDetails = new rojeru_san.complementos.RSTableMetro();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
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
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 110, 40));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 60));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 60));

        txt_BookId.setBackground(new java.awt.Color(102, 102, 255));
        txt_BookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_BookId.setForeground(new java.awt.Color(255, 255, 255));
        txt_BookId.setCaretColor(new java.awt.Color(255, 255, 255));
        txt_BookId.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txt_BookId.setPhColor(new java.awt.Color(255, 255, 255));
        txt_BookId.setPlaceholder("Enter Book Id...");
        txt_BookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_BookIdFocusLost(evt);
            }
        });
        txt_BookId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_BookIdActionPerformed(evt);
            }
        });
        jPanel1.add(txt_BookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 320, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, 40, 60));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel2.setText("Back");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 110, 40));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Verdana", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(" Book Id");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 190, 40));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Verdana", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText(" Book Name");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, 190, 40));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 60, 60));

        txt_BookName.setBackground(new java.awt.Color(102, 102, 255));
        txt_BookName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_BookName.setForeground(new java.awt.Color(255, 255, 255));
        txt_BookName.setCaretColor(new java.awt.Color(255, 255, 255));
        txt_BookName.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txt_BookName.setName(""); // NOI18N
        txt_BookName.setPhColor(new java.awt.Color(255, 255, 255));
        txt_BookName.setPlaceholder("Enter Book Name...");
        txt_BookName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_BookNameFocusLost(evt);
            }
        });
        txt_BookName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_BookNameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_BookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, 320, 40));

        txt_Quantity.setBackground(new java.awt.Color(102, 102, 255));
        txt_Quantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_Quantity.setForeground(new java.awt.Color(255, 255, 255));
        txt_Quantity.setCaretColor(new java.awt.Color(255, 255, 255));
        txt_Quantity.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txt_Quantity.setName(""); // NOI18N
        txt_Quantity.setPhColor(new java.awt.Color(255, 255, 255));
        txt_Quantity.setPlaceholder("Enter Number of Books..");
        txt_Quantity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_QuantityFocusLost(evt);
            }
        });
        txt_Quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_QuantityActionPerformed(evt);
            }
        });
        jPanel1.add(txt_Quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 710, 320, 40));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 690, 40, 60));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Verdana", 0, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText(" Quantity");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 640, 190, 40));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 540, 40, 60));

        txt_AuthorName.setBackground(new java.awt.Color(102, 102, 255));
        txt_AuthorName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_AuthorName.setForeground(new java.awt.Color(255, 255, 255));
        txt_AuthorName.setCaretColor(new java.awt.Color(255, 255, 255));
        txt_AuthorName.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txt_AuthorName.setPhColor(new java.awt.Color(255, 255, 255));
        txt_AuthorName.setPlaceholder("Enter Author Name...");
        txt_AuthorName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_AuthorNameFocusLost(evt);
            }
        });
        txt_AuthorName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_AuthorNameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_AuthorName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 560, 320, -1));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Verdana", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Author Name");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 490, 190, 40));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle1.setText("DELETE");
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
        jPanel1.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 860, 160, 70));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle2.setText("UPDATE");
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
        jPanel1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 860, 160, 70));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle3.setText("ADD");
        rSMaterialButtonCircle3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rSMaterialButtonCircle3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rSMaterialButtonCircle3MouseExited(evt);
            }
        });
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 860, 170, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 1030));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(102, 102, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Verdana", 1, 40)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("X");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel12MouseExited(evt);
            }
        });
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 50, 40));

        jPanel5.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 0, 150, 60));

        tbl_bookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book Id", "Name", "Author", "Quantity"
            }
        ));
        tbl_bookDetails.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tbl_bookDetails.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        tbl_bookDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_bookDetails.setColorFilasForeground1(new java.awt.Color(0, 0, 255));
        tbl_bookDetails.setColorFilasForeground2(new java.awt.Color(0, 0, 255));
        tbl_bookDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_bookDetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        tbl_bookDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tbl_bookDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        tbl_bookDetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tbl_bookDetails.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbl_bookDetails.setRowHeight(40);
        tbl_bookDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_bookDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_bookDetails);

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, 980, 370));

        jLabel3.setBackground(new java.awt.Color(255, 51, 51));
        jLabel3.setFont(new java.awt.Font("Verdana", 0, 35)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel3.setText("Manage books");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 350, 80));

        jPanel6.setBackground(new java.awt.Color(255, 51, 51));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, 410, 4));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, 1280, 1030));

        setSize(new java.awt.Dimension(1923, 1027));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
     
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txt_BookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_BookIdFocusLost

        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BookIdFocusLost

    private void txt_BookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_BookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BookIdActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked

    private void txt_BookNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_BookNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BookNameFocusLost

    private void txt_BookNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_BookNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BookNameActionPerformed

    private void txt_QuantityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_QuantityFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_QuantityFocusLost

    private void txt_QuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_QuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_QuantityActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseClicked

    private void txt_AuthorNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_AuthorNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_AuthorNameFocusLost

    private void txt_AuthorNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_AuthorNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_AuthorNameActionPerformed

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseClicked

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
       if(addBooks()==true){
        JOptionPane.showMessageDialog(this, "Book Added");
       clearTable();
       setBookDetailsToTable();
      }
      else{ JOptionPane.showMessageDialog(this, "Book Addition Failed");
        
       }
        
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
         HomePage page=new HomePage();
       page.setVisible(true);
        dispose();// TODO add your handling code here:
                                 // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseClicked

    private void tbl_bookDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_bookDetailsMouseClicked
        int rowNo=tbl_bookDetails.getSelectedRow();
        TableModel model=tbl_bookDetails.getModel();
        txt_BookId.setText(model.getValueAt(rowNo, 0).toString());
        txt_BookName.setText(model.getValueAt(rowNo, 1).toString());
        txt_AuthorName.setText(model.getValueAt(rowNo, 2).toString());
        txt_Quantity.setText(model.getValueAt(rowNo, 3).toString());
    }//GEN-LAST:event_tbl_bookDetailsMouseClicked

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
       if(updateBooks()==true){
        JOptionPane.showMessageDialog(this, "Book Updated");
       clearTable();
       setBookDetailsToTable();
      }
      else{ JOptionPane.showMessageDialog(this, "Book Updation Failed");
        
       }
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
if(deleteBooks()==true){
        JOptionPane.showMessageDialog(this, "Book Deleted");
       clearTable();
       setBookDetailsToTable();
      }
      else{ JOptionPane.showMessageDialog(this, "Book Deletion Failed");
        
       }      
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseEntered
        jPanel3.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel11MouseEntered

    private void jLabel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseExited
        jPanel3.setBackground(mouseExistColor);
    }//GEN-LAST:event_jLabel11MouseExited

    private void rSMaterialButtonCircle3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3MouseEntered
       rSMaterialButtonCircle3.setBackground(mouseEnterColor);
    }//GEN-LAST:event_rSMaterialButtonCircle3MouseEntered

    private void rSMaterialButtonCircle3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3MouseExited
        rSMaterialButtonCircle3.setBackground(mouseExistColor);
    }//GEN-LAST:event_rSMaterialButtonCircle3MouseExited

    private void rSMaterialButtonCircle2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2MouseEntered
       rSMaterialButtonCircle2.setBackground(mouseEnterColor);
    }//GEN-LAST:event_rSMaterialButtonCircle2MouseEntered

    private void rSMaterialButtonCircle2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2MouseExited
       rSMaterialButtonCircle2.setBackground(mouseExistColor);
    }//GEN-LAST:event_rSMaterialButtonCircle2MouseExited

    private void rSMaterialButtonCircle1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1MouseEntered
     rSMaterialButtonCircle1.setBackground(mouseEnterColor);        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle1MouseEntered

    private void rSMaterialButtonCircle1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1MouseExited
       rSMaterialButtonCircle1.setBackground(mouseExistColor); 
    }//GEN-LAST:event_rSMaterialButtonCircle1MouseExited

    private void jLabel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseEntered
      jPanel4.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel12MouseEntered

    private void jLabel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseExited
       jPanel4.setBackground(mouseExistColor);
    }//GEN-LAST:event_jLabel12MouseExited

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
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageBooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private rojeru_san.complementos.RSTableMetro tbl_bookDetails;
    private app.bolivia.swing.JCTextField txt_AuthorName;
    private app.bolivia.swing.JCTextField txt_BookId;
    private app.bolivia.swing.JCTextField txt_BookName;
    private app.bolivia.swing.JCTextField txt_Quantity;
    // End of variables declaration//GEN-END:variables
}
