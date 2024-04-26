import dao.ConnectionProvider;
import javax.swing.JOptionPane;
import java.sql.*;

public class AddMedicine extends javax.swing.JFrame {

    public String numberPattern = "^[0-9]*$";

    public AddMedicine() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtUniqueId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCompanyName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPricePerUnit = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(850, 500));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); 
        jLabel1.setText("Add Medicine");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 6, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 68, 850, 10));

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(807, 15, -1, -1));

        jLabel2.setText("Medicine ID");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 115, -1, -1));

        txtUniqueId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUniqueIdActionPerformed(evt);
            }
        });
        getContentPane().add(txtUniqueId, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 137, 300, -1));

        jLabel3.setText("Name");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 37, -1));

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 202, 300, -1));

        jLabel4.setText("Company Name");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, -1, -1));

        txtCompanyName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCompanyNameActionPerformed(evt);
            }
        });
        getContentPane().add(txtCompanyName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 288, 300, -1));

        jLabel5.setText("Quantity");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 334, -1, -1));

        txtQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantityActionPerformed(evt);
            }
        });
        getContentPane().add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 368, 300, -1));

        jLabel6.setText("Price Per Unit");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 115, -1, -1));
        getContentPane().add(txtPricePerUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 137, 300, -1));

        jButton2.setText("Save");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 205, -1, -1));

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

        setVisible(false);
    }

    private void txtCompanyNameActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void txtUniqueIdActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void txtQuantityActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {

        String uniqueId = txtUniqueId.getText();
        String name = txtName.getText();
        String companyName = txtCompanyName.getText();
        String quantity = txtQuantity.getText();
        String price = txtPricePerUnit.getText();

        if(uniqueId.equals("")){
            JOptionPane.showMessageDialog(null, "MedicineID is required.");
        }else if(name.equals("")){
            JOptionPane.showMessageDialog(null, "Name field is required.");
        }else if(companyName.equals("")){
            JOptionPane.showMessageDialog(null, "Comapany Name is required.");
        }else if(quantity.equals("")){
            JOptionPane.showMessageDialog(null, "Quantity field is required");
        }else if(!quantity.matches(numberPattern)){
            JOptionPane.showMessageDialog(null, "Quantity is invalid.");
        }else if(price.equals("")){
            JOptionPane.showMessageDialog(null, "Price Per Unit field is required.");
        }else if(!price.matches(numberPattern)){
            JOptionPane.showMessageDialog(null, "Price Per Unit field is invalid.");
        }else{
            try{
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("insert into medicine (uniqueId,name,companyName,quantity,price) values(?,?,?,?,?)");
            ps.setString(1, uniqueId);
            ps.setString(2, name);
            ps.setString(3, companyName);
            ps.setString(4, quantity);
            ps.setString(5, price);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Medicine Added Successfully");
            setVisible(false);
            new AddMedicine().setVisible(true);
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
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
            java.util.logging.Logger.getLogger(AddMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddMedicine().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtCompanyName;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPricePerUnit;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtUniqueId;

}