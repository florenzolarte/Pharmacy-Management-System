import dao.ConnectionProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.util.Date;

public class AddUser extends javax.swing.JFrame {

    public String emailPattern = "^[a-zA-Z0-9]+[@]+[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+$";
    public String mobileNumberPattern = "^[0-9]*$";
    public int checkUsername = 0;

    public AddUser() {
        initComponents();
        iconLabel.setVisible(true);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        comboUserRole = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        dateDOB = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        txtMobileNumber = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        iconLabel = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); 
        jLabel1.setText("Add User");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 56, 855, 10));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        jLabel2.setText("User Role");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 84, 59, -1));

        comboUserRole.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        comboUserRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Pharmacist" }));
        getContentPane().add(comboUserRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 111, 300, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        jLabel3.setText("Name");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 195, 37, -1));

        txtName.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 228, 300, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        jLabel4.setText("DOB (Date Of Birth)");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 279, -1, -1));

        dateDOB.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        getContentPane().add(dateDOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 312, 300, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        jLabel5.setText("Mobile Number");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 362, -1, -1));

        txtMobileNumber.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        txtMobileNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMobileNumberActionPerformed(evt);
            }
        });
        getContentPane().add(txtMobileNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 395, 300, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        jLabel6.setText("Email");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(484, 84, 37, -1));

        txtEmail.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(484, 111, 300, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        jLabel7.setText("Username");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(484, 195, -1, -1));

        txtUsername.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });
        txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUsernameKeyReleased(evt);
            }
        });
        getContentPane().add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(484, 228, 300, -1));
        getContentPane().add(iconLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(802, 218, 37, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        jLabel9.setText("Password");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(484, 279, -1, -1));

        txtPassword.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(484, 312, 300, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        jLabel10.setText("Address");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(484, 362, 52, -1));

        txtAddress.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });
        getContentPane().add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(484, 395, 300, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 440, -1, -1));

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
        jButton3.setText("X");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 10, -1, -1));

        pack();
    }

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void txtMobileNumberActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

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
        String password = txtPassword.getText();
        String address = txtAddress.getText();

        if (name.equals("")) {
            JOptionPane.showMessageDialog(null, "Name field is required");
        } else if (dob.equals("")) {
            JOptionPane.showMessageDialog(null, "Date of Birth field is required");
        } else if (mobileNumber.equals("")) {
            JOptionPane.showMessageDialog(null, "Mobile Number field is required");
        } else if (!mobileNumber.matches(mobileNumberPattern) || mobileNumber.length() != 11) {
            JOptionPane.showMessageDialog(null, "Mobile Number field is invalid");
        } else if (email.equals("")) {
            JOptionPane.showMessageDialog(null, "Email field is required");
        } else if (!email.matches(emailPattern)) {
            JOptionPane.showMessageDialog(null, "Email field is invalid");
        } else if (username.equals("")) {
            JOptionPane.showMessageDialog(null, "Username field is required");
        } else if (checkUsername == 1) {
            JOptionPane.showMessageDialog(null, "Username already exist");
        }else if(password.equals("")){
            JOptionPane.showMessageDialog(null, "Password field is required");
        }else if(address.equals("")){
            JOptionPane.showMessageDialog(null, "Address field is required");
        }else{
            try{
                Connection con = ConnectionProvider.getCon();
                PreparedStatement ps = con.prepareStatement("insert into appuser (userRole,name,dob,mobileNumber,email,username,password,address) values(?,?,?,?,?,?,?,?)");
                ps.setString(1, userRole);
                ps.setString(2, name);
                ps.setString(3, dob);
                ps.setString(4, mobileNumber);
                ps.setString(5, email);
                ps.setString(6, username);
                ps.setString(7, password);
                ps.setString(8, address);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "User Added Successfully");
                setVisible(false);
                new AddUser().setVisible(true);
            }
            catch(Exception e){
               JOptionPane.showMessageDialog(null, e); 
            }
        }
    }

    private void txtUsernameKeyReleased(java.awt.event.KeyEvent evt) {

        String username = txtUsername.getText();
        if (!username.equals("")) {
            iconLabel.setVisible(true);
            iconLabel.setIcon(new ImageIcon("src\\images\\no.png"));
            iconLabel.setText("");
            checkUsername = 0;

            try {
                Connection con = ConnectionProvider.getCon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select *from appuser where username='" + username + "'");
                while (rs.next()) {
                    checkUsername = 1;
                    iconLabel.setIcon(new ImageIcon("src\\images\\yes.png"));
                    iconLabel.setText("");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        } else {
            iconLabel.setVisible(false);
        }
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {

        setVisible(false);
    }

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {

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
            java.util.logging.Logger.getLogger(AddUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddUser().setVisible(true);
            }
        });
    }

    private javax.swing.JComboBox<String> comboUserRole;
    private com.toedter.calendar.JDateChooser dateDOB;
    private javax.swing.JLabel iconLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMobileNumber;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUsername;

}