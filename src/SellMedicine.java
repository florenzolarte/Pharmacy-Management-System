import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import common.OpenPdf;
import dao.ConnectionProvider;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.table.TableModel;
import java.util.Calendar;
import java.util.Date;
import dao.PharmacyUtils;
import java.io.FileOutputStream;

public class SellMedicine extends javax.swing.JFrame {

    public String numberPattern = "^[0-9]*$";
    private int finalTotalPrice = 0;
    private String billId = "";
    private String username = "";

    public SellMedicine() {
        initComponents();
    }

    public SellMedicine(String tempUsername) {
        initComponents();
        username = tempUsername;
        setLocationRelativeTo(null);
    }

    private void medicineName(String nameOrUniqueId) {
        DefaultTableModel model = (DefaultTableModel) medicinesTable.getModel();
        model.setRowCount(0);
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select *from medicine where name like '" + nameOrUniqueId + "%' or uniqueId like '" + nameOrUniqueId + "%'");
            while(rs.next()){
                model.addRow(new Object[]{rs.getString("uniqueId")+"- "+rs.getString("name")});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void clearMedicineFields(){
        txtUniqueId.setText("");
        txtName.setText("");
        txtCompanyName.setText("");
        txtPricePerUnit.setText("");
        txtNoOfUnits.setText("");
    }

    public String getUniqueId(String prefix){
        return prefix + System.nanoTime();
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        medicinesTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtUniqueId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCompanyName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPricePerUnit = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNoOfUnits = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTotalPrice = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        cartTable = new javax.swing.JTable();
        btnAddToCart = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lblFinalTotalPrice = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); 
        jLabel1.setText("Sell Medicine");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); 
        jLabel2.setText("Search");

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        medicinesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicines"
            }
        ));
        medicinesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                medicinesTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(medicinesTable);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); 
        jLabel3.setText("Medicine ID");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); 
        jLabel4.setText("Name");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); 
        jLabel5.setText("Company Name");

        txtCompanyName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCompanyNameActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); 
        jLabel6.setText("Price Per Unit");

        txtPricePerUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPricePerUnitActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); 
        jLabel7.setText("No. of Units");

        txtNoOfUnits.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNoOfUnitsKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); 
        jLabel8.setText("Total Price");

        txtTotalPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalPriceActionPerformed(evt);
            }
        });

        cartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicine ID", "Name", "Company Name", "Price Per Unit", "No. Of Units ", "Total Price"
            }
        ));
        cartTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(cartTable);

        btnAddToCart.setFont(new java.awt.Font("Segoe UI", 1, 12)); 
        btnAddToCart.setText("Add to Cart");
        btnAddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToCartActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); 
        jLabel9.setText("₱:");

        lblFinalTotalPrice.setFont(new java.awt.Font("Segoe UI", 1, 24)); 
        lblFinalTotalPrice.setText("0");

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
        jButton3.setText("Purchase & Print");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(557, 557, 557)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(32, 32, 32))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1387, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(jLabel2)
                        .addGap(301, 301, 301)
                        .addComponent(jLabel3)
                        .addGap(317, 317, 317)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(162, 162, 162)
                        .addComponent(txtUniqueId, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(txtPricePerUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(160, 160, 160)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(344, 344, 344)
                                .addComponent(jLabel7))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(81, 81, 81)
                                .addComponent(txtNoOfUnits, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel5)
                                .addGap(295, 295, 295)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(txtCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(81, 81, 81)
                                .addComponent(txtTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(530, 530, 530)
                                .addComponent(btnAddToCart, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(223, 223, 223)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblFinalTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(162, 162, 162)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUniqueId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPricePerUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNoOfUnits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addComponent(btnAddToCart, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblFinalTotalPrice))
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        pack();
    }

    private void txtCompanyNameActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void txtPricePerUnitActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void txtTotalPriceActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void btnAddToCartActionPerformed(java.awt.event.ActionEvent evt) {

        String noOfUnits = txtNoOfUnits.getText();
        String uniqueId = txtUniqueId.getText();

        if(!noOfUnits.equals("") && !uniqueId.equals("")){
            String name = txtName.getText();
            String companyName = txtCompanyName.getText();
            String pricePerUnit = txtPricePerUnit.getText();
            String totalPrice = txtTotalPrice.getText();
            int checkStock = 0;
            int checkMedicineAlreadyExistInCart = 0;

            try{
                Connection con = ConnectionProvider.getCon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select *from medicine where uniqueId="+uniqueId+"");
                while(rs.next()){
                    if(rs.getInt("quantity") >= Integer.parseInt(noOfUnits)){
                        checkStock = 1;
                    }else{
                        JOptionPane.showMessageDialog(null, "Medicine is out of stock. Only"+rs.getInt("quantity")+" Left");
                    }
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }

            if(checkStock == 1){
                DefaultTableModel dtm = (DefaultTableModel) cartTable.getModel();
                if(cartTable.getRowCount() !=0){
                    for(int i =0;i <cartTable.getRowCount();i++){
                        if(Integer.parseInt(dtm.getValueAt(i,0).toString()) == Integer.parseInt(uniqueId)){
                            checkMedicineAlreadyExistInCart = 1;
                            JOptionPane.showMessageDialog(null,"Medicine already exist in cart.");
                        }
                    }
                }
                if(checkMedicineAlreadyExistInCart == 0){
                    dtm.addRow(new Object[]{uniqueId,name,companyName,pricePerUnit,noOfUnits,totalPrice});
                    finalTotalPrice = finalTotalPrice + Integer.parseInt(totalPrice);
                    lblFinalTotalPrice.setText(String.valueOf(finalTotalPrice));
                    JOptionPane.showMessageDialog(null,"Added Successfully");
                }
                clearMedicineFields();
            }
        }else{
            JOptionPane.showMessageDialog(null, "No. Of Units and Medicine ID field is required.");
        }
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {

        if(finalTotalPrice !=0){
            billId = getUniqueId("Bill");

            DefaultTableModel dtm = (DefaultTableModel) cartTable.getModel();
            if(cartTable.getRowCount() !=0){
                for(int i=0;i<cartTable.getRowCount();i++){
                    try{
                        Connection con = ConnectionProvider.getCon();
                        Statement st = con.createStatement();
                        st.executeUpdate("update medicine set quantity=quantity-"+Integer.parseInt(dtm.getValueAt(i,4).toString()) + " where uniqueId="+Integer.parseInt(dtm.getValueAt(i, 0).toString()));

                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            }

            try{
                SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
                Calendar  cal = Calendar.getInstance();
                Connection con = ConnectionProvider.getCon();
                PreparedStatement ps = con.prepareStatement("insert into bill(billId,billDate,totalPaid,generatedBy) values(?,?,?,?)");
                ps.setString(1, billId);
                ps.setString(2,myFormat.format(cal.getTime()));
                ps.setInt(3, finalTotalPrice);
                ps.setString(4,username);
                ps.executeUpdate();
            }
            catch(Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

            com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
            try{
                PdfWriter.getInstance(doc, new FileOutputStream(PharmacyUtils.billPath+""+billId+".pdf"));
                doc.open();
                Paragraph pharmacyName = new Paragraph("                                                  Pharmacy Management System\n");
                doc.add(pharmacyName);
                Paragraph starLine = new Paragraph("*************************************************************************************************************");
                doc.add(starLine);
                Paragraph details = new Paragraph("\tBill ID: "+billId+"\nDate: "+ new Date()+"\nTotal Paid: "+finalTotalPrice);
                doc.add(details);
                doc.add(starLine);
                PdfPTable tbl = new PdfPTable(6);
                tbl.addCell("Medicine ID");
                tbl.addCell("Name");
                tbl.addCell("Company Name");
                tbl.addCell("Price Per Unit ");
                tbl.addCell("No Of Units");
                tbl.addCell("Sub Total Price");
                for(int i=0;i<cartTable.getRowCount();i++){
                   String a = cartTable.getValueAt(i,0 ).toString();
                   String b = cartTable.getValueAt(i,1 ).toString();
                   String c = cartTable.getValueAt(i,2 ).toString();
                   String d = cartTable.getValueAt(i,3 ).toString();
                   String e = cartTable.getValueAt(i,4 ).toString();
                   String f = cartTable.getValueAt(i,5 ).toString();
                   tbl.addCell(a);
                   tbl.addCell(b);
                   tbl.addCell(c);
                   tbl.addCell(d);
                   tbl.addCell(e);
                   tbl.addCell(f);   
                }
                doc.add(tbl);
                doc.add(starLine);
                Paragraph thanksMsg = new Paragraph("Thank you, Please Visit Again.");
                doc.add(thanksMsg);
                OpenPdf.openById(String.valueOf(billId));
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            doc.close();
            setVisible(false);
            new SellMedicine(username).setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(null, "Please add some medicine to cart");
        }
    }

    private void formComponentShown(java.awt.event.ComponentEvent evt) {

        medicineName("");
        txtUniqueId.setEditable(false);
        txtName.setEditable(false);
        txtCompanyName.setEditable(false);
        txtPricePerUnit.setEditable(false);
        txtTotalPrice.setEditable(false);
    }

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {

        String search = txtSearch.getText();
        medicineName(search);
    }

    private void medicinesTableMouseClicked(java.awt.event.MouseEvent evt) {

        int index = medicinesTable.getSelectedRow();
        TableModel model = medicinesTable.getModel();
        String nameOrUniqueId = model.getValueAt(index, 0).toString();

        String uniqueId[] = nameOrUniqueId.split("-",0);
        try{
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select *from medicine where uniqueId="+uniqueId[0]+"");
            while(rs.next()){
                txtUniqueId.setText(uniqueId[0]);
                txtName.setText(rs.getString("name"));
                txtCompanyName.setText(rs.getString("companyName"));
                txtPricePerUnit.setText(rs.getString("price"));
                txtNoOfUnits.setText("");
                txtTotalPrice.setText("");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void txtNoOfUnitsKeyReleased(java.awt.event.KeyEvent evt) {

        String noOfUnits = txtNoOfUnits.getText();
        if(!noOfUnits.equals("")){
            String price = txtPricePerUnit.getText();
            if(!noOfUnits.matches(numberPattern)){
                JOptionPane.showMessageDialog(null, "Number ofUnits field is invalid.");
            }
            int totalPrice = Integer.parseInt(noOfUnits) * Integer.parseInt(price);
            txtTotalPrice.setText(String.valueOf(totalPrice));
        }
        else{
            txtTotalPrice.setText("");
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

        setVisible(false);
    }

    private void cartTableMouseClicked(java.awt.event.MouseEvent evt) {

        int index = cartTable.getSelectedRow();
        int a = JOptionPane.showConfirmDialog(null, "Do you want to remove this Medicine","Select",JOptionPane.YES_NO_OPTION);
        if(a==0){
            TableModel model = cartTable.getModel();
            String total = model.getValueAt(index, 5).toString();
            finalTotalPrice = finalTotalPrice  - Integer.parseInt(total);
            lblFinalTotalPrice.setText(String.valueOf(finalTotalPrice));
            ((DefaultTableModel) cartTable.getModel()).removeRow(index);
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
            java.util.logging.Logger.getLogger(SellMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SellMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SellMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SellMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SellMedicine().setVisible(true);
            }
        });
    }

    private javax.swing.JButton btnAddToCart;
    private javax.swing.JTable cartTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblFinalTotalPrice;
    private javax.swing.JTable medicinesTable;
    private javax.swing.JTextField txtCompanyName;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNoOfUnits;
    private javax.swing.JTextField txtPricePerUnit;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTotalPrice;
    private javax.swing.JTextField txtUniqueId;

}