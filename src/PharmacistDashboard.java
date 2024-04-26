import javax.swing.JOptionPane;

public class PharmacistDashboard extends javax.swing.JFrame {

    private String username = "";

    public PharmacistDashboard() {
        initComponents();
    }

    public PharmacistDashboard(String tempUsername) {
        initComponents();
        username = tempUsername;
        setLocationRelativeTo(null);

    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1366, 768));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); 
        jLabel1.setText("Pharmacist Dashboard");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 550, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1366, 10));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); 
        jButton1.setText("Add Medicine");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 137, 340, 100));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 24)); 
        jButton2.setText("View Medicine");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, 340, 90));

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 24)); 
        jButton3.setText("Update Medicine");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, 340, 80));

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        jButton4.setText("Logout");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 549, 340, 50));

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 24)); 
        jButton5.setText("Sell Medicine");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(738, 137, 340, 100));

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 24)); 
        jButton6.setText("View Bill");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 270, 340, 90));

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 24)); 
        jButton7.setText("Profile");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 390, 340, 80));

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        jButton8.setText("Exit");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 550, 340, 50));

        jButton9.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        jButton9.setText("X");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 20, -1, -1));

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

        new AddMedicine() .setVisible(true);
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {

        int a = JOptionPane.showConfirmDialog(null, "Do you want to Logout", "Select", JOptionPane.YES_NO_OPTION);

        if (a == 0) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {

        new Profile(username).setVisible(true);
    }

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {

        int a = JOptionPane.showConfirmDialog(null, "Do you want to Close Application", "Select", JOptionPane.YES_NO_OPTION);

        if (a == 0) {
            System.exit(0);
        }

    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {

        new SellMedicine(username).setVisible(true);
    }

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {

        new ViewBill().setVisible(true);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {

        new ViewMedicine() .setVisible(true);
    }

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {

        setVisible(false);
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {

        new UpdateMedicine().setVisible(true);
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
            java.util.logging.Logger.getLogger(PharmacistDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PharmacistDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PharmacistDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PharmacistDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PharmacistDashboard().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;

}