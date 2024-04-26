import dao.ConnectionProvider;
import javax.swing.JOptionPane;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.table.TableModel;

public class ViewUser extends javax.swing.JFrame {

    private String username = "";

    public ViewUser() {
        initComponents();
    }

    public ViewUser(String tempUsername) {
        initComponents();
        username = tempUsername;
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); 
        jLabel1.setText("View User");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(339, 15, -1, -1));
        jLabel1.getAccessibleContext().setAccessibleDescription("");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 20, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 65, 850, 10));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Role", "Date of Birth (DOB)", "Mobile Number", "Email", "Username", "Password", "Address"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 81, 838, 380));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jLabel2.setText("Click on row to Delete User");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(307, 479, -1, -1));

        pack();
    }

    private void formComponentShown(java.awt.event.ComponentEvent evt) {

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        try{
           Connection con = ConnectionProvider.getCon();
           Statement st = con.createStatement();
           ResultSet rs = st.executeQuery("select *from appuser");
           while(rs.next()) {
               model.addRow(new Object[]{rs.getString("appuser_pk"),rs.getString("name"),rs.getString("userRole"),rs.getString("dob"),rs.getString("mobileNumber"),rs.getString("email"),rs.getString("username"),rs.getString("password"),rs.getString("address")});
           }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
    }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

        setVisible(false);
    }

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {

        int index = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        String id = model.getValueAt(index, 0).toString();
        String usernameTable = model.getValueAt(index, 6).toString() ;
        if(username.equals(usernameTable)){
            JOptionPane.showMessageDialog(null, "You can't delete your own account"); 
        }else{
            int a = JOptionPane.showConfirmDialog(null, "Do you want to delete this user","Select",JOptionPane.YES_NO_OPTION);
            if(a==0){
                try{
                    Connection con = ConnectionProvider.getCon();
                    PreparedStatement ps = con.prepareStatement("delete from appuser where appuser_pk=?");
                    ps.setString(1, id);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "User Successfully Deleted");
                    setVisible(false);
                    new ViewUser(username).setVisible(true);
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }
            }
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
            java.util.logging.Logger.getLogger(ViewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewUser().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;

}