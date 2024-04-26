import javax.swing.JOptionPane;
import java.sql.Connection;
import dao.ConnectionProvider;
import java.sql.Statement;
import java.sql.ResultSet;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font("Tahoma", 1, 12)); 
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); 
        jLabel1.setText("Login");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 280, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jLabel2.setText("Username");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 340, -1, -1));

        txtUsername.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        getContentPane().add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 340, 309, -1));

        txtPassword.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 380, 309, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 420, 90, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jLabel3.setText("Password");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 380, -1, -1));

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        jButton3.setText("X");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 30, 30, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 48)); 
        jLabel5.setText("PHARMACY STOCK MANAGEMENT");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, -1, 60));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); 
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 170, 100));

        pack();
    }

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

        String username = txtUsername.getText();
        String password = txtPassword.getText();

        int temp = 0;

        try{
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select *from appuser where username='"+username+"' and password='"+password+"'");
            while(rs.next()) {
                temp = 1;
                if(rs.getString("userRole").equals("Admin")){
                    setVisible(false);
                    new AdminDashboard(username).setVisible(true);
                }
                else{
                    setVisible(false);
                    new PharmacistDashboard(username).setVisible(true);
                }
            }

            if(temp == 0) {
                JOptionPane.showMessageDialog(null,"Incorrect Username or Password");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {

        int a  = JOptionPane.showConfirmDialog(null, "Do you want to close application", "Select",JOptionPane.YES_NO_OPTION);
        if(a==0){
            System.exit(0);
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;

}