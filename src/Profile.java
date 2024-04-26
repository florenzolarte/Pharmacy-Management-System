import dao.ConnectionProvider;
import javax.swing.JOptionPane;
import java.sql.*;

public class Profile extends javax.swing.JFrame {

    public String emailPattern = "^[a-zA-Z0-9]+[@]+[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+$";
    public String mobileNumberPattern = "^[0-9]*$";
    private String username = "";

    public Profile() {
        initComponents();
    }

    public Profile(String tempUsername) {
        initComponents();
        username = tempUsername;
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        lblUsername = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMobileNumber = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        jLabel3.setText("jLabel3");

        jTextField2.setText("jTextField2");

        jTextField3.setText("jTextField3");

        jTextField6.setText("jTextField6");

        jLabel9.setText("jLabel9");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(850, 500));
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); 
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Profile");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 15, 135, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 68, 836, 10));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(807, 15, 30, -1));

        lblUsername.setFont(new java.awt.Font("Segoe UI", 0, 36)); 
        lblUsername.setText("Username");
        getContentPane().add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        jLabel5.setText("Name");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 117, 37, -1));

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 138, 300, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        jLabel6.setText("Mobile Number");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, -1, -1));
        getContentPane().add(txtMobileNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 221, 300, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        jLabel7.setText("Email");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 277, 37, -1));

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 298, 300, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        jLabel8.setText("Address");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 355, 58, -1));
        getContentPane().add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 388, 300, -1));

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 430, 80, 30));

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

        setVisible(false);
    }

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {

        String name = txtName.getText();
        String mobileNumber = txtMobileNumber.getText();
        String email = txtEmail.getText();
        String address = txtAddress.getText();

        if (name.equals("")) {
            JOptionPane.showMessageDialog(null, "Name field is required");
        } else if (mobileNumber.equals("")) {
            JOptionPane.showMessageDialog(null, "Number field is required");
        }else if(!mobileNumber.matches(mobileNumberPattern) || mobileNumber.length() != 11){
            JOptionPane.showMessageDialog(null, "Mobile Number field is invalid");
        }else if(email.equals("")){
            JOptionPane.showMessageDialog(null, "Email field is required");
        }else if(!email.matches(emailPattern)){
            JOptionPane.showMessageDialog(null, "Email field is Invalid");
        }else if(address.equals("")){
            JOptionPane.showMessageDialog(null, "Address field is required");
        }else{
            try{
                Connection con = ConnectionProvider.getCon();
                PreparedStatement ps = con.prepareStatement("update appuser set name=?,mobileNumber=?,email=?,address=? where username=?");
                ps.setString(1, name);
                ps.setString(2, mobileNumber);
                ps.setString(3, email);
                ps.setString(4, address);
                ps.setString(5, username);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Profile Successfully Update");
                setVisible(false);
                new Profile(username).setVisible(true);
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "e");
            }
        }
    }

    private void formComponentShown(java.awt.event.ComponentEvent evt) {

        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select *from appuser where username='" + username + "'");
            while (rs.next()) {
                txtName.setText(rs.getString("name"));
                txtMobileNumber.setText(rs.getString("mobileNumber"));
                txtEmail.setText(rs.getString("email"));
                txtAddress.setText(rs.getString("address"));
                lblUsername.setText(username);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Profile().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMobileNumber;
    private javax.swing.JTextField txtName;

}