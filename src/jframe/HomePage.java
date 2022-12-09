/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import static jframe.DBConnection.con;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author ahmad
 */
public class HomePage extends javax.swing.JFrame {
Color mouseEnterColor1=new Color(255,51,51);
    Color mouseExistColor1=new Color(102,102,255);
    /**
     * Creates new form HomePage
     */
   Color mouseEnterColor=new Color(0,0,0);
    Color mouseExistColor=new Color(51,51,51);
     DefaultTableModel model;
    public HomePage() {
        initComponents();
        showPieChart();
        setBookDetailsToTable();
        setStudentDetailsToTable();
        setDateToCArds();
    }
    public void setStudentDetailsToTable(){
    try {  Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","");
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select * from student_details");
        while(rs.next()){
        String studentId=rs.getString("student_id");
        String studentName=rs.getString("name");
        String course=rs.getString("course");
        String branch=rs.getString("branch");
   Object[] obj={studentId,studentName,course,branch};
   model=(DefaultTableModel)tbl_studentDetails.getModel();
   model.addRow(obj);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
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
   model=(DefaultTableModel)tbl_bookdetails.getModel();
   model.addRow(obj);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
 }
    public void setDateToCArds(){
    Statement st=null;
    ResultSet rs=null;
    long l=System.currentTimeMillis();
    Date todaysdate=new Date(l);
        try {
            Connection con=DBConnection.getConnection();
            st=con.createStatement();
            rs   =st.executeQuery("select * from book_details");
            rs.last();
            lbl_noOfBooks.setText(Integer.toString(rs.getRow()));
             rs   =st.executeQuery("select * from student_details");
            rs.last();
            lbl_noOfStudents.setText(Integer.toString(rs.getRow()));
             rs   =st.executeQuery("select * from issue_book_details where status ='"+"pending"+"'");
            rs.last();
            lbl_noOfIssuedBooks.setText(Integer.toString(rs.getRow()));
             rs   =st.executeQuery("select * from issue_book_details where due_date <'"+todaysdate+"'and status ='"+"pending"+"'");
            rs.last();
            lbl_noOfStudentsInDefoultList.setText(Integer.toString(rs.getRow()));
        } catch (Exception e) {
        }
                
    }
public void showPieChart(){
        
        //create dataset
      DefaultPieDataset barDataset = new DefaultPieDataset( );
      try {
        Connection con=DBConnection.getConnection();
        String sql="select book_name , count(*) as issue_count from issue_book_details group by book_id";
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(sql);
        while(rs.next()){
        barDataset.setValue(rs.getString("book_name"),new Double(rs.getDouble("issue_count")));}
    } catch (Exception e) {e.printStackTrace();
    }
      
      //create chart
       JFreeChart piechart = ChartFactory.createPieChart("Issue Book Details",barDataset, true,true,false);//explain
      
        PiePlot piePlot =(PiePlot) piechart.getPlot();
      
       //changing pie chart blocks colors
       piePlot.setSectionPaint("IPhone 5s", new Color(255,255,102));
        piePlot.setSectionPaint("SamSung Grand", new Color(102,255,102));
        piePlot.setSectionPaint("MotoG", new Color(255,102,153));
        piePlot.setSectionPaint("Nokia Lumia", new Color(0,204,204));
      
       
        piePlot.setBackgroundPaint(Color.white);
        
        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        panelPieChart.removeAll();
        panelPieChart.add(barChartPanel, BorderLayout.CENTER);
        panelPieChart.validate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanelz = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lbl_noOfBooks = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        lbl_noOfStudents = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        lbl_noOfIssuedBooks = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        lbl_noOfStudentsInDefoultList = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_studentDetails = new rojeru_san.complementos.RSTableMetro();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_bookdetails = new rojeru_san.complementos.RSTableMetro();
        jLabel35 = new javax.swing.JLabel();
        panelPieChart = new javax.swing.JPanel();

        jPanel9.setBackground(new java.awt.Color(255, 51, 51));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel9.setText("Home page");
        jPanel9.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, 30));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel10.setText("Home page");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_menu_48px_1.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 70));

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 5, 50));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 40)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("BOOKAHOLIC");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 570, 70));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 50)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("x");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1880, 0, -1, 60));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 35)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/male_user_50px.png"))); // NOI18N
        jLabel4.setText(" Admin");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1670, 0, -1, 70));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 70));

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Book_26px.png"))); // NOI18N
        jLabel7.setText("    View Issued Records");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel7MouseExited(evt);
            }
        });
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, 450, 70));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("Features");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 100, -1));

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Sell_26px.png"))); // NOI18N
        jLabel5.setText("    Issue Book");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
        });
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, 30));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 450, 70));

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 153, 153));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel11.setText("   LMS Dashboard");
        jPanel8.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        jPanel5.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 450, 70));

        jPanel14.setBackground(new java.awt.Color(255, 51, 51));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel13.setText("  Home page");
        jPanel14.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, 30));

        jPanel5.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 450, 70));

        jPanel15.setBackground(new java.awt.Color(51, 51, 51));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 153, 153));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_View_Details_26px.png"))); // NOI18N
        jLabel14.setText("    View Records");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel14MouseExited(evt);
            }
        });
        jPanel15.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, 30));

        jPanel5.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 450, 70));

        jPanelz.setBackground(new java.awt.Color(51, 51, 51));
        jPanelz.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelzMouseEntered(evt);
            }
        });
        jPanelz.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(153, 153, 153));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Return_Purchase_26px.png"))); // NOI18N
        jLabel15.setText("    Return Book");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel15MouseExited(evt);
            }
        });
        jPanelz.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        jPanel5.add(jPanelz, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 450, 70));

        jPanel17.setBackground(new java.awt.Color(51, 51, 51));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(153, 153, 153));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Conference_26px.png"))); // NOI18N
        jLabel16.setText("    Defaulter List");
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel16MouseExited(evt);
            }
        });
        jPanel17.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        jPanel5.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 690, 450, 70));

        jPanel18.setBackground(new java.awt.Color(51, 51, 51));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(153, 153, 153));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Read_Online_26px.png"))); // NOI18N
        jLabel17.setText("    Manage Students");
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel17MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel17MouseExited(evt);
            }
        });
        jPanel18.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        jPanel5.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 450, 70));

        jPanel19.setBackground(new java.awt.Color(102, 102, 255));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Exit_26px_2.png"))); // NOI18N
        jLabel18.setText("   Logout");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel18MouseExited(evt);
            }
        });
        jPanel19.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        jPanel5.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 770, 450, 70));

        jPanel20.setBackground(new java.awt.Color(51, 51, 51));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(153, 153, 153));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Books_26px.png"))); // NOI18N
        jLabel19.setText("    Manage Books");
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
        jPanel20.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        jPanel5.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 450, 70));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 450, 960));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 51, 51)));
        jPanel3.setPreferredSize(new java.awt.Dimension(260, 1));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_noOfBooks.setFont(new java.awt.Font("Times New Roman", 1, 50)); // NOI18N
        lbl_noOfBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Book_Shelf_50px.png"))); // NOI18N
        lbl_noOfBooks.setText("10");
        jPanel3.add(lbl_noOfBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 120, 70));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 260, 140));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel20.setText("Student Details");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 210, 30));

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel22.setText("No Of  Students");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 210, 30));

        jPanel10.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(102, 102, 255)));
        jPanel10.setPreferredSize(new java.awt.Dimension(260, 1));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_noOfStudents.setFont(new java.awt.Font("Times New Roman", 1, 50)); // NOI18N
        lbl_noOfStudents.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_People_50px.png"))); // NOI18N
        lbl_noOfStudents.setText("10");
        jPanel10.add(lbl_noOfStudents, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 120, 70));

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel24.setText("No Of  Students");
        jPanel10.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 210, 30));

        jPanel11.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 51, 51)));
        jPanel11.setPreferredSize(new java.awt.Dimension(260, 1));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 50)); // NOI18N
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Book_Shelf_50px.png"))); // NOI18N
        jLabel25.setText("10");
        jPanel11.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 120, 70));

        jLabel26.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel26.setText("No Of  Students");
        jPanel11.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 210, 30));

        jPanel10.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 260, 140));

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, 260, 140));

        jPanel12.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 51, 51)));
        jPanel12.setPreferredSize(new java.awt.Dimension(260, 1));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_noOfIssuedBooks.setFont(new java.awt.Font("Times New Roman", 1, 50)); // NOI18N
        lbl_noOfIssuedBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Sell_50px.png"))); // NOI18N
        lbl_noOfIssuedBooks.setText("10");
        jPanel12.add(lbl_noOfIssuedBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 120, 70));

        jPanel1.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 130, 260, 140));

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel28.setText("Issued Books");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 90, 210, 30));

        jPanel13.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(102, 102, 255)));
        jPanel13.setPreferredSize(new java.awt.Dimension(260, 1));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_noOfStudentsInDefoultList.setFont(new java.awt.Font("Times New Roman", 1, 50)); // NOI18N
        lbl_noOfStudentsInDefoultList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_List_of_Thumbnails_50px.png"))); // NOI18N
        lbl_noOfStudentsInDefoultList.setText("10");
        jPanel13.add(lbl_noOfStudentsInDefoultList, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 120, 70));

        jLabel30.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel30.setText("No Of  Students");
        jPanel13.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 210, 30));

        jPanel21.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 51, 51)));
        jPanel21.setPreferredSize(new java.awt.Dimension(260, 1));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setFont(new java.awt.Font("Times New Roman", 1, 50)); // NOI18N
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Book_Shelf_50px.png"))); // NOI18N
        jLabel31.setText("10");
        jPanel21.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 120, 70));

        jLabel32.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel32.setText("No Of  Students");
        jPanel21.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 210, 30));

        jPanel13.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 260, 140));

        jPanel1.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 130, 260, 140));

        jLabel33.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel33.setText("Defaulter List");
        jPanel1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 90, 210, 30));

        tbl_studentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Id", "Name", "Course", "Branch"
            }
        ));
        tbl_studentDetails.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tbl_studentDetails.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        tbl_studentDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_studentDetails.setColorFilasForeground1(new java.awt.Color(0, 0, 255));
        tbl_studentDetails.setColorFilasForeground2(new java.awt.Color(0, 0, 255));
        tbl_studentDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_studentDetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        tbl_studentDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tbl_studentDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        tbl_studentDetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tbl_studentDetails.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbl_studentDetails.setRowHeight(40);
        jScrollPane1.setViewportView(tbl_studentDetails);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 790, 210));

        jLabel34.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel34.setText("No Of  Books");
        jPanel1.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 210, 30));

        tbl_bookdetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book Id", "Name", "Author", "Quantity"
            }
        ));
        tbl_bookdetails.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tbl_bookdetails.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        tbl_bookdetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_bookdetails.setColorFilasForeground1(new java.awt.Color(0, 0, 255));
        tbl_bookdetails.setColorFilasForeground2(new java.awt.Color(0, 0, 255));
        tbl_bookdetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_bookdetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        tbl_bookdetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tbl_bookdetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        tbl_bookdetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tbl_bookdetails.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbl_bookdetails.setRowHeight(40);
        jScrollPane2.setViewportView(tbl_bookdetails);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 620, 790, 210));

        jLabel35.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel35.setText("Book Details");
        jPanel1.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 580, 210, 30));

        panelPieChart.setLayout(new java.awt.BorderLayout());
        jPanel1.add(panelPieChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 340, 540, 480));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, 1470, 960));

        setSize(new java.awt.Dimension(1923, 1027));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
ManageBooks books=new ManageBooks();
books.setVisible(true);
        dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseEntered
       jPanel20.setBackground(mouseEnterColor);
       
    }//GEN-LAST:event_jLabel19MouseEntered

    private void jLabel19MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseExited
          jPanel20.setBackground(mouseExistColor);
    }//GEN-LAST:event_jLabel19MouseExited

    private void jLabel17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseEntered
     jPanel18.setBackground(mouseEnterColor);       
    }//GEN-LAST:event_jLabel17MouseEntered

    private void jLabel17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseExited
          jPanel18.setBackground(mouseExistColor);
    }//GEN-LAST:event_jLabel17MouseExited

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
       jPanel6.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
      jPanel6.setBackground(mouseExistColor);
    }//GEN-LAST:event_jLabel5MouseExited

    private void jPanelzMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelzMouseEntered
        jPanelz.setBackground(mouseExistColor);
    }//GEN-LAST:event_jPanelzMouseEntered
     
    private void jLabel15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseExited
       jPanelz.setBackground(mouseExistColor);
    }//GEN-LAST:event_jLabel15MouseExited

    private void jLabel15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseEntered
           jPanelz.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel15MouseEntered

    private void jLabel14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseEntered
       jPanel15.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel14MouseEntered

    private void jLabel14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseExited
      jPanel15.setBackground(mouseExistColor);
    }//GEN-LAST:event_jLabel14MouseExited

    private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseEntered
         jPanel7.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel7MouseEntered

    private void jLabel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseExited
        jPanel7.setBackground(mouseExistColor);
    }//GEN-LAST:event_jLabel7MouseExited

    private void jLabel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseEntered
         jPanel17.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel16MouseEntered

    private void jLabel16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseExited
       jPanel17.setBackground(mouseExistColor);
    }//GEN-LAST:event_jLabel16MouseExited

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
         ManageStudents page=new ManageStudents();
       page.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
          IssueBook page=new IssueBook();
       page.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
     ReturnBook page=new ReturnBook();
     page.setVisible(true);
     dispose();

    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
       ViewAllRecords page=new ViewAllRecords();
       page.setVisible(true);
       dispose();
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
      ViewIssuedRecords page=new ViewIssuedRecords();
      page.setVisible(true);
        dispose();
              
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
   DefoulterList page=new DefoulterList();
   page.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
      SignupPage page=new SignupPage();
      page.setVisible(true);
      dispose();
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseEntered
       jPanel19.setBackground(mouseEnterColor1);
                                       
    }//GEN-LAST:event_jLabel18MouseEntered

    private void jLabel18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseExited
         jPanel19.setBackground(mouseExistColor1);
    }//GEN-LAST:event_jLabel18MouseExited

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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelz;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_noOfBooks;
    private javax.swing.JLabel lbl_noOfIssuedBooks;
    private javax.swing.JLabel lbl_noOfStudents;
    private javax.swing.JLabel lbl_noOfStudentsInDefoultList;
    private javax.swing.JPanel panelPieChart;
    private rojeru_san.complementos.RSTableMetro tbl_bookdetails;
    private rojeru_san.complementos.RSTableMetro tbl_studentDetails;
    // End of variables declaration//GEN-END:variables
}
