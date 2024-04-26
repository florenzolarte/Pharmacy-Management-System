import dao.ConnectionProvider;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.Date;

public class UpdateUser extends javax.swing.JFrame {

    private String emailPattern = "^[a-zA-Z0-9]+[@]+[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+$";
    private String mobileNumberPattern = "^[0-9]*$";

    public UpdateUser() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        comboUserRole = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        dateDOB = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtMobileNumber = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();

        jLabel4.setText("jLabel4");

        jLabel5.setText("jLabel5");

        jTextField2.setText("jTextField2");

        jLabel7.setText("jLabel7");

        jTextField5.setText("jTextField5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); 
        jLabel1.setText("Update User");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(302, 0, 240, 50));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 56, 850, 10));

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); 
        jLabel2.setText("Username");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 83, 71, -1));
        getContentPane().add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 80, 300, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); 
        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 78, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); 
        jLabel3.setText("User Role");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 123, 60, -1));

        comboUserRole.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        comboUserRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Pharmacist" }));
        comboUserRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboUserRoleActionPerformed(evt);
            }
        });
        getContentPane().add(comboUserRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 144, 299, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); 
        jLabel6.setText("Name");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 216, 37, -1));

        txtName.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 237, 299, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); 
        jLabel8.setText("Date of Birth");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 301, -1, -1));
        getContentPane().add(dateDOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 328, 299, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); 
        jLabel9.setText("Email");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(487, 123, 37, -1));

        txtEmail.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(487, 144, 300, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); 
        jLabel10.setText("Mobile Number");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(487, 216, -1, -1));

        txtMobileNumber.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        getContentPane().add(txtMobileNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(487, 237, 300, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); 
        jLabel11.setText("Address");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(487, 301, -1, -1));

        txtAddress.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        getContentPane().add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(487, 328, 300, -1));

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); 
        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 380, 80, 30));

        pack();
    }

    @SuppressWarnings("empty-statement")
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {

        int checkUserExist = 0;
        String username = txtUsername.getText();
        if (username.equals("")) {
            JOptionPane.showMessageDialog(null, "Username field is required.");
        } else {
            SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
            try {
                Connection con = ConnectionProvider.getCon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select *from appuser where username='" + username + "'");
                while (rs.next()) {
                    txtUsername.setEditable(false);
                    checkUserExist = 1;
                    txtName.setText(rs.getString("name"));
                    txtMobileNumber.setText(rs.getString("mobileNumber"));
                    txtEmail.setText(rs.getString("email"));
                    txtAddress.setText(rs.getString("address"));
                    String dob = rs.getString("dob");
                    if (dob != "") {
                        try {
                            dateDOB.setDate(dFormat.parse(dob));
                        } catch (Exception e) {
                        }
                    }
                    if (rs.getString("userRole").equals("Admin")) {
                        comboUserRole.removeAllItems();
                        comboUserRole.addItem("Admin");
                        comboUserRole.addItem("Pharmacist");
                    } else {
                        comboUserRole.removeAllItems();
                        comboUserRole.addItem("Pharmacist");
                        comboUserRole.addItem("Admin");
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            if (checkUserExist == 0) {
                JOptionPane.showMessageDialog(null, "Username does not exist");
            }
        }
    }

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {

        String userRole = (String) comboUserRole.getSelectedItem();
        String name = txtName.getText();
        SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = dateDOB.getDate();
        String dob = "";
        if (date != null) {
            dob = dFormat.format(dateDOB.getDate());
        }
        String mobileNumber = txtMobileNumber.getText();
        String email = txtEmail.getText();
        String username = txtUsername.getText();
        String address = txtAddress.getText();

        if (name.equals("")) {
            JOptionPane.showMessageDialog(null, "Name field is required.");
        } else if (dob.equals("")) {
            JOptionPane.showMessageDialog(null, "Date of Birth field is required.");
        } else if (mobileNumber.equals("")) {
            JOptionPane.showMessageDialog(null, "Mobile Number field is required.");
        } else if (!mobileNumber.matches(mobileNumberPattern) || mobileNumber.length() != 11) {
            JOptionPane.showMessageDialog(null, "Mobile Number field is invalid.");
        } else if (email.equals("")) {
            JOptionPane.showMessageDialog(null, "Email field is required.");
        } else if (!email.matches(emailPattern)) {
            JOptionPane.showMessageDialog(null, "Email field is Invalid.");
        } else if (username.equals("")) {
            JOptionPane.showMessageDialog(null, "Username field is required.");
        } else if (address.equals("")) {
            JOptionPane.showMessageDialog(null, "Address field is required.");
        } else {
            try {
                Connection con = ConnectionProvider.getCon();
                PreparedStatement ps = con.prepareStatement("update appuser set userRole=?,name=?,dob=?,mobileNumber=?,email=?,address=? where username=?");
                ps.setString(1, userRole);
                ps.setString(2, name);
                ps.setString(3, dob);
                ps.setString(4, mobileNumber);
                ps.setString(5, email);
                ps.setString(6, address);
                ps.setString(7, username);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "User Updated Successfully");
                setVisible(false);
                new UpdateUser().setVisible(true);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

        setVisible(false);
    }

    private void comboUserRoleActionPerformed(java.awt.event.ActionEvent evt) {

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
            java.util.logging.Logger.getLogger(UpdateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateUser().setVisible(true);
            }
        });
    }

    private javax.swing.JComboBox<String> comboUserRole;
    private com.toedter.calendar.JDateChooser dateDOB;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMobileNumber;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtUsername;

}