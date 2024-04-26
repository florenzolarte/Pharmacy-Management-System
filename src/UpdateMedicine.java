import dao.ConnectionProvider;
import javax.swing.JOptionPane;
import java.sql.*;

public class UpdateMedicine extends javax.swing.JFrame {

    public String numberPattern = "^[0-9]*$";

    public UpdateMedicine() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtMedicineId = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCompanyName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtAddQuantity = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtPricePerUnit = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(850, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); 
        jLabel1.setText("Update Medicine");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 6, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 62, 850, 10));

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 20, -1, -1));

        jLabel2.setText("Medicine ID");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 93, -1, -1));

        txtMedicineId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMedicineIdActionPerformed(evt);
            }
        });
        getContentPane().add(txtMedicineId, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 90, 300, -1));

        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(613, 90, -1, -1));

        jLabel3.setText("Name");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 150, 37, -1));

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 172, 300, -1));

        jLabel4.setText("Company Name");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 243, -1, -1));
        getContentPane().add(txtCompanyName, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 269, 300, -1));

        jLabel5.setText("Quantity");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 372, -1, -1));

        txtQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantityActionPerformed(evt);
            }
        });
        getContentPane().add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 394, 300, -1));

        jLabel6.setText("Add  Quantity");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 437, -1, -1));

        txtAddQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddQuantityActionPerformed(evt);
            }
        });
        getContentPane().add(txtAddQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 434, 77, -1));

        jLabel7.setText("Price Per Unit");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 150, 90, -1));

        txtPricePerUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPricePerUnitActionPerformed(evt);
            }
        });
        getContentPane().add(txtPricePerUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 172, 300, -1));

        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 240, -1, -1));

        pack();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {

        int checkMedicineExist = 0;
        String uniqueId = txtMedicineId.getText();
        if(uniqueId.equals("")){
            JOptionPane.showMessageDialog(null, "Medicine ID field is required.");
        }
        else{
            try{
                Connection con = ConnectionProvider.getCon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select *from medicine where uniqueId="+uniqueId+"");
                while(rs.next()){
                    txtMedicineId.setEditable(false);
                    txtName.setText(rs.getString("name"));
                    txtCompanyName.setText(rs.getString("companyName"));
                    txtQuantity.setText(rs.getString("quantity"));
                    txtPricePerUnit.setText(rs.getString("price"));
                    txtQuantity.setEditable(false);
                    checkMedicineExist = 1;
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }

            if (checkMedicineExist == 0){
                JOptionPane.showMessageDialog(null, "Medicine ID does not exist");
            }
        }
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {

        String uniqueId = txtMedicineId.getText();
        String name = txtName.getText();
        String companyName = txtCompanyName.getText();
        String quantity = txtQuantity.getText();
        String price = txtPricePerUnit.getText();
        String addQuantity = txtAddQuantity.getText();

        int totalQuantity = 0;
        if(addQuantity.equals("")){
            totalQuantity = Integer.parseInt(quantity);
        }else{
            totalQuantity = Integer.parseInt(quantity) + Integer.parseInt(addQuantity);
        }

        if(uniqueId.equals("")){
            JOptionPane.showMessageDialog(null, "Medicine ID field is required");
        }else if(name.equals("")){
            JOptionPane.showMessageDialog(null, "Name field is required");
        }else if(companyName.equals("")){
            JOptionPane.showMessageDialog(null, "Company Name field is required");
        }else if(!addQuantity.matches(numberPattern)){
            JOptionPane.showMessageDialog(null, "Add Quantity field is invalid");
        }else if(price.equals("")){
            JOptionPane.showMessageDialog(null, "Price Per Unit field is required");
        }else if(!price.matches(numberPattern)){
            JOptionPane.showMessageDialog(null, "Price Per Unit field is invalid");
        }else{
            try{
                Connection con = ConnectionProvider.getCon();
                PreparedStatement ps = con.prepareStatement("update medicine set name=?,companyName=?,quantity=?,price=? where uniqueId=?");
                ps.setString(1, name);
                ps.setString(2, companyName);
                ps.setInt(3, totalQuantity);
                ps.setString(4, price);
                ps.setInt(5, Integer.parseInt(uniqueId));
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Medicine Updated Successfully");
                setVisible(false);
                new UpdateMedicine().setVisible(true);      
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    private void txtQuantityActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void txtPricePerUnitActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void txtAddQuantityActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void txtMedicineIdActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

        setVisible(false);
    }

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {

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
            java.util.logging.Logger.getLogger(UpdateMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateMedicine().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtAddQuantity;
    private javax.swing.JTextField txtCompanyName;
    private javax.swing.JTextField txtMedicineId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPricePerUnit;
    private javax.swing.JTextField txtQuantity;

}